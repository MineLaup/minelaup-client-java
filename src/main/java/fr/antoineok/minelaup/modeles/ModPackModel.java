package fr.antoineok.minelaup.modeles;

public class ModPackModel {
	
	private int id;
	
	private String name;
	
	private String summary;
	
	private int launcher_id;
	
	private VersionsInfo version;
	
	public ModPackModel(int id, String name, String summary, int launcher_id, VersionsInfo version) {
		this.id = id;
		this.name = name;
		this.summary = summary;
		this.launcher_id = launcher_id;
		this.version = version;
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
	
	public int getLauncher_id() {
		return launcher_id;
	}
	
	public VersionsInfo getVersion() {
		return version;
	}
	
	public void setVersion(VersionsInfo version) {
		this.version = version;
	}
	
	public static class VersionsInfo{
		private int id;
		private String version;
		private String summary;
		private String created_at;
		private int modpack_id;
		private String mc_version;
		
		public VersionsInfo(int id, String version, String summary, String created_at, int modpack_id, String mc_version) {
			this.id = id;
			this.version = version;
			this.summary = summary;
			this.created_at = created_at;
			this.modpack_id = modpack_id;
			this.mc_version = mc_version;
		}
		
		public int getId() {
			return id;
		}
		
		public String getVersion() {
			return version;
		}
		
		public String getSummary() {
			return summary;
		}
		
		public String getCreated_at() {
			return created_at;
		}
		
		public int getModpack_id() {
			return modpack_id;
		}
		
		public String getMcVersion() {
			return mc_version;
		}
	}
	
}
