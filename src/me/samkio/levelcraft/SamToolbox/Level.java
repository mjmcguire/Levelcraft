package me.samkio.levelcraft.SamToolbox;

import me.samkio.levelcraft.Levelcraft;
import me.samkio.levelcraft.Settings;
import me.samkio.levelcraft.Functions.LevelFunctions;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Level {

	public static double getExp(CommandSender sender, String s) {
		if (Settings.database.equalsIgnoreCase("flatfile")) {
			if (s.equalsIgnoreCase("w")) {
				Double exp = LevelFunctions.getExp(sender, Levelcraft.WCExpFile);
				return exp;
			}
			if (s.equalsIgnoreCase("r")) {
				Double exp = LevelFunctions.getExp(sender, Levelcraft.RangeExpFile);
				return exp;
			}
			if (s.equalsIgnoreCase("s")) {
				Double exp = LevelFunctions.getExp(sender, Levelcraft.SlayExpFile);
				return exp;
			}
			if (s.equalsIgnoreCase("m")) {
				Double exp = LevelFunctions.getExp(sender, Levelcraft.MiExpFile);
				return exp;
			}
			if (s.equalsIgnoreCase("f")) {
				Double exp = LevelFunctions.getExp(sender, Levelcraft.FisticuffsExpFile);
				return exp;
			}
			if (s.equalsIgnoreCase("a")) {
				Double exp = LevelFunctions.getExp(sender, Levelcraft.ArcherExpFile);
				return exp;
			}
		}

		if (Settings.database.equalsIgnoreCase("mysql")) {
			if (s.equalsIgnoreCase("w")) {
				Double exp = DataMySql.getExp(sender, "WoodcuttingExp");
				return exp;
			}
			if (s.equalsIgnoreCase("r")) {
				Double exp = DataMySql.getExp(sender, "RangingExp");
				return exp;
			}
			if (s.equalsIgnoreCase("s")) {
				Double exp = DataMySql.getExp(sender, "SlayingExp");
				return exp;
			}
			if (s.equalsIgnoreCase("m")) {
				Double exp = DataMySql.getExp(sender, "MiningExp");
				return exp;
			}
			if (s.equalsIgnoreCase("f")) {
				Double exp = DataMySql.getExp(sender, "FisticuffsExp");
				return exp;
			}
			if (s.equalsIgnoreCase("a")) {
				Double exp = DataMySql.getExp(sender, "ArcheryExp");
				return exp;
			}
			return 0;
		}
		if (Settings.database.equalsIgnoreCase("sqlite")) {
			if (s.equalsIgnoreCase("w")) {
				Double exp = DataSqlite.getExp(sender, "WoodcuttingExp");
				return exp;
			}
			if (s.equalsIgnoreCase("r")) {
				Double exp = DataSqlite.getExp(sender, "RangingExp");
				return exp;
			}
			if (s.equalsIgnoreCase("s")) {
				Double exp = DataSqlite.getExp(sender, "SlayingExp");
				return exp;
			}
			if (s.equalsIgnoreCase("m")) {
				Double exp = DataSqlite.getExp(sender, "MiningExp");
				return exp;
			}
			if (s.equalsIgnoreCase("f")) {
				Double exp = DataSqlite.getExp(sender, "FisticuffsExp");
				return exp;
			}
			if (s.equalsIgnoreCase("a")) {
				Double exp = DataSqlite.getExp(sender, "ArcheryExp");
				return exp;
			}
		}
		return 0;
	}

	public static int getLevel(CommandSender sender, String s) {
		if (Settings.database.equalsIgnoreCase("flatfile")) {
			if (s.equalsIgnoreCase("w")) {
				int level = LevelFunctions.getLevel(sender, Levelcraft.WCExpFile);
				return level;
			}
			if (s.equalsIgnoreCase("r")) {
				int level = LevelFunctions.getLevel(sender, Levelcraft.RangeExpFile);
				return level;
			}
			if (s.equalsIgnoreCase("s")) {
				int level = LevelFunctions.getLevel(sender, Levelcraft.SlayExpFile);
				return level;
			}
			if (s.equalsIgnoreCase("m")) {
				int level = LevelFunctions.getLevel(sender, Levelcraft.MiExpFile);
				return level;
			}
			if (s.equalsIgnoreCase("f")) {
				int level = LevelFunctions.getLevel(sender, Levelcraft.FisticuffsExpFile);
				return level;
			}
			if (s.equalsIgnoreCase("a")) {
				int level = LevelFunctions.getLevel(sender, Levelcraft.ArcherExpFile);
				return level;
			}
		}

		if (Settings.database.equalsIgnoreCase("mysql")) {
			if (s.equalsIgnoreCase("w")) {
				int level = DataMySql.getLevel(sender, "WoodcuttingExp");
				return level;
			}
			if (s.equalsIgnoreCase("r")) {
				int level = DataMySql.getLevel(sender, "RangingExp");
				return level;
			}
			if (s.equalsIgnoreCase("s")) {
				int level = DataMySql.getLevel(sender, "SlayingExp");
				return level;
			}
			if (s.equalsIgnoreCase("m")) {
				int level = DataMySql.getLevel(sender, "MiningExp");
				return level;
			}
			if (s.equalsIgnoreCase("f")) {
				int level = DataMySql.getLevel(sender, "FisticuffsExp");
				return level;
			}
			if (s.equalsIgnoreCase("a")) {
				int level = DataMySql.getLevel(sender, "ArcheryExp");
				return level;
			}
			return 0;
		}
		if (Settings.database.equalsIgnoreCase("sqlite")) {
			if (s.equalsIgnoreCase("w")) {
				int level = DataSqlite.getLevel(sender, "WoodcuttingExp");
				return level;
			}
			if (s.equalsIgnoreCase("r")) {
				int level = DataSqlite.getLevel(sender, "RangingExp");
				return level;
			}
			if (s.equalsIgnoreCase("s")) {
				int level = DataSqlite.getLevel(sender, "SlayingExp");
				return level;
			}
			if (s.equalsIgnoreCase("m")) {
				int level = DataSqlite.getLevel(sender, "MiningExp");
				return level;
			}
			if (s.equalsIgnoreCase("f")) {
				int level = DataSqlite.getLevel(sender, "FisticuffsExp");
				return level;
			}
			if (s.equalsIgnoreCase("a")) {
				int level = DataSqlite.getLevel(sender, "ArcheryExp");
				return level;
			}
		}
		return 0;
	}

	public static double getExpLeft(CommandSender sender, String s) {
		if (Settings.database.equalsIgnoreCase("flatfile")) {
			if (s.equalsIgnoreCase("w")) {
				Double exp = LevelFunctions.getExpLeft(sender, Levelcraft.WCExpFile);
				return exp;
			}
			if (s.equalsIgnoreCase("r")) {
				Double exp = LevelFunctions.getExpLeft(sender, Levelcraft.RangeExpFile);
				return exp;
			}
			if (s.equalsIgnoreCase("s")) {
				Double exp = LevelFunctions.getExpLeft(sender, Levelcraft.SlayExpFile);
				return exp;
			}
			if (s.equalsIgnoreCase("m")) {
				Double exp = LevelFunctions.getExpLeft(sender, Levelcraft.MiExpFile);
				return exp;
			}
			if (s.equalsIgnoreCase("f")) {
				Double exp = LevelFunctions.getExpLeft(sender, Levelcraft.FisticuffsExpFile);
				return exp;
			}
			if (s.equalsIgnoreCase("a")) {
				Double exp = LevelFunctions.getExpLeft(sender, Levelcraft.ArcherExpFile);
				return exp;
			}
		}
		if (Settings.database.equalsIgnoreCase("mysql")) {
			if (s.equalsIgnoreCase("w")) {
				Double exp = DataMySql.getExpLeft(sender, "WoodcuttingExp");
				return exp;
			}
			if (s.equalsIgnoreCase("r")) {
				Double exp = DataMySql.getExpLeft(sender, "RangingExp");
				return exp;
			}
			if (s.equalsIgnoreCase("s")) {
				Double exp = DataMySql.getExpLeft(sender, "SlayingExp");
				return exp;
			}
			if (s.equalsIgnoreCase("m")) {
				Double exp = DataMySql.getExpLeft(sender, "MiningExp");
				return exp;
			}
			if (s.equalsIgnoreCase("f")) {
				Double exp = DataMySql.getExpLeft(sender, "FisticuffsExp");
				return exp;
			}
			if (s.equalsIgnoreCase("a")) {
				Double exp = DataMySql.getExpLeft(sender, "ArcheryExp");
				return exp;
			}
			return 0;
		}
		if (Settings.database.equalsIgnoreCase("sqlite")) {
			if (s.equalsIgnoreCase("w")) {
				Double exp = DataSqlite.getExpLeft(sender, "WoodcuttingExp");
				return exp;
			}
			if (s.equalsIgnoreCase("r")) {
				Double exp = DataSqlite.getExpLeft(sender, "RangingExp");
				return exp;
			}
			if (s.equalsIgnoreCase("s")) {
				Double exp = DataSqlite.getExpLeft(sender, "SlayingExp");
				return exp;
			}
			if (s.equalsIgnoreCase("m")) {
				Double exp = DataSqlite.getExpLeft(sender, "MiningExp");
				return exp;
			}
			if (s.equalsIgnoreCase("f")) {
				Double exp = DataSqlite.getExpLeft(sender, "FisticuffsExp");
				return exp;
			}
			if (s.equalsIgnoreCase("a")) {
				Double exp = DataSqlite.getExpLeft(sender, "ArcheryExp");
				return exp;
			}
		}
		return 0;
	}
	public static boolean update(CommandSender sender, String s, Double exp) {
		if (Settings.database.equalsIgnoreCase("flatfile")) {
			if (s.equalsIgnoreCase("w")) {
				LevelFunctions.write(sender, exp, Levelcraft.WCExpFile);
				return true;
			}
			if (s.equalsIgnoreCase("r")) {
				LevelFunctions.write(sender, exp, Levelcraft.RangeExpFile);
				return true;
			}
			if (s.equalsIgnoreCase("s")) {
				LevelFunctions.write(sender, exp, Levelcraft.SlayExpFile);
				return true;
			}
			if (s.equalsIgnoreCase("m")) {
				LevelFunctions.write(sender, exp, Levelcraft.MiExpFile);
				return true;
			}
			if (s.equalsIgnoreCase("f")) {
				LevelFunctions.write(sender, exp, Levelcraft.FisticuffsExpFile);
				return true;
			}
			if (s.equalsIgnoreCase("a")) {
				LevelFunctions.write(sender, exp, Levelcraft.ArcherExpFile);
				return true;
			}
		}
		if (Settings.database.equalsIgnoreCase("mysql")) {
			if (s.equalsIgnoreCase("w")) {
				DataMySql.update(sender, "WoodcuttingExp", exp);
				return true;
			}
			if (s.equalsIgnoreCase("r")) {
				DataMySql.update(sender, "RangingExp", exp);
				return true;
			}
			if (s.equalsIgnoreCase("s")) {
				DataMySql.update(sender, "SlayingExp", exp);
				return true;
			}
			if (s.equalsIgnoreCase("m")) {
				DataMySql.update(sender, "MiningExp", exp);
				return true;
			}
			if (s.equalsIgnoreCase("f")) {
				DataMySql.update(sender, "FisticuffsExp", exp);
				return true;
			}
			if (s.equalsIgnoreCase("a")) {
				DataMySql.update(sender, "ArcheryExp", exp);
				return true;
			}
			return false;
		}
		if (Settings.database.equalsIgnoreCase("sqlite")) {
			if (s.equalsIgnoreCase("w")) {
				DataSqlite.update(sender, "MiningExp", exp);
				return true;
			}
			if (s.equalsIgnoreCase("r")) {
				DataSqlite.update(sender, "RangingExp", exp);
				return true;
			}
			if (s.equalsIgnoreCase("s")) {
				DataSqlite.update(sender, "SlayingExp", exp);
				return true;
			}
			if (s.equalsIgnoreCase("m")) {
				DataSqlite.update(sender, "MiningExp", exp);
				return true;
			}
			if (s.equalsIgnoreCase("f")) {
				DataSqlite.update(sender, "FisticuffsExp", exp);
				return true;
			}
			if (s.equalsIgnoreCase("a")) {
				DataSqlite.update(sender, "ArcheryExp", exp);
				return true;
			}
		}
		return false;
	}
}