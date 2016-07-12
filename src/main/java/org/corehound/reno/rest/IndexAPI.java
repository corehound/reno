package org.corehound.reno.rest;

import java.io.IOException;
import java.io.InputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.corehound.reno.adapter.index.IndexException;
import org.corehound.reno.adapter.search.SearchException;
import org.corehound.reno.plugin.PluginFactory;
import org.corehound.reno.plugin.index.IndexWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/index")
public class IndexAPI {
	
	private Logger logger = LoggerFactory.getLogger(IndexAPI.class);
	
	private IndexWrapper indexWrapper = PluginFactory.getIndexWrapper();
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Response index(final InputStream incomingData) {	
		return RestUtils.run(new Execution() {
			public Object execute() throws IOException, IndexException {
				String index = IOUtils.toString(incomingData);
				logger.debug("/index : INCOMING JSON : " + index);
				
				String result = indexWrapper.index(index);
	
				logger.debug("/index : OUTGOING JSON : " + result);
				return result;
			}
		});
	}

}
