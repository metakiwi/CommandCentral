package de.ironaxe.commandcentral.Filter;

import java.util.List;

interface FilterCommands {
    public List<FilterCommand> getCommands();
    public void remove(FilterCommand command);
    public void refreshCommands();
}
