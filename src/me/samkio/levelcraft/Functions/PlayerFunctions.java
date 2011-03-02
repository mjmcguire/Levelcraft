package me.samkio.levelcraft.Functions;

import java.util.HashMap;

import me.samkio.levelcraft.Admin;
import me.samkio.levelcraft.Help;
import me.samkio.levelcraft.Levelcraft;
import me.samkio.levelcraft.Settings;
import me.samkio.levelcraft.Whitelist;
import me.samkio.levelcraft.SamToolbox.DataMySql;
import me.samkio.levelcraft.SamToolbox.DataSqlite;
import me.samkio.levelcraft.SamToolbox.Level;
import me.samkio.levelcraft.SamToolbox.Toolbox;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;


public class PlayerFunctions {
	private final static HashMap<Player, Boolean> NotifyUsers = new HashMap<Player, Boolean>();

	public static void doThis(Player player, String[] split, Levelcraft plugin) {
		if ((split[1].equalsIgnoreCase("wc")
				|| split[1].equalsIgnoreCase("wood")
				|| split[1].equalsIgnoreCase("woodcut") || split[1]
				.equalsIgnoreCase("w")) && Settings.enableWCLevel == true) {
			showStat(player, "w");
		} else if ((split[1].equalsIgnoreCase("mine")
				|| split[1].equalsIgnoreCase("m") || split[1]
				.equalsIgnoreCase("mining"))
				&& Settings.enableMineLevel == true) {
			showStat(player, "m");
		} else if ((split[1].equalsIgnoreCase("slay")
				|| split[1].equalsIgnoreCase("s") || split[1]
				.equalsIgnoreCase("slayer"))
				&& Settings.enableSlayerLevel == true) {
			showStat(player, "s");
		} else if ((split[1].equalsIgnoreCase("range")
				|| split[1].equalsIgnoreCase("r") || split[1].equalsIgnoreCase("ranging"))
				&& Settings.enableRangeLevel == true) {
			showStat(player, "r"); 
		} else if ((split[1].equalsIgnoreCase("fist")
				|| split[1].equalsIgnoreCase("f") || split[1].equalsIgnoreCase("fisticuffs"))
				&& Settings.enableFisticuffsLevel == true) {
			showStat(player, "f"); 
		} else if ((split[1].equalsIgnoreCase("archer")
				|| split[1].equalsIgnoreCase("a") || split[1].equalsIgnoreCase("archery"))
				&& Settings.enableArcherLevel == true) {
			showStat(player, "a");
		} else if (split[1].equalsIgnoreCase("list")) {
			Help.ListLevels(player);
		} else if (split[1].equalsIgnoreCase("admin")
				&& Whitelist.isAdmin(player.getName()) == true
				&& split.length >= 3) {
			Admin.dothis(player, split);
		} else if (split[1].equalsIgnoreCase("notify")) {
			toggleNotify(player);
		} else if (split[1].equalsIgnoreCase("shout") && split.length >= 3) {
			Help.shout(player, split[2], plugin);
		} else if ((split[1].equalsIgnoreCase("all"))) {
			int level = 0;
			int level2 = 0;
			int level3 = 0;
			int level4 = 0;
			int level5 = 0;
			int level6 = 0;
			double mineexp = 0;
			double slayexp = 0;
			double wcexp = 0;
			double rangexp = 0;
			double fisticuffsexp = 0;
			double archeryexp = 0;
			level = Level.getLevel(player, "m");
			level2 = Level.getLevel(player, "s");
			level3 = Level.getLevel(player, "w");
			level4 = Level.getLevel(player, "r");
			level5 = Level.getLevel(player, "f");
			level6 = Level.getLevel(player, "a");
			mineexp = Level.getExp(player, "m");
			slayexp = Level.getExp(player, "s");
			wcexp = Level.getExp(player, "w");
			rangexp = Level.getExp(player, "r");
			fisticuffsexp = Level.getExp(player, "f");
			archeryexp = Level.getExp(player, "a");
			player.sendMessage(ChatColor.GOLD
					+ "[LC] ---LevelCraftPlugin By Samkio--- ");
			player.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.GREEN
					+ " (M): " + level + ". Exp:" + mineexp);
			player.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.GREEN
					+ " (S): " + level2 + ", Exp:" + slayexp);
			player.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.GREEN
					+ " (W): " + level3 + ". Exp:" + wcexp);
			player.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.GREEN
					+ " (R): " + level4 + ". Exp:" + rangexp);
			player.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.GREEN
					+ " (F): " + level5 + ". Exp:" + fisticuffsexp);
			player.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.GREEN
					+ " (A): " + level6 + ". Exp:" + archeryexp);
		}

		else if (split[1].equalsIgnoreCase("unlocks")) {
			if (split.length >= 3) {
				Help.unlocks(player, split);
			} else {
				Help.IncorrectExp(player);
			}

		} else {
			player.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.YELLOW
					+ " Stat not found type '/level list' to list all stats. ");
		}

	}

	public static void checkAccount(Player player) {
		if (Settings.database.equalsIgnoreCase("flatfile")) {
			boolean HasWCAccount = LevelFunctions.containskey(player,
					Levelcraft.WCExpFile);
			boolean HasMineAcc = LevelFunctions.containskey(player,
					Levelcraft.MiExpFile);
			boolean HasSlayAcc = LevelFunctions.containskey(player,
					Levelcraft.SlayExpFile);
			boolean HasRangeAcc = LevelFunctions.containskey(player,
					Levelcraft.RangeExpFile);
			boolean HasFisticuffsAcc = LevelFunctions.containskey(player,
					Levelcraft.FisticuffsExpFile);
			if (HasWCAccount == false) {
				LevelFunctions.write(player, 0, Levelcraft.WCExpFile);
			}

			if (HasMineAcc == false) {
				LevelFunctions.write(player, 0, Levelcraft.MiExpFile);
			}

			if (HasSlayAcc == false) {
				LevelFunctions.write(player, 0, Levelcraft.SlayExpFile);
			}
			if (HasRangeAcc == false) {
				LevelFunctions.write(player, 0, Levelcraft.RangeExpFile);
			}
			if (HasFisticuffsAcc == false) {
				LevelFunctions.write(player, 0, Levelcraft.FisticuffsExpFile);
			}
		} else if (Settings.database.equalsIgnoreCase("mysql") && DataMySql.PlayerExsists(player) == false) {
			DataMySql.NewPlayer(player, 0);
		} else if (Settings.database.equalsIgnoreCase("sqlite")
				&& DataSqlite.PlayerExsists(player) == false) {
			DataSqlite.NewPlayer(player, 0);
		}
	}

	public static boolean enabled(Player player) {
		return NotifyUsers.containsKey(player);
	}

	public static void toggleNotify(Player player) {
		if (enabled(player)) {
			NotifyUsers.remove(player);
			Toolbox.sendMessage(player, "Experience notify disabled.", true);
		} else {
			NotifyUsers.put(player, null);
			player.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.GREEN
					+ " Experience notify enabled.");
		}
	}

	public static void showStat(Player player, String string) {
		int level = 0;
		double stat = 0;
		double expLeft = 0;
		String str = "NULL";
		if (string.equalsIgnoreCase("W")) {
			level = Level.getLevel(player, "w");
			stat = Level.getExp(player, "w");
			expLeft = Level.getExpLeft(player, "w");
			str = "Woodcut";
		} else if (string.equalsIgnoreCase("M")) {
			level = Level.getLevel(player, "m");
			stat = Level.getExp(player, "m");
			expLeft = Level.getExpLeft(player, "m");
			str = "Mining";
		} else if (string.equalsIgnoreCase("S")) {
			level = Level.getLevel(player, "s");
			stat = Level.getExp(player, "s");
			expLeft = Level.getExpLeft(player, "s");
			str = "Slaying";
		}  else if (string.equalsIgnoreCase("R")) {
			level = Level.getLevel(player, "r");
			stat = Level.getExp(player, "r");
			expLeft = Level.getExpLeft(player, "r");
			str = "Ranging";
		}   else if (string.equalsIgnoreCase("F")) {
			level = Level.getLevel(player, "f");
			stat = Level.getExp(player, "f");
			expLeft = Level.getExpLeft(player, "f");
			str = "Fisticuffs";
		}   else if (string.equalsIgnoreCase("A")) {
			level = Level.getLevel(player, "a");
			stat = Level.getExp(player, "a");
			expLeft = Level.getExpLeft(player, "a");
			str = "Archery";
		}
		player.sendMessage(ChatColor.GOLD
				+ "[LC] ---LevelCraftPlugin By Samkio--- ");
		player.sendMessage(ChatColor.GOLD + "[LC] " + ChatColor.GREEN + str
				+ " experience: " + stat);
		player.sendMessage(ChatColor.GOLD + "[LC] " + ChatColor.GREEN + str
				+ " level: " + level);
		player.sendMessage(ChatColor.GOLD + "[LC] " + ChatColor.GREEN
				+ "Experience left to next level: " + expLeft);
	}
}
