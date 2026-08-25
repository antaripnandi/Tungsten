package com.hyperperformance.client;

import com.hyperperformance.HyperPerformance;
import net.fabricmc.api.ClientModInitializer;

public class HyperPerformanceClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HyperPerformance.LOGGER.info("[HyperPerformance] Initialized client-side rendering & culling pipeline.");
    }
}
