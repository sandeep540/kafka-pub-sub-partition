package org.acme;

import java.time.Duration;
import java.util.UUID;

import org.eclipse.microprofile.reactive.messaging.Outgoing;

import io.smallrye.mutiny.Multi;
import io.smallrye.reactive.messaging.kafka.Record;
import jakarta.enterprise.context.ApplicationScoped;
import org.instancio.Instancio;

@ApplicationScoped
public class QuoteGen {

    // Populates quotes into Kafka topic
    @Outgoing("quotes")
    public Multi<Record<String, Quote>> generate() {
        return Multi.createFrom().ticks().every(Duration.ofMillis(100))
                .map(quote -> Record.of(UUID.randomUUID().toString(), Instancio.create(Quote.class)) );
    }
}