package fr.antoineok.minelaup;

import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import fr.antoineok.minelaup.exceptions.*;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

public class MineLaup {

    private final String URL;
    private final String LAUNCHER_NAME;
    private final File LAUNCHER_DIRECTORY;

    private final String API_KEY;

    final OkHttpClient client = new OkHttpClient();

    private static final String URL_REGEX =
            "^((https?://)(%[0-9A-Fa-f]{2}|[-()_.!~*';/?:@&=+$,A-Za-z0-9])+)([).!';/?:,][[:blank:]])?$";

	
	public MineLaup(String url, String launcherName, String apiKey, File launcherDir) throws IOException, MineLaupException {
        if(isValidUrl(url)) throw new MalformedURLException("Url non valide");
        this.URL = url;
        this.API_KEY = apiKey;
        this.LAUNCHER_NAME = launcherName;
        if(!launcherDir.exists()) launcherDir.mkdirs();
        this.LAUNCHER_DIRECTORY = launcherDir;

    }


    private boolean isValidUrl(@NotNull String url){
        return url.matches(URL_REGEX);
    }

    private boolean getLauncherInfo() throws IOException, MineLaupException {
        HttpUrl.Builder urlBuilder = HttpUrl.parse(URL.endsWith("/") ? URL + "LauncherInfo" : URL + "/LauncherInfo").newBuilder();
        urlBuilder.addQueryParameter("name", LAUNCHER_NAME);
        String finalUrl = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .header("Authorization", API_KEY)
                .url(finalUrl)
                .build();

        Response response = client.newCall(request).execute();
        if(response.code() == 404) throw new LauncherNotFoundException("Launcher innexistant");
	    if(response.code() == 401) throw new WrongKeyException("Clée éronnée ");
        System.out.print(response.message());
        return !response.message().isEmpty();
    }
    
    
    public void download(){
    
    }
}
