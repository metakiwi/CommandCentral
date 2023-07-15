package de.ironaxe.commandcentral.Filter;

import org.bukkit.entity.Player;

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
