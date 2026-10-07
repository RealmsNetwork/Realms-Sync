# Contributing to Realms-Sync

Thanks for helping improve Realms-Sync.

## Development Guidelines

Realms-Sync deals with distributed state. Changes should prioritize correctness over shortcuts.

Avoid:

- assuming messages always arrive in order
- applying remote changes without validation
- storing version state only in memory
- depending on one database or message broker
- adding Minecraft version specific code outside adapters

## Code Structure

Keep platform-specific code isolated:

- Core: no Bukkit or Velocity dependencies
- Bukkit adapter: Minecraft server integration
- Velocity adapter: proxy integration
- Transport: communication implementations

## Testing

Before submitting changes:

- test with multiple server instances
- test server restarts
- test duplicate event delivery
- test delayed communication

## Commit Messages

Use clear commit messages:

```
feat: add chunk ownership tracking
fix: prevent duplicate event processing
docs: update architecture notes
```
