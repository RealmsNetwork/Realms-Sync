package work.realmsnetwork.sync.protocol;

/**
 * Protocol versions allow nodes to reject incompatible messages safely.
 */
public record ProtocolVersion(int major, int minor) {

    public boolean isCompatibleWith(ProtocolVersion other) {
        return major == other.major;
    }
}
