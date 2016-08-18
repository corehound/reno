package org.corehound.reno.rest;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
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
import org.corehound.reno.adapter.search.SearchException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

@Path("/admin")
public class AdminAPI {
	
	private Logger logger = LoggerFactory.getLogger(AdminAPI.class);
	
	private AdminService adminService = AdapterFactory.getAdminService();
	
	@POST
	@Path("/index/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response createIndex(final @PathParam("name") String indexName, final InputStream incomingData) {	
		return RestUtils.run(new Execution() {
			public Object execute() throws IOException, AdminException {
				String definition = IOUtils.toString(incomingData);
				logger.debug("create:/index/" + indexName + " : INCOMING DATA : " + definition);
				
				String result = "OK";
				adminService.createIndex(indexName, definition);
				
				logger.debug("create:/index/" + indexName + " : OUTGOING JSON : " + result);
				return result;
			}
		});
	}
	
	@DELETE
	@Path("/index/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteIndex(final @PathParam("name") String indexName) {	
		return RestUtils.run(new Execution() {
			public Object execute() throws IOException, AdminException {
				logger.debug("delete:/index/" + indexName);
				
				String result = "OK";
				adminService.deleteIndex(indexName);
				
				logger.debug("delete:/index/" + indexName + " : OUTGOING JSON : " + result);
				return result;
			}
		});
	}
	
	@GET
	@Path("/index/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getIndexDefinition(final @PathParam("name") String indexName){
		return RestUtils.run(new Execution() {
			public Object execute() throws IOException, AdminException {
				logger.debug("get:/index/" + indexName);
				
				String result = adminService.getIndexDefinition(indexName);
				
				logger.debug("get:/index/" + indexName + " : OUTGOING JSON : " + result);
				return result;
			}
		});
	}
	
	@GET
	@Path("/indexes")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getIndexNames() {	
		return RestUtils.run(new Execution() {
			public Object execute() throws IOException, AdminException {
				logger.debug("get:/indexes");
				
				List<String> result = adminService.getIndexNames();
				
				ObjectMapper mapper = new ObjectMapper();
				String jsonResult = mapper.writeValueAsString(result);
				
				logger.debug("get:/indexes : OUTGOING JSON : " + jsonResult);
				return jsonResult;
			}
		});	
	}
	
	@PUT
	@Path("/index/{name}/synonyms")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateSynonyms(final @PathParam("name") String indexName, final InputStream incomingData) {	
		return RestUtils.run(new Execution() {
			public Object execute() throws IOException, AdminException {
				String synonyms = IOUtils.toString(incomingData);
				ObjectMapper mapper = new ObjectMapper();
				List<List<String>> list = mapper.readValue(synonyms, List.class);
				logger.debug("update:/index/" + indexName + "/synonyms : INCOMING DATA : " + synonyms);
				
				String result = "OK";
				adminService.updateSynonyms(indexName, list);
				
				logger.debug("update:/index/" + indexName + "/synonyms : OUTGOING JSON : " + result);
				return result;
			}
		});
	}
	
	@GET
	@Path("/index/{name}/synonyms")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSynonyms(final @PathParam("name") String indexName){
		return RestUtils.run(new Execution() {
			public Object execute() throws IOException, AdminException {
				logger.debug("get:/index/" + indexName + "/synonyms");
				
				List<List<String>> result = adminService.getSynonyms(indexName);
				ObjectMapper mapper = new ObjectMapper();
				String jsonResult = mapper.writeValueAsString(result);
				
				logger.debug("get:/index/" + indexName + "/synonyms : OUTGOING JSON : " + jsonResult);
				return jsonResult;
			}
		});
	}
	
	
}
