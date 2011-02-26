package me.samkio.levelcraft.Skills;

import me.samkio.levelcraft.Levelcraft;
import me.samkio.levelcraft.Settings;
import me.samkio.levelcraft.Functions.LevelFunctions;
import me.samkio.levelcraft.Functions.PlayerFunctions;
import me.samkio.levelcraft.SamToolbox.DataMySql;
import me.samkio.levelcraft.SamToolbox.DataSqlite;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockDamageEvent;


public class Wood {

	public static void Destroy(BlockDamageEvent event) {
		Player player = event.getPlayer();
		int iih = player.getItemInHand().getTypeId();

		if (Settings.enableWCLevel == true) {
			int level = 0;
			double woodstat = 0;

			if (Settings.database.equalsIgnoreCase("flatfile")) {
				level = LevelFunctions.getLevel(player, Levelcraft.WCExpFile);
				woodstat = LevelFunctions.getExp(player, Levelcraft.WCExpFile);
			} else if (Settings.database.equalsIgnoreCase("sqlite")) {
				woodstat = DataSqlite.getExp(player, "WoodcuttingExp");
				level = DataSqlite.getLevel(player, "WoodcuttingExp");
			}
			else if (Settings.database.equalsIgnoreCase("mysql")) {
				woodstat = DataMySql.getExp(player, "WoodcuttingExp");
				level = DataMySql.getLevel(player, "WoodcuttingExp");
			}
			if (level < Settings.WCIronAxe && iih == 258) {
				player.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.RED
						+ " Cannot use this tool. Required Level:"
						+ Settings.WCIronAxe);
				event.setCancelled(true);
			} else if (level < Settings.WCGoldAxe && iih == 286) {
				player.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.RED
						+ " Cannot use this tool. Required Level:"
						+ Settings.WCGoldAxe);
				event.setCancelled(true);
			} else if (level < Settings.WCDiamondAxe && iih == 279) {
				player.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.RED
						+ " Cannot use this tool. Required Level:"
						+ Settings.WCDiamondAxe);
				event.setCancelled(true);
			} else if (level < Settings.WCStoneAxe && iih == 275) {
				player.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.RED
						+ " Cannot use this tool. Required Level:"
						+ Settings.WCStoneAxe);
				event.setCancelled(true);
			} else if (level < Settings.WCWoodAxe && iih == 271) {
				player.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.RED
						+ " Cannot use this tool. Required Level:"
						+ Settings.WCWoodAxe);
				event.setCancelled(true);
			} else if (level < Settings.LogLevel
					&& event.getBlock().getType() == Material.LOG) {
				player.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.RED
						+ " Cannot mine this block. Required Level:"
						+ Settings.LogLevel);
				event.setCancelled(true);
			} else if (level < Settings.PlankLevel
					&& event.getBlock().getType() == Material.WOOD) {
				player.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.RED
						+ " Cannot mine this block. Required Level:"
						+ Settings.PlankLevel);
				event.setCancelled(true);
			} else if (event.getBlock().getType() == Material.LOG
					|| event.getBlock().getType() == Material.WOOD) {

				if (event.getBlock().getType() == Material.LOG) {
					woodstat = woodstat + Settings.ExpPerLog;
				}
				if (event.getBlock().getType() == Material.WOOD) {
					woodstat = woodstat + Settings.ExpPerPlank;
				}
				int aftlevel = 0;
				if (Settings.database.equalsIgnoreCase("flatfile")) {
					LevelFunctions
							.write(player, woodstat, Levelcraft.WCExpFile);
					aftlevel = LevelFunctions.getLevel(player,
							Levelcraft.WCExpFile);
				} else if (Settings.database.equalsIgnoreCase("sqlite")) {
					DataSqlite.update(player, "WoodcuttingExp", woodstat);
					aftlevel = DataSqlite.getLevel(player, "WoodcuttingExp");
				}
				else if (Settings.database.equalsIgnoreCase("mysql")) {
					DataMySql.update(player, "WoodcuttingExp", woodstat);
					aftlevel = DataMySql.getLevel(player, "WoodcuttingExp");
				}
				if (aftlevel > level) {
					player.sendMessage(ChatColor.GOLD + "[LC]"
							+ ChatColor.GREEN
							+ " Level up! Your Woodcut level is now "
							+ aftlevel);
				} else if (PlayerFunctions.enabled(player)) {
					player.sendMessage(ChatColor.GOLD + "[LC]"
							+ ChatColor.GREEN + " You gained exp.");
				}
			}

		}
	}
}
