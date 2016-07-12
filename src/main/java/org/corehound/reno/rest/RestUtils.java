package org.corehound.reno.rest;

import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RestUtils {
	
	private static Logger logger = LoggerFactory.getLogger(RestUtils.class);

	public static Response run(Execution execution){
		try {
			Object response = execution.execute();
			if(response != null){
				return Response.status(200).entity(response).build();
			}
			return Response.status(200).build();
		} catch (Exception e){
			logger.error(e.getMessage(), e);
			return Response.status(500).entity(e.getMessage()).build();
		}
	}

}
