package de.ironaxe.commandcentral;

import de.ironaxe.commandcentral.Listener.ProxyDefineCommandsEventListener;
import net.md_5.bungee.api.plugin.Plugin;

public class CommandCentralBungee extends Plugin {
    @Override
    public void onEnable() {
        getProxy().getPluginManager().registerListener(this, new ProxyDefineCommandsEventListener(this));
    }

    @Override
    public void onDisable() {

    }
}
