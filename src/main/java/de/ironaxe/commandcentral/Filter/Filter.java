package de.ironaxe.commandcentral.Filter;

import de.ironaxe.commandcentral.Filter.Interface.FilterCommands;
import de.ironaxe.commandcentral.Filter.Interface.FilterPlayer;

public class Filter {
    private FilterPlayer player;
    private FilterCommands commands;

    public Filter(FilterPlayer player, FilterCommands commands) {
        this.player = player;
        this.commands = commands;

        filterByPermissions();
        commands.refreshCommands();
    }

    public void filterByPermissions() {
        if(!player.hasPermission("commandcentral.filter")) return;

        for (String command : commands.getCommands()) {
            if (!player.hasPermission("commandcentral.command." + command) && !player.isOp()) {
                commands.remove(command);
            }
        }
    }
}
