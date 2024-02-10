package de.ironaxe.commandcentral.Filter.Interface;

import java.util.List;

import de.ironaxe.commandcentral.Filter.FilterCommand;

public interface FilterCommands {
    public List<FilterCommand> getCommands();
    public void remove(FilterCommand command);
    public void refreshCommands();
}
