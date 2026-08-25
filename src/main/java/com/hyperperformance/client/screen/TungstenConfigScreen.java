package com.hyperperformance.client.screen;

import com.hyperperformance.config.HyperPerformanceConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;

public final class TungstenConfigScreen extends Screen {
    private final Screen parent;

    private TungstenConfigScreen(Screen parent) {
        super(Component.literal("Tungsten Settings"));
        this.parent = parent;
    }

    public static Screen create(Screen parent) {
        return new TungstenConfigScreen(parent);
    }

    @Override
    protected void init() {
        int y = 35;
        int btnWidth = 220;
        int x = (this.width - btnWidth) / 2;

        addToggleButton(x, y, "Entity Visibility Culling", () -> HyperPerformanceConfig.INSTANCE.enableEntityCulling, v -> HyperPerformanceConfig.INSTANCE.enableEntityCulling = v);
        y += 24;
        addToggleButton(x, y, "Item & XP Orb Merging", () -> HyperPerformanceConfig.INSTANCE.enableItemMerging, v -> HyperPerformanceConfig.INSTANCE.enableItemMerging = v);
        y += 24;
        addToggleButton(x, y, "VoxelShape Memory Dedup", () -> HyperPerformanceConfig.INSTANCE.enableVoxelShapeDedup, v -> HyperPerformanceConfig.INSTANCE.enableVoxelShapeDedup = v);
        y += 24;
        addToggleButton(x, y, "Fast Collision Math", () -> HyperPerformanceConfig.INSTANCE.enableFastCollision, v -> HyperPerformanceConfig.INSTANCE.enableFastCollision = v);
        y += 24;
        addToggleButton(x, y, "Particle Culling", () -> HyperPerformanceConfig.INSTANCE.enableParticleCulling, v -> HyperPerformanceConfig.INSTANCE.enableParticleCulling = v);

        y += 30;
        this.addRenderableWidget(
            Button.builder(CommonComponents.GUI_DONE, b -> this.onClose())
                .bounds(x, y, btnWidth, 20)
                .build()
        );
    }

    private void addToggleButton(int x, int y, String label, java.util.function.BooleanSupplier getter, java.util.function.Consumer<Boolean> setter) {
        this.addRenderableWidget(
            Button.builder(Component.literal(label + ": " + (getter.getAsBoolean() ? "ON" : "OFF")), b -> {
                boolean next = !getter.getAsBoolean();
                setter.accept(next);
                b.setMessage(Component.literal(label + ": " + (next ? "ON" : "OFF")));
                HyperPerformanceConfig.save();
            })
            .bounds(x, y, 220, 20)
            .build()
        );
    }

    @Override
    public void onClose() {
        HyperPerformanceConfig.save();
//? if <26.2 {
/*      Minecraft.getInstance().setScreen(parent);
*///?} else {
        Minecraft.getInstance().gui.setScreen(parent);
//?}
    }
}
