/*
 * Copyright (C) 2014  RapidWolf_
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

public class BroadcastCommand implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!sender.hasPermission("under50.broadcast")) {
            sender.sendMessage(ChatColor.RED + "No permission");
            return true;
        }
        if (args.length == 0) {
            sender.sendMessage("Try /bcast <message>");
            return true;
        }
        StringBuilder message = new StringBuilder();
        for (String part : args) {
            message.append(" ").append(part);
        }
        Bukkit.getServer().broadcastMessage(ChatColor.AQUA + "[BROADCAST]" + message.toString());
        return true;
    }
}

