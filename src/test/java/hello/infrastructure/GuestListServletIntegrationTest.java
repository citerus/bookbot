package hello.infrastructure;

import com.mashape.unirest.http.Unirest;
import hello.domain.GuestRepositoryInMemory;
import hello.testsupport.WebappRule;
import org.junit.Rule;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class GuestListServletIntegrationTest {
    @Rule
    public WebappRule RULE = new WebappRule();

    @Test
    public void noGuestsHaveArrived() throws Exception {
        GuestRepositoryInMemory.emptyList();

        String body = Unirest
                .get(guestURL())
                .asString()
                .getBody();

        assertThat(body, is(""));
    }

    @Test
    public void twoGuestsHaveArrived() throws Exception {
        GuestRepositoryInMemory.emptyList();

        Unirest.post(helloURL())
                .queryString("name", "Name1")
                .asString();
        Unirest.post(helloURL())
                .queryString("name", "Name2")
                .asString();

        String body = Unirest
                .get(guestURL())
                .asString()
                .getBody();

        assertThat(body, is("Name1\nName2"));
    }

    private String helloURL() {
        return serverURL() + "hello";
    }

    private String guestURL() {
        return serverURL() + "guests";
    }

    private String serverURL() {
        return String.format("http://localhost:%d/",RULE.localPort());
    }
}
