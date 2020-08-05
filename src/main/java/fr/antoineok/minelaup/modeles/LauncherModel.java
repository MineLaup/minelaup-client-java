package fr.antoineok.minelaup.modeles;

import java.util.List;

public class LauncherModel {
	
	private int id;
	
	private String name;
	
	private String summary;
	
	private List<ModPackModel> modpacks;
	
	public LauncherModel(int id, String name, String summary, List<ModPackModel> modpacks) {
		this.id = id;
		this.name = name;
		this.summary = summary;
		this.modpacks = modpacks;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getSummary() {
		return summary;
	}
	
	
	public List<ModPackModel> getModPacks() {
		return modpacks;
	}
	
	public void setModpacks(List<ModPackModel> modpacks) {
		this.modpacks = modpacks;
	}
}
