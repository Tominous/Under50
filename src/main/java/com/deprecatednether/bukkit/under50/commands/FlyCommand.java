package com.deprecatednether.bukkit.under50.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Must be a player to fly");
            return true;
        }
        if (!sender.hasPermission("under50.fly")) {
            sender.sendMessage(ChatColor.RED + "Insufficient permission.");
            return true;
        }
        Player player = (Player) sender;
        player.setAllowFlight(!player.getAllowFlight());
        player.sendMessage(ChatColor.YELLOW + "Flight mode " + (player.getAllowFlight() ?
                ChatColor.GREEN + "enabled" : ChatColor.RED + "disabled") + ChatColor.YELLOW + ".");
        return true;
    }
}
