package de.ironaxe.commandcentral;

import org.bstats.bungeecord.Metrics;

import de.ironaxe.commandcentral.Listener.ChatEventListener;
import de.ironaxe.commandcentral.Listener.ProxyDefineCommandsEventListener;
import net.md_5.bungee.api.plugin.Plugin;

public class CommandCentralBungee extends Plugin {
    @Override
    public void onEnable() {
        new Metrics(this, 19145);

        getProxy().getPluginManager().registerListener(this, new ProxyDefineCommandsEventListener());
        getProxy().getPluginManager().registerListener(this, new ChatEventListener());
    }

    @Override
    public void onDisable() {

    }
}
