package work.realmsnetwork.sync.api.node;

import java.util.UUID;

/**
 * Represents a server participating in a Realms-Sync cluster.
 */
public interface SyncNode {

    String id();

    UUID uniqueId();

    String platform();

    String minecraftVersion();

    default boolean supportsWorldReplication() {
        return false;
    }
}
