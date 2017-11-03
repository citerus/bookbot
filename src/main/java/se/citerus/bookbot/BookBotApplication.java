package se.citerus.bookbot;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import se.citerus.bookbot.health.HelloHealthCheck;
import se.citerus.bookbot.resources.HelloResource;

public class BookBotApplication extends Application<BookBotConfiguration> {

    public static void main(final String[] args) throws Exception {
        new BookBotApplication().run(args);
    }

    @Override
    public String getName() {
        return "BookBot";
    }

    @Override
    public void initialize(final Bootstrap<BookBotConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final BookBotConfiguration c,
                    final Environment e) {
        e.jersey().register(new HelloResource());
        HelloResource helloResource = null;
        e.healthChecks().register("", new HelloHealthCheck(helloResource));

    }

}
