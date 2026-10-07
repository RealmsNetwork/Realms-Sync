package work.realmsnetwork.sync.core;

import java.util.UUID;
import java.util.function.Supplier;

/**
 * Validates ownership before applying mutable synchronization operations.
 */
public final class LeaseValidator {
    private final Supplier<UUID> activeLease;

    public LeaseValidator(Supplier<UUID> activeLease) {
        this.activeLease = activeLease;
    }

    public boolean owns(UUID leaseId) {
        return leaseId != null && leaseId.equals(activeLease.get());
    }
}
