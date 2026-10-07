package work.realmsnetwork.sync.storage;

/**
 * Allows storage implementations to provide atomic multi-step operations.
 */
public interface TransactionManager {
    void execute(Runnable operation);
}
