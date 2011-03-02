package me.samkio.levelcraft.SamToolbox;

import me.samkio.levelcraft.Levelcraft;
import me.samkio.levelcraft.Settings;
import me.samkio.levelcraft.Functions.LevelFunctions;

import org.bukkit.entity.Player;

public class Level {

	public static double getExp(Player p, String s) {

		if (Settings.database.equalsIgnoreCase("flatfile")) {
			if (s.equalsIgnoreCase("w")) {
				Double exp = LevelFunctions.getExp(p,
						Levelcraft.FisticuffsExpFile);
				return exp;
			}
			if (s.equalsIgnoreCase("r")) {
				Double exp = LevelFunctions.getExp(p, Levelcraft.RangeExpFile);
				return exp;
			}
			if (s.equalsIgnoreCase("s")) {
				Double exp = LevelFunctions.getExp(p, Levelcraft.SlayExpFile);
				return exp;
			}
			if (s.equalsIgnoreCase("m")) {
				Double exp = LevelFunctions.getExp(p, Levelcraft.MiExpFile);
				return exp;
			}
			if (s.equalsIgnoreCase("f")) {
				Double exp = LevelFunctions.getExp(p,
						Levelcraft.FisticuffsExpFile);
				return exp;
			}
			if (s.equalsIgnoreCase("a")) {
				Double exp = LevelFunctions.getExp(p,
						Levelcraft.ArcherExpFile);
				return exp;
			}
		}

		if (Settings.database.equalsIgnoreCase("mysql")) {
			if (s.equalsIgnoreCase("w")) {
				Double exp = DataMySql.getExp(p, "WoodcuttingExp");
				return exp;
			}
			if (s.equalsIgnoreCase("r")) {
				Double exp = DataMySql.getExp(p, "RangingExp");
				return exp;
			}
			if (s.equalsIgnoreCase("s")) {
				Double exp = DataMySql.getExp(p, "SlayingExp");
				return exp;
			}
			if (s.equalsIgnoreCase("m")) {
				Double exp = DataMySql.getExp(p, "MiningExp");
				return exp;
			}
			if (s.equalsIgnoreCase("f")) {
				Double exp = DataMySql.getExp(p, "FisticuffsExp");
				return exp;
			}
			if (s.equalsIgnoreCase("a")) {
				Double exp = DataMySql.getExp(p, "ArcheryExp");
				return exp;
			}
			return 0;
		}
		if (Settings.database.equalsIgnoreCase("sqlite")) {
			if (s.equalsIgnoreCase("w")) {
				Double exp = DataSqlite.getExp(p, "WoodcuttingExp");
				return exp;
			}
			if (s.equalsIgnoreCase("r")) {
				Double exp = DataSqlite.getExp(p, "RangingExp");
				return exp;
			}
			if (s.equalsIgnoreCase("s")) {
				Double exp = DataSqlite.getExp(p, "SlayingExp");
				return exp;
			}
			if (s.equalsIgnoreCase("m")) {
				Double exp = DataSqlite.getExp(p, "MiningExp");
				return exp;
			}
			if (s.equalsIgnoreCase("f")) {
				Double exp = DataSqlite.getExp(p, "FisticuffsExp");
				return exp;
			}
			if (s.equalsIgnoreCase("a")) {
				Double exp = DataSqlite.getExp(p, "ArcheryExp");
				return exp;
			}
		}
		return 0;
	}

