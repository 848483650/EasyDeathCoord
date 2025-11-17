package me.maxfield.easyDeathCoord.command;

import me.maxfield.easyDeathCoord.Main;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MainCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("只有玩家可以使用此指令");
            return true;
        }
        if (strings.length > 0) {
            if (strings[0].equalsIgnoreCase("reload")) {
                if (sender.hasPermission("easydeathcoord.reload")) {
                    Main.getPlugin(Main.class).reloadConfig();
                    sender.sendMessage("" + ChatColor.GREEN + "reload");
                } else {
                    sender.sendMessage("你没有权限");
                }
                return true;
            }
            sender.sendMessage("" + ChatColor.RED + "/easydeathcoord");
            return true;
        } else {
            if (sender.hasPermission("easydeathcoord.use")) {
                Player player = (Player) sender;
                Location location = Main.main.getListeners().getDeathLocations().get(player.getUniqueId());

                if (location != null) {
                        sender.sendMessage(ChatColor.RED + "最后一次死亡的位置" + "X:" + Integer.valueOf((int) location.getX()) + "Y:" + Integer.valueOf((int) location.getY()) + "Z:" + Integer.valueOf((int) location.getZ()));
                } else {
                    sender.sendMessage("截止本次开服你还没有死过");
                }
            }
        }
        return true;
    }
}
