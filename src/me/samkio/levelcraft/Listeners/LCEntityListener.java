package me.samkio.levelcraft.Listeners;


import me.samkio.levelcraft.Levelcraft;
import me.samkio.levelcraft.Settings;
import me.samkio.levelcraft.Skills.Range;
import me.samkio.levelcraft.Skills.Slayer;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageByProjectileEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityListener;

public class LCEntityListener extends EntityListener{
	public static Levelcraft plugin;
	public LCEntityListener(Levelcraft instance) {
		plugin = instance;
	}
	public void onEntityDamage(EntityDamageEvent event) {
		if (event.isCancelled()){
			return;
		}
		if (event instanceof EntityDamageByEntityEvent){
			if(((EntityDamageByEntityEvent) event).getDamager() instanceof Player && Settings.enableSlayerLevel == true && event.getEntity() instanceof Monster){
				Slayer.attack((EntityDamageByEntityEvent) event);
			}
		}
		if (event instanceof EntityDamageByProjectileEvent){
			if(((EntityDamageByProjectileEvent) event).getProjectile() instanceof Arrow && ((EntityDamageByEntityEvent) event).getDamager() instanceof Player && Settings.enableRangeLevel == true && event.getEntity() instanceof Monster){
				Range.attack((EntityDamageByProjectileEvent) event);
			}
		}
	}

}
