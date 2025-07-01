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
                setArrowOwner(arrowOwnerKey, arrow);
            }
        }
    }

    public static void setArrowOwner(NamespacedKey arrowOwnerKey, AbstractArrow arrow) {
        // If the arrow has an owner, skip it
        if (arrow.getShooter() != null) {
            return;
        }

        // Get the owner of the arrow from the PersistentDataContainer
        UUID ownerId = arrow.getPersistentDataContainer().get(arrowOwnerKey, new PersistentDataType_UUID());

        // If the arrow has no owner stored, skip it
        if (ownerId == null) {
            return;
        }

        // Check if the owner is online
        Player owner = Bukkit.getServer().getPlayer(ownerId);
        if (owner != null) {
            // Set the owner of the arrow
            arrow.setShooter(owner);
        }
    }
}
