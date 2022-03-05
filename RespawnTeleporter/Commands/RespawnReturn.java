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
    public int timer;

    public RespawnReturn(RespawnTeleporter plugin) {
        this.plugin = plugin;
    }

    private BukkitTask task;
    private int count;

    //Countdown for Invulernability timer
    public void countdownTimer(Player player) {
        count = 9; // restart count down at 10 seconds
        task = Bukkit.getScheduler().runTaskTimer(plugin, ()-> {
            if(count == 0){
                player.sendMessage(ChatColor.YELLOW + "The invulnerability period has ended.");
                task.cancel(); // cancel the task if the counter is finished
            } else{
                player.sendMessage(ChatColor.YELLOW + "" + count);
            }
            count--; // reduce the counter
        }, 20, 20);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            timer = 10;
            Player player = (Player) sender;
            Location location = plugin.respawnLocation.get(player.getUniqueId());
            if (location != null){
                player.teleport(location);
                player.sendMessage(ChatColor.YELLOW + "You've been returned to your place of death. You will be invulnerabile for 10s.");

                //player invulerable for 10 seconds
                player.setNoDamageTicks(200);
                countdownTimer(player);



            }
        }
        return true;
    }

}
