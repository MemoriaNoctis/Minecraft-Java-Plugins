package me.rosalia.respawnteleporter;

import me.rosalia.respawnteleporter.Commands.RespawnReturn;
import me.rosalia.respawnteleporter.Listeners.SetLocationDeath;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.UUID;

public class RespawnTeleporter extends JavaPlugin {
    //Store player death locations using UUID
    public final HashMap<UUID, Location> respawnLocation;

    public RespawnTeleporter() {
        this.respawnLocation = new HashMap<>();
    }


    @Override
    public void onEnable() {
        getCommand("return").setExecutor(new RespawnReturn(this));
        getServer().getPluginManager().registerEvents(new SetLocationDeath(this), this);

    }

}
