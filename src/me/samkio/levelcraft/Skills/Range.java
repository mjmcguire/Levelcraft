package me.samkio.levelcraft.Skills;

import me.samkio.levelcraft.Settings;
import me.samkio.levelcraft.Functions.PlayerFunctions;
import me.samkio.levelcraft.SamToolbox.Level;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByProjectileEvent;

public class Range {
	public static void attack(EntityDamageByProjectileEvent event) {
		Player player = (Player) event.getDamager();
		PlayerFunctions.checkAccount(player);
		int level = 0;
		double stat = 0;
		if (Settings.enableRangeLevel == true) {			
			level = Level.getLevel(player, "r");
			stat = Level.getExp(player, "r");
			if (level >= Settings.Rangep5 && level < Settings.Range1p0) {
				event.setDamage(1);
			}else if(level >= Settings.Range1p0 && level < Settings.Range1p5){
				event.setDamage(2);
			}else if(level >= Settings.Range1p5 && level < Settings.Range2p0){
				event.setDamage(3);
			}else if(level >= Settings.Range2p0 && level < Settings.Range2p5){
				event.setDamage(4);
			}else if(level >= Settings.Range2p5 && level < Settings.Range3p0){
				event.setDamage(5);
			}else if(level >= Settings.Range3p0){
				event.setDamage(6);
			}
			stat = stat + Settings.ExpPerDamage;
			int aftlevel = 0;
			Level.update(player, "r", stat);
			aftlevel = Level.getLevel(player, "r");
			if (aftlevel > level) {
				player.sendMessage(ChatColor.GOLD + "[LC]"
						+ ChatColor.GREEN
						+ " Level up! Your Range level is now " + aftlevel);
			} else if (PlayerFunctions.enabled(player) == true) {
				player.sendMessage(ChatColor.GOLD + "[LC]"
						+ ChatColor.GREEN + " You gained exp.");
			}

		}
	}
}
