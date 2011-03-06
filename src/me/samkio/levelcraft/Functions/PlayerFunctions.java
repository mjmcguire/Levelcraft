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
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class PlayerFunctions {
	private final static HashMap<CommandSender, Boolean> NotifyUsers = new HashMap<CommandSender, Boolean>();

	public static void doThis(CommandSender sender, String[] split, Levelcraft plugin) {
		if (sender instanceof Player){
			Player player  = (Player) sender;
			if ((split[0].equalsIgnoreCase("wc")
					|| split[0].equalsIgnoreCase("wood")
					|| split[0].equalsIgnoreCase("woodcut") || split[0]
					.equalsIgnoreCase("w")) && Settings.enableWCLevel == true) {
				showStat(sender, "w");
			} else if ((split[0].equalsIgnoreCase("mine")
					|| split[0].equalsIgnoreCase("m") || split[0]
                    .equalsIgnoreCase("mining"))
                    && Settings.enableMineLevel == true) {
				showStat(sender, "m");
			} else if ((split[0].equalsIgnoreCase("slay")
					|| split[0].equalsIgnoreCase("s") || split[0]
					.equalsIgnoreCase("slayer"))
					&& Settings.enableSlayerLevel == true) {
				showStat(sender, "s");
			} else if ((split[0].equalsIgnoreCase("range")
					|| split[0].equalsIgnoreCase("r") || split[0].equalsIgnoreCase("ranging"))
					&& Settings.enableRangeLevel == true) {
				showStat(sender, "r"); 
			} else if ((split[0].equalsIgnoreCase("fist")
					|| split[0].equalsIgnoreCase("f") || split[0].equalsIgnoreCase("fisticuffs"))
				    && Settings.enableFisticuffsLevel == true) {
				showStat(sender, "f"); 
			} else if ((split[0].equalsIgnoreCase("archer")
					|| split[0].equalsIgnoreCase("a") || split[0].equalsIgnoreCase("archery"))
					&& Settings.enableArcherLevel == true) {
				showStat(sender, "a");
			} else if (split[0].equalsIgnoreCase("list")) {
				Help.ListLevels(sender);
			} else if (split[0].equalsIgnoreCase("admin")
					&& Whitelist.isAdmin(player.getName()) == true
					&& split.length >= 3) {
				Admin.dothis(sender, split);
			} else if (split[0].equalsIgnoreCase("notify")) {
				toggleNotify(sender);
			} else if (split[0].equalsIgnoreCase("shout") && split.length >= 2) {
				Help.shout(sender, split[1], plugin);
			} else if ((split[0].equalsIgnoreCase("all"))) {
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
				level = Level.getLevel(sender, "m");
				level2 = Level.getLevel(sender, "s");
				level3 = Level.getLevel(sender, "w");
				level4 = Level.getLevel(sender, "r");
				level5 = Level.getLevel(sender, "f");
				level6 = Level.getLevel(sender, "a");
				mineexp = Level.getExp(sender, "m");
				slayexp = Level.getExp(sender, "s");
				wcexp = Level.getExp(sender, "w");
				rangexp = Level.getExp(sender, "r");
				fisticuffsexp = Level.getExp(sender, "f");
				archeryexp = Level.getExp(sender, "a");
				sender.sendMessage(ChatColor.GOLD
						+ "[LC] ---LevelCraftPlugin By Samkio--- ");
				sender.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.GREEN
						+ " (M): " + level + ". Exp:" + mineexp);
				sender.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.GREEN
						+ " (S): " + level2 + ", Exp:" + slayexp);
				sender.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.GREEN
						+ " (W): " + level3 + ". Exp:" + wcexp);
				sender.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.GREEN
						+ " (R): " + level4 + ". Exp:" + rangexp);
				sender.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.GREEN
						+ " (F): " + level5 + ". Exp:" + fisticuffsexp);
				sender.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.GREEN
						+ " (A): " + level6 + ". Exp:" + archeryexp);
			} else if (split[0].equalsIgnoreCase("unlocks")) {
				if (split.length >= 2) {
					Help.unlocks(sender, split);
				} else {
					Help.IncorrectExp(sender);
				}
			} else {
				sender.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.YELLOW
						+ " Stat not found type '/level list' to list all stats. ");
			}
		}	
	}

	public static void checkAccount(CommandSender sender) {
		if (Settings.database.equalsIgnoreCase("flatfile")) {
			boolean HasWCAccount = LevelFunctions.containskey(sender,
					Levelcraft.WCExpFile);
			boolean HasMineAcc = LevelFunctions.containskey(sender,
					Levelcraft.MiExpFile);
			boolean HasSlayAcc = LevelFunctions.containskey(sender,
					Levelcraft.SlayExpFile);
			boolean HasRangeAcc = LevelFunctions.containskey(sender,
					Levelcraft.RangeExpFile);
			boolean HasFisticuffsAcc = LevelFunctions.containskey(sender,
					Levelcraft.FisticuffsExpFile);
			boolean HasArcherAcc = LevelFunctions.containskey(sender,
					Levelcraft.ArcherExpFile);
			if (HasWCAccount == false) {
				LevelFunctions.write(sender, 0, Levelcraft.WCExpFile);
			}

			if (HasMineAcc == false) {
				LevelFunctions.write(sender, 0, Levelcraft.MiExpFile);
			}

			if (HasSlayAcc == false) {
				LevelFunctions.write(sender, 0, Levelcraft.SlayExpFile);
			}
			if (HasRangeAcc == false) {
				LevelFunctions.write(sender, 0, Levelcraft.RangeExpFile);
			}
			if (HasFisticuffsAcc == false) {
				LevelFunctions.write(sender, 0, Levelcraft.FisticuffsExpFile);
			}
			if (HasArcherAcc == false) {
				LevelFunctions.write(sender, 0, Levelcraft.ArcherExpFile);
			}
		} else if (Settings.database.equalsIgnoreCase("mysql") && DataMySql.PlayerExsists(sender) == false) {
			DataMySql.NewPlayer(sender, 0);
		} else if (Settings.database.equalsIgnoreCase("sqlite")
				&& DataSqlite.PlayerExsists(sender) == false) {
			DataSqlite.NewPlayer(sender, 0);
		}
	}

	public static boolean enabled(CommandSender sender) {
		return NotifyUsers.containsKey(sender);
	}

	public static void toggleNotify(CommandSender sender) {
		if (enabled(sender)) {
			NotifyUsers.remove(sender);
			Toolbox.sendMessage(sender, "Experience notify disabled.", true);
		} else {
			NotifyUsers.put(sender, null);
			sender.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.GREEN
						+ " Experience notify enabled.");
			}
	}

	public static void showStat(CommandSender sender, String string) {
		if (sender instanceof Player) {
			int level = 0;
			double stat = 0;
			double expLeft = 0;
			String str = "NULL";
			if (string.equalsIgnoreCase("W")) {
				level = Level.getLevel(sender, "w");
				stat = Level.getExp(sender, "w");
				expLeft = Level.getExpLeft(sender, "w");
				str = "Woodcut";
			} else if (string.equalsIgnoreCase("M")) {
				level = Level.getLevel(sender, "m");
				stat = Level.getExp(sender, "m");
				expLeft = Level.getExpLeft(sender, "m");
				str = "Mining";
			} else if (string.equalsIgnoreCase("S")) {
				level = Level.getLevel(sender, "s");
				stat = Level.getExp(sender, "s");
				expLeft = Level.getExpLeft(sender, "s");
				str = "Slaying";
			} else if (string.equalsIgnoreCase("R")) {
				level = Level.getLevel(sender, "r");
				stat = Level.getExp(sender, "r");
				expLeft = Level.getExpLeft(sender, "r");
				str = "Ranging";
			} else if (string.equalsIgnoreCase("F")) {
				level = Level.getLevel(sender, "f");
				stat = Level.getExp(sender, "f");
				expLeft = Level.getExpLeft(sender, "f");
				str = "Fisticuffs";
			} else if (string.equalsIgnoreCase("A")) {
				level = Level.getLevel(sender, "a");
				stat = Level.getExp(sender, "a");
				expLeft = Level.getExpLeft(sender, "a");
				str = "Archery";
			}

			sender.sendMessage(ChatColor.GOLD
					+ "[LC] ---LevelCraftPlugin By Samkio--- ");
			sender.sendMessage(ChatColor.GOLD + "[LC] " + ChatColor.GREEN + str
					+ " experience: " + stat);
			sender.sendMessage(ChatColor.GOLD + "[LC] " + ChatColor.GREEN + str
					+ " level: " + level);
			sender.sendMessage(ChatColor.GOLD + "[LC] " + ChatColor.GREEN
					+ "Experience left to next level: " + expLeft);
		} else {
			sender.sendMessage("Error: Invalid player!");
		}
	}
}