	public static int getLevel(Player p, String s) {
		if (Settings.database.equalsIgnoreCase("flatfile")) {
			if (s.equalsIgnoreCase("w")) {
				int level = LevelFunctions.getLevel(p,
						Levelcraft.FisticuffsExpFile);
				return level;
			}
			if (s.equalsIgnoreCase("r")) {
				int level = LevelFunctions.getLevel(p, Levelcraft.RangeExpFile);
				return level;
			}
			if (s.equalsIgnoreCase("s")) {
				int level = LevelFunctions.getLevel(p, Levelcraft.SlayExpFile);
				return level;
			}
			if (s.equalsIgnoreCase("m")) {
				int level = LevelFunctions.getLevel(p, Levelcraft.MiExpFile);
				return level;
			}
			if (s.equalsIgnoreCase("f")) {
				int level = LevelFunctions.getLevel(p,
						Levelcraft.FisticuffsExpFile);
				return level;
			}
			if (s.equalsIgnoreCase("a")) {
				int level = LevelFunctions.getLevel(p,
						Levelcraft.ArcherExpFile);
				return level;
			}
		}

		if (Settings.database.equalsIgnoreCase("mysql")) {
			if (s.equalsIgnoreCase("w")) {
				int level = DataMySql.getLevel(p, "WoodcuttingExp");
				return level;
			}
			if (s.equalsIgnoreCase("r")) {
				int level = DataMySql.getLevel(p, "RangingExp");
				return level;
			}
			if (s.equalsIgnoreCase("s")) {
				int level = DataMySql.getLevel(p, "SlayingExp");
				return level;
			}
			if (s.equalsIgnoreCase("m")) {
				int level = DataMySql.getLevel(p, "MiningExp");
				return level;
			}
			if (s.equalsIgnoreCase("f")) {
				int level = DataMySql.getLevel(p, "FisticuffsExp");
				return level;
			}
			if (s.equalsIgnoreCase("a")) {
				int level = DataMySql.getLevel(p, "ArcheryExp");
				return level;
			}
			return 0;
		}
		if (Settings.database.equalsIgnoreCase("sqlite")) {
			if (s.equalsIgnoreCase("w")) {
				int level = DataSqlite.getLevel(p, "WoodcuttingExp");
				return level;
			}
			if (s.equalsIgnoreCase("r")) {
				int level = DataSqlite.getLevel(p, "RangingExp");
				return level;
			}
			if (s.equalsIgnoreCase("s")) {
				int level = DataSqlite.getLevel(p, "SlayingExp");
				return level;
			}
			if (s.equalsIgnoreCase("m")) {
				int level = DataSqlite.getLevel(p, "MiningExp");
				return level;
			}
			if (s.equalsIgnoreCase("f")) {
				int level = DataSqlite.getLevel(p, "FisticuffsExp");
				return level;
			}
			if (s.equalsIgnoreCase("a")) {
				int level = DataSqlite.getLevel(p, "ArcheryExp");
				return level;
			}
		}
		return 0;

	}

