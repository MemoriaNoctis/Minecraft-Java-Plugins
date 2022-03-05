package me.rosalia.respawnteleporter.Listeners;

import me.rosalia.respawnteleporter.RespawnTeleporter;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class SetLocationDeath implements Listener {

    private final RespawnTeleporter plugin;

    public SetLocationDeath(RespawnTeleporter plugin) {
        this.plugin = plugin;
    }


    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e) {
        Player player = e.getEntity().getPlayer();
        if (player != null) {
            Location location = player.getLocation();
            plugin.respawnLocation.put(player.getUniqueId(), location);
            player.sendMessage(ChatColor.YELLOW + "Death location saved.");

        }
    }
}
