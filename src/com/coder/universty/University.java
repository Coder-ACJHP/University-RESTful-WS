package com.coder.universty;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.jws.WebParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/university")
public class University {

	@GET
	@Path("{studentRollNo1}/{studentRollNo2}")
	@Produces(MediaType.TEXT_PLAIN)
	
	public String getStudentInfo(@PathParam("studentRollNo1") String studentRollNo1,
			                     @PathParam("studentRollNo2") String studentRollNo2) {
		return "RESTful WEBSERVICE says : getted two roll numbers : "+ studentRollNo1+" and "+studentRollNo2;
	}
	
	@GET
	@Path("/fatalerror")
	@Produces(MediaType.TEXT_HTML)
	
	public String getUserAgent(@WebParam(name = "Error") String Error) {
		try {
			InetAddress address = InetAddress.getLocalHost();
			Error = address.toString();
			
		} catch (UnknownHostException e) {}
		return "<html>"+"<title>"+"ERROR ON RESTful WEB SERVICE"+"</title>"+
		"<body>"+"<h1>"+"FATAL ERROR!"+Error+"</body>"+"</h1>"+"</html>";
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	
	public String getstudentRoll(@QueryParam("studentRoll1") String studentRoll1,
			                     @QueryParam("studentRoll2") String studentRoll2) {
		return "Service is getted : "+studentRoll1+"&"+studentRoll2;
	}
}
