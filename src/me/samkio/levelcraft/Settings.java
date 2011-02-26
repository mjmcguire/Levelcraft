package me.samkio.levelcraft;

import java.io.IOException;

import me.samkio.levelcraft.SamToolbox.PropertyFunctions;


public class Settings {
	public static boolean enableWCLevel;
	public static boolean enableMineLevel;
	public static boolean enableRangeLevel;
	public static boolean enableSlayerLevel;
	public static int WCWoodAxe;
	public static int WCStoneAxe;
	public static int WCIronAxe;
	public static int WCGoldAxe;
	public static int WCDiamondAxe;

	public static int SlayWoodSword;
	public static int SlayStoneSword;
	public static int SlayIronSword;
	public static int SlayGoldSword;
	public static int SlayDiamondSword;

	public static int MIWoodPick;
	public static int MIStonePick;
	public static int MIIronPick;
	public static int MIGoldPick;
	public static int MIDiamondPick;

	public static double ExpPerLog;
	public static double ExpPerPlank;
	public static int LogLevel;
	public static int PlankLevel;

	public static double ExpPerStone;
	public static double ExpPerCobble;
	public static double ExpPerRedstone;
	public static double ExpPerGoldOre;
	public static double ExpPerIronOre;
	public static double ExpPerCoalOre;
	public static double ExpPerLapisOre;
	public static double ExpPerMossstone;
	public static double ExpPerObsidian;
	public static double ExpPerDiamondOre;
	public static double ExpPerNetherrack;

	public static double ExpPerDamage;

	public static int StoneLevel;
	public static int CobbleLevel;
	public static int IronLevel;
	public static int RedLevel;
	public static int GoldLevel;
	public static int CoalLevel;
	public static int LapisLevel;
	public static int MossLevel;
	public static int ObsidianLevel;
	public static int DiamondLevel;
	public static int NetherLevel;
	public static String rawAdmins;
	public static String rawAvoid;
	public static String[] LCAdmins;
	public static String[] LCAvoiders;

