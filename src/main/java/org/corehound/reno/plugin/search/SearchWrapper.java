package org.corehound.reno.plugin.search;

import org.corehound.reno.adapter.AdapterFactory;
import org.corehound.reno.adapter.search.SearchException;
import org.corehound.reno.adapter.search.SearchService;

public abstract class SearchWrapper {
	
	private SearchService searchService = AdapterFactory.getSearchService();
	
	protected SearchService getSearchService(){
		return searchService;
	}
	
	public abstract String search(String query) throws SearchException;

}
