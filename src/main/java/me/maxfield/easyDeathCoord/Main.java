package me.maxfield.easyDeathCoord;

import me.maxfield.easyDeathCoord.command.MainCommand;
import me.maxfield.easyDeathCoord.listeners.Listeners;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    private static Main main;
    private Listeners listeners = new Listeners();
    @Override
    public void onEnable() {
        // Plugin startup logic
        main = this;
        Bukkit.getPluginManager().registerEvents(listeners, this);
        getCommand("easydeathcoord").setExecutor(new MainCommand());
        getLogger().info("EasyDeathCoord is runing.");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("EasyDeathCoord is closing.");
    }
}
