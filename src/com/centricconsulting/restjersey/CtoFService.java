package com.centricconsulting.restjersey;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/ctofservice")
public class CtoFService {
	@GET
	@Produces("application/xml")
	public String convertCtoF(){
		Double celsius = 36.8;
		Double farenheit = convertValue(celsius);
		
		return getResultString(celsius, farenheit);
		
		//Double celsius = 36.8;
		//farenheit = ((celsius * 9)/5) + 32;
		
		//String result = "@Produces(\"application/xml\") Output: \n\nC to F Converter Output: \n\n" + farenheit;
		//return "<ctofservice><celsius>" + celsius + "</celsius><ctofoutput>" + result + "</ctofoutpu></ctofservice>";
	}
	
	@Path("{c}")
	@GET
	@Produces("application/xml") 
	public String convertCtoFfromInfom(@PathParam("c") Double c) {
		Double farenheit = convertValue(c);
		
		return getResultString(c, farenheit);
		//String result = "@Produces(\"application/xml\") Output: \n\nC to F Converter Output: \n\n" + farenheit;
		//return "<ctofservice><celsius>" + c + "</celsius><ctofoutput>" + result + "</ctofoutput></ctofservice>";
	}
	
	private Double convertValue(Double celsius) {
		return ((celsius * 9)/5) + 32;
	}
	
	private String getResultString(Double celsius, Double farenheit) {
		String result = "@Produces(\"application/xml\") Output: \n\nC to F Converter Output: \n\n" + farenheit;
		return "<ctofservice><celsius>" + celsius + "</celsius><ctofoutput>" + result + "</ctofoutput></ctofservice>";
	}
}