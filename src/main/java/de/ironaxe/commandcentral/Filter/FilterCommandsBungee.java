package de.ironaxe.commandcentral.Filter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.md_5.bungee.api.plugin.Command;

public class FilterCommandsBungee implements FilterCommands {
    Map<String, Command> commands;
    List<FilterCommand> removeCommands = new ArrayList<FilterCommand>();

    public FilterCommandsBungee(Map<String, Command> commands) {
        this.commands = commands;
    }

    public List<FilterCommand> getCommands() {
        List<FilterCommand> commandList = new ArrayList<FilterCommand>();
        
        for(Map.Entry<String, Command> entry : commands.entrySet()) {
            commandList.add(new FilterCommand(entry.getKey(), entry.getValue().getPermission()));
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
