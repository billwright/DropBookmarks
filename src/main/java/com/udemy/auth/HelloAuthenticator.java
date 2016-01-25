package com.udemy.auth;


import com.google.common.base.Optional;
import com.udemy.core.User;
import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.basic.BasicCredentials;

/**
 * Created by bwright on 1/15/16.
 */
public class HelloAuthenticator implements io.dropwizard.auth.Authenticator<BasicCredentials, User> {

    @Override
    public Optional<User> authenticate(BasicCredentials basicCredentials) throws AuthenticationException {
        if ("p@ssw0rd".equals(basicCredentials.getPassword())) {
            return Optional.of(new User());
        } else {
            return Optional.absent();
        }
    }
}
