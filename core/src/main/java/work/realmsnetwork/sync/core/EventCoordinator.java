package work.realmsnetwork.sync.core;

import work.realmsnetwork.sync.api.event.SyncEvent;
import work.realmsnetwork.sync.storage.AtomicEventStore;

import java.util.Objects;

/**
 * Coordinates acceptance of events before platform-specific application.
 */
public final class EventCoordinator {

    private final AtomicEventStore store;

    public EventCoordinator(AtomicEventStore store) {
        this.store = Objects.requireNonNull(store);
    }

    public boolean accept(SyncEvent event) {
        if (store.contains(event.id())) {
            return false;
        }

        return store.appendAtomically(event);
    }
}
