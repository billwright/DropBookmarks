package com.udemy;

import com.udemy.auth.HelloAuthenticator;
import com.udemy.core.User;
import com.udemy.resources.HelloResource;
import io.dropwizard.Application;
import io.dropwizard.auth.AuthFactory;
import io.dropwizard.auth.basic.BasicAuthFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class DropbookmarksApplication extends Application<DropbookmarksConfiguration> {

    public static void main(final String[] args) throws Exception {
        new DropbookmarksApplication().run(args);
    }

    @Override
    public String getName() {
        return "Dropbookmarks";
    }

    @Override
    public void initialize(final Bootstrap<DropbookmarksConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final DropbookmarksConfiguration configuration,
                    final Environment environment) {
        environment.jersey().register(new HelloResource());
        environment.jersey().register(
                AuthFactory.binder(
                        new BasicAuthFactory<>(
                                new HelloAuthenticator(),
                                "SECURITY REALM",
                                User.class
                        )
                )
        );
    }

}
