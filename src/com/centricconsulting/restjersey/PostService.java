package com.centricconsulting.restjersey;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.print.attribute.standard.Media;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/postservice")
public class PostService {
	// See: https://crunchify.com/create-very-simple-jersey-rest-service-and-send-json-data-from-java-client/
	
	// Full Path: localhost:8080/SampleJavaWebService/centric/postservice/senddata
	@POST
	@Path("/senddata")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response postJSON(InputStream incomingData) {
		StringBuilder jsonBuilder = new StringBuilder();
		
		try{
			BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
			String line = null;
			while((line = in.readLine()) != null) {
				jsonBuilder.append(line);
			}
		} catch (Exception e) {
			System.out.println("Error parsing: - ");
		}
		System.out.println("Data Received: " + jsonBuilder.toString());
		
		return Response.status(200).entity(jsonBuilder.toString()).build();
	}
	
	// Full Path: localhost:8080/SampleJavaWebService/centric/postservice/verify
	@GET
	@Path("/verify")
	@Produces(MediaType.TEXT_PLAIN)
	public Response verifyData(InputStream incomingData) {
		String result = "PostService Successfully started..";
		
		return Response.status(200).entity(result).build();
	}
}
