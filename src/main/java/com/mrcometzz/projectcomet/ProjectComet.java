package com.projectcomet;

import com.projectcomet.config.CometConfig;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProjectComet implements ModInitializer {

    public static final String MOD_ID = "projectcomet";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        CometConfig.load();
        LOGGER.info("[Project Comet] Core optimizations active. Config loaded.");
    }
}
