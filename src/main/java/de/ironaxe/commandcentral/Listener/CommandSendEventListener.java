package de.ironaxe.commandcentral.Listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandSendEvent;

import de.ironaxe.commandcentral.Filter.Filter;
import de.ironaxe.commandcentral.Filter.FilterCommandsBukkit;
import de.ironaxe.commandcentral.Filter.FilterPlayerBukkit;

public class CommandSendEventListener implements Listener {
    @EventHandler
    public void playerCommandSendEvent(PlayerCommandSendEvent e) {
        new Filter(new FilterPlayerBukkit(e.getPlayer()), new FilterCommandsBukkit(e.getCommands()));
    }
}