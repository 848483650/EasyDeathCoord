package me.maxfield.easyDeathCoord;

import me.maxfield.easyDeathCoord.command.MainCommand;
import me.maxfield.easyDeathCoord.listeners.Listeners;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    public static Main main;
    private Listeners listeners = new Listeners();
    @Override
    public void onEnable() {
        // Plugin startup logic
        saveDefaultConfig();
        main = this;
        getCommand("easydeathcoord").setExecutor(new MainCommand());
        getLogger().info("简单死亡记录已启动");

        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            /*
             * We register the EventListener here, when PlaceholderAPI is installed.
             * Since all events are in the main class (this class), we simply use "this"
             */
            Bukkit.getPluginManager().registerEvents(listeners, this);
        } else {
            /*
             * We inform about the fact that PlaceholderAPI isn't installed and then
             * disable this plugin to prevent issues.
             */
            getLogger().warning("简单死亡记录需要PlaceHolderAPI");
            Bukkit.getPluginManager().disablePlugin(this);
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("简单死亡记录已经关闭");
    }

    public Listeners getListeners() {
        return listeners;
    }
}
