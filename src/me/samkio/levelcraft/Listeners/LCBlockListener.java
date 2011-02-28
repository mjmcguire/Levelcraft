package me.samkio.levelcraft.Listeners;
import me.samkio.levelcraft.Levelcraft;
import me.samkio.levelcraft.Whitelist;
import me.samkio.levelcraft.Skills.Mine;
import me.samkio.levelcraft.Skills.Wood;

import org.bukkit.block.BlockDamageLevel;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.block.BlockListener;

public class LCBlockListener extends BlockListener {
	public static Levelcraft plugin;

	public LCBlockListener(Levelcraft instance) {
		plugin = instance;
	}

	public void onBlockDamage(BlockDamageEvent event) {
		
		if ((!event.isCancelled()) && (event.getDamageLevel() == BlockDamageLevel.STOPPED)&&(Whitelist.isAvoid(event.getPlayer().getName()) == false)) {
			
			  Wood.Destroy(event);
			  Mine.Destroy(event);
			
		}

	}

}
