package work.realmsnetwork.sync.storage;

import work.realmsnetwork.sync.api.event.SyncEvent;

/**
 * Storage contract for atomic event commits.
 *
 * Implementations should commit the event and any recovery metadata together
 * when the underlying backend supports transactions.
 */
public interface AtomicEventStore extends EventStore {

    boolean appendAtomically(SyncEvent event);
}
