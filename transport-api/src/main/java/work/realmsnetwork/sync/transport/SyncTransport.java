package work.realmsnetwork.sync.transport;

import work.realmsnetwork.sync.protocol.SyncEnvelope;
import java.util.function.Consumer;

public interface SyncTransport extends AutoCloseable {
    void publish(SyncEnvelope envelope);

    void subscribe(Consumer<SyncEnvelope> consumer);

    @Override
    void close();
}
