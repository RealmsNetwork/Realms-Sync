package work.realmsnetwork.sync.protocol;

import java.time.Instant;
import java.util.UUID;

/**
 * Transport-independent event wrapper. Consumers must process eventId only once.
 */
public record SyncEnvelope(
        UUID eventId,
        UUID sourceNode,
        long sequence,
        String type,
        byte[] payload,
        String checksum,
        Instant createdAt
) {
}
