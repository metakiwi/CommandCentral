package de.ironaxe.commandcentral.Hook;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;

import de.ironaxe.commandcentral.CommandCentralBukkit;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.event.node.NodeMutateEvent;

public class HookManager {
    LuckPerms luckPerms;
    CommandCentralBukkit plugin;

    public HookManager(CommandCentralBukkit plugin) {
        this.plugin = plugin;
        RegisteredServiceProvider<LuckPerms> provider = null;
        if (this.plugin.getServer().getPluginManager().getPlugin("LuckPerms") == null)
            return;

        try {
            provider = Bukkit.getServicesManager().getRegistration(LuckPerms.class);
        } catch (Exception ignored) {
        }

        if (provider != null) {
            luckPerms = provider.getProvider();
            luckPerms.getEventBus().subscribe(this.plugin, NodeMutateEvent.class, e -> {
                Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, () -> {
                    for (Player player : Bukkit.getOnlinePlayers()) {
                        player.updateCommands();
                    }
                });
            });
            this.plugin.getLogger().info("Hooked into LuckPerms");
        }
    }
}
