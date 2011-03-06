package me.samkio.levelcraft.Functions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Properties;

import me.samkio.levelcraft.Settings;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class LevelFunctions {
	public static void write(CommandSender sender, double levelstat, File file) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			Properties pro = new Properties();
			String startingvalue = (new Double(levelstat)).toString();
			String player = p.getName();
			try {
				FileInputStream in = new FileInputStream(file);
				pro.load(in);
				pro.setProperty(player, startingvalue);
				pro.store(new FileOutputStream(file), null);
				in.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		} else {
			sender.sendMessage("Error: could not write to file!");
		}
	}
	
	public static double roundTwoDecimals(double d) {
		DecimalFormat twoDForm = new DecimalFormat("#.##");
		return Double.valueOf(twoDForm.format(d));
	}
	
	public static double getExp(CommandSender sender, File file) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			String player = p.getName();
			Properties pro = new Properties();
			try {
				FileInputStream in = new FileInputStream(file);
				pro.load(in);
				String string = pro.getProperty(player);
				double experience = Double.parseDouble(string);
				in.close();
				double exp = roundTwoDecimals(experience);
				return exp;
			}
			catch (IOException e) {
				System.out.println(e.getMessage());
			}
			return 0;
		} else {
			sender.sendMessage("Error: Could not retrieve exp value!");
		return 0;
		}
	}

	public static boolean containskey(CommandSender sender, File file) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			Properties pro = new Properties();
			String player = p.getName();
			try {
				FileInputStream in = new FileInputStream(file);
				pro.load(in);				
				if (pro.containsKey(player))
					return true;
			}
			catch (IOException e)
			{
				System.out.println(e.getMessage());
			}
			return false;
		} else {
			return false;
		}
	}
	
	public static int getLevel(CommandSender sender,File file) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			int level = 0;
			double constant = Settings.Constant;
			constant = constant/100;
			for(int i=1;i<=1000;i++){
				double levelAti = (100*(i*(i*constant)));
				if(levelAti >= getExp(p,file)){
					level = i;
					break;
				}
			}
			return level;
		} else {
			sender.sendMessage("Error: Could not retrieve level value!");
			return 0;
		}
	}
	
	public static double getExpLeft(CommandSender sender, File file) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			double exp = getExp(p,file);
			double getExpUp = 0;
			double constant = Settings.Constant;
			constant = constant/100;
			for(int i=1;i<=1000;i++){
				double levelAti = (100*(i*(i*constant)));
				if(levelAti >= exp){
					getExpUp = levelAti;
					break;
				}
			}
			double leftExp = (getExpUp - exp);
			double leftExp2 = roundTwoDecimals(leftExp);
			return leftExp2;
		} else {
			sender.sendMessage("Error: Could not retrieve experience value!");
			return 0;
		}
	}
}
