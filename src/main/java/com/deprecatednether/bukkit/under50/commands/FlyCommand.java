/*
 * Copyright (C) 2014  DeprecatedNether
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.deprecatednether.bukkit.under50.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player target;
        if (!(sender instanceof Player) && args.length != 1) {
            sender.sendMessage("Try /fly <player name>");
            return true;
        }
        if (!sender.hasPermission("under50.fly")) {
            sender.sendMessage(ChatColor.RED + "Insufficient permission.");
            return true;
        }
        if (args.length == 1) {
            target = Bukkit.getServer().getPlayer(args[0]);
        } else {
            target = (Player) sender;
        }
        if (target == null) {
            sender.sendMessage(ChatColor.RED + "Unknown player");
            return true;
        }
        target.setAllowFlight(!target.getAllowFlight());
        target.sendMessage(ChatColor.YELLOW + "Flight mode " + (target.getAllowFlight() ?
                ChatColor.GREEN + "enabled" : ChatColor.RED + "disabled") + ChatColor.YELLOW + ".");
        if (!target.equals(sender)) {
            sender.sendMessage(ChatColor.YELLOW + "Flight mode for " + target.getName() + " " +
                    (target.getAllowFlight() ? ChatColor.GREEN + "enabled" : ChatColor.RED +
                    "disabled") + ChatColor.YELLOW + ".");
        }
        return true;
    }
}
