package work.realmsnetwork.sync.core.node;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Tracks node heartbeat timestamps. Transport and persistence are intentionally
 * external so different discovery systems can be used.
 */
public final class HeartbeatManager {
    private final Map<UUID, Instant> heartbeats = new ConcurrentHashMap<>();
    private final Clock clock;

    public HeartbeatManager() {
        this(Clock.systemUTC());
    }

    public HeartbeatManager(Clock clock) {
        this.clock = clock;
    }

    public void heartbeat(UUID nodeId) {
        heartbeats.put(nodeId, clock.instant());
    }

    public boolean isAlive(UUID nodeId, Duration timeout) {
        Instant last = heartbeats.get(nodeId);
        return last != null && last.plus(timeout).isAfter(clock.instant());
    }
}
