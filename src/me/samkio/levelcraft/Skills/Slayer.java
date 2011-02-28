package me.samkio.levelcraft.Skills;

<<<<<<< HEAD
=======
import me.samkio.levelcraft.Levelcraft;
import me.samkio.levelcraft.Settings;
>>>>>>> parent of 9a92e9f... Whitelist Modified again.
import me.samkio.levelcraft.Functions.LevelFunctions;
import me.samkio.levelcraft.Functions.PlayerFunctions;
import me.samkio.levelcraft.SamToolbox.DataMySql;
import me.samkio.levelcraft.SamToolbox.DataSqlite;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

<<<<<<< HEAD
import samkio.levelcraft.Levelcraft;
import samkio.levelcraft.Settings;

=======
>>>>>>> parent of 9a92e9f... Whitelist Modified again.

public class Slayer {

	public static void attack(EntityDamageByEntityEvent event) {
		Player player = (Player) event.getDamager();
		int iih = player.getItemInHand().getTypeId();
		PlayerFunctions.checkAccount(player);
		int level = 0;
		double stat = 0;
		if (Settings.enableSlayerLevel == true) {
			if (Settings.database.equalsIgnoreCase("flatfile")) {
				level = LevelFunctions.getLevel(player, Levelcraft.SlayExpFile);
				stat = LevelFunctions.getExp(player, Levelcraft.SlayExpFile);
			} else if (Settings.database.equalsIgnoreCase("sqlite")) {
				stat = DataSqlite.getExp(player, "SlayingExp");
				level = DataSqlite.getLevel(player, "SlayingExp");
			}
			else if (Settings.database.equalsIgnoreCase("mysql")) {
				stat = DataMySql.getExp(player, "SlayingExp");
				level = DataMySql.getLevel(player, "SlayingExp");
			}
			if (level < Settings.SlayIronSword && iih == 267) {
				player.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.RED
						+ " Cannot use this tool. Required Level:"
						+ Settings.SlayIronSword);
				event.setCancelled(true);
			} else if (level < Settings.SlayGoldSword && iih == 283) {
				player.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.RED
						+ " Cannot use this tool. Required Level:"
						+ Settings.SlayGoldSword);
				event.setCancelled(true);
			} else if (level < Settings.SlayDiamondSword && iih == 276) {
				player.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.RED
						+ " Cannot use this tool. Required Level:"
						+ Settings.SlayDiamondSword);
				event.setCancelled(true);
			} else if (level < Settings.SlayStoneSword && iih == 272) {
				player.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.RED
						+ " Cannot use this tool. Required Level:"
						+ Settings.SlayStoneSword);
				event.setCancelled(true);
			} else if (level < Settings.SlayWoodSword && iih == 268) {
				player.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.RED
						+ " Cannot use this tool. Required Level:"
						+ Settings.SlayWoodSword);
				event.setCancelled(true);
			} else {

				stat = stat + Settings.ExpPerDamage;
				int aftlevel = 0;
				if (Settings.database.equalsIgnoreCase("flatfile")) {
					LevelFunctions.write(player, stat, Levelcraft.SlayExpFile);
					aftlevel = LevelFunctions.getLevel(player,
							Levelcraft.SlayExpFile);
				} else if (Settings.database.equalsIgnoreCase("sqlite")) {
					DataSqlite.update(player, "SlayingExp", stat);
					aftlevel = DataSqlite.getLevel(player, "SlayingExp");
				}
				else if (Settings.database.equalsIgnoreCase("mysql")) {
					DataMySql.update(player, "SlayingExp", stat);
					aftlevel = DataMySql.getLevel(player, "SlayingExp");
				}
				if (aftlevel > level) {
					player.sendMessage(ChatColor.GOLD + "[LC]"
							+ ChatColor.GREEN
							+ " Level up! Your Slayer level is now " + aftlevel);
				} else if (PlayerFunctions.enabled(player) == true) {
					player.sendMessage(ChatColor.GOLD + "[LC]"
							+ ChatColor.GREEN + " You gained exp.");
				}

			}

		}
	}
}
