package me.samkio.levelcraft.Functions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Properties;

import me.samkio.levelcraft.SamToolbox.DataSqlite;

import org.bukkit.entity.Player;

import samkio.levelcraft.Settings;


public class LevelFunctions {
	
	public static void write(Player p, double levelstat, File file) {
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
	}
	public static double roundTwoDecimals(double d) {
    	DecimalFormat twoDForm = new DecimalFormat("#.##");
	return Double.valueOf(twoDForm.format(d));
}
	public static double getExp(Player p, File file) {
		String player = p.getName();
		if (Settings.database.equalsIgnoreCase("flatfile")) {
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
			}
		else if (Settings.database.equalsIgnoreCase("sqlite")){
			double exp = DataSqlite.getLevel(p, "WoodcuttingExp");
		}
		else if (Settings.database.equalsIgnoreCase("mysql")){
			
		}
		return 0;
	}
	public static boolean containskey(Player p, File file) {
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
	  }
	public static int getLevel(Player p,File file){
		int level = 0;
		double constant = Settings.Constant;
		constant = constant/100;
		  for(int i=1;i<=1000;i++){
			  double levelAti =  (100*(i*(i*constant)));
			 if(levelAti >= getExp(p,file)){
				 level = i;
				 break;
			 }
		  }
		return level;
	}

	public static double getExpLeft(Player player, File file) {
		double exp = getExp(player,file);
		double getExpUp = 0;
		double constant = Settings.Constant;
		constant = constant/100;
		for(int i=1;i<=1000;i++){
			double levelAti =  (100*(i*(i*constant)));
			 if(levelAti >= exp){
				 getExpUp = levelAti;
				 break;
			 }
		  }
		double leftExp = (getExpUp - exp);
		double leftExp2 = roundTwoDecimals(leftExp);
		return leftExp2;
	}

	
}
