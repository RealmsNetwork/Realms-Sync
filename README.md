# Realms-Sync

A distributed synchronization framework for Minecraft servers.

Realms-Sync is designed for networks that need multiple backend instances to cooperate without replacing the Minecraft server implementation. It focuses on safe synchronization primitives, dimension routing, and future world replication capabilities.

> This project is in early development. It does not currently claim to be a replacement for MultiPaper or a fully distributed Minecraft server engine.

## Goals

- Support multiple proxy setups
- Support multiple backend instances
- Separate dimensions across server instances
- Provide optional replication between instances
- Avoid duplicate world changes through versioning and event tracking
- Support different infrastructure providers

## Supported Platforms

Planned support:

- Velocity proxy
- Paper-based servers
- Purpur-based servers
- Spigot-compatible servers where APIs allow

Minecraft compatibility is designed around a version adapter system instead of locking the project to one Minecraft release.

Target compatibility:

- Minecraft 1.8+
- Modern Minecraft releases

## Architecture

Realms-Sync is split into separate components:

```
Realms-Sync
├── API
├── Core
├── Platform adapters
│   ├── Bukkit/Paper/Purpur
│   └── Velocity
├── Transport providers
│   ├── SQL
│   ├── Redis
│   ├── RabbitMQ
│   └── Custom
└── Storage providers
```

## Design Principles

### No blind syncing

World data is not copied around without tracking. Synchronization uses:

- event identifiers
- sequence numbers
- chunk ownership
- recovery history

### No required infrastructure

A server should not need one specific service to run Realms-Sync.

Possible transports:

- MariaDB/MySQL
- Redis
- RabbitMQ
- Custom implementations

## Planned Features

### Phase 1 - Foundation

- [ ] Core API
- [ ] Server registration
- [ ] Node discovery
- [ ] Transport abstraction
- [ ] Configuration system

### Phase 2 - Network Features

- [ ] Velocity integration
- [ ] Dimension routing
- [ ] Instance health checks
- [ ] Player transfer handling

### Phase 3 - Synchronization

- [ ] Block change events
- [ ] Container synchronization
- [ ] Block entity synchronization
- [ ] Chunk snapshots

### Phase 4 - Advanced Replication

- [ ] Chunk replication
- [ ] Conflict handling
- [ ] Recovery logs
- [ ] Entity synchronization research

## Development Status

Realms-Sync is experimental software.

The project prioritizes correctness over speed. Minecraft world synchronization has difficult edge cases involving:

- scheduled ticks
- redstone
- entities
- chunk loading
- inventories
- crashes
- network partitions

These systems will be implemented gradually with testing before being enabled for production use.

## License

License information will be added before the first release.
