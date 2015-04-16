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

package com.deprecatednether.bukkit.under50;

import com.deprecatednether.bukkit.under50.commands.BroadcastCommand;
import com.deprecatednether.bukkit.under50.commands.FlyCommand;
import com.deprecatednether.bukkit.under50.commands.GamemodeCommand;
import com.deprecatednether.bukkit.under50.commands.KickCommand;
import com.deprecatednether.bukkit.under50.commands.ListCommand;
import com.deprecatednether.bukkit.under50.commands.TeleportCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class UnderFifty extends JavaPlugin {
    @Override
    public void onEnable() {
        getCommand("fly").setExecutor(new FlyCommand());
        getCommand("gamemode").setExecutor(new GamemodeCommand());
        getCommand("list").setExecutor(new ListCommand());
        getCommand("tp").setExecutor(new TeleportCommand());
        getCommand("kick").setExecutor(new KickCommand());
        getCommand("bcast").setExecutor(new BroadcastCommand());
    }
}
