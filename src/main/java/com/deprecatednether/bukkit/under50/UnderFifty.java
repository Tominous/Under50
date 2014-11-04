package com.deprecatednether.bukkit.under50;

import com.deprecatednether.bukkit.under50.commands.FlyCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class UnderFifty extends JavaPlugin {
    @Override
    public void onEnable() {
        getCommand("fly").setExecutor(new FlyCommand());
    }
}
