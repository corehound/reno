package org.corehound.reno.plugin;

public class SystemPropertiesConfig extends Config{

	@Override
	protected String doGet(String key) {
		return System.getProperty(key);
	}

}
