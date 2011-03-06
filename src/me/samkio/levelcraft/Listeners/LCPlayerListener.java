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

	public void onPlayerJoin(PlayerEvent event) {
		Player player = event.getPlayer();
		PlayerFunctions.checkAccount(player);
	}
}