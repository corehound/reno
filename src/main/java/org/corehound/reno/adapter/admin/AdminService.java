package org.corehound.reno.adapter.admin;

import java.util.List;

public interface AdminService {
	
	void createIndex(String name, String definition) throws AdminException;
	
	void deleteIndex(String name) throws AdminException;
	
	String getIndexDefinition(String name) throws AdminException;
	
	List<String> getIndexNames() throws AdminException;
	
	void updateSynonyms(String indexName, List<List<String>> synonyms) throws AdminException;
	
	List<List<String>> getSynonyms(String indexName) throws AdminException;
		
}
