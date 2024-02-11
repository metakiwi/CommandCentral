package de.ironaxe.commandcentral.Listener;

import de.ironaxe.commandcentral.Filter.Filter;
import de.ironaxe.commandcentral.Filter.Bungee.FilterPlayerBungee;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ChatEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class ChatEventListener implements Listener {
    @EventHandler
    public void onChatEvent(ChatEvent e) {
        if(!e.isProxyCommand()) return;

        Filter filter = new Filter(new FilterPlayerBungee((ProxiedPlayer)e.getSender()));

        String[] message = e.getMessage().split(" ");
        String command = message[0].replace("/", "");

        if (filter.isBlockedByFirewall(command))
            e.setCancelled(true);
    }
}
