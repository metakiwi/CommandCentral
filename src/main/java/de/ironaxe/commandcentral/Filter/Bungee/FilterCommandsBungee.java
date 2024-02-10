package de.ironaxe.commandcentral.Filter.Bungee;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import de.ironaxe.commandcentral.Filter.Interface.FilterCommands;
import net.md_5.bungee.api.plugin.Command;

public class FilterCommandsBungee implements FilterCommands {
    Map<String, Command> commands;
    List<String> removeCommands = new ArrayList<String>();

    public FilterCommandsBungee(Map<String, Command> commands) {
        this.commands = commands;
    }

    public List<String> getCommands() {
        List<String> commandList = new ArrayList<String>();
        
        for(Map.Entry<String, Command> entry : commands.entrySet()) {
            commandList.add(entry.getKey());
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
