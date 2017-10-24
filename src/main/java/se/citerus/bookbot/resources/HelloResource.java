package se.citerus.bookbot.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("hello")
public class HelloResource {

    @GET
    public String getHello() {
        return "Hello, Johan!";
    }

    @GET
    @Path("{name}")
    public String getHelloErika(@PathParam("name") String name) {
        String correctedName = name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase();
        return "Hello, " + correctedName + "!";
    }
}