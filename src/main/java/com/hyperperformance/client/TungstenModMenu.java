package com.hyperperformance.client;

import com.hyperperformance.client.screen.TungstenConfigScreen;
import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;

public class TungstenModMenu implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return TungstenConfigScreen::create;
    }
}
