package de.ironaxe.commandcentral.Filter.Bukkit;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import de.ironaxe.commandcentral.Filter.Interface.FilterCommands;

public class FilterCommandsBukkit implements FilterCommands {
    Collection<String> commands;
    List<String> removeCommands = new ArrayList<String>();

    public FilterCommandsBukkit(Collection<String> commands) {
        this.commands = commands;
    }

    public List<String> getCommands() {
        List<String> commandList = new ArrayList<String>();
        for (String command : commands) {
            commandList.add(command);
        }

        return commandList;
    }

    public void remove(String command) {
        removeCommands.add(command);
    }

    public void refreshCommands() {
        for(String command : removeCommands) {
            commands.remove(command);
        }
    }
}
