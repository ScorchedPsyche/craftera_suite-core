package com.github.scorchedpsyche.craftera_suite.core;

import com.github.scorchedpsyche.craftera_suite.core.Utils.Natives.ConsoleUtils;
import com.github.scorchedpsyche.craftera_suite.core.Utils.Natives.FolderUtils;
import com.github.scorchedpsyche.craftera_suite.core.Utils.Natives.StringUtils;

import org.bukkit.plugin.java.JavaPlugin;

public final class CraftEraSuiteCore extends JavaPlugin {
    public String pluginNamePrefix = "CraftEra Suite";
    public StringUtils stringUtils;
    public FolderUtils folderUtils;
    public ConsoleUtils consoleUtils;

    // Plugin startup logic
    @Override
    public void onEnable()
    {
        stringUtils = new StringUtils();
        folderUtils = new FolderUtils(this);
        consoleUtils = new ConsoleUtils();
    }

    // Plugin shutdown logic
    @Override
    public void onDisable()
    {
    }
}
