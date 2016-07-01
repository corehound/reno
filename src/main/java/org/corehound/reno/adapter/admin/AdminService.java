package org.corehound.reno.adapter.admin;

import java.util.List;

public interface AdminService {
	
	void updateIndex(String name, String definition) throws AdminException;
	
	void deleteIndex(String name) throws AdminException;
	
	String getIndexDefinition(String name);
	
	List<String> getIndexNames();
	
	void updateSynonyms(String indexName, String synonyms) throws AdminException;
	
	String getSynonyms(String indexName);
	
}
