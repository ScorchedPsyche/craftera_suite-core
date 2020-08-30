package com.github.scorchedpsyche.craftera_suite.core;

import com.github.scorchedpsyche.craftera_suite.core.Utils.Natives.StringUtils;
import org.bukkit.plugin.java.JavaPlugin;

public final class CraftEraSuiteCore extends JavaPlugin {
    public StringUtils stringUtils;

    // Plugin startup logic
    @Override
    public void onEnable()
    {
        stringUtils = new StringUtils();
    }

    // Plugin shutdown logic
    @Override
    public void onDisable()
    {
    }
}
