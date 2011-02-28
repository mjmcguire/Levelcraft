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


public class Mine {

	public static void Destroy(BlockDamageEvent event) {
		Player player = event.getPlayer();
		int iih = player.getItemInHand().getTypeId();
		PlayerFunctions.checkAccount(player);
		if (Settings.enableMineLevel == true) {
			int level = 0;
			double stat = 0;
			if (Settings.database.equalsIgnoreCase("flatfile")) {
				level = LevelFunctions.getLevel(player, Levelcraft.MiExpFile);
				stat = LevelFunctions.getExp(player, Levelcraft.MiExpFile);
			} else if (Settings.database.equalsIgnoreCase("sqlite")) {
				stat = DataSqlite.getExp(player, "MiningExp");
				level = DataSqlite.getLevel(player, "MiningExp");
			}
		 else if (Settings.database.equalsIgnoreCase("mysql")) {
			stat = DataMySql.getExp(player, "MiningExp");
			level = DataMySql.getLevel(player, "MiningExp");
		}
			if (level < Settings.MIIronPick && iih == 257) {
				player.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.RED
						+ " Cannot use this tool. Required Level:"
						+ Settings.MIIronPick);
				event.setCancelled(true);
			} else if (level < Settings.MIGoldPick && iih == 285) {
				player.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.RED
						+ " Cannot use this tool. Required Level:"
						+ Settings.MIGoldPick);
				event.setCancelled(true);
			} else if (level < Settings.MIDiamondPick && iih == 278) {
				player.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.RED
						+ " Cannot use this tool. Required Level:"
						+ Settings.MIDiamondPick);
				event.setCancelled(true);
			} else if (level < Settings.MIStonePick && iih == 274) {
				player.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.RED
						+ " Cannot use this tool. Required Level:"
						+ Settings.MIStonePick);
				event.setCancelled(true);
			} else if (level < Settings.MIWoodPick && iih == 270) {
				player.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.RED
						+ " Cannot use this tool. Required Level:"
						+ Settings.MIWoodPick);
				event.setCancelled(true);
			} else if (level < Settings.StoneLevel
					&& event.getBlock().getType() == Material.STONE) {
				player.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.RED
						+ " Cannot mine this block. Required Level:"
						+ Settings.StoneLevel);
				event.setCancelled(true);
			} else if (level < Settings.CobbleLevel
					&& event.getBlock().getType() == Material.COBBLESTONE) {
				player.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.RED
						+ " Cannot mine this block. Required Level:"
						+ Settings.CobbleLevel);
				event.setCancelled(true);
			} else if (level < Settings.RedLevel
					&& event.getBlock().getType() == Material.REDSTONE_ORE) {
				player.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.RED
						+ " Cannot mine this block. Required Level:"
						+ Settings.RedLevel);

				event.setCancelled(true);
			} else if (level < Settings.IronLevel
					&& event.getBlock().getType() == Material.IRON_ORE) {
				player.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.RED
						+ " Cannot mine this block. Required Level:"
						+ Settings.IronLevel);
				event.setCancelled(true);
			} else if (level < Settings.GoldLevel
					&& event.getBlock().getType() == Material.GOLD_ORE) {
				player.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.RED
						+ " Cannot mine this block. Required Level:"
						+ Settings.GoldLevel);
				event.setCancelled(true);
			} else if (level < Settings.DiamondLevel
					&& event.getBlock().getType() == Material.DIAMOND_ORE) {
				player.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.RED
						+ " Cannot mine this block. Required Level:"
						+ Settings.DiamondLevel);
				event.setCancelled(true);
			} else if (level < Settings.CoalLevel
					&& event.getBlock().getType() == Material.COAL_ORE) {
				player.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.RED
						+ " Cannot mine this block. Required Level:"
						+ Settings.CoalLevel);
				event.setCancelled(true);
			} else if (level < Settings.MossLevel
					&& event.getBlock().getType() == Material.MOSSY_COBBLESTONE) {
				player.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.RED
						+ " Cannot mine this block. Required Level:"
						+ Settings.MossLevel);
				event.setCancelled(true);
			} else if (level < Settings.LapisLevel
					&& event.getBlock().getType() == Material.LAPIS_ORE) {
				player.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.RED
						+ " Cannot mine this block. Required Level:"
						+ Settings.LapisLevel);
				event.setCancelled(true);
			} else if (level < Settings.NetherLevel
					&& event.getBlock().getType() == Material.OBSIDIAN) {
				player.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.RED
						+ " Cannot mine this block. Required Level:"
						+ Settings.NetherLevel);
				event.setCancelled(true);
			} else if (level < Settings.ObsidianLevel
					&& event.getBlock().getType() == Material.OBSIDIAN) {
				player.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.RED
						+ " Cannot mine this block. Required Level:"
						+ Settings.ObsidianLevel);
				event.setCancelled(true);

			} else if (event.getBlock().getType() == Material.STONE
					|| event.getBlock().getType() == Material.COBBLESTONE
					|| event.getBlock().getType() == Material.REDSTONE_ORE
					|| event.getBlock().getType() == Material.IRON_ORE
					|| event.getBlock().getType() == Material.OBSIDIAN
					|| event.getBlock().getType() == Material.GOLD_ORE
					|| event.getBlock().getType() == Material.COAL_ORE
					|| event.getBlock().getType() == Material.MOSSY_COBBLESTONE
					|| event.getBlock().getType() == Material.LAPIS_ORE
					|| event.getBlock().getType() == Material.NETHERRACK
					|| event.getBlock().getType() == Material.DIAMOND_ORE) {
				if (event.getBlock().getType() == Material.STONE) {

					stat = stat + Settings.ExpPerStone;
				}
				if (event.getBlock().getType() == Material.OBSIDIAN) {

					stat = stat + Settings.ExpPerObsidian;
				}
				if (event.getBlock().getType() == Material.MOSSY_COBBLESTONE) {

					stat = stat + Settings.ExpPerMossstone;
				}
				if (event.getBlock().getType() == Material.COBBLESTONE) {
					stat = stat + Settings.ExpPerCobble;
				}
				if (event.getBlock().getType() == Material.GOLD_ORE) {

					stat = stat + Settings.ExpPerGoldOre;
				}
				if (event.getBlock().getType() == Material.IRON_ORE) {

					stat = stat + Settings.ExpPerIronOre;
				}
				if (event.getBlock().getType() == Material.LAPIS_ORE) {

					stat = stat + Settings.ExpPerLapisOre;
				}
				if (event.getBlock().getType() == Material.COAL_ORE) {

					stat = stat + Settings.ExpPerCoalOre;
				}
				if (event.getBlock().getType() == Material.OBSIDIAN) {

					stat = stat + Settings.ExpPerObsidian;
				}
				if (event.getBlock().getType() == Material.REDSTONE_ORE) {

					stat = stat + Settings.ExpPerRedstone;
				}
                                if (event.getBlock().getType() == Material.GLOWING_REDSTONE_ORE) {

					stat = stat + Settings.ExpPerRedstone;
				}
				if (event.getBlock().getType() == Material.NETHERRACK) {

					stat = stat + Settings.ExpPerNetherrack;
				}
				if (event.getBlock().getType() == Material.DIAMOND_ORE) {

					stat = stat + Settings.ExpPerDiamondOre;
				}
				int aftlevel = 0;
				if (Settings.database.equalsIgnoreCase("flatfile")) {
					LevelFunctions.write(player, stat, Levelcraft.MiExpFile);
					aftlevel = LevelFunctions.getLevel(player,
							Levelcraft.MiExpFile);
				} else if (Settings.database.equalsIgnoreCase("sqlite")) {
					DataSqlite.update(player,"MiningExp",stat);
					aftlevel = DataSqlite.getLevel(player, "MiningExp");
				}
				 else if (Settings.database.equalsIgnoreCase("mysql")) {
						DataMySql.update(player,"MiningExp",stat);
						aftlevel = DataMySql.getLevel(player, "MiningExp");
					}
				if (aftlevel > level) {
					player.sendMessage(ChatColor.GOLD + "[LC]"
							+ ChatColor.GREEN
							+ " Level up! Your Mining level is now " + aftlevel);
				} else if (PlayerFunctions.enabled(player) == true) {
					player.sendMessage(ChatColor.GOLD + "[LC]"
							+ ChatColor.GREEN + " You gained exp.");
				}
			}
		}
	}
}
