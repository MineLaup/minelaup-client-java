package fr.antoineok.minelaup;

import fr.antoineok.minelaup.modeles.LauncherModel;
import fr.antoineok.minelaup.modeles.ModPackModel;

import java.util.ArrayList;
import java.util.List;

public class ModPackManager {
	
	private final LauncherModel data;
	
	protected List<ModPackModel> enabledModPacks;
	
	private static ModPackManager INSTANCE;
	
	public static ModPackManager getInstance(LauncherModel data){
		if(INSTANCE == null) INSTANCE = new ModPackManager(data);
		return INSTANCE;
	}
	
	private ModPackManager(LauncherModel data) {
		this.data = data;
		enabledModPacks = new ArrayList<>();
	}
	
	
	public void enableModPack(ModPackModel modPack){
		if(enabledModPacks.contains(modPack)) return;
		enabledModPacks.add(modPack);
	}
	
	
	public void disableModPack(ModPackModel modPack){
		if(!enabledModPacks.contains(modPack)) return;
		enabledModPacks.remove(modPack);
	}
	
	public ModPackModel getModPackForName(String name){
		return data.getModPacks().stream().filter(mod -> mod.getName().equals(name)).findFirst().orElse(null);
	}
	
	public ModPackModel getModPackForId(int id){
		return data.getModPacks().stream().filter(mod -> mod.getId() == id).findFirst().orElse(null);
	}
	
	
	public ModPackModel[] getModPacksForMCVersion(String version){
		return (ModPackModel[]) data.getModPacks().stream().filter(mod -> mod.getVersion().getMcVersion().equals(version)).toArray();
	}
	
}
