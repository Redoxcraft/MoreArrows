package de.redoxcraft.morearrows.recipes;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import de.redoxcraft.morearrows.main.Main;

public class LightnightArrowRecipe {

	public void lightnightArrowRecipe() {
		
		ItemStack arrow = new ItemStack(Material.TIPPED_ARROW, 8);
		ItemMeta arrowMeta = arrow.getItemMeta();
		arrowMeta.setDisplayName("§aElektrisierter Pfeil");
		ArrayList<String> arrowLore = new ArrayList<String>();
		arrowLore.add("§d§oEntläd sich beim Aufprall");
		arrowMeta.setLore(arrowLore);
		arrow.setItemMeta(arrowMeta);
		
		NamespacedKey key = new NamespacedKey(Main.getPlugin() , "LightnightArrow");
		
		ShapedRecipe recipe = new ShapedRecipe(key, arrow);
		recipe.shape("AAA", "ABA", "AAA");
		recipe.setIngredient('A', Material.ARROW);
		recipe.setIngredient('B', Material.ENCHANTED_BOOK);
		
		Bukkit.addRecipe(recipe);
	}
	
}
