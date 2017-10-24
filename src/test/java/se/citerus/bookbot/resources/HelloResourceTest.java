package se.citerus.bookbot.resources;

import io.dropwizard.testing.junit.ResourceTestRule;
import org.junit.ClassRule;
import org.junit.Test;

import static org.junit.Assert.*;

public class HelloResourceTest {

    @ClassRule
    public static final ResourceTestRule helloResources = ResourceTestRule.builder()
                                                                          .addResource(new HelloResource())
                                                                          .build();

    @Test
    public void testGetHello() throws Exception {
        assertEquals("Hello, Johan!",
                helloResources.target("/hello").request().get(String.class));
    }

    @Test
    public void testGetHelloErika() throws Exception {
        assertEquals("Hello, Erika!",
                helloResources.target("/hello/erika").request().get(String.class));
    }

    @Test
    public void testHelloRandom() throws Exception {
        assertEquals("Hello, Random!",
                helloResources.target("/hello/rANdOm").request().get(String.class));
    }
}