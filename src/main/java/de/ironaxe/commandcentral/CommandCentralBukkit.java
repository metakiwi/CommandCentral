package de.ironaxe.commandcentral;

import org.bukkit.plugin.java.JavaPlugin;

import de.ironaxe.commandcentral.Listener.CommandSendEventListener;

public class CommandCentralBukkit extends JavaPlugin {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new CommandSendEventListener(this), this);
    }

    @Override
    public void onDisable() {

    }
}
