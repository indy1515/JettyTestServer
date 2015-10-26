package com.indyzalab.test;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

@Path("/currentTime")
public class CurrentTime {

  // This method is called if TEXT_PLAIN is request
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String sayPlainTextHello() {
    return getCurrentTime();
  }

  // This method is called if XML is request
  @GET
  @Produces(MediaType.TEXT_XML)
  public String sayXMLHello() {
    return "<?xml version=\"1.0\"?>" + "<hello> "+getCurrentTime() + "</hello>";
  }

  // This method is called if HTML is request
  @GET
  @Produces(MediaType.TEXT_HTML)
  public String sayHtmlHello() {
    return "<html> " + "<title>" + "CurrentTime" + "</title>"
        + "<body><h1>" + getCurrentTime() + "</body></h1>" + "</html> ";
  }
  
  private String getCurrentTime(){
	  DateTimeZone timeZoneBangkok = DateTimeZone.forID( "Asia/Bangkok" );

	  DateTime nowBangkok = DateTime.now( timeZoneBangkok );
	  DateTimeFormatter fmt = DateTimeFormat.forPattern("EEE MMM dd HH:mm:ss z YYYY");
	  return nowBangkok.toString(fmt);
  }

} 
