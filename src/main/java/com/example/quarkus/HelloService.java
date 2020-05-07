package com.example.quarkus;

import io.quarkus.scheduler.Scheduled;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Singleton;
import java.util.concurrent.atomic.AtomicInteger;

//Fails
//@ApplicationScoped

//Works
@Singleton


public class HelloService {
    final AtomicInteger c = new AtomicInteger();

    private static final Logger LOG = Logger.getLogger(HelloService.class.getName());

    @Scheduled(every = "1s")
    public void updateCounter() {
        LOG.info(c.incrementAndGet());
    }
}
