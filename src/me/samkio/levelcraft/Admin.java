package me.samkio.levelcraft;

import java.util.List;

import me.samkio.levelcraft.Functions.LevelFunctions;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;


public class Admin {
	public static Levelcraft plugin;

	public Admin(Levelcraft instance) {
		plugin = instance;
	}

	public static void dothis(Player player, String[] split) {

		if (split[2].equalsIgnoreCase("setexp") && split.length >= 6) {

			String editplayer = split[4];
			int newexp = Integer.parseInt(split[5]);

			List<Player> players = plugin.getServer().matchPlayer(editplayer);
			if (players.size() == 0) {
				player.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.RED
						+ " No matching player!");
			} else if (players.size() != 1) {
				player.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.RED
						+ " Matched more than one player!  Be more specific!");

			} else {
				Player editor = players.get(0);
				String stat = split[3];

				if ((stat.equalsIgnoreCase("mine")
						|| stat.equalsIgnoreCase("m") || stat
						.equalsIgnoreCase("mining"))) {
					LevelFunctions.write(editor, newexp, Levelcraft.MiExpFile);
					player.sendMessage(ChatColor.GOLD + "[LC]"
							+ ChatColor.GREEN + " Set Experience successful!");
				} else if ((stat.equalsIgnoreCase("w")
						|| stat.equalsIgnoreCase("wc") || stat
						.equalsIgnoreCase("woodcut"))) {
					player.sendMessage(ChatColor.GOLD + "[LC]"
							+ ChatColor.GREEN + " Set Experience successful!");
					LevelFunctions.write(editor, newexp, Levelcraft.WCExpFile);
				}else if ((stat.equalsIgnoreCase("s")
						|| stat.equalsIgnoreCase("slay") || stat
						.equalsIgnoreCase("slayer"))) {
					player.sendMessage(ChatColor.GOLD + "[LC]"
							+ ChatColor.GREEN + " Set Experience successful!");
					LevelFunctions.write(editor, newexp, Levelcraft.SlayExpFile);
				} else {
					player.sendMessage(ChatColor.GOLD
							+ "[LC]"
							+ ChatColor.YELLOW
							+ " Stat not found type '/level list' to list all stats. ");
				}
			}
		}
	}

}
