package me.samkio.levelcraft.Skills;

import me.samkio.levelcraft.Settings;
import me.samkio.levelcraft.Functions.PlayerFunctions;
import me.samkio.levelcraft.SamToolbox.Level;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByProjectileEvent;

public class Archer {
	public static void attack(EntityDamageByProjectileEvent event) {
		Player player = (Player) event.getDamager();
		Player victim = (Player) event.getEntity();
		PlayerFunctions.checkAccount(player);
		int level = 0;
		double stat = 0;
		int newhealth = 0;
		if (Settings.enableRangeLevel == true) {
			level = Level.getLevel(player, "a");
			stat = Level.getExp(player, "a");
			if (level >= Settings.Archerp5 && level < Settings.Archer1p0) {
				newhealth = (victim.getHealth()+3);
				if(newhealth<=0){
					newhealth=0;
				}
				victim.setHealth(newhealth);
			}else if(level >= Settings.Archer1p0 && level < Settings.Archer1p5){
				newhealth = (victim.getHealth()+2);
				if(newhealth<=0){
					newhealth=0;
				}
				victim.setHealth(newhealth);
			}else if(level >= Settings.Archer1p5 && level < Settings.Archer2p0){
				newhealth = (victim.getHealth()+1);
				if(newhealth<=0){
					newhealth=0;
				}
				victim.setHealth(newhealth);
			}else if(level >= Settings.Archer2p0 && level < Settings.Archer2p5){
				newhealth = (victim.getHealth());
				if(newhealth<=0){
					newhealth=0;
				}
				victim.setHealth(newhealth);
			}else if(level >= Settings.Archer2p5 && level < Settings.Archer3p0){
				newhealth = (victim.getHealth()-1);
				if(newhealth<=0){
					newhealth=0;
				}
				victim.setHealth(newhealth);
			}else if(level >= Settings.Archer3p0){
				newhealth = (victim.getHealth()-2);
				if(newhealth<=0){
					newhealth=0;
				}
				victim.setHealth(newhealth);
			}
			stat = stat + Settings.ExpPerDamage;
			int aftlevel = 0;
			Level.update(player, "a", stat);
			aftlevel = Level.getLevel(player, "a");
			if (aftlevel > level) {
				player.sendMessage(ChatColor.GOLD + "[LC]"
						+ ChatColor.GREEN
						+ " Level up! Your Archery level is now " + aftlevel);
			} else if (PlayerFunctions.enabled(player) == true) {
				player.sendMessage(ChatColor.GOLD + "[LC]"
						+ ChatColor.GREEN + " You gained exp.");
			}
		}
	}
}
