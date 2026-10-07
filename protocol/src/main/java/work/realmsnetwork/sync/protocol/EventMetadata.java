package work.realmsnetwork.sync.protocol;

import java.util.UUID;

/**
 * Metadata used when ordering and validating distributed events.
 */
public record EventMetadata(
        UUID eventId,
        UUID sourceNode,
        long sequence,
        long epoch
) {
}
