package se.citerus.bookbot.resources;

import io.dropwizard.testing.junit.ResourceTestRule;
import org.junit.ClassRule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookBotResourceTest {

    @ClassRule
    public static final ResourceTestRule bookBotResources = ResourceTestRule.builder()
                                                                            .addResource(new BookBotResource())
                                                                            .build();

    @Test
    public void testGetBookBot() throws Exception {
        assertEquals("Hi, I'm BookBot!",
                bookBotResources.target("/").request().get(String.class));
    }

    @Test
    public void testGetBookBotWithUserName() throws Exception {
        assertEquals("Hi erika, I'm BookBot!",
                bookBotResources.target("/").queryParam("user_name", "erika")
                        .request().get(String.class));
    }

}