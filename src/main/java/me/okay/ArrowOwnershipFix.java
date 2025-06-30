package me.okay;

import org.bukkit.NamespacedKey;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.okay.utils.ArrowUtils;

public class ArrowOwnershipFix extends JavaPlugin {
    private static NamespacedKey arrowOwnerKey;
    
    @Override
    public void onEnable() {
        // Initialize the arrow owner key
        arrowOwnerKey = new NamespacedKey(this, "owner");

        // Set up listener
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new ArrowOwnerWatcher(arrowOwnerKey), this);

        ArrowUtils.setAllArrowOwners(arrowOwnerKey);
    }

    @Override
    public void onDisable() {
    }
}