package me.rosalia.enderpearlwithpets.Listeners;

import me.rosalia.enderpearlwithpets.EnderpearlWithPets;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;

public class PearlTeleport implements Listener {
    private final EnderpearlWithPets plugin;

    public PearlTeleport(EnderpearlWithPets plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onTeleport (PlayerTeleportEvent e){
        Player player = e.getPlayer();
        PlayerTeleportEvent.TeleportCause c = e.getCause();

        //If player teleported from an enderpearl throw
        if (player != null && c.equals(PlayerTeleportEvent.TeleportCause.ENDER_PEARL)){
            int radius = plugin.getConfig().getInt("radius");

            //get all entities within a specified radius
            for (Entity entElem : e.getFrom().getWorld().getNearbyEntities(e.getFrom(), radius, radius, radius)){

                //execute only if entity is living, on a leash, and the leash is held by the player that just teleported
                if (entElem instanceof LivingEntity && ((LivingEntity) entElem).isLeashed() && ((LivingEntity) entElem).getLeashHolder().equals(e.getPlayer())){
                    //get location player teleported to
                    Location location = e.getTo();

                    //make teleported entites immune to damage for 3 seconds; teleport entities to player
                    ((LivingEntity) entElem).setNoDamageTicks(60);
                    entElem.teleport(location);

                }
            }
        }
    }
}
