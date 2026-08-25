package com.hyperperformance.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class HyperPerformanceConfig {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final File CONFIG_FILE = new File("config/hyperperformance.json");

    public boolean enableEntityCulling = true;
    public boolean enableItemMerging = true;
    public boolean enableModelDeduplication = true;
    public boolean enableLazyDfu = true;
    public boolean enableImmediateBatching = true;

    public static HyperPerformanceConfig INSTANCE = new HyperPerformanceConfig();

    public static void load() {
        if (CONFIG_FILE.exists()) {
            try (FileReader reader = new FileReader(CONFIG_FILE)) {
                INSTANCE = GSON.fromJson(reader, HyperPerformanceConfig.class);
                if (INSTANCE == null) {
                    INSTANCE = new HyperPerformanceConfig();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            save();
        }
    }

    public static void save() {
        try {
            File parent = CONFIG_FILE.getParentFile();
            if (parent != null && !parent.exists()) {
                parent.mkdirs();
            }
            try (FileWriter writer = new FileWriter(CONFIG_FILE)) {
                GSON.toJson(INSTANCE, writer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
