package de.ironaxe.commandcentral.Filter.Bungee;

import de.ironaxe.commandcentral.Filter.Interface.FilterPlayer;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class FilterPlayerBungee implements FilterPlayer {
    private ProxiedPlayer player;
    
    public FilterPlayerBungee(ProxiedPlayer player) {
        this.player = player;
    }

    public boolean hasPermission(String permission) {
        return player.hasPermission(permission);
    }
    
    public boolean isOp() {
        // there is no OP mechanism in BungeeCord
        return false;
    }
}
