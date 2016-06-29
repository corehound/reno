package org.corehound.reno.plugin;

import org.corehound.reno.plugin.index.IndexWrapper;
import org.corehound.reno.plugin.search.SearchWrapper;

public abstract class PluginFactory {
	
	private static PluginFactory factory;

	public static PluginFactory getInstance() {
		return factory;
	}

	public static void setInstance(PluginFactory factory) {
		PluginFactory.factory = factory;
	}
	
	public static SearchWrapper getSearchWrapper(){
		return getInstance().doGetSearchWrapper();
	}
	
	public static IndexWrapper getIndexWrapper(){
		return getInstance().doGetIndexWrapper();
	}
	
	protected abstract SearchWrapper doGetSearchWrapper();
	
	protected abstract IndexWrapper doGetIndexWrapper();

}
