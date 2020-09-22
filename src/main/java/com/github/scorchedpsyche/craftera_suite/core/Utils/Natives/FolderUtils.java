package com.github.scorchedpsyche.craftera_suite.core.Utils.Natives;

import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;

import com.github.scorchedpsyche.craftera_suite.core.CraftEraSuiteCore;

import org.bukkit.ChatColor;

public class FolderUtils {
    private CraftEraSuiteCore plugin;
    private File pluginsFolder;
    public File cesRootFolder;

    public FolderUtils(CraftEraSuiteCore plugin) {
        this.plugin = plugin;
        pluginsFolder = getPluginsFolder();
        cesRootFolder = getOrCreateCesRootFolder();
    }

    /**
     * Retrieves or creates the root CraftEra Suite folder which holds all of the suite plugin's configuration files.
     * @return The root folder inside Plugins folder for the CraftEra Suite configurations
     */
    private File getOrCreateCesRootFolder()
    {
        String cesRootPath = pluginsFolder.toString();
        cesRootPath += File.separator + "craftera_suite";
        File cesFolder = new File( cesRootPath );

        if ( !cesFolder.exists() )
        {
            if (!cesFolder.mkdirs()) {
                plugin.consoleUtils.logError(plugin, "Main CraftEra Suite configuration folder failed to be created: check folder write permissions or try to create the folder manually. If everything looks OK and the issue still persists, report this to the developer. FOLDER PATH STRUCTURE THAT SHOULD HAVE BEEN CREATED: " + ChatColor.YELLOW + cesFolder.toString());
            }
        }

        return cesFolder;
    }

    /** 
     * @return Returns root Plugins folder.
    */
    private File getPluginsFolder()
    {
        String path;
        try {
            path = plugin.getDataFolder().getCanonicalPath();
        } catch( IOException ex ) {
            path = plugin.getDataFolder().getAbsolutePath();
        }

        String pattern = Pattern.quote(File.separator);
        String[] pathSplit = path.split(pattern);
        path = "";

        for ( int i = 0; i < pathSplit.length - 1; i++ )
        {
            path += pathSplit[i] + File.separator;
        }

        return new File( path );
    }
}