package me.okay;

import org.bukkit.NamespacedKey;
import org.bukkit.entity.AbstractArrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.projectiles.ProjectileSource;

import me.okay.utils.ArrowUtils;
import me.okay.utils.PersistentDataType_UUID;

public class ArrowOwnerWatcher implements Listener {
    private NamespacedKey arrowOwnerKey;

    public ArrowOwnerWatcher(NamespacedKey arrowOwnerKey) {
        this.arrowOwnerKey = arrowOwnerKey;
    }

    @EventHandler(ignoreCancelled = true)
    public void onArrowLaunch(ProjectileLaunchEvent event) {
        Entity entity = event.getEntity();
        // Only detect arrows
        if (!(entity instanceof AbstractArrow)) {
            return;
        }

        // Get owner of the arrow
        AbstractArrow arrow = (AbstractArrow) entity;
        ProjectileSource owner = arrow.getShooter();
        
        // Only process arrows shot by players
        if (!(owner instanceof Player)) {
            return;
        }

        Player player = (Player) owner;
        
        // Attach owner to the PersistentDataContainer
        arrow.getPersistentDataContainer().set(arrowOwnerKey, new PersistentDataType_UUID(), player.getUniqueId());
    }

    @EventHandler(ignoreCancelled = true)
    public void onPlayerJoin(PlayerJoinEvent event) {
        ArrowUtils.setAllArrowOwners(arrowOwnerKey);
    }
}
