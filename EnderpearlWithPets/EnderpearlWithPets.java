package me.rosalia.enderpearlwithpets;

import me.rosalia.enderpearlwithpets.Commands.changeRadius;
import me.rosalia.enderpearlwithpets.Listeners.PearlTeleport;
import org.bukkit.plugin.java.JavaPlugin;

public final class EnderpearlWithPets extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getConfig().options().copyDefaults();
        getConfig().set("radius", 10);
        saveConfig();

        getServer().getPluginManager().registerEvents(new PearlTeleport(this), this);
        getCommand("radius").setExecutor(new changeRadius(this));


    }

}
