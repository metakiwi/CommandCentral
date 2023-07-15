package de.ironaxe.commandcentral.Filter;

public class FilterCommand {
    private String command;
    private String permission;

    public FilterCommand(String command, String permission) {
        this.command = command;
        this.permission = permission;
    }    

    public String getPermission() {
        return permission;
    }

    public String getCommand() {
        return command;
    }
}
