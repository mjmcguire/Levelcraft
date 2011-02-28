package me.samkio.levelcraft;

import me.samkio.levelcraft.Functions.LevelFunctions;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;


public class Help {
	public static Levelcraft plugin;
	public static void IncorrectExp(Player player) {
		player.sendMessage(ChatColor.GOLD + "[LC]" +ChatColor.YELLOW+ " Stat not found.");
		player.sendMessage(ChatColor.GOLD + "[LC]" +ChatColor.YELLOW+ " Please type '/level list' to show all stats.");
	}

	public static void ListLevels(Player player) {
		String list = ChatColor.GOLD + "[LC]" +ChatColor.YELLOW+ " Stats:";
		if(      Settings.enableWCLevel == true){
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
      player.sendMessage(list);

	}
	
public static void shout(Player player,String string){
	int level = 0;
	double exp = 0;
	if ((string.equalsIgnoreCase("wc") ||string.equalsIgnoreCase("wood") || string.equalsIgnoreCase("woodcut") || string.equalsIgnoreCase("w"))  && Settings.enableWCLevel==true)   {
		level = LevelFunctions.getLevel(player, Levelcraft.WCExpFile);
		 plugin.getServer().broadcastMessage(ChatColor.GOLD + "[AC]" + ChatColor.WHITE+ "You have been taxed.");
	}else if ((string.equalsIgnoreCase("mine") ||string.equalsIgnoreCase("m") || string.equalsIgnoreCase("mining")) && Settings.enableMineLevel==true)   {
		level = LevelFunctions.getLevel(player, Levelcraft.MiExpFile);
		plugin.getServer().broadcastMessage(ChatColor.GOLD + "[AC]" + ChatColor.WHITE+ "You have been taxed.");
	}else if ((string.equalsIgnoreCase("slay") ||string.equalsIgnoreCase("s") || string.equalsIgnoreCase("slaying")) && Settings.enableSlayerLevel==true)   {
		level = LevelFunctions.getLevel(player, Levelcraft.SlayExpFile);
		plugin.getServer().broadcastMessage(ChatColor.GOLD + "[AC]" + ChatColor.WHITE+ "You have been taxed.");
	}else if ((string.equalsIgnoreCase("range") ||string.equalsIgnoreCase("r") || string.equalsIgnoreCase("ranging")) && Settings.enableRangeLevel==true)   {
		level = LevelFunctions.getLevel(player, Levelcraft.RangeExpFile);
		plugin.getServer().broadcastMessage(ChatColor.GOLD + "[AC]" + ChatColor.WHITE+ "You have been taxed.");
	}else if ((string.equalsIgnoreCase("Fist") ||string.equalsIgnoreCase("F") || string.equalsIgnoreCase("Fisticuffs")) && Settings.enableFisticuffsLevel==true)   {
		level = LevelFunctions.getLevel(player, Levelcraft.FisticuffsExpFile);
		plugin.getServer().broadcastMessage(ChatColor.GOLD + "[AC]" + ChatColor.WHITE+ "You have been taxed.");
	}
	else{
		player.sendMessage(ChatColor.GOLD + "[LC]" +ChatColor.YELLOW+ " Stat not found.");
		player.sendMessage(ChatColor.GOLD + "[LC]" +ChatColor.YELLOW+ " Please type '/level list' to show all stats.");
	}
}
	public static void unlocks(Player player, String[] split) {
		if ((split[2].equalsIgnoreCase("wc") ||split[2].equalsIgnoreCase("wood") || split[2].equalsIgnoreCase("woodcut") || split[2].equalsIgnoreCase("w"))  && Settings.enableWCLevel==true)   {
			player.sendMessage(ChatColor.GOLD + "[LC] ---LevelCraftPlugin By Samkio--- ");
			player.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.GREEN + " WoodenAxe: "+ Settings.WCWoodAxe);
			player.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.GREEN + " StoneAxe: "+ Settings.WCStoneAxe);
			player.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.GREEN + " IronAxe: "+ Settings.WCIronAxe);
			player.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.GREEN + " GoldAxe: "+ Settings.WCGoldAxe);
			player.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.GREEN + " DiamondAxe: "+ Settings.WCDiamondAxe);
			
		}else if ((split[2].equalsIgnoreCase("mine") ||split[2].equalsIgnoreCase("m") || split[2].equalsIgnoreCase("mining")) && Settings.enableMineLevel==true)   {
			player.sendMessage(ChatColor.GOLD + "[LC] ---LevelCraftPlugin By Samkio--- ");
			player.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.GREEN + " WoodenPick: "+ Settings.MIWoodPick);
			player.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.GREEN + " StonePick: "+ Settings.MIStonePick);
			player.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.GREEN + " IronPick: "+ Settings.MIIronPick);
			player.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.GREEN + " GoldPick: "+ Settings.MIGoldPick);
			player.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.GREEN + " DiamondPick: "+ Settings.MIDiamondPick);
		}else if ((split[2].equalsIgnoreCase("slay") ||split[2].equalsIgnoreCase("s") || split[2].equalsIgnoreCase("slaying")) && Settings.enableSlayerLevel==true)   {
			player.sendMessage(ChatColor.GOLD + "[LC] ---LevelCraftPlugin By Samkio--- ");
			player.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.GREEN + " WoodenSword: "+ Settings.SlayWoodSword);
			player.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.GREEN + " StoneSword: "+ Settings.SlayStoneSword);
			player.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.GREEN + " IronSword: "+ Settings.SlayIronSword);
			player.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.GREEN + " GoldSword: "+ Settings.SlayGoldSword);
			player.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.GREEN + " DiamondSword: "+ Settings.SlayDiamondSword);
		}else if ((split[2].equalsIgnoreCase("range") ||split[2].equalsIgnoreCase("r") || split[2].equalsIgnoreCase("ranging")) && Settings.enableSlayerLevel==true)   {
			player.sendMessage(ChatColor.GOLD + "[LC] ---LevelCraftPlugin By Samkio--- ");
			player.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.GREEN + " 0.5 Damage per Arrow: "+ Settings.Rangep5);
			player.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.GREEN + " 1.0 Damage per Arrow: "+ Settings.Range1p0);
			player.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.GREEN + " 1.5 Damage per Arrow: "+ Settings.Range1p5);
			player.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.GREEN + " 2.0 Damage per Arrow: "+ Settings.Range2p0);
			player.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.GREEN + " 2.5 Damage per Arrow: "+ Settings.Range2p5);
			player.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.GREEN + " 3.0 Damage per Arrow: "+ Settings.Range3p0);
		}else if ((split[2].equalsIgnoreCase("fist") ||split[2].equalsIgnoreCase("f") || split[2].equalsIgnoreCase("fisticuffs")) && Settings.enableSlayerLevel==true)   {
			player.sendMessage(ChatColor.GOLD + "[LC] ---LevelCraftPlugin By Samkio--- ");
			player.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.GREEN + " WoodenSword: "+ Settings.FisticuffsWoodSword);
			player.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.GREEN + " StoneSword: "+ Settings.FisticuffsStoneSword);
			player.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.GREEN + " IronSword: "+ Settings.FisticuffsIronSword);
			player.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.GREEN + " GoldSword: "+ Settings.FisticuffsGoldSword);
			player.sendMessage(ChatColor.GOLD + "[LC]" + ChatColor.GREEN + " DiamondSword: "+ Settings.FisticuffsDiamondSword);
		}else{
			player.sendMessage(ChatColor.GOLD + "[LC]" +ChatColor.YELLOW+ " Stat not found.");
			player.sendMessage(ChatColor.GOLD + "[LC]" +ChatColor.YELLOW+ " Please type '/level list' to show all stats.");
		}
	}

}
