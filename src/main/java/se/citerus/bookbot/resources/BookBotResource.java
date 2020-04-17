package se.citerus.bookbot.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("/")
public class BookBotResource {

    @GET
    public String getBookBot(@QueryParam("user_name") String name){
        if (name == null) {
            return "Hi, I'm BookBot!";
        } else {
            return "Hi " + name + ", I'm BookBot!";
        }
    }

}
