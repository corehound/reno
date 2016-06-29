package org.corehound.reno.adapter.search;

import java.util.ArrayList;
import java.util.List;

public class SearchResults extends ArrayList<SearchItem>{
	
	private long totalCount;

	public long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}
	
}
