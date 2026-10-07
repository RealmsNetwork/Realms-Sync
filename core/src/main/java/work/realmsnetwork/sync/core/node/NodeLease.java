package work.realmsnetwork.sync.core.node;

import java.time.Instant;
import java.util.UUID;

/**
 * Represents temporary ownership of a node identity.
 *
 * Leases allow the cluster to detect stale nodes without assuming clocks are
 * perfectly synchronized.
 */
public record NodeLease(
        UUID nodeId,
        Instant acquiredAt,
        Instant expiresAt,
        long epoch
) {
    public boolean expired(Instant now) {
        return now.isAfter(expiresAt);
    }
}
