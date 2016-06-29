package org.corehound.reno.adapter.admin;

public interface AdminService {
	
	void updateIndex(String name, String definition) throws AdminException;
	
	void deleteIndex(String name) throws AdminException;
	
}
