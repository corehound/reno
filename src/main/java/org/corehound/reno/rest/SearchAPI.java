package org.corehound.reno.rest;

import java.io.IOException;
import java.io.InputStream;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.corehound.reno.adapter.search.SearchException;
import org.corehound.reno.plugin.PluginFactory;
import org.corehound.reno.plugin.search.SearchWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/search")
public class SearchAPI {
	
	private Logger logger = LoggerFactory.getLogger(SearchAPI.class);
	
	private SearchWrapper searchWrapper = PluginFactory.getSearchWrapper();
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response search(final InputStream incomingData) {	
		return RestUtils.run(new Execution() {
			public Object execute() throws IOException, SearchException {
				String query = IOUtils.toString(incomingData);
				logger.debug("/search : INCOMING JSON : " + query);
				
				String result = searchWrapper.search(query);
				
				logger.debug("/search : OUTGOING JSON : " + result);
				return result;
			}
		});
	}

}
