package work.realmsnetwork.sync.core;

import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Tracks processed events to provide idempotent replication.
 */
public final class EventRegistry {

    private final Set<UUID> processed = ConcurrentHashMap.newKeySet();

    public boolean markProcessed(UUID id) {
        return processed.add(id);
    }

    public boolean wasProcessed(UUID id) {
        return processed.contains(id);
    }
}
