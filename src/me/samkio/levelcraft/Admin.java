package me.samkio.levelcraft;

import java.util.List;

import me.samkio.levelcraft.Functions.LevelFunctions;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class Admin {
	public static Levelcraft plugin;

	public Admin(Levelcraft instance) {
		plugin = instance;
	}

	public static void dothis(CommandSender sender, String[] split) {

		if (split[1].equalsIgnoreCase("setexp") && split.length >= 5) {

			String editplayer = split[3];
			int newexp = Integer.parseInt(split[4]);

			List<Player> players = plugin.getServer().matchPlayer(editplayer);
			if (players.size() == 0) {
				sender.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.RED
						+ " No matching player!");
			} else if (players.size() != 1) {
				sender.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.RED
						+ " Matched more than one player! Be more specific!");

			} else {
				Player editor = players.get(0);
				String stat = split[2];

				if ((stat.equalsIgnoreCase("mine")
						|| stat.equalsIgnoreCase("m") || stat
						.equalsIgnoreCase("mining"))) {
					LevelFunctions.write(editor, newexp, Levelcraft.MiExpFile);
					sender.sendMessage(ChatColor.GOLD + "[LC]"
							+ ChatColor.GREEN + " Set Experience successful!");
				} else if ((stat.equalsIgnoreCase("w")
						|| stat.equalsIgnoreCase("wc") || stat
						.equalsIgnoreCase("woodcut"))) {
					sender.sendMessage(ChatColor.GOLD + "[LC]"
							+ ChatColor.GREEN + " Set Experience successful!");
					LevelFunctions.write(editor, newexp, Levelcraft.WCExpFile);
				} else if ((stat.equalsIgnoreCase("s")
						|| stat.equalsIgnoreCase("slay") || stat
						.equalsIgnoreCase("slayer"))) {
					sender.sendMessage(ChatColor.GOLD + "[LC]"
							+ ChatColor.GREEN + " Set Experience successful!");
					LevelFunctions.write(editor, newexp, Levelcraft.SlayExpFile);
				} else if ((stat.equalsIgnoreCase("r")
						|| stat.equalsIgnoreCase("range") || stat
						.equalsIgnoreCase("ranging"))) {
					sender.sendMessage(ChatColor.GOLD + "[LC]"
							+ ChatColor.GREEN + " Set Experience successful!");
					LevelFunctions.write(editor, newexp, Levelcraft.RangeExpFile);
				} else if ((stat.equalsIgnoreCase("f")
						|| stat.equalsIgnoreCase("fist") || stat
						.equalsIgnoreCase("fisticuffs"))) {
					sender.sendMessage(ChatColor.GOLD + "[LC]"
							+ ChatColor.GREEN + " Set Experience successful!");
					LevelFunctions.write(editor, newexp, Levelcraft.FisticuffsExpFile);
				} else if ((stat.equalsIgnoreCase("a")
						|| stat.equalsIgnoreCase("archer") || stat
						.equalsIgnoreCase("archery"))) {
					sender.sendMessage(ChatColor.GOLD + "[LC]"
							+ ChatColor.GREEN + " Set Experience successful!");
					LevelFunctions.write(editor, newexp, Levelcraft.ArcherExpFile);
				} else {
					sender.sendMessage(ChatColor.GOLD
							+ "[LC]"
							+ ChatColor.YELLOW
							+ " Stat not found type '/level list' to list all stats. ");
				}
			}
		}
	}
}
