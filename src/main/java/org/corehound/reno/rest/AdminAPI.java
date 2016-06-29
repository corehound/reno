package org.corehound.reno.rest;

import java.io.IOException;
import java.io.InputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.corehound.reno.adapter.AdapterFactory;
import org.corehound.reno.adapter.admin.AdminException;
import org.corehound.reno.adapter.admin.AdminService;
import org.corehound.reno.adapter.index.IndexException;
import org.corehound.reno.adapter.search.SearchException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/admin")
public class AdminAPI {
	
	private Logger logger = LoggerFactory.getLogger(AdminAPI.class);
	
	private AdminService adminService = AdapterFactory.getAdminService();
	
	@PUT
	@Path("/index/{indexName}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateIndex(final @PathParam("indexName") String indexName, final InputStream incomingData) {	
		return RestUtils.run(new Execution() {
			public Object execute() throws IOException, SearchException {
				String definition = IOUtils.toString(incomingData);
				logger.debug("update:/index/" + indexName + " : INCOMING DATA : " + definition);
				
				String result = "OK";
				
				try {
				   adminService.updateIndex(indexName, definition);
				} catch (AdminException e) {
					logger.error("Update index failed. ", e);
					result = e.getMessage();
				}
				
				logger.debug("update:/index/" + indexName + " : OUTGOING JSON : " + result);
				return result;
			}
		});
	}
	
	@DELETE
	@Path("/index/{indexName}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteIndex(final @PathParam("indexName") String indexName) {	
		return RestUtils.run(new Execution() {
			public Object execute() throws IOException, SearchException {
				logger.debug("delete:/index/" + indexName);
				
				String result = "OK";
				
				try {
				   adminService.deleteIndex(indexName);
				} catch (AdminException e) {
					logger.error("Delete index failed. ", e);
					result = e.getMessage();
				}
				
				logger.debug("delete:/index/" + indexName + " : OUTGOING JSON : " + result);
				return result;
			}
		});
	}
}
