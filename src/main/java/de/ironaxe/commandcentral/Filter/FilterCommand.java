package de.ironaxe.commandcentral.Filter;

public class FilterCommand {
    private String command;
    private String permission;
    private String pluginName;

    public FilterCommand(String command, String permission) {
        this.command = command;
        this.permission = permission;
    }    

    public FilterCommand(String command, String permission, String pluginName) {
        this.command = command;
        this.permission = permission;
        this.pluginName = pluginName;
    }    

    public String getPermission() {
        return permission;
    }

    public String getCommand() {
        return command;
    }

    public String getPluginName() {
        return pluginName;
    }
}
