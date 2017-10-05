package hello.infrastructure;

import com.mashape.unirest.http.Unirest;
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
        String body = Unirest
                .get(guestURL())
                .asString()
                .getBody();

        assertThat(body, is(""));
    }

    private String guestURL() {
        return serverURL() + "guests";
    }

    private String serverURL() {
        return String.format("http://localhost:%d/",RULE.localPort());
    }
}
