package se.citerus.bookbot.health;

import com.codahale.metrics.health.HealthCheck;
import se.citerus.bookbot.resources.HelloResource;

public class HelloHealthCheck extends HealthCheck {
    private final HelloResource helloResource;

    public HelloHealthCheck(HelloResource helloResource) {
        this.helloResource = helloResource;
    }

    @Override
    protected Result check() throws Exception {
        if (helloResource.getHello(null).equals("Hello, Johan!")) {
            return Result.healthy();
        }
        return Result.unhealthy("Did not return a correct hello");
    }

}
