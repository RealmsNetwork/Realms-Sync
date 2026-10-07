package work.realmsnetwork.sync.core.event;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Generates monotonic sequence numbers per node.
 *
 * Sequence numbers are scoped to a node identity. They are not a replacement
 * for global ordering in a distributed system.
 */
public final class EventSequencer {

    private final Map<UUID, AtomicLong> sequences = new ConcurrentHashMap<>();

    public long next(UUID nodeId) {
        return sequences.computeIfAbsent(nodeId, ignored -> new AtomicLong())
                .incrementAndGet();
    }
}
