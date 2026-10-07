package work.realmsnetwork.sync.transport;

import work.realmsnetwork.sync.api.event.SyncEvent;

import java.util.function.Consumer;

/**
 * Communication abstraction. Providers can implement SQL, Redis, RabbitMQ or
 * custom transports without changing the synchronization engine.
 */
public interface Transport {

    void publish(SyncEvent event);

    void subscribe(Consumer<SyncEvent> consumer);

    default void close() {
    }
}
