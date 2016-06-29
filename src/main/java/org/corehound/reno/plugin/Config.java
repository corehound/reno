package org.corehound.reno.plugin;

public abstract class Config {
	
	private static Config config;

	private static Config getInstance() {
		return config;
	}

	public static void setInstance(Config config) {
		Config.config = config;
	}
	
	public static String get(String key){
		return getInstance().doGet(key);
	}
	
	protected abstract String doGet(String key);

}
