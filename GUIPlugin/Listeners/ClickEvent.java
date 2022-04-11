package me.rosalia.guiplugin.Listeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class ClickEvent implements Listener {

    @EventHandler
    public void clickEvent(InventoryClickEvent e){
        Player player = (Player) e.getWhoClicked();
        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.AQUA + "Custom GUI")){
            switch(e.getCurrentItem().getType()){
                case TNT:
                    player.closeInventory();
                    player.setHealth(0.0);
                    player.sendMessage("You chose to kill yourself");
                    break;
                case BREAD:
                    player.closeInventory();
                    player.setFoodLevel(20);
                    player.sendMessage("Yum!");
                    break;
                case DIAMOND_SWORD:
                    player.closeInventory();
                    player.getInventory().addItem(new ItemStack(Material.DIAMOND_SWORD));
                    player.sendMessage("Careful, it's sharp :)");
                    break;
            }

            e.setCancelled(true);
        }
    }
}
