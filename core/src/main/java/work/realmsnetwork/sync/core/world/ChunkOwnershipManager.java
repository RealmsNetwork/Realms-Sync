package work.realmsnetwork.sync.core.world;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Basic ownership registry. Future storage providers can replace this with a
 * persistent implementation.
 */
public final class ChunkOwnershipManager {
    private final Map<String, ChunkOwnership> ownership = new ConcurrentHashMap<>();

    private String key(String world, int x, int z) {
        return world + ":" + x + ":" + z;
    }

    public void claim(ChunkOwnership chunk) {
        ownership.put(key(chunk.world(), chunk.chunkX(), chunk.chunkZ()), chunk);
    }

    public ChunkOwnership get(String world, int x, int z) {
        return ownership.get(key(world, x, z));
    }

    public boolean canModify(String node, String world, int x, int z) {
        ChunkOwnership chunk = get(world, x, z);
        return chunk == null || chunk.ownerNode().equals(node);
    }
}
