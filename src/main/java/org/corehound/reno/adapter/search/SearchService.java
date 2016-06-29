package org.corehound.reno.adapter.search;

public interface SearchService {

	SearchResults search(String[] index, String query, String queryTamplete, int from, int size) throws SearchException;
	
}
