package de.ironaxe.commandcentral.Filter.Bukkit;

import org.bukkit.entity.Player;

import de.ironaxe.commandcentral.Filter.Interface.FilterPlayer;

public class FilterPlayerBukkit implements FilterPlayer {
    private Player player;
    
    public FilterPlayerBukkit(Player player) {
        this.player = player;
    }

    public boolean hasPermission(String permission) {
        if(permission == null) return false;
        
        return player.hasPermission(permission);
    }

    public boolean isOp() {
        return player.isOp();
    }
}
