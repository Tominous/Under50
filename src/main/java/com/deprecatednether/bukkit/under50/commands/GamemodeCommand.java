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

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GamemodeCommand implements CommandExecutor{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Must be a player");
            return true;
        }
        if (!sender.hasPermission("under50.gamemode")) {
            sender.sendMessage(ChatColor.RED + "No permission.");
            return true;
        }
        if (args.length != 1) {
            sender.sendMessage(ChatColor.RED + "Insufficient arguments.");
            return true;
        }
        GameMode target = null;
        String arg = args[0].toLowerCase();
        if (arg.equals("adventure") || arg.equals("a") || arg.equals("2")) {
            target = GameMode.ADVENTURE;
        } else if (arg.equals("survival") || arg.equals("s") || arg.equals("0")) {
            target = GameMode.SURVIVAL;
        } else if (arg.equals("creative") || arg.equals("c") || arg.equals("1")) {
            target = GameMode.CREATIVE;
        }
        if (target == null) {
            sender.sendMessage(ChatColor.RED + "Invalid gamemode " + arg);
            return true;
        }
        ((Player) sender).setGameMode(target);
        sender.sendMessage(ChatColor.GREEN + "Game mode set to " + ChatColor.YELLOW +
                target.toString().toLowerCase());
        return true;
    }
}
