package de.redoxcraft.morearrows.recipes;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import de.redoxcraft.morearrows.main.Main;

public class ExplosionArrowRecipe {

	public void explosionArrowRecipe() {
		
		ItemStack arrow = new ItemStack(Material.TIPPED_ARROW);
		ItemMeta arrowMeta = arrow.getItemMeta();
		arrowMeta.setDisplayName("§aExplosiver Pfeil");
		ArrayList<String> arrowLore = new ArrayList<String>();
		arrowLore.add("§d§oGut um Gegner in die Luft");
		arrowLore.add("§d§ozu sprengen");
		arrowMeta.setLore(arrowLore);
		arrow.setItemMeta(arrowMeta);
		
		NamespacedKey key = new NamespacedKey(Main.getPlugin() , "ExplosionArrow");
		
		ShapedRecipe recipe = new ShapedRecipe(key, arrow);
		recipe.shape("TTT", "TAT", "TTT");
		recipe.setIngredient('A', Material.ARROW);
		recipe.setIngredient('T', Material.GUNPOWDER);
		
		Bukkit.addRecipe(recipe);
	}

	
}
