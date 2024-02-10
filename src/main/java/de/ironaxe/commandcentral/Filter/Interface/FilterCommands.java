package de.ironaxe.commandcentral.Filter.Interface;

import java.util.List;

public interface FilterCommands {
    public List<String> getCommands();
    public void remove(String command);
    public void refreshCommands();
}
