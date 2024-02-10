package de.ironaxe.commandcentral.Filter.Bukkit;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.PluginCommand;

import de.ironaxe.commandcentral.Filter.FilterCommand;
import de.ironaxe.commandcentral.Filter.Interface.FilterCommands;

public class FilterCommandsBukkit implements FilterCommands {
    Collection<String> commands;
    List<FilterCommand> removeCommands = new ArrayList<FilterCommand>();

    public FilterCommandsBukkit(Collection<String> commands) {
        this.commands = commands;
    }

    public List<FilterCommand> getCommands() {
        List<FilterCommand> commandList = new ArrayList<FilterCommand>();
        for (String command : commands) {
            PluginCommand pluginCommand = Bukkit.getPluginCommand(command);
            
            String pluginName = null;
            String permission = null;

            if(pluginCommand != null) {
                pluginName = pluginCommand.getPlugin().getName();
                permission = pluginCommand.getPermission();
            }
            
            commandList.add(new FilterCommand(command, permission, pluginName));
        }

        return commandList;
    }

    public void remove(FilterCommand command) {
        removeCommands.add(command);
    }

    public void refreshCommands() {
        for(FilterCommand command : removeCommands) {
            commands.remove(command.getCommand());
        }
    }
}
