package de.ironaxe.commandcentral.Listener;

import java.util.ArrayList;
import java.util.Collection;

import org.bukkit.Bukkit;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandSendEvent;

import de.ironaxe.commandcentral.CommandCentralBukkit;

public class CommandSendEventListener implements Listener {
    CommandCentralBukkit plugin;

    public CommandSendEventListener(CommandCentralBukkit plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void playerCommandSendEvent(PlayerCommandSendEvent e) {
        Collection<String> commands = e.getCommands();
        Collection<String> removeCommands = new ArrayList<String>();

        Player player = e.getPlayer();
        Boolean showIncompatibleCommands = player.hasPermission("commandcentral.showincompatiblecommands");
        Boolean showColonCommands = player.hasPermission("commandcentral.showcoloncommands");

        for (String commandString : commands) {
            PluginCommand pluginCommand = Bukkit.getPluginCommand(commandString);
            String pluginPermission = pluginCommand != null ? pluginCommand.getPermission() : null;
            String allowPermission = "commandcentral.allowcommand." + commandString;
            Boolean playerHasPluginPermission = pluginPermission != null ? player.hasPermission(pluginPermission)
                    : false;
            Boolean playerHasAllowPermission = player.hasPermission(allowPermission);
            Boolean delete = !playerHasAllowPermission && !playerHasPluginPermission
                    && (pluginPermission == null && !showIncompatibleCommands);

            if (!delete && (commandString.indexOf(":") >= 0) && !showColonCommands) {
                delete = true;
            }

            if (delete) {
                removeCommands.add(commandString);
            }
        }
        commands.removeAll(removeCommands);
    }
}