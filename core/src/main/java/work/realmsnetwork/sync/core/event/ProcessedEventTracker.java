package work.realmsnetwork.sync.core.event;

import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Tracks events already accepted by a node.
 *
 * Durable implementations belong in storage providers; this class provides
 * the in-memory coordination primitive used by the core.
 */
public final class ProcessedEventTracker {

    private final Set<UUID> processed = ConcurrentHashMap.newKeySet();

    public boolean markProcessed(UUID eventId) {
        return processed.add(eventId);
    }

    public boolean hasProcessed(UUID eventId) {
        return processed.contains(eventId);
    }
}
