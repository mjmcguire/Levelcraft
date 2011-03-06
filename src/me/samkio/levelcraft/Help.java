package me.samkio.levelcraft;

import me.samkio.levelcraft.SamToolbox.Level;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class Help {
	
	public static void IncorrectExp(CommandSender sender) {
		sender.sendMessage(ChatColor.GOLD + "[LC]" +ChatColor.YELLOW+ " Stat not found.");
		sender.sendMessage(ChatColor.GOLD + "[LC]" +ChatColor.YELLOW+ " Please type '/level list' to show all stats.");
	}
    
	public static void ListLevels(CommandSender sender) {
		String list = ChatColor.GOLD + "[LC]" +ChatColor.YELLOW+ " Stats:";
		if( Settings.enableWCLevel == true){
			list = list + "WoodCutting(W),";
		}
		if( Settings.enableMineLevel == true){
			list = list + "Mining(M),";
		}
		if( Settings.enableSlayerLevel == true){
			list = list + "Slaying(S),";
		}
		if( Settings.enableRangeLevel == true){
			list = list + "Ranging(R),";
		}
		if( Settings.enableFisticuffsLevel == true){
			list = list + "Fisticuffs(F),";
		}
		if( Settings.enableArcherLevel == true){
			list = list + "Archery(A),";
		}
		sender.sendMessage(list);
	}
	
	public static void shout(CommandSender sender,String string, Levelcraft plugin){
		if (sender instanceof Player) {
			Player player = (Player) sender;
			int level = 0;
			if ((string.equalsIgnoreCase("wc") ||string.equalsIgnoreCase("wood") || string.equalsIgnoreCase("woodcut") || string.equalsIgnoreCase("w")) && Settings.enableWCLevel==true) {
				level = Level.getLevel(sender, "w");
				plugin.getServer().broadcastMessage(ChatColor.GOLD + "[LC] " + ChatColor.BLUE + player.getName() + "'s" + ChatColor.GOLD + " woodcutting level is " + level + ".");
			} else if ((string.equalsIgnoreCase("mine") ||string.equalsIgnoreCase("m") || string.equalsIgnoreCase("mining")) && Settings.enableMineLevel==true) {
				level = Level.getLevel(sender, "m");
				plugin.getServer().broadcastMessage(ChatColor.GOLD + "[LC] " + ChatColor.BLUE + player.getName() + "'s" + ChatColor.GOLD + " mining level is " + level + ".");
			} else if ((string.equalsIgnoreCase("slay") ||string.equalsIgnoreCase("s") || string.equalsIgnoreCase("slaying")) && Settings.enableSlayerLevel==true) {
				level = Level.getLevel(sender, "s");
				plugin.getServer().broadcastMessage(ChatColor.GOLD + "[LC] " + ChatColor.BLUE + player.getName() + "'s" + ChatColor.GOLD + " slayer level is " + level + ".");
			} else if ((string.equalsIgnoreCase("range") ||string.equalsIgnoreCase("r") || string.equalsIgnoreCase("ranging")) && Settings.enableRangeLevel==true) {
				level = Level.getLevel(sender, "r");
				plugin.getServer().broadcastMessage(ChatColor.GOLD + "[LC] " + ChatColor.BLUE + player.getName() + "'s" + ChatColor.GOLD + " range level is " + level + ".");
			} else if ((string.equalsIgnoreCase("Fist") ||string.equalsIgnoreCase("F") || string.equalsIgnoreCase("Fisticuffs")) && Settings.enableFisticuffsLevel==true) {
				level = Level.getLevel(sender, "f");
				plugin.getServer().broadcastMessage(ChatColor.GOLD + "[LC] " + ChatColor.BLUE + player.getName() + "'s" + ChatColor.GOLD + " fisticuffs level is " + level + ".");
			} else if ((string.equalsIgnoreCase("archer") ||string.equalsIgnoreCase("a") || string.equalsIgnoreCase("archery")) && Settings.enableFisticuffsLevel==true) {
				level = Level.getLevel(sender, "a");
				plugin.getServer().broadcastMessage(ChatColor.GOLD + "[LC] " + ChatColor.BLUE + player.getName() + "'s" + ChatColor.GOLD + " archery level is " + level + ".");
			} else {
				sender.sendMessage(ChatColor.GOLD + "[LC]" +ChatColor.YELLOW+ " Stat not found.");
				sender.sendMessage(ChatColor.GOLD + "[LC]" +ChatColor.YELLOW+ " Please type '/level list' to show all stats.");
			}
		} else {
			sender.sendMessage("Error: Could not broadcast message!");
		}
	}
	public static void shoutMsg(String String){
	
	}
	public static void unlocks(CommandSender sender, String[] split) {
		if ((split[1].equalsIgnoreCase("wc") ||split[1].equalsIgnoreCase("wood") || split[1].equalsIgnoreCase("woodcut") || split[1].equalsIgnoreCase("w")) && Settings.enableWCLevel==true) {
			sender.sendMessage(ChatColor.GOLD + "[LC] ---LevelCraftPlugin By Samkio--- ");
			sender.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.GREEN + " WoodenAxe: "+ Settings.WCWoodAxe);
			sender.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.GREEN + " StoneAxe: "+ Settings.WCStoneAxe);
			sender.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.GREEN + " IronAxe: "+ Settings.WCIronAxe);
			sender.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.GREEN + " GoldAxe: "+ Settings.WCGoldAxe);
			sender.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.GREEN + " DiamondAxe: "+ Settings.WCDiamondAxe);
		} else if ((split[1].equalsIgnoreCase("mine") ||split[1].equalsIgnoreCase("m") || split[1].equalsIgnoreCase("mining")) && Settings.enableMineLevel==true) {
			sender.sendMessage(ChatColor.GOLD + "[LC] ---LevelCraftPlugin By Samkio--- ");
			sender.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.GREEN + " WoodenPick: "+ Settings.MIWoodPick);
			sender.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.GREEN + " StonePick: "+ Settings.MIStonePick);
			sender.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.GREEN + " IronPick: "+ Settings.MIIronPick);
			sender.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.GREEN + " GoldPick: "+ Settings.MIGoldPick);
			sender.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.GREEN + " DiamondPick: "+ Settings.MIDiamondPick);
		} else if ((split[1].equalsIgnoreCase("slay") ||split[1].equalsIgnoreCase("s") || split[1].equalsIgnoreCase("slaying")) && Settings.enableSlayerLevel==true) {
			sender.sendMessage(ChatColor.GOLD + "[LC] ---LevelCraftPlugin By Samkio--- ");
			sender.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.GREEN + " WoodenSword: "+ Settings.SlayWoodSword);
			sender.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.GREEN + " StoneSword: "+ Settings.SlayStoneSword);
			sender.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.GREEN + " IronSword: "+ Settings.SlayIronSword);
			sender.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.GREEN + " GoldSword: "+ Settings.SlayGoldSword);
			sender.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.GREEN + " DiamondSword: "+ Settings.SlayDiamondSword);
		} else if ((split[1].equalsIgnoreCase("range") ||split[1].equalsIgnoreCase("r") || split[1].equalsIgnoreCase("ranging")) && Settings.enableRangeLevel==true) {
			sender.sendMessage(ChatColor.GOLD + "[LC] ---LevelCraftPlugin By Samkio--- ");
			sender.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.GREEN + " 0.5 Damage per Arrow: "+ Settings.Rangep5);
			sender.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.GREEN + " 1.0 Damage per Arrow: "+ Settings.Range1p0);
			sender.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.GREEN + " 1.5 Damage per Arrow: "+ Settings.Range1p5);
			sender.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.GREEN + " 2.0 Damage per Arrow: "+ Settings.Range2p0);
			sender.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.GREEN + " 2.5 Damage per Arrow: "+ Settings.Range2p5);
			sender.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.GREEN + " 3.0 Damage per Arrow: "+ Settings.Range3p0);
		} else if ((split[1].equalsIgnoreCase("fist") ||split[1].equalsIgnoreCase("f") || split[1].equalsIgnoreCase("fisticuffs")) && Settings.enableFisticuffsLevel==true) {
			sender.sendMessage(ChatColor.GOLD + "[LC] ---LevelCraftPlugin By Samkio--- ");
			sender.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.GREEN + " WoodenSword: "+ Settings.FisticuffsWoodSword);
			sender.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.GREEN + " StoneSword: "+ Settings.FisticuffsStoneSword);
			sender.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.GREEN + " IronSword: "+ Settings.FisticuffsIronSword);
			sender.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.GREEN + " GoldSword: "+ Settings.FisticuffsGoldSword);
			sender.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.GREEN + " DiamondSword: "+ Settings.FisticuffsDiamondSword);
		} else if ((split[1].equalsIgnoreCase("archer") ||split[1].equalsIgnoreCase("a") || split[1].equalsIgnoreCase("archery")) && Settings.enableArcherLevel==true) {
			sender.sendMessage(ChatColor.GOLD + "[LC] ---LevelCraftPlugin By Samkio--- ");
			sender.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.GREEN + " 0.5 Damage per Arrow: "+ Settings.Archerp5);
			sender.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.GREEN + " 1.0 Damage per Arrow: "+ Settings.Archer1p0);
			sender.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.GREEN + " 1.5 Damage per Arrow: "+ Settings.Archer1p5);
			sender.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.GREEN + " 2.0 Damage per Arrow: "+ Settings.Archer2p0);
			sender.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.GREEN + " 2.5 Damage per Arrow: "+ Settings.Archer2p5);
			sender.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.GREEN + " 3.0 Damage per Arrow: "+ Settings.Archer3p0);
		} else {
			sender.sendMessage(ChatColor.GOLD + "[LC]" +ChatColor.YELLOW+ " Stat not found.");
			sender.sendMessage(ChatColor.GOLD + "[LC]" +ChatColor.YELLOW+ " Please type '/level list' to show all stats.");
		}
	}

}

