package org.corehound.reno.adapter;

import org.corehound.reno.adapter.admin.AdminService;
import org.corehound.reno.adapter.index.IndexService;
import org.corehound.reno.adapter.search.SearchService;

public abstract class AdapterFactory {
	
	private static AdapterFactory factory;

	public static AdapterFactory getInstance() {
		return factory;
	}

	public static void setInstance(AdapterFactory factory) {
		AdapterFactory.factory = factory;
	}	
	
	public static SearchService getSearchService(){
		return getInstance().doGetSearchService();
	}
	
	public static IndexService getIndexService(){
		return getInstance().doGetIndexService();
	}
	
	public static AdminService getAdminService(){
		return getInstance().doGetAdminService();
	}
	
	protected abstract SearchService doGetSearchService();
	
	protected abstract IndexService doGetIndexService();
	
	protected abstract AdminService doGetAdminService(); 

}
