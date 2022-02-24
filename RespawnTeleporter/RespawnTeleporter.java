package me.rosalia.respawnteleporter;

import me.rosalia.respawnteleporter.Commands.RespawnReturn;
import me.rosalia.respawnteleporter.Listeners.SetLocationDeath;
import org.bukkit.plugin.java.JavaPlugin;

public final class RespawnTeleporter extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        getCommand("return").setExecutor(new RespawnReturn(this));
        getServer().getPluginManager().registerEvents(new SetLocationDeath(this), this);

    }

}
