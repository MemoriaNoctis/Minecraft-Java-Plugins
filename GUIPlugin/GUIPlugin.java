package me.rosalia.guiplugin;

import me.rosalia.guiplugin.Commands.GUICommand;
import me.rosalia.guiplugin.Listeners.ClickEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class GUIPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("gui").setExecutor(new GUICommand());
        getServer().getPluginManager().registerEvents(new ClickEvent(), this);

    }
}
