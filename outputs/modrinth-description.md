# HyperPerformance

**HyperPerformance** is a lightweight optimization mod for Fabric that speeds up rendering, entity handling, and server ticks with zero gameplay changes.

---

## Features

### Entity Culling
Skips GPU draw calls for occluded and invisible entities to eliminate frame-time spikes in dense areas and mob farms.

### Item Merging
Combines loose item stacks and experience orbs on server ticks to maintain smooth MSPT during high-drop events.

### Configuration
Every feature can be toggled in `config/hyperperformance.json`:
- `enableEntityCulling`
- `enableItemMerging`
- `enableModelDeduplication`
- `enableLazyDfu`
- `enableImmediateBatching`

---

## Compatibility

- Works alongside **Sodium**, **Lithium**, and **FerriteCore**.
- Supports singleplayer, client-only multiplayer, and dedicated servers.
