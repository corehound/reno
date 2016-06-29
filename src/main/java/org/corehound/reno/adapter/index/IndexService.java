package org.corehound.reno.adapter.index;

import java.util.Map;

public interface IndexService {
	
	String index(String index, String url, String title, String content, Map<String, Object> metadata) throws IndexException;

}
