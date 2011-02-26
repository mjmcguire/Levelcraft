package me.samkio.levelcraft.Skills;

import me.samkio.levelcraft.Functions.PlayerFunctions;

import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByProjectileEvent;

public class Range {
	public static void attack(EntityDamageByProjectileEvent event) {
		Player player = (Player) event.getDamager();
		PlayerFunctions.checkAccount(player);
		int level = 0;
		double stat = 0;
	}
}
