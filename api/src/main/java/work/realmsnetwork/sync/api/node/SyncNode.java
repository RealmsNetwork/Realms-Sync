package work.realmsnetwork.sync.api.node;

/**
 * Represents a server participating in a Realms-Sync cluster.
 */
public interface SyncNode {

    String id();

    String platform();

    String minecraftVersion();
}
