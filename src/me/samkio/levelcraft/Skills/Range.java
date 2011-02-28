package me.samkio.levelcraft.Skills;

import java.util.logging.Logger;

<<<<<<< HEAD
<<<<<<< HEAD
=======
import me.samkio.levelcraft.Levelcraft;
import me.samkio.levelcraft.Settings;
>>>>>>> parent of 9a92e9f... Whitelist Modified again.
=======
import me.samkio.levelcraft.Levelcraft;
import me.samkio.levelcraft.Settings;
>>>>>>> parent of 9a92e9f... Whitelist Modified again.
import me.samkio.levelcraft.Functions.LevelFunctions;
import me.samkio.levelcraft.Functions.PlayerFunctions;
import me.samkio.levelcraft.SamToolbox.DataMySql;
import me.samkio.levelcraft.SamToolbox.DataSqlite;

import org.bukkit.ChatColor;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByProjectileEvent;

<<<<<<< HEAD
<<<<<<< HEAD
import samkio.levelcraft.Levelcraft;
import samkio.levelcraft.Settings;

=======
>>>>>>> parent of 9a92e9f... Whitelist Modified again.
=======
>>>>>>> parent of 9a92e9f... Whitelist Modified again.
public class Range {
	public static void attack(EntityDamageByProjectileEvent event) {
		Player player = (Player) event.getDamager();
		Monster monster = (Monster) event.getEntity();
		PlayerFunctions.checkAccount(player);
		int level = 0;
		double stat = 0;
		int newhealth = 0;
		if (Settings.enableRangeLevel == true) {
			if (Settings.database.equalsIgnoreCase("flatfile")) {
				level = LevelFunctions.getLevel(player, Levelcraft.RangeExpFile);
				stat = LevelFunctions.getExp(player, Levelcraft.RangeExpFile);
			} else if (Settings.database.equalsIgnoreCase("sqlite")) {
				stat = DataSqlite.getExp(player, "RangingExp");
				level = DataSqlite.getLevel(player, "RangingExp");
			}
			else if (Settings.database.equalsIgnoreCase("mysql")) {
				stat = DataMySql.getExp(player, "RangingExp");
				level = DataMySql.getLevel(player, "RangingExp");
			}
			if (level > Settings.Rangep5 && level < Settings.Range1p0) {
				newhealth = (monster.getHealth()-1);
				if(newhealth<=0){
					newhealth=0;
				}
				monster.setHealth(newhealth);
			}else if(level > Settings.Range1p0 && level < Settings.Range1p5){
				newhealth = (monster.getHealth()-2);
				if(newhealth<=0){
					newhealth=0;
				}
				monster.setHealth(newhealth);
			}else if(level > Settings.Range1p5 && level < Settings.Range2p0){
				newhealth = (monster.getHealth()-3);
				if(newhealth<=0){
					newhealth=0;
				}
				monster.setHealth(newhealth);
			}else if(level > Settings.Range2p0 && level < Settings.Range2p5){
				newhealth = (monster.getHealth()-4);
				if(newhealth<=0){
					newhealth=0;
				}
				monster.setHealth(newhealth);
			}else if(level > Settings.Range2p5 && level < Settings.Range3p0){
				newhealth = (monster.getHealth()-5);
				if(newhealth<=0){
					newhealth=0;
				}
				monster.setHealth(newhealth);
			}else if(level > Settings.Range3p0){
				newhealth = (monster.getHealth()-6);
				if(newhealth<=0){
					newhealth=0;
				}
				monster.setHealth(newhealth);
			}
			stat = stat + Settings.ExpPerDamage;
			int aftlevel = 0;
			if (Settings.database.equalsIgnoreCase("flatfile")) {
				LevelFunctions.write(player, stat, Levelcraft.RangeExpFile);
				aftlevel = LevelFunctions.getLevel(player,
						Levelcraft.RangeExpFile);
			} else if (Settings.database.equalsIgnoreCase("sqlite")) {
				DataSqlite.update(player, "RangingExp", stat);
				aftlevel = DataSqlite.getLevel(player, "RangingExp");
			}
			else if (Settings.database.equalsIgnoreCase("mysql")) {
				DataMySql.update(player, "RangingExp", stat);
				aftlevel = DataMySql.getLevel(player, "RangingExp");
			}
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
