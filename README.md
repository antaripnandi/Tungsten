# Tungsten ⚡

**Tungsten** is a comprehensive, high-leverage Minecraft Java Edition optimization suite for Fabric spanning versions `1.20.x`, `1.21.x`, `26.1.x`, and `26.2.x`.

---

## 🚀 Key Features

- **🧮 Fast Math Engine**: Replaces expensive trigonometric calculations with a precomputed 65,536-entry lookup table for `Mth.sin` and `Mth.cos`, speeding up entity animations, weather, and particle ticks.
- **💤 Mob AI Optimization**: Intelligently throttles redundant goal evaluation sweeps for dormant and distant mobs, boosting server TPS and singleplayer MSPT.
- **🧠 Memory & VoxelShape Deduplication**: Caches and deduplicates block collision shapes to cut RAM allocation and eliminate Garbage Collection (GC) freeze spikes.
- **⚡ Fast Collision Math**: Early-outs empty bounding box and non-intersect checks on entity movements to accelerate player and mob movement ticks.
- **👁️ Entity Visibility Culling**: Skips GPU draw calls for occluded and invisible entities to eliminate frame-time spikes in dense areas.
- **📦 Server-Side Item & XP Orb Merging**: Aggressively merges loose item stacks and experience orbs during high-yield mob farm drops.
- **⚙️ Native In-Game Config GUI**: Fully integrated with **Mod Menu** and standalone JSON config (`config/hyperperformance.json`) with live toggles for every single module.

---

## 🎯 Supported Minecraft Versions

- `1.20.1` (`1.20` – `1.20.3`)
- `1.20.4`
- `1.20.6` (`1.20.5` – `1.20.6`)
- `1.21.1` (`1.21` – `1.21.1`)
- `1.21.4` (`1.21.2` – `1.21.4`)
- `1.21.8` (`1.21.5` – `1.21.11`)
- `26.1.2` (`26.1` – `26.1.2`)
- `26.2`

---

## 🔨 Building from Source

```bash
./gradlew build
```

The output JAR files will be placed into the `outputs/` directory.

---

## 📜 License

MIT License
