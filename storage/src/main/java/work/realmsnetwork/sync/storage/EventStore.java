package work.realmsnetwork.sync.storage;

import work.realmsnetwork.sync.api.event.SyncEvent;

import java.util.List;
import java.util.Optional;

/**
 * Persistent storage contract for synchronization events.
 * Implementations may use SQL, Redis streams, or other durable stores.
 */
public interface EventStore {

    void append(SyncEvent event);

    boolean contains(String eventId);

    Optional<SyncEvent> find(String eventId);

    List<SyncEvent> replay(long afterSequence);
}
