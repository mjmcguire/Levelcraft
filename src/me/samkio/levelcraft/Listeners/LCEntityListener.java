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
import org.bukkit.event.entity.EntityListener;

public class LCEntityListener extends EntityListener{
	public static Levelcraft plugin;
	public LCEntityListener(Levelcraft instance) {
		plugin = instance;
	}
	public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
       if(event.getDamager() instanceof Player && Settings.enableSlayerLevel == true && event.getEntity() instanceof Monster){
    	 Slayer.attack(event);
       }
    }
	public void onEntityDamageByProjectile(EntityDamageByProjectileEvent event) {
		if(event.getProjectile() instanceof Arrow && event.getDamager() instanceof Player && Settings.enableRangeLevel == true && event.getEntity() instanceof Monster){
			Range.attack(event);
		}
		
	    }

}
