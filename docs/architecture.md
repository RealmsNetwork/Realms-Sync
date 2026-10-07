# Architecture

## Overview

Realms-Sync is built as a distributed coordination layer above Minecraft servers.

The project does not attempt to directly replace the Minecraft server engine. Instead, it provides controlled synchronization between independent instances.

## Components

```
                 Velocity
                    |
             Realms-Sync Proxy
                    |
        +-----------+-----------+
        |           |           |
    Backend A   Backend B   Backend C
        |           |           |
             Realms-Sync Core
                    |
        Transport and Storage Layer
```

## Event Model

Changes should use immutable events.

Example:

```json
{
  "id": "unique-event-id",
  "source": "survival-us",
  "world": "overworld",
  "sequence": 100,
  "type": "BLOCK_CHANGE"
}
```

Events must be safe to process more than once.

## Conflict Prevention

The synchronization layer will use:

- unique event IDs
- monotonic sequence numbers
- chunk ownership leases
- persistent recovery data

The goal is preventing duplicated updates and inconsistent state.

## Transport Layer

Communication is abstracted so deployments can choose their own infrastructure.

Examples:

- MySQL/MariaDB
- Redis
- RabbitMQ
- custom transports

## Future Work

World replication requires handling:

- chunk data
- block entities
- scheduled ticks
- entities
- redstone behavior

These systems require independent testing before production use.
