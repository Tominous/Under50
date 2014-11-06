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

public class TeleportCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission("under50.teleport")) {
            sender.sendMessage(ChatColor.RED + "No access");
            return true;
        }
        Player who, toWhom;
        if (args.length == 1 && sender instanceof Player) {
            who = (Player) sender;
            toWhom = Bukkit.getServer().getPlayer(args[0]);
        } else if (args.length == 2) {
            who = Bukkit.getServer().getPlayer(args[0]);
            toWhom = Bukkit.getServer().getPlayer(args[1]);
        } else {
            sender.sendMessage(ChatColor.RED + "Improper usage.");
            return true;
        }
        if (who == null || toWhom == null) {
            sender.sendMessage(ChatColor.RED + "Player not found");
            return true;
        }
        who.teleport(toWhom);
        sender.sendMessage(ChatColor.GREEN + "Teleported " + who.getName() + " to " + toWhom.getName());
        return true;
    }
}
