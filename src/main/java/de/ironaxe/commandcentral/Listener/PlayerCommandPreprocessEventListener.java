package de.ironaxe.commandcentral.Listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import de.ironaxe.commandcentral.Filter.Filter;
import de.ironaxe.commandcentral.Filter.Bukkit.FilterPlayerBukkit;

public class PlayerCommandPreprocessEventListener implements Listener {
    @EventHandler
    public void onPlayerCommandPreprocessEvent(PlayerCommandPreprocessEvent e) {
        Filter filter = new Filter(new FilterPlayerBukkit(e.getPlayer()));

        String[] message = e.getMessage().split(" ");
        String command = message[0].substring(1);

        if(filter.isBlockedByFirewall(command)) e.setCancelled(true);
    }
}
