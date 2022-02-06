package com.test;

import java.util.Date;
import java.util.Random;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Gauge;
import org.eclipse.microprofile.metrics.annotation.Timed;

@Path("/hello")
public class GreetingResource {
    
    Random r = new Random();

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Counted(name = "getOneTask", description = "How many get method being triggered.")
    @Timed(name = "getOneTaskTimer", description = "How long get one task perform", unit = MetricUnits.MILLISECONDS)
    public String hello() {
        return "Hello there, the time is " + new Date();
    }

    @Gauge(unit = MetricUnits.NONE, name = "queueSize", description = "The number of applications in the queue waiting to be processed")
    public int getQueueSize() {
        return r.nextInt(100);
    }
}
