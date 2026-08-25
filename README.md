# Tungsten ⚡

A high-leverage, lightweight optimization suite for Minecraft Java Edition (Fabric) spanning `1.20.x`, `1.21.x`, `26.1.x`, and `26.2.x`.

---

## Features

- **Entity Visibility Culling**: Intercepts entity rendering passes to cull invisible and occluded entities from issuing GPU draw calls.
- **Server-Side Item & XP Merging**: Efficiently consolidates nearby item entities and experience orbs on server ticks to maintain smooth MSPT (milliseconds per tick) in mob farms.
- **Independent Configuration**: Easily toggle any module on/off via `config/hyperperformance.json`.
- **Multi-Version Architecture**: Powered by Stonecutter and Fabric Loom for seamless cross-version compatibility.

---

## Supported Minecraft Versions

- `1.20.1` (`1.20` – `1.20.3`)
- `1.20.4`
- `1.20.6` (`1.20.5` – `1.20.6`)
- `1.21.1` (`1.21` – `1.21.1`)
- `1.21.4` (`1.21.2` – `1.21.4`)
- `1.21.8` (`1.21.5` – `1.21.11`)
- `26.1.2` (`26.1` – `26.1.2`)
- `26.2`

---

## Building from Source

To compile the release JARs for all versions:
```bash
./gradlew build
```

The output JAR files will be placed into the `outputs/` directory.

---

## License

MIT License
