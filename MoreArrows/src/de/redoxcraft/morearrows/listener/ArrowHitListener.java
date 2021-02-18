package de.redoxcraft.morearrows.listener;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class ArrowHitListener implements Listener {
	
	@EventHandler
	public void onPlayerHitArrow(EntityDamageByEntityEvent e) { //NOT WORKING! & NOT REGISTERED!
		
		if(e.getDamager() instanceof Player) {
			System.out.println("test1");
			if(e.getEntity() instanceof Arrow) {
				System.out.println("test2");
				e.getEntity().remove();
				e.setCancelled(true);
				return;
			}return;
		}return;
		
	}

}
