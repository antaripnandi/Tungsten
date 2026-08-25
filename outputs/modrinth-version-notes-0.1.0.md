# HyperPerformance 0.1.0

Initial public release spanning Minecraft `1.20.x`, `1.21.x`, `26.1.x`, and `26.2.x`.

### Features
- **Entity Culling**: Intercepts entity render dispatcher to skip occluded rendering passes.
- **Item Merging**: Accelerates server-side item entity & XP orb merging.
- **JSON Configuration**: Independent per-feature toggles via `config/hyperperformance.json`.

---

### Version Compatibility Matrix

Upload each compatibility JAR to Modrinth and assign the matching Minecraft version tags:

| JAR File | Target Minecraft Versions | Mod Loader |
| --- | --- | --- |
| `hyperperformance-1.20.1-0.1.0+mc1.20.1.jar` | `1.20`, `1.20.1`, `1.20.2`, `1.20.3` | Fabric |
| `hyperperformance-1.20.4-0.1.0+mc1.20.4.jar` | `1.20.4` | Fabric |
| `hyperperformance-1.20.6-0.1.0+mc1.20.6.jar` | `1.20.5`, `1.20.6` | Fabric |
| `hyperperformance-1.21.1-0.1.0+mc1.21.1.jar` | `1.21`, `1.21.1` | Fabric |
| `hyperperformance-1.21.4-0.1.0+mc1.21.4.jar` | `1.21.2`, `1.21.3`, `1.21.4` | Fabric |
| `hyperperformance-1.21.8-0.1.0+mc1.21.8.jar` | `1.21.5`, `1.21.6`, `1.21.7`, `1.21.8`, `1.21.9`, `1.21.10`, `1.21.11` | Fabric |
| `hyperperformance-26.1.2-0.1.0+mc26.1.2.jar` | `26.1`, `26.1.1`, `26.1.2` | Fabric |
| `hyperperformance-26.2-0.1.0+mc26.2.jar` | `26.2` | Fabric |
