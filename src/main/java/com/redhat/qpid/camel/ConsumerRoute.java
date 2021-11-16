package com.redhat.qpid.camel;

import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConsumerRoute extends RouteBuilder {

    private static final Logger LOG = LoggerFactory.getLogger(ConsumerRoute.class);

    @Value("${destination.address}")
    private String destinationName;

    @Override
    public void configure() {

        LOG.debug(destinationName);

        from(destinationName)
                .log("============= Received: ${body}");
    }
}
