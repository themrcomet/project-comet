package com.projectcomet;


import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

@Environment(EnvType.CLIENT)
public class ProjectCometClient implements ClientModInitializer {

    private static KeyBinding hudToggleKey;
    

    @Override
    public void onInitializeClient() {
        ProjectComet.LOGGER.info("[Project Comet] Client optimizations active.");



        // Register the HUD renderer
        HudRenderCallback.EVENT.register(HUD);

        // Listen for keybind presses
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (hudToggleKey.wasPressed()) {
                CometDebugHud.visible = !CometDebugHud.visible;
                ProjectComet.LOGGER.debug("[Project Comet] HUD visibility: {}", CometDebugHud.visible);
            }
        });

        ProjectComet.LOGGER.info("[Project Comet] Debug HUD registered on F7.");
    }
}
