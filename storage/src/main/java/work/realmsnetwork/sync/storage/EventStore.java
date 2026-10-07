package work.realmsnetwork.sync.storage;

import work.realmsnetwork.sync.api.event.SyncEvent;

import java.util.List;
import java.util.Optional;

/**
 * Durable event storage abstraction.
 *
 * Implementations must preserve event ordering and provide replay support.
 * Conflict resolution is handled by the synchronization layer, not by
 * blindly replacing newer records.
 */
public interface EventStore {

    void append(SyncEvent event);

    boolean contains(String eventId);

    Optional<SyncEvent> find(String eventId);

    List<SyncEvent> replay(long afterSequence);
}