	public static double getExpLeft(Player p, String s) {
		if (Settings.database.equalsIgnoreCase("flatfile")) {
			if (s.equalsIgnoreCase("w")) {
				Double exp = LevelFunctions.getExpLeft(p,
						Levelcraft.FisticuffsExpFile);
				return exp;
			}
			if (s.equalsIgnoreCase("r")) {
				Double exp = LevelFunctions.getExpLeft(p, Levelcraft.RangeExpFile);
				return exp;
			}
			if (s.equalsIgnoreCase("s")) {
				Double exp = LevelFunctions.getExpLeft(p, Levelcraft.SlayExpFile);
				return exp;
			}
			if (s.equalsIgnoreCase("m")) {
				Double exp = LevelFunctions.getExpLeft(p, Levelcraft.MiExpFile);
				return exp;
			}
			if (s.equalsIgnoreCase("f")) {
				Double exp = LevelFunctions.getExpLeft(p,
						Levelcraft.FisticuffsExpFile);
				return exp;
			}
			if (s.equalsIgnoreCase("a")) {
				Double exp = LevelFunctions.getExpLeft(p,
						Levelcraft.ArcherExpFile);
				return exp;
			}
		}

		if (Settings.database.equalsIgnoreCase("mysql")) {
			if (s.equalsIgnoreCase("w")) {
				Double exp = DataMySql.getExpLeft(p, "WoodcuttingExp");
				return exp;
			}
			if (s.equalsIgnoreCase("r")) {
				Double exp = DataMySql.getExpLeft(p, "RangingExp");
				return exp;
			}
			if (s.equalsIgnoreCase("s")) {
				Double exp = DataMySql.getExpLeft(p, "SlayingExp");
				return exp;
			}
			if (s.equalsIgnoreCase("m")) {
				Double exp = DataMySql.getExpLeft(p, "MiningExp");
				return exp;
			}
			if (s.equalsIgnoreCase("f")) {
				Double exp = DataMySql.getExpLeft(p, "FisticuffsExp");
				return exp;
			}
			if (s.equalsIgnoreCase("a")) {
				Double exp = DataMySql.getExpLeft(p, "ArcheryExp");
				return exp;
			}
			return 0;
		}
		if (Settings.database.equalsIgnoreCase("sqlite")) {
			if (s.equalsIgnoreCase("w")) {
				Double exp = DataSqlite.getExpLeft(p, "WoodcuttingExp");
				return exp;
			}
			if (s.equalsIgnoreCase("r")) {
				Double exp = DataSqlite.getExpLeft(p, "RangingExp");
				return exp;
			}
			if (s.equalsIgnoreCase("s")) {
				Double exp = DataSqlite.getExpLeft(p, "SlayingExp");
				return exp;
			}
			if (s.equalsIgnoreCase("m")) {
				Double exp = DataSqlite.getExpLeft(p, "MiningExp");
				return exp;
			}
			if (s.equalsIgnoreCase("f")) {
				Double exp = DataSqlite.getExpLeft(p, "FisticuffsExp");
				return exp;
			}
			if (s.equalsIgnoreCase("a")) {
				Double exp = DataSqlite.getExpLeft(p, "ArcheryExp");
				return exp;
			}		}
		return 0;
	}
	public static boolean update(Player p, String s, Double exp) {
		if (Settings.database.equalsIgnoreCase("flatfile")) {
			if (s.equalsIgnoreCase("w")) {
				LevelFunctions.write(p, exp, Levelcraft.WCExpFile);
				return true;
			}
			if (s.equalsIgnoreCase("r")) {
				LevelFunctions.write(p, exp, Levelcraft.RangeExpFile);
				return true;
			}
			if (s.equalsIgnoreCase("s")) {
				LevelFunctions.write(p, exp, Levelcraft.SlayExpFile);
				return true;
			}
			if (s.equalsIgnoreCase("m")) {
				LevelFunctions.write(p, exp, Levelcraft.MiExpFile);
				return true;
			}
			if (s.equalsIgnoreCase("f")) {
				LevelFunctions.write(p, exp, Levelcraft.FisticuffsExpFile);
				return true;
			}
			if (s.equalsIgnoreCase("a")) {
				LevelFunctions.write(p, exp, Levelcraft.ArcherExpFile);
				return true;
			}
		}

		if (Settings.database.equalsIgnoreCase("mysql")) {
			if (s.equalsIgnoreCase("w")) {
				DataMySql.update(p, "WoodcuttingExp", exp);
				return true;
			}
			if (s.equalsIgnoreCase("r")) {
				DataMySql.update(p, "RangingExp", exp);
				return true;
			}
			if (s.equalsIgnoreCase("s")) {
				DataMySql.update(p, "SlayingExp", exp);
				return true;
			}
			if (s.equalsIgnoreCase("m")) {
				DataMySql.update(p, "MiningExp", exp);
				return true;
			}
			if (s.equalsIgnoreCase("f")) {
				DataMySql.update(p, "FisticuffsExp", exp);
				return true;
			}
			if (s.equalsIgnoreCase("a")) {
				DataMySql.update(p, "ArcheryExp", exp);
				return true;
			}
			return false;
		}
		if (Settings.database.equalsIgnoreCase("sqlite")) {
			if (s.equalsIgnoreCase("w")) {
				DataSqlite.update(p, "MiningExp", exp);
				return true;
			}
			if (s.equalsIgnoreCase("r")) {
				DataSqlite.update(p, "RangingExp", exp);
				return true;
			}
			if (s.equalsIgnoreCase("s")) {
				DataSqlite.update(p, "SlayingExp", exp);
				return true;
			}
			if (s.equalsIgnoreCase("m")) {
				DataSqlite.update(p, "MiningExp", exp);
				return true;
			}
			if (s.equalsIgnoreCase("f")) {
				DataSqlite.update(p, "FisticuffsExp", exp);
				return true;
			}
			if (s.equalsIgnoreCase("a")) {
				DataSqlite.update(p, "ArcheryExp", exp);
				return true;
			}
		}
		return false;
	}

}