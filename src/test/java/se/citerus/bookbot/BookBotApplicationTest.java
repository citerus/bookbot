package se.citerus.bookbot;

import io.dropwizard.testing.ResourceHelpers;
import io.dropwizard.testing.junit.DropwizardAppRule;
import org.junit.ClassRule;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.core.Response;

import static org.junit.Assert.*;

public class BookBotApplicationTest {

    @ClassRule
    public static final DropwizardAppRule<BookBotConfiguration> RULE =
            new DropwizardAppRule<BookBotConfiguration>(BookBotApplication.class,
                    ResourceHelpers.resourceFilePath("test.yml"));

    @Test
    public void startApplicationTest() throws Exception {
        Client client = RULE.client();

        Response response = client.target(String.format("http://localhost:%d/hello", RULE.getLocalPort())).request().get();
        assertEquals("Hello, Johan!", response.readEntity(String.class));
    }
}