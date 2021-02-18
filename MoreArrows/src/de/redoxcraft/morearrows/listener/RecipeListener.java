package de.redoxcraft.morearrows.listener;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.bukkit.inventory.meta.ItemMeta;

public class RecipeListener implements Listener {
	
	@EventHandler
	public void checkRecipes2(CraftItemEvent e) {
		ItemStack slot5 = e.getInventory().getItem(5);
		
		ItemStack lightnightArrow = new ItemStack(Material.TIPPED_ARROW, 8);
		ItemMeta lightnightArrowMeta = lightnightArrow.getItemMeta();
		lightnightArrowMeta.setDisplayName("§aElektrisierter Pfeil");
		ArrayList<String> lightnightArrowLore = new ArrayList<String>();
		lightnightArrowLore.add("§d§oEntläd sich beim Aufprall");
		lightnightArrowMeta.setLore(lightnightArrowLore);
		lightnightArrow.setItemMeta(lightnightArrowMeta);
		
		if(e.getRecipe().getResult().equals(lightnightArrow)) {
			EnchantmentStorageMeta slot5meta = (EnchantmentStorageMeta) slot5.getItemMeta();
			HashMap<Enchantment, Integer> map = new HashMap<Enchantment, Integer>();
			map.put(Enchantment.CHANNELING, 1);
			if(slot5meta.getStoredEnchants().equals(map) && slot5.getType().equals(Material.ENCHANTED_BOOK)) {
				return;
			}else {
				e.setCancelled(true);
				return;
			}
		}return;
	}

}
