package me.okay.utils;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.World;
import org.bukkit.entity.AbstractArrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class ArrowUtils {
    public static void setAllArrowOwners(NamespacedKey arrowOwnerKey) {
        // Go through all arrows and set their owner
        for (World world : Bukkit.getServer().getWorlds()) {
            for (Entity entity : world.getEntitiesByClass(AbstractArrow.class)) {
                AbstractArrow arrow = (AbstractArrow) entity;
                // Get the owner of the arrow from the PersistentDataContainer
                UUID ownerId = arrow.getPersistentDataContainer().get(arrowOwnerKey, new PersistentDataType_UUID());

                // If the arrow has no owner, skip it
                if (ownerId == null) {
                    continue;
                }

                // Check if the owner is online and the arrow has no owner
                Player owner = Bukkit.getServer().getPlayer(ownerId);
                if (owner != null && arrow.getShooter() == null) {
                    // Set the owner of the arrow
                    arrow.setShooter(owner);
                }
            }
        }
    }
}
