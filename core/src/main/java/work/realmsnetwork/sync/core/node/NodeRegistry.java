package work.realmsnetwork.sync.core.node;

import work.realmsnetwork.sync.api.node.SyncNode;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Tracks nodes currently known by the synchronization cluster.
 */
public final class NodeRegistry {
    private final Map<String, SyncNode> nodes = new ConcurrentHashMap<>();

    public void register(SyncNode node) {
        nodes.put(node.id(), node);
    }

    public void unregister(String id) {
        nodes.remove(id);
    }

    public Optional<SyncNode> find(String id) {
        return Optional.ofNullable(nodes.get(id));
    }

    public Map<String, SyncNode> snapshot() {
        return Map.copyOf(nodes);
    }
}
