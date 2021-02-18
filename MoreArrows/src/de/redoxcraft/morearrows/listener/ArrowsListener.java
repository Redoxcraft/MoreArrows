package de.redoxcraft.morearrows.listener;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.projectiles.BlockProjectileSource;

public class ArrowsListener implements Listener {

	@EventHandler
	public void onArrowHit(ProjectileHitEvent e) {
		if(e.getEntityType().equals(EntityType.ARROW)) {
			Location loc = e.getEntity().getLocation();
			String s = e.getEntity().getCustomName();
			if(e.getEntity().getShooter() instanceof Entity) {
				Entity shooter = (Entity) e.getEntity().getShooter();
				if(shooter instanceof Player) {
					Player pshooter = (Player) e.getEntity().getShooter();
					if(!(s == null)) {
						
						if(s.equals("Explosion_arrow")) {
							loc.getWorld().createExplosion(loc, 2F, false, false);
							ArrowBreak(loc);
						}else if(s.equals("Lightnight_arrow")) {
							loc.getWorld().strikeLightning(loc);
							ArrowBreak(loc);
						}else if(s.equals("Teleport_arrow")) {
							Location eloc = (Location) pshooter.getEyeLocation();
							loc.setPitch(eloc.getPitch());
							loc.setYaw(eloc.getYaw());
							pshooter.teleport(loc);
							ArrowBreak(loc);
						}else if(s.equals("PlayerSwitch_arrow")) {
							if(!(e.getHitEntity() == null)) {
								Entity hit = (Entity) e.getHitEntity();
								Location hitloc = (Location) hit.getLocation();
								Location shooterloc = (Location) pshooter.getLocation();
								pshooter.teleport(hitloc);
								hit.teleport(shooterloc);
							}
							ArrowBreak(loc);
						}else {
							return;
						}
						
						e.getEntity().remove();
						return;
					}return;
				}return;
			}else if (e.getEntity().getShooter() instanceof BlockProjectileSource){
				if(!(s == null)) {
					
					if(s.equals("Explosion_arrow")) {
						loc.getWorld().createExplosion(loc, 2F, false, false);
						ArrowBreak(loc);
					}else if(s.equals("Lightnight_arrow")) {
						loc.getWorld().strikeLightning(loc);
						ArrowBreak(loc);
					}else if(s.equals("Teleport_arrow")) {
						ArrowBreak(loc);
					}else if(s.equals("PlayerSwitch_arrow")) {
						ArrowBreak(loc);
					}else {
						return;
					}
					
					e.getEntity().remove();
					return;
				}return;
			}return;
		}return;
	}
	
	
	@EventHandler
	public void onBowUse(EntityShootBowEvent e) {
		
		if(e.getEntity() instanceof Player) {
			Projectile pr = (Projectile) e.getProjectile();
			List<String> n = e.getConsumable().getItemMeta().getLore();
			
			ArrayList<String> explosionArrowLore = new ArrayList<String>();
			explosionArrowLore.add("§d§oGut um Gegner in die Luft");
			explosionArrowLore.add("§d§ozu sprengen");
			
			ArrayList<String> lightnightArrowLore = new ArrayList<String>();
			lightnightArrowLore.add("§d§oEntläd sich beim Aufprall");
			
			ArrayList<String> teleportArrowLore = new ArrayList<String>();
			teleportArrowLore.add("§d§oHoffentlich ist");
			teleportArrowLore.add("§d§odie Landung weich");
			
			ArrayList<String> PlayerSwitchArrowLore = new ArrayList<String>();
			PlayerSwitchArrowLore.add("§d§oTauscht dich mit der getroffenen Kreatur,");
			PlayerSwitchArrowLore.add("§d§ovorausgesetzt du triffst...");
			
			if(!(n == null)) {
				if(n.equals(explosionArrowLore)) {
					pr.setCustomName("Explosion_arrow");
					return;
				}else if(n.equals(lightnightArrowLore)) {
					pr.setCustomName("Lightnight_arrow");
					return;
				}else if(n.equals(teleportArrowLore)) {
					pr.setCustomName("Teleport_arrow");
					return;
				}else if(n.equals(PlayerSwitchArrowLore)) {
					pr.setCustomName("PlayerSwitch_arrow");
					return;
				}return;
			}return;
		}return;
		
	}
	
	private void ArrowBreak(Location loc) {
		ItemStack holzsplitter = new ItemStack(Material.STICK);
		ItemMeta holzsplitterMeta = holzsplitter.getItemMeta();
		holzsplitterMeta.setDisplayName("§7Holzsplitter");
		ArrayList<String> holzsplitterLore = new ArrayList<String>();
		holzsplitterLore.add("Die Überreste");
		holzsplitterLore.add("eines Pfeils");
		holzsplitterMeta.setLore(holzsplitterLore);
		holzsplitter.setItemMeta(holzsplitterMeta);
		
		int randomHolzsplitter = (int) (Math.random()*(2));
		if(randomHolzsplitter == 0) {
			loc.getWorld().dropItem(loc, holzsplitter);
		}
		return;
	}
	
}
