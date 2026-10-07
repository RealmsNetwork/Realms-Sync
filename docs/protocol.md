# Synchronization Protocol

## Event Identity

Every replicated operation must have a unique identifier.

A receiver must be able to safely receive the same event more than once without applying it twice.

## Ordering

Events contain:

- source node
- sequence number
- world identifier
- operation identifier

Ordering is tracked per source node rather than relying on network delivery order.

## Conflict Handling

Realms-Sync does not use last-write-wins for world mutations.

Future implementations will use ownership leases and version checks for mutable world state.

## Recovery

Transports should support replaying durable events when a node reconnects.
