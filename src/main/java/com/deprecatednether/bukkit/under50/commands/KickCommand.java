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

public class KickCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission("under50.kick")) {
            sender.sendMessage(ChatColor.RED + "No access");
            return true;
        }
        if (args.length < 1) {
            sender.sendMessage(ChatColor.RED + "Improper usage.");
            return true;
        }
        Player target = Bukkit.getServer().getPlayer(args[0]);
        if (target == null) {
            sender.sendMessage(ChatColor.RED + args[0] + " is not online");
            return true;
        }
        String reason = "";
        for (int i=1;i<args.length;i++) {
            reason += " " + args[i];
        }
        if (reason.equals("")) {
            reason = " No reason given";
        }
        reason = reason.substring(1);
        target.kickPlayer(ChatColor.YELLOW + "You've been kicked by " + ChatColor.RED +
                sender.getName() + "\n" + ChatColor.YELLOW + reason);
        sender.sendMessage(ChatColor.GREEN + "Kicked " + target.getName());
        return true;
    }
}
