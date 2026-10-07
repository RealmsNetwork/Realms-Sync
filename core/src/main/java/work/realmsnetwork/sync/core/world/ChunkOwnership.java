package work.realmsnetwork.sync.core.world;

/**
 * Represents ownership of a chunk inside a synchronized world.
 *
 * Ownership is intentionally separated from replication. A replica can exist
 * without being allowed to mutate state.
 */
public record ChunkOwnership(
        String world,
        int chunkX,
        int chunkZ,
        String ownerNode,
        long version
) {
}
