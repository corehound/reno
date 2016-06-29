package org.corehound.reno.plugin.index;

import org.corehound.reno.adapter.AdapterFactory;
import org.corehound.reno.adapter.index.IndexException;
import org.corehound.reno.adapter.index.IndexService;

public abstract class IndexWrapper {
	
	private IndexService indexService = AdapterFactory.getIndexService();
	
	protected IndexService getIndexService(){
		return indexService;
	}
	
	public abstract String index(String index) throws IndexException;

}
