package main.wsapp.controllers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.net.URI;

/**
 * Root resource, which represents “Hello world!”.
 */
@Path("/helloworld")
public class Root {

    @GET
    @Produces("text/plain")
    public Response getText() {
//        return Response.ok("<%@ page contentType=\"text/html; charset=UTF-8\" pageEncoding=\"UTF-8\" %>\n" +
//                "<!DOCTYPE html>\n" +
//                "<html>\n" +
//                "<head>\n" +
//                "    <title>JSP - Hello World</title>\n" +
//                "</head>\n" +
//                "<body>\n" +
//                "<h1><%= \"Hello World!\" %>\n" +
//                "</h1>\n" +
//                "<br/>\n" +
//                "<a href=\"hello-servlet\">Hello Servlet</a>\n" +
//                "<a href=\"login-servlet\">Login</a>\n" +
//                "</body>\n" +
//                "</html>").build();
        Response.ResponseBuilder responseBuilder = Response.temporaryRedirect(URI.create("index.html"));
        return   responseBuilder.build();
    }

}
