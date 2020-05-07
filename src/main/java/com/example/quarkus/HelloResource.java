package com.example.quarkus;

import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/counter")
@Singleton
public class HelloResource {

    private static final Logger LOG = Logger.getLogger(HelloResource.class.getName());

    @Inject
    HelloService s;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello() {
        LOG.info("sayHello called...");
        return Integer.toString(s.c.get());
    }
}
