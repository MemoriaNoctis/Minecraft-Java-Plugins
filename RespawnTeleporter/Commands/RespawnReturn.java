package me.rosalia.respawnteleporter.Commands;

import me.rosalia.respawnteleporter.RespawnTeleporter;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

public class RespawnReturn implements CommandExecutor {

    private final RespawnTeleporter plugin;
    public int timer = 10;

    public RespawnReturn(RespawnTeleporter plugin) {
        this.plugin = plugin;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;
            Location location = plugin.getConfig().getLocation("death");
            if (location != null){
                player.teleport(location);
                player.sendMessage(ChatColor.YELLOW + "You've been returned to your place of death. You will be invulnerabile for 10s.");
                player.setNoDamageTicks(200);
                plugin.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
                    @Override
                    public void run() {
                        if (timer != -1){
                            if (timer != 0){
                                Bukkit.broadcastMessage(ChatColor.YELLOW + "" + timer);
                                timer --;
                            } else{
                                Bukkit.broadcastMessage(ChatColor.YELLOW + "The invulnerability period has ended.");
                                timer --;
                            }
                        }
                    }
                }, 0L, 20L);


            }
        }
        return true;
    }

}
