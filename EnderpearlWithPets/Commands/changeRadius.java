package me.rosalia.enderpearlwithpets.Commands;

import me.rosalia.enderpearlwithpets.EnderpearlWithPets;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class changeRadius implements CommandExecutor {
    private final EnderpearlWithPets plugin;

    public changeRadius(EnderpearlWithPets plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;
            if (args.length == 0){
                player.sendMessage("Please provide a radius value.");
            }
            else if (args.length == 1){
                plugin.getConfig().set("radius", Integer.parseInt(args[0]));
                plugin.saveConfig();
            }
            else{
                player.sendMessage("This command takes only one argument.");
            }
        }
        return true;
    }

}
