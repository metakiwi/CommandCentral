package de.ironaxe.commandcentral.Filter;

import de.ironaxe.commandcentral.Filter.Interface.FilterCommands;
import de.ironaxe.commandcentral.Filter.Interface.FilterPlayer;

public class Filter {
    private FilterPlayer player;
    private FilterCommands commands;

    public Filter(FilterPlayer player, FilterCommands commands) {
        this.player = player;
        this.commands = commands;
    }

    public Filter(FilterPlayer player) {
        this.player = player;
    }

    public void filterByPermissions() {
        if(!hasPermission("commandcentral.filter") || player.isOp()) return;

        for (String command : commands.getCommands()) {
            if (!hasCommandPermission(command)) {
                commands.remove(command);
            }
        }

        commands.refreshCommands();
    }

    public boolean hasPermission(String permission) {
        return player.hasPermission(permission);
    }

    public boolean hasCommandPermission(String command) {
        return hasPermission("commandcentral.command." + command);
    }

    public boolean isBlockedByFirewall(String command) {
        if(!hasPermission("commandcentral.filter") || player.isOp()) return false;
        
        return !hasCommandPermission(command);
    }
}
