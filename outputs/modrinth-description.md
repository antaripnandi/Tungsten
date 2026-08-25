# Tungsten

**Tungsten** is a lightweight, general performance optimization suite for Fabric that speeds up rendering, entity ticks, math calculations, and memory management with zero gameplay changes.

---

## Features

### Fast Math Engine
Uses a precomputed trigonometric lookup table for `Mth.sin` and `Mth.cos` to accelerate entity animations, physics, and particle ticks.

### Mob AI Optimization
Throttles redundant goal evaluations on dormant and distant mobs to preserve high server TPS and low singleplayer MSPT.

### Memory Optimization
Caches and deduplicates block collision voxel shapes to reduce RAM usage and prevent Garbage Collection frame spikes.

### Fast Collision Math
Accelerates entity collision checks and movement ticks with optimized bounding box fast-paths.

### Entity Culling
Skips GPU draw calls for occluded and invisible entities to eliminate frame-time spikes in dense areas and mob farms.

### Item Merging
Combines loose item stacks and experience orbs on server ticks to maintain smooth MSPT during high-drop events.

### Configuration
Live in-game config screen via **Mod Menu** and JSON config at `config/hyperperformance.json`:
- `enableFastMath`
- `enableAiThrottling`
- `enableVoxelShapeDedup`
- `enableFastCollision`
- `enableEntityCulling`
- `enableItemMerging`

---

## Compatibility

- Works alongside **Sodium**, **Lithium**, and **FerriteCore**.
- Supports singleplayer, client-only multiplayer, and dedicated servers.
