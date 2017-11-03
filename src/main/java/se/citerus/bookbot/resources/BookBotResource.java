package se.citerus.bookbot.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/")
public class BookBotResource {

    @GET
    public String getBookBot(){
        return "Hi, I'm BookBot!";
    }

}
