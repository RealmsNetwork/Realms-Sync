package work.realmsnetwork.sync.transport;

import work.realmsnetwork.sync.api.event.SyncEvent;

/**
 * Communication abstraction. Providers can implement SQL, Redis, RabbitMQ or
 * other transports without changing the synchronization engine.
 */
public interface Transport {

    void publish(SyncEvent event);

    void subscribe(EventConsumer consumer);

    interface EventConsumer {
        void accept(SyncEvent event);
    }
}
