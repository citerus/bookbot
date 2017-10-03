package hello;

import com.mashape.unirest.http.Unirest;
import hello.testsupport.WebappRule;
import org.junit.ClassRule;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

public class HelloServletIntegrationTest {

  @ClassRule
  public static WebappRule RULE = new WebappRule();

  @Test
  public void postingEmptyReturnsHelloWorld() throws Exception {
    String body = Unirest
            .post(helloURL())
            .queryString("name", "")
            .asString()
            .getBody();

    assertThat(body, containsString("Hello, World"));
  }

  @Test
  public void postingNameReturnsNamedGreeting() throws Exception {
    String body = Unirest
            .post(helloURL())
            .queryString("name", "Johan")
            .asString()
            .getBody();

    assertThat(body, containsString("Hello, Johan"));
  }

  private String helloURL() {
    return serverURL() + "hello";
  }

  private String serverURL() {
    return String.format("http://localhost:%d/", RULE.localPort());
  }

}