package de.ironaxe.commandcentral.Filter;

public class Filter {
    private FilterPlayer player;
    private FilterCommands commands;

    public Filter(FilterPlayer player, FilterCommands commands) {
        this.player = player;
        this.commands = commands;

        filterByPermissions();
    }

    public void filterByPermissions() {
        for (FilterCommand command : commands.getCommands()) {
            Boolean show = false;

            show = player.hasPermission(command.getPermission()) ||
                    player.hasPermission("commandcentral.show." + command.getCommand());

            if (!show && command.getPluginName() != null
                    && player.hasPermission("commandcentral.showplugin." + command.getPluginName()))
                show = true;

            if (command.getCommand().contains(":")
                    && !player.hasPermission("commandcentral.showColonCommands"))
                show = false;

            if (player.hasPermission("commandcentral.hide." + command.getCommand()))
                show = false;

            if (show && command.getPluginName() != null
                    && player.hasPermission("commandcentral.hideplugin." + command.getPluginName()))
                show = false;

            if (player.hasPermission("commandcentral.bypass"))
                show = true;

            if (!show) {
                commands.remove(command);
            }
        }

        commands.refreshCommands();
    }
}
