package work.realmsnetwork.sync.api.event;

import java.time.Instant;
import java.util.UUID;

/**
 * Immutable event exchanged between Realms-Sync nodes.
 *
 * Events are designed to be safely replayed. Implementations must treat the
 * event id as globally unique and avoid applying the same event twice.
 */
public interface SyncEvent {

    UUID id();

    String sourceNode();

    long sequence();

    Instant createdAt();

    String type();
}