	public static int Constant;
	public static String database;
	public static String MySqlDir;
	public static String MySqlUser;
	public static String MySqlPass;
	public static void loadMain() {
		
		String propertiesFile = Levelcraft.maindirectory
				+ Levelcraft.configdirectory + "MainConfig.properties";
		PropertyFunctions properties = new PropertyFunctions(propertiesFile);
		try {
			properties.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		enableWCLevel = properties.getBoolean("Enable-Woodcuting-Level", true);
		enableMineLevel = properties.getBoolean("Enable-Mining-Level", true);
		enableSlayerLevel = properties.getBoolean("Enable-Slayer-Level", true);
		enableRangeLevel = properties.getBoolean("Enable-Range-Level", true);
		Constant = properties.getInteger("Level-Constant", 20);
		database = properties.getString("Database", "flatfile");
		MySqlDir = properties.getString("MySqlDatabaseDirectory", "localhost:3306/LC");
		MySqlUser = properties.getString("MySqlDatabaseUsername", "root");
		MySqlPass = properties.getString("MySqlDatabasePassword", "");
		properties.save();

	}

	public static void loadWhitelist() {
		String propertiesFile = Levelcraft.maindirectory
				+ Levelcraft.configdirectory + "Whitelist.properties";
		PropertyFunctions properties = new PropertyFunctions(propertiesFile);
		try {
			properties.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		rawAdmins = properties.getString("Admins", "Name1,Name2");
		rawAvoid = properties.getString("Whitelist", "Name1,Name2");
		if (rawAdmins != null) {
			LCAdmins = rawAdmins.split(",");

		}
		if (rawAvoid != null) {
			LCAvoiders = rawAvoid.split(",");

		}
		properties.save();

	}

	public static void loadWoodcut() {
		String propertiesFile = Levelcraft.maindirectory
				+ Levelcraft.configdirectory + "WoodCuttingConfig.properties";
		PropertyFunctions properties = new PropertyFunctions(propertiesFile);
		try {
			properties.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WCWoodAxe = properties.getInteger("Wooden-Axe-Level", 0);
		WCStoneAxe = properties.getInteger("Stone-Axe-Level", 5);
		WCIronAxe = properties.getInteger("Iron-Axe-Level", 10);
		WCGoldAxe = properties.getInteger("Gold-Axe-Level", 20);
		WCDiamondAxe = properties.getInteger("Diamond-Axe-Level", 30);
		ExpPerLog = properties.getDouble("Experience-Per-Log", 5);
		ExpPerPlank = properties.getDouble("Experience-Per-Plank", 2);
		LogLevel = properties.getInteger("Level-for-Log", 0);
		PlankLevel = properties.getInteger("Level-for-Plank", 0);

		properties.save();
	}

	public static void loadSlayer() {
		String propertiesFile = Levelcraft.maindirectory
				+ Levelcraft.configdirectory + "SlayerConfig.properties";
		PropertyFunctions properties = new PropertyFunctions(propertiesFile);
		try {
			properties.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		SlayWoodSword = properties.getInteger("Wooden-Sword-Level", 0);
		SlayStoneSword = properties.getInteger("Stone-Sword-Level", 5);
		SlayIronSword = properties.getInteger("Iron-Sword-Level", 10);
		SlayGoldSword = properties.getInteger("Gold-Sword-Level", 20);
		SlayDiamondSword = properties.getInteger("Diamond-Sword-Level", 30);
		ExpPerDamage = properties.getDouble("Experience-per-1-damage", 2);

		properties.save();
	}

	public static void loadMine() {
		String propertiesFile = Levelcraft.maindirectory
				+ Levelcraft.configdirectory + "MiningConfig.properties";
		PropertyFunctions properties = new PropertyFunctions(propertiesFile);
		try {
			properties.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		MIWoodPick = properties.getInteger("Wooden-Pick-Level", 0);
		MIStonePick = properties.getInteger("Stone-Pick-Level", 5);
		MIIronPick = properties.getInteger("Iron-Pick-Level", 10);
		MIGoldPick = properties.getInteger("Gold-Pick-Level", 20);
		MIDiamondPick = properties.getInteger("Diamond-Pick-Level", 30);

		ExpPerStone = properties.getDouble("Experience-Per-Stone", 5);
		ExpPerCobble = properties.getDouble("Experience-Per-Cobble", 2);
		ExpPerRedstone = properties.getDouble("Experience-Per-Redstone", 20);
		ExpPerGoldOre = properties.getDouble("Experience-Per-GoldOre", 30);
		ExpPerIronOre = properties.getDouble("Experience-Per-IronOre", 20);
		ExpPerCoalOre = properties.getDouble("Experience-Per-CoalOre", 10);
		ExpPerLapisOre = properties.getDouble("Experience-Per-LapisOre", 100);
		ExpPerMossstone = properties.getDouble("Experience-Per-MossStone", 10);
		ExpPerObsidian = properties.getDouble("Experience-Per-Obsidian", 200);
		ExpPerDiamondOre = properties.getDouble("Experience-Per-DiamondOre",100);
		ExpPerNetherrack = properties.getInteger("Experience-Per-Netherrack", 3);
		StoneLevel = properties.getInteger("Level-for-Stone", 0);
		CobbleLevel = properties.getInteger("Level-for-Cobble", 0);
		RedLevel = properties.getInteger("Level-for-Redstone", 10);
		GoldLevel = properties.getInteger("Level-for-GoldOre", 20);
		IronLevel = properties.getInteger("Level-for-IronOre", 5);
		CoalLevel = properties.getInteger("Level-for-CoalOre", 5);
		LapisLevel = properties.getInteger("Level-for-LapisOre", 20);
		MossLevel = properties.getInteger("Level-for-MossStone", 10);
		ObsidianLevel = properties.getInteger("Level-for-Obsidian", 35);
		DiamondLevel = properties.getInteger("Level-for-Diamond", 25);
		NetherLevel = properties.getInteger("Level-for-Nether", 0);

		properties.save();
	}
}
