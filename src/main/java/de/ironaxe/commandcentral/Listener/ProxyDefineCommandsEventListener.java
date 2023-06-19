package de.ironaxe.commandcentral.Listener;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.command.PluginCommand;

import de.ironaxe.commandcentral.CommandCentralBungee;
import io.github.waterfallmc.waterfall.event.ProxyDefineCommandsEvent;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.Connection;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class ProxyDefineCommandsEventListener implements Listener {
    CommandCentralBungee plugin;

    public ProxyDefineCommandsEventListener(CommandCentralBungee plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onTabCompleteResponse(ProxyDefineCommandsEvent e) {
        Connection receiver = e.getReceiver();
        if(!(receiver instanceof ProxiedPlayer)) return;
        
        ProxiedPlayer player = (ProxiedPlayer)receiver;
        Map<String, Command> commands = e.getCommands();
        Map<String, Command> newCommands = new HashMap<>();
        for(Map.Entry<String, Command> entry : commands.entrySet()) {
            String pluginPermission = entry.getValue().getPermission();
            String allowPermission = "commandcentral.allowcommand." + entry.getKey();
            Boolean playerHasPluginPermission = pluginPermission != null ? player.hasPermission(pluginPermission) : false;
            Boolean playerHasAllowPermission = player.hasPermission(allowPermission);
            Boolean showIncompatibleCommands = player.hasPermission("commandcentral.showincompatiblecommands");

            if(playerHasAllowPermission || playerHasPluginPermission || (pluginPermission == null && showIncompatibleCommands)) {
                newCommands.put(entry.getKey(), entry.getValue());
            }
        }
        commands.clear();
        commands.putAll(newCommands);
    }
}
