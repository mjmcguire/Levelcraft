package me.samkio.levelcraft.Skills;

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
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

<<<<<<< HEAD
<<<<<<< HEAD
import samkio.levelcraft.Levelcraft;
import samkio.levelcraft.Settings;

=======
>>>>>>> parent of 9a92e9f... Whitelist Modified again.
=======
>>>>>>> parent of 9a92e9f... Whitelist Modified again.
public class Fisticuffs {
	public static void attack(EntityDamageByEntityEvent event) {
		Player player = (Player) event.getDamager();
		int iih = player.getItemInHand().getTypeId();
		PlayerFunctions.checkAccount(player);
		int level = 0;
		double stat = 0;
		if (Settings.enableFisticuffsLevel == true) {
			if (Settings.database.equalsIgnoreCase("flatfile")) {
				level = LevelFunctions.getLevel(player, Levelcraft.FisticuffsExpFile);
				stat = LevelFunctions.getExp(player, Levelcraft.FisticuffsExpFile);
			} else if (Settings.database.equalsIgnoreCase("sqlite")) {
				stat = DataSqlite.getExp(player, "FisticuffsExp");
				level = DataSqlite.getLevel(player, "FisticuffsExp");
			}
			else if (Settings.database.equalsIgnoreCase("mysql")) {
				stat = DataMySql.getExp(player, "FisticuffsExp");
				level = DataMySql.getLevel(player, "FisticuffsExp");
			}
			if (level < Settings.FisticuffsIronSword && iih == 267) {
				player.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.RED
						+ " Cannot use this weapon. Required Level:"
						+ Settings.FisticuffsIronSword);
				event.setCancelled(true);
			} else if (level < Settings.FisticuffsGoldSword && iih == 283) {
				player.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.RED
						+ " Cannot use this weapon. Required Level:"
						+ Settings.FisticuffsGoldSword);
				event.setCancelled(true);
			} else if (level < Settings.FisticuffsDiamondSword && iih == 276) {
				player.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.RED
						+ " Cannot use this weapon. Required Level:"
						+ Settings.FisticuffsDiamondSword);
				event.setCancelled(true);
			} else if (level < Settings.FisticuffsStoneSword && iih == 272) {
				player.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.RED
						+ " Cannot use this weapon. Required Level:"
						+ Settings.FisticuffsStoneSword);
				event.setCancelled(true);
			} else if (level < Settings.FisticuffsWoodSword && iih == 268) {
				player.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.RED
						+ " Cannot use this weapon. Required Level:"
						+ Settings.FisticuffsWoodSword);
				event.setCancelled(true);
			} else {

				stat = stat + Settings.ExpPerDamage;
				int aftlevel = 0;
				if (Settings.database.equalsIgnoreCase("flatfile")) {
					LevelFunctions.write(player, stat, Levelcraft.FisticuffsExpFile);
					aftlevel = LevelFunctions.getLevel(player,
							Levelcraft.FisticuffsExpFile);
				} else if (Settings.database.equalsIgnoreCase("sqlite")) {
					DataSqlite.update(player, "FisticuffsExp", stat);
					aftlevel = DataSqlite.getLevel(player, "FisticuffsExp");
				}
				else if (Settings.database.equalsIgnoreCase("mysql")) {
					DataMySql.update(player, "FisticuffsExp", stat);
					aftlevel = DataMySql.getLevel(player, "FisticuffsExp");
				}
				if (aftlevel > level) {
					player.sendMessage(ChatColor.GOLD + "[LC]"
							+ ChatColor.GREEN
							+ " Level up! Your Fisticuffs level is now " + aftlevel);
				} else if (PlayerFunctions.enabled(player) == true) {
					player.sendMessage(ChatColor.GOLD + "[LC]"
							+ ChatColor.GREEN + " You gained exp.");
				}
			}
		}
	}
}
