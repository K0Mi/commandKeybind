package com.nek036.commandkeybind.config;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import com.nek036.commandkeybind.CommandKeybind;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

import java.io.File;

@Mod.EventBusSubscriber
public class Config {
    private static final ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec config;

    static{
        config = builder.build();
    }

    public static void loadConfig(ForgeConfigSpec config, String path){
        CommandKeybind.LOGGER.info("Loading config:" + path);
        final CommentedFileConfig file = CommentedFileConfig.builder(new File(path)).sync().autosave().writingMode(WritingMode.REPLACE).build();
        CommandKeybind.LOGGER.info("Built config:" + path);
        file.load();
        CommandKeybind.LOGGER.info("Loaded config:" + path);
    }
}
