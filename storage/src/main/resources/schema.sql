CREATE TABLE IF NOT EXISTS realms_sync_events (
    event_id VARCHAR(36) PRIMARY KEY,
    source_node VARCHAR(36) NOT NULL,
    sequence_number BIGINT NOT NULL,
    event_type VARCHAR(128) NOT NULL,
    checksum VARCHAR(128) NOT NULL,
    payload BLOB NOT NULL,
    created_at TIMESTAMP NOT NULL,
    UNIQUE KEY uq_node_sequence (source_node, sequence_number)
);

CREATE TABLE IF NOT EXISTS realms_sync_recovery_log (
    event_id VARCHAR(36) PRIMARY KEY,
    status VARCHAR(32) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    completed_at TIMESTAMP NULL
);
