package com.github.scorchedpsyche.craftera_suite.core;

import com.github.scorchedpsyche.craftera_suite.core.Utils.Natives.ConsoleUtils;
import com.github.scorchedpsyche.craftera_suite.core.Utils.Natives.FolderUtils;
import com.github.scorchedpsyche.craftera_suite.core.Utils.Natives.StringUtils;
import com.github.scorchedpsyche.craftera_suite.core.main.SuitePluginManager;
import com.github.scorchedpsyche.craftera_suite.core.main.commands.CustomCommandExecutor;
import com.github.scorchedpsyche.craftera_suite.core.main.commands.CustomTabCompleter;

import org.bukkit.plugin.java.JavaPlugin;

public final class CraftEraSuiteCore extends JavaPlugin {
    public String pluginNamePrefix = "CraftEra Suite";
    public StringUtils stringUtils;
    public FolderUtils folderUtils;
    public ConsoleUtils consoleUtils;
    
    public SuitePluginManager suitePlugins;

    // Plugin startup logic
    @Override
    public void onEnable()
    {
        stringUtils = new StringUtils();
        folderUtils = new FolderUtils(this);
        consoleUtils = new ConsoleUtils();
        suitePlugins = new SuitePluginManager();

        // Register "ces" command
        this.getCommand("ces").setExecutor(new CustomCommandExecutor(this));
        this.getCommand("ces").setTabCompleter(new CustomTabCompleter(this));
    }

    // Plugin shutdown logic
    @Override
    public void onDisable()
    {
    }

    /**
     * Saves plugin as loaded by the server.
     * @param plugin Plugin to be saved
     */
    public void enablePlugin(String name)
    {
        switch(name)
        {
            case "craftera_suite-hud":
                suitePlugins.isHudPluginEnabled = true;
                break;
        }
    }
}
