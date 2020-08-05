package fr.antoineok.minelaup;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import fr.antoineok.minelaup.exceptions.*;
import fr.antoineok.minelaup.modeles.LauncherModel;
import fr.antoineok.minelaup.modeles.ModPackModel;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

@SuppressWarnings({"unused"})
public class MineLaup {

    private final String URL;
    private final String LAUNCHER_NAME;
    private final File LAUNCHER_DIRECTORY;

    private final String API_KEY;

    final OkHttpClient client = new OkHttpClient();
    
    private final LauncherModel LAUNCHER_DATA;

    private static final String URL_REGEX =
            "^((https?://)(%[0-9A-Fa-f]{2}|[-()_.!~*';/?:@&=+$,A-Za-z0-9])+)([).!';/?:,][[:blank:]])?$";

	private final Gson GSON;
 
	public MineLaup(String url, String launcherName, String apiKey, File launcherDir) throws IOException, MineLaupException {
        if(isValidUrl(url)) throw new MalformedURLException("Url non valide");
        this.URL = url;
        this.API_KEY = apiKey;
        this.LAUNCHER_NAME = launcherName;
        if(!launcherDir.exists()) launcherDir.mkdirs();
        this.LAUNCHER_DIRECTORY = launcherDir;
        
        GSON = new GsonBuilder().disableHtmlEscaping().serializeNulls().setPrettyPrinting().create();
		
		LAUNCHER_DATA = getLauncherInfo();
		System.out.println(GSON.toJson(LAUNCHER_DATA));
    }


    private boolean isValidUrl(String url){
        return url.matches(URL_REGEX);
    }

    private LauncherModel getLauncherInfo() throws IOException, MineLaupException {
        HttpUrl.Builder urlBuilder = HttpUrl.parse(URL.endsWith("/") ? URL + "game" : URL + "/game").newBuilder();
        String finalUrl = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .header("Authorization", API_KEY)
                .url(finalUrl)
                .build();

        Response response = client.newCall(request).execute();
        if(response.code() == 404) throw new NotFoundException("Launcher innexistant");
	    if(response.code() == 401) throw new WrongKeyException("Clée éronnée");
	    if(response.code() == 403) throw new DisabledException("Launcher désactivé");
	    String json = response.message();
        LauncherModel modelToEnd = GSON.fromJson(json, LauncherModel.class);
        modelToEnd.setModpacks(getModPack(modelToEnd.getModPacks()));
        return modelToEnd;
    }
    
    private List<ModPackModel> getModPack(List<ModPackModel> packList) throws MineLaupException, IOException {
	   for(ModPackModel modPack : packList){
		   HttpUrl.Builder urlBuilder = HttpUrl.parse(URL.endsWith("/") ? URL + "game/modpack" : URL + "/game/modpack").newBuilder();
		   urlBuilder.addQueryParameter("id", Integer.toString(modPack.getId()));
		   String finalUrl = urlBuilder.build().toString();
		
		   Request request = new Request.Builder()
				                     .header("Authorization", API_KEY)
				                      .url(finalUrl)
				                      .build();
		   Response response = client.newCall(request).execute();
		   if(response.code() == 404) throw new NotFoundException("Modpack version not found");
		   if(response.code() == 401) throw new WrongKeyException("Clée éronnée");
		   if(response.code() == 403) throw new DisabledException("Modpack désactivé");
		   String json = response.message();
		   ModPackModel mod = GSON.fromJson(json, ModPackModel.class);
		   modPack.setVersion(mod.getVersion());
	   }
		return packList;
    }
    
    
    public void download(){
    
    }
}
