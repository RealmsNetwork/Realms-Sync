package work.realmsnetwork.sync.mysql;

import work.realmsnetwork.sync.protocol.SyncEnvelope;
import work.realmsnetwork.sync.transport.SyncTransport;

import java.util.function.Consumer;

/**
 * MariaDB/MySQL transport implementation entry point.
 *
 * Database schema and SQL batching are intentionally kept separate from the
 * transport API so deployments can tune durability and throughput.
 */
public final class MySqlEventTransport implements SyncTransport {

    @Override
    public void publish(SyncEnvelope envelope) {
        throw new UnsupportedOperationException("SQL persistence adapter not configured");
    }

    @Override
    public void subscribe(Consumer<SyncEnvelope> consumer) {
        throw new UnsupportedOperationException("SQL consumer not configured");
    }

    @Override
    public void close() {
    }
}
