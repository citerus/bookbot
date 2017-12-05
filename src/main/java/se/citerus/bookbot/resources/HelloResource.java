package se.citerus.bookbot.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

@Path("/hello")
public class HelloResource {

    @GET
    public String getHello(@QueryParam("user_name") String name) {
        if (name == null) {
            return "Hello, Johan!";
        } else {
            return "Hello, " + capitalize(name) + "!";
        }
    }

    @GET
    @Path("{name}")
    public String getHelloErika(@PathParam("name") String name) {
        return "Hello, " + capitalize(name) + "!";
    }

    private String capitalize(String name) {
        return name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase();
    }
}