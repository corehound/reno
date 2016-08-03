package org.corehound.reno.adapter.search;

public interface SearchService {

	SearchResults search(Index[] indexes, String text, String queryTamplete, int from, int size) throws SearchException;
	
}
