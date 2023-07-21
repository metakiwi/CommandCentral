package de.ironaxe.commandcentral;

import org.bstats.bukkit.Metrics;
import org.bukkit.plugin.java.JavaPlugin;

import de.ironaxe.commandcentral.Listener.CommandSendEventListener;

public class CommandCentralBukkit extends JavaPlugin {
    @Override
    public void onEnable() {
        new Metrics(this, 19144);
        
        getServer().getPluginManager().registerEvents(new CommandSendEventListener(), this);
    }

    @Override
    public void onDisable() {

    }
}
