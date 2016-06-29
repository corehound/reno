package org.corehound.reno.adapter.search;

import java.util.Map;

public interface SearchItem{
	
	String getUrl();
	
	String getTitle();
	
	String getContent();
	
	Double getScore();
	
	Map<String, Object> getMap();
	
}
