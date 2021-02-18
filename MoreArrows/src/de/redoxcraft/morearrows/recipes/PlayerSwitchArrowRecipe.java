package de.redoxcraft.morearrows.recipes;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import de.redoxcraft.morearrows.main.Main;

public class PlayerSwitchArrowRecipe {

	public void playerSwitchArrowRecipe() {
		
		ItemStack arrow = new ItemStack(Material.TIPPED_ARROW);
		ItemMeta arrowMeta = arrow.getItemMeta();
		arrowMeta.setDisplayName("§aPositionstauschender Pfeil");
		ArrayList<String> arrowLore = new ArrayList<String>();
		arrowLore.add("§d§oTauscht dich mit der getroffenen Kreatur,");
		arrowLore.add("§d§ovorausgesetzt du triffst...");
		arrowMeta.setLore(arrowLore);
		arrow.setItemMeta(arrowMeta);
		
		NamespacedKey key = new NamespacedKey(Main.getPlugin() , "PlayerSwitchArrow");
		
		ShapedRecipe recipe = new ShapedRecipe(key, arrow);
		recipe.shape("EEE", "EAE", "EEE");
		recipe.setIngredient('A', Material.ARROW);
		recipe.setIngredient('E', Material.ENDER_EYE);
		
		Bukkit.addRecipe(recipe);
	}
	
}
