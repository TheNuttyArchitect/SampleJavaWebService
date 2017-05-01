package com.centricconsulting.restjersey;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.json.JSONException;
import org.json.JSONObject;

@Path("/ftocservice")
public class FtoCService {
	// See https://crunchify.com/how-to-build-restful-service-with-java-using-jax-rs-and-jersey/
	//   for additional details
	// REST Path: http://localhost:8080/SampleJavaWebService/centric/ftocservice/
	
	@GET
	@Produces("application/json")
	public Response convertFtoC() throws JSONException {
		Double farenheit = 98.24;
		Double celcius = convertValue(farenheit);
		JSONObject json = getJSON(farenheit, celcius);
		
		String result = getResultString(json);
		
		return Response.status(200).entity(result).build();
	}
	
	@Path("{f}")
	@GET
	@Produces("application/json")
	public Response convertFtoC(@PathParam("f") double f) throws JSONException {
		Double celcius = convertValue(f);
		JSONObject json = getJSON(f, celcius);
		
		String result = getResultString(json);
		
		return Response.status(200).entity(result).build();
	}
	
	private Double convertValue(Double farenheit) {
		return (farenheit - 32) * 5/9;
	}

	
	private JSONObject getJSON(Double farenheit, Double celsius) throws JSONException {
		JSONObject json = new JSONObject();
		json.put("F Value", farenheit);
		json.put("C Value",  celsius);
		
		return json;
	}
	
	private String getResultString(JSONObject json) {
		return "@Produces(\"application/json\")Output: \n\nF to C Converter Output: \n\n" + json;
	}
}
