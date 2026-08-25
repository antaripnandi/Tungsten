package com.hyperperformance;

import com.hyperperformance.config.HyperPerformanceConfig;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HyperPerformance implements ModInitializer {
    public static final String MOD_ID = "hyperperformance";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("[Tungsten] Initializing optimization suite...");
        HyperPerformanceConfig.load();
        LOGGER.info("[Tungsten] Loaded configuration options:");
        LOGGER.info("  - Entity Culling: {}", HyperPerformanceConfig.INSTANCE.enableEntityCulling);
        LOGGER.info("  - Item & XP Merging: {}", HyperPerformanceConfig.INSTANCE.enableItemMerging);
        LOGGER.info("  - VoxelShape Dedup: {}", HyperPerformanceConfig.INSTANCE.enableVoxelShapeDedup);
        LOGGER.info("  - Fast Collision Math: {}", HyperPerformanceConfig.INSTANCE.enableFastCollision);
        LOGGER.info("  - Particle Culling: {}", HyperPerformanceConfig.INSTANCE.enableParticleCulling);
    }
}
