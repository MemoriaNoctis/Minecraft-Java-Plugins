package me.rosalia.guiplugin.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class GUICommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;
            Inventory gui = Bukkit.createInventory(player, 9, ChatColor.AQUA + "Custom GUI");

            ItemStack suicide = new ItemStack(Material.TNT);
            ItemStack feed = new ItemStack(Material.BREAD);
            ItemStack sword = new ItemStack(Material.DIAMOND_SWORD);

            ItemMeta suicideMeta = suicide.getItemMeta();
            suicideMeta.setDisplayName(ChatColor.RED + "Suicide");
            ArrayList<String> suicideLore = new ArrayList<>();
            suicideLore.add(ChatColor.GOLD + "Kill yourself");
            suicideMeta.setLore(suicideLore);
            suicide.setItemMeta(suicideMeta);

            ItemMeta feedMeta = feed.getItemMeta();
            feedMeta.setDisplayName(ChatColor.RED + "Food");
            ArrayList<String> feedLore = new ArrayList<>();
            feedLore.add(ChatColor.GOLD + "Fills hunger bar");
            feedMeta.setLore(feedLore);
            feed.setItemMeta(feedMeta);

            ItemMeta swordMeta = sword.getItemMeta();
            swordMeta.setDisplayName(ChatColor.RED + "Sword");
            ArrayList<String> swordLore = new ArrayList<>();
            swordLore.add(ChatColor.GOLD + "Get a sword");
            swordMeta.setLore(swordLore);
            sword.setItemMeta(swordMeta);

            ItemStack[] menuItems = {suicide, feed, sword};
            gui.setContents(menuItems);

            player.openInventory(gui);
        }
        return true;
    }
}
