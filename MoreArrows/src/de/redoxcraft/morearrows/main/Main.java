package de.redoxcraft.morearrows.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.redoxcraft.morearrows.listener.ArrowsListener;
import de.redoxcraft.morearrows.listener.RecipeListener;
import de.redoxcraft.morearrows.recipes.ExplosionArrowRecipe;
import de.redoxcraft.morearrows.recipes.LightnightArrowRecipe;
import de.redoxcraft.morearrows.recipes.PlayerSwitchArrowRecipe;
import de.redoxcraft.morearrows.recipes.TeleportArrowRecipe;

public class Main extends JavaPlugin {

	private static Main plugin;
	
	public void onEnable() {
		plugin = this;
		
		System.out.println(this.getDescription().getName() + " " + this.getDescription().getVersion() + " geladen.");
		
		PluginManager PluginManager = Bukkit.getPluginManager();
		PluginManager.registerEvents(new ArrowsListener(), this);
		PluginManager.registerEvents(new RecipeListener(), this);
		
		new ExplosionArrowRecipe().explosionArrowRecipe();
		new LightnightArrowRecipe().lightnightArrowRecipe();
		new PlayerSwitchArrowRecipe().playerSwitchArrowRecipe();
		new TeleportArrowRecipe().teleportArrowRecipe();
	}
	
	public static Main getPlugin() {
		return plugin;
	}
	
}
