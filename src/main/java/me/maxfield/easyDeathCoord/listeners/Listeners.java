package me.maxfield.easyDeathCoord.listeners;

import me.clip.placeholderapi.PlaceholderAPI;
import me.maxfield.easyDeathCoord.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.HashMap;
import java.util.UUID;

public class Listeners implements Listener {
    private final HashMap<UUID, Location> deathLocations = new HashMap<>();

    @EventHandler
    public void onPlayerDead(PlayerDeathEvent event) {
        deathLocations.put(event.getEntity().getUniqueId(), event.getEntity().getLocation());
        String message = Main.main.getConfig().getString("deathmessage");
        message = PlaceholderAPI.setPlaceholders(event.getEntity().getPlayer(), message);

        if (Main.main.getConfig().getBoolean("broadcast")) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                event.getEntity().sendMessage(message);
            }
        } else {
            event.getEntity().sendMessage(message);
        }
    }

    public HashMap<UUID, Location> getDeathLocations() {
        return deathLocations;
    }
}
