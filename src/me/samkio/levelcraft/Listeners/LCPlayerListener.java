package me.samkio.levelcraft.Listeners;

import me.samkio.levelcraft.Levelcraft;
import me.samkio.levelcraft.Functions.PlayerFunctions;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.event.player.PlayerListener;


public class LCPlayerListener extends PlayerListener {
	public static Levelcraft plugin;

	public LCPlayerListener(Levelcraft instance) {
		plugin = instance;
	}

	public void onPlayerCommand(PlayerChatEvent event) {
		String[] split = event.getMessage().split(" ");
		Player player = event.getPlayer();
		PlayerFunctions.checkAccount(player);
		if (split[0].equalsIgnoreCase("/level")
				|| split[0].equalsIgnoreCase("/lvl")) {

			if (split.length >= 2) {
				PlayerFunctions.doThis(player, split);
			} else {
				About(player);

			}
		}

	}

	public void onPlayerJoin(PlayerEvent event) {
		Player player = event.getPlayer();
		PlayerFunctions.checkAccount(player);
	}
	public static void About(Player player) {
		player.sendMessage(ChatColor.GOLD + "[LC] ---LevelCraftPlugin By Samkio (C)2011--- ");
		player.sendMessage(ChatColor.GOLD + "[LC]" +ChatColor.YELLOW+ " /lvl list - Shows active stats.");
		player.sendMessage(ChatColor.GOLD + "[LC]" +ChatColor.YELLOW+ " /lvl [w|m|s|r|f] - Shows stats statisics.");
		player.sendMessage(ChatColor.GOLD + "[LC]" +ChatColor.YELLOW+ " /lvl notify - Toggles notifications.");
		player.sendMessage(ChatColor.GOLD + "[LC]" +ChatColor.YELLOW+ " /lvl unlocks [w|m|s|r|f] - Shows tool level unlocks.");
		player.sendMessage(ChatColor.GOLD + "[LC]" +ChatColor.YELLOW+ " /lvl or /level - Shows this.");
	}

}