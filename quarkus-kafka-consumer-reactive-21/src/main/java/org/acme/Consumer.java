package org.acme;

import io.smallrye.common.annotation.RunOnVirtualThread;
import io.vertx.core.impl.logging.Logger;
import io.vertx.core.impl.logging.LoggerFactory;
import org.eclipse.microprofile.reactive.messaging.*;

import jakarta.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class Consumer {

    private final Logger logger = LoggerFactory.getLogger(Consumer.class);

    @Incoming("quotes")
    @RunOnVirtualThread
    public void consume(io.smallrye.reactive.messaging.kafka.Record<String, Quote> record) {
        logger.info("Key: "+ record.key().toString() +"  Value ------- >> " + record.value().toString());
    }

}
