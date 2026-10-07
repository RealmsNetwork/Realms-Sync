package work.realmsnetwork.sync.core;

import work.realmsnetwork.sync.api.event.SyncEvent;
import work.realmsnetwork.sync.storage.EventStore;

import java.util.Objects;

/**
 * Coordinates duplicate checks and durable event storage before applying events.
 */
public final class EventProcessor {

    private final EventStore store;

    public EventProcessor(EventStore store) {
        this.store = Objects.requireNonNull(store);
    }

    public boolean process(SyncEvent event) {
        if (store.contains(event.id())) {
            return false;
        }

        store.append(event);
        return true;
    }
}
