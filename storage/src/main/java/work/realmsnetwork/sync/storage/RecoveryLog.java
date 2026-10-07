package work.realmsnetwork.sync.storage;

import work.realmsnetwork.sync.api.event.SyncEvent;

import java.util.List;

/**
 * Durable journal contract for events that may need replay after recovery.
 */
public interface RecoveryLog {

    void record(SyncEvent event);

    List<SyncEvent> pendingReplay();

    void acknowledge(String eventId);
}
