package de.ironaxe.commandcentral.Listener;

import de.ironaxe.commandcentral.Filter.Filter;
import de.ironaxe.commandcentral.Filter.Bungee.FilterCommandsBungee;
import de.ironaxe.commandcentral.Filter.Bungee.FilterPlayerBungee;
import io.github.waterfallmc.waterfall.event.ProxyDefineCommandsEvent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class ProxyDefineCommandsEventListener implements Listener {
    @EventHandler
    public void onTabCompleteResponse(ProxyDefineCommandsEvent e) {
        new Filter(new FilterPlayerBungee((ProxiedPlayer)e.getReceiver()), new FilterCommandsBungee(e.getCommands()));
    }
}
