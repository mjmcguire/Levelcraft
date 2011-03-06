package me.samkio.levelcraft.SamToolbox;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.samkio.levelcraft.Levelcraft;
import me.samkio.levelcraft.Settings;


public class DataSqlite {
	private static Connection connection;
	private static final Logger log = Logger.getLogger("Minecraft");

	public static synchronized Connection getConnection() {
		if (connection == null) {
			connection = createConnection();
		}
		return connection;
	}

	private static Connection createConnection() {

		try {

			Class.forName("org.sqlite.JDBC");
			Connection ret = DriverManager.getConnection("jdbc:sqlite:"
					+ Levelcraft.maindirectory + Levelcraft.datadirectory
					+ "Experience.sqlite");
			ret.setAutoCommit(false);
			return ret;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void PrepareDB() {
		Connection conn = null;
		Statement st = null;
		int maxcolumns = 7;                //Always update this when added new experience tree
		try {
			conn = getConnection();
			st = conn.createStatement();
			st.executeUpdate("CREATE TABLE IF NOT EXISTS 'ExperienceTable' ('PlayerName' VARCHAR, 'WoodcuttingExp' INT ( 255 ) NOT NULL," +
					"'MiningExp' INT ( 255 ) NOT NULL,'SlayingExp' INT ( 255 ) NOT NULL," +
					"'RangingExp' INT ( 255 ) NOT NULL,'FisticuffsExp' INT ( 255 ) NOT NULL," +
					"'ArcheryExp' INT ( 255 ) NOT NULL ); CREATE INDEX playerIndex on ExperienceTable (PlayerName);");
			ResultSet rs = st.executeQuery("SELECT * FROM 'ExperienceTable';");
		    ResultSetMetaData rsmd = rs.getMetaData();
		    int numColumns = rsmd.getColumnCount();
		    if (!(numColumns == maxcolumns)){
		    	//database is old we need to add the new columns
		    	if(numColumns==4){
		    		st.executeUpdate("ALTER TABLE 'ExperienceTable' ADD COLUMN 'RangingExp' INT ( 255 )  NOT NULL;");
		    		st.executeUpdate("ALTER TABLE 'ExperienceTable' ADD COLUMN 'FisticuffsExp' INT ( 255 )  NOT NULL;");
		    		st.executeUpdate("ALTER TABLE 'ExperienceTable' ADD COLUMN 'ArcheryExp' INT ( 255 )  NOT NULL;");
		    	}
		    	if(numColumns==5){
		    		st.executeUpdate("ALTER TABLE 'ExperienceTable' ADD COLUMN 'FisticuffsExp' INT ( 255 )  NOT NULL;");
		    		st.executeUpdate("ALTER TABLE 'ExperienceTable' ADD COLUMN 'ArcheryExp' INT ( 255 )  NOT NULL;");
		    	}
		    	if(numColumns==6){
		    		st.executeUpdate("ALTER TABLE 'ExperienceTable' ADD COLUMN 'ArcheryExp' INT ( 255 )  NOT NULL;");
		    	}
		    }
		    conn.commit();
		} catch (SQLException e) {
			log.severe("[Levelcraft] Unable to prepare database");
		}
	}

	public static void NewPlayer(CommandSender sender, double var) {
		if (sender instanceof Player) {
			Player player = (Player) sender;
			Connection conn = null;
			Statement st = null;
			String p = player.getName();
			try {
				conn = getConnection();
				st = conn.createStatement();
				st.executeUpdate("INSERT INTO ExperienceTable (PlayerName,WoodcuttingExp,MiningExp,SlayingExp,RangingExp,FisticuffsExp,ArcheryExp) VALUES ('"
						+ p + "'," + var + "," + var + "," + var +"," + var +"," + var +"," + var +")");
				conn.commit();
			} catch (SQLException e) {
				log.severe("[Levelcraft] Unable to add row database" + e);
			}
		} else {
			sender.sendMessage("Error: Cannot create new player!");
		}
	}

	public static void DelRow(String databasetable, String value) {
		Connection conn = null;
		Statement st = null;
		try {
			conn = getConnection();
			st = conn.createStatement();
			st.executeUpdate("DELETE FROM Players WHERE PlayerName=('" + value
					+ "')");
			conn.commit();
		} catch (SQLException e) {
			log.severe("[Levelcraft] Unable to delete row database" + e);
		}
	}

	public static void update(CommandSender sender, String value,double newvalue) {
		if (sender instanceof Player) {
			Player player = (Player) sender;
			Connection conn = null;
			Statement st = null;
			String p = player.getName();
			try {
				conn = getConnection();
				st = conn.createStatement();
				st.executeUpdate("UPDATE ExperienceTable set "+value+" = '"+newvalue+"' WHERE PlayerName='"+p+"'");
				conn.commit();
			} catch (SQLException e) {
				log.severe("[Levelcraft] Unable to update row database" + e);
			}
		} else {
			sender.sendMessage("Error: Player could not be updated!");
		}
	}

	public static String GetRow(String databasetable, String value) {
		Connection conn = null;
		Statement st = null;
		String name = "NULL";
		try {
			conn = getConnection();
			st = conn.createStatement();
			ResultSet rs = st
			.executeQuery("SELECT PlayerName FROM Players WHERE PlayerName=('"
					+ value + "')");
			while (rs.next()) {
				name = rs.getString("PlayerName");
			}
			conn.commit();
			return name;
		} catch (SQLException e) {
			log.severe("[Levelcraft] Unable to get row database" + e);
		}
		return name;
	}

	public static double getExp(CommandSender sender, String value) {
		if (sender instanceof Player) {
			Player player = (Player) sender;
			Connection conn = null;
			Statement st = null;
			String p = player.getName();
			double level = 0;
			try {
				conn = getConnection();
				st = conn.createStatement();
				ResultSet rs = st.executeQuery("SELECT " + value
						+ " FROM ExperienceTable WHERE PlayerName=('" + p + "')");
				while (rs.next()) {
					level = rs.getDouble(value);
				}
				conn.commit();
				return level;
			} catch (SQLException e) {
				log.severe("[Levelcraft] Unable to get row database" + e);
			}
			return level;
		} else {
			sender.sendMessage("Error: Could not retrieve experience value!");
			return 0;
		}
	}

	public static int getLevel(CommandSender sender, String value) {
		if (sender instanceof Player) {
			Player player = (Player) sender;
			int level = 0;
			double exp = getExp(player, value);
			double constant = Settings.Constant;
			constant = constant / 100;
			for (int i = 1; i <= 1000; i++) {
				double levelAti = (100 * (i * (i * constant)));
				if (levelAti >= exp) {
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

	public static double getExpLeft(CommandSender sender, String value) {
		if (sender instanceof Player) {
			Player player = (Player) sender;
			double exp = getExp(player, value);
			double getExpUp = 0;
			double constant = Settings.Constant;
			constant = constant / 100;
			for (int i = 1; i <= 1000; i++) {
				double levelAti = (100 * (i * (i * constant)));
				if (levelAti >= exp) {
					getExpUp = levelAti;
					break;
				}
			}
			double leftExp = (getExpUp - exp);
			double leftExp2 = Toolbox.roundTwoDecimals(leftExp);
			return leftExp2;
		} else {
			sender.sendMessage("Error: Could not retrieve experience value!");
			return 0;
		}
	}

	public static boolean PlayerExsists(CommandSender sender) {
		if (sender instanceof Player) {
			Player player = (Player) sender;
			Connection conn = null;
			Statement st = null;
			String p = player.getName();
			boolean isTrue = false;
			try {
				conn = getConnection();
				st = conn.createStatement();
				ResultSet rs = st
				.executeQuery("SELECT PlayerName FROM ExperienceTable WHERE PlayerName=('"
						+ p + "')");
				while (rs.next()) {
					isTrue = true;
				}
				conn.commit();
				return isTrue;
			} catch (SQLException e) {
				log.severe("[Levelcraft] Unable to get row database" + e);
			}
			return isTrue;
		} else {
			sender.sendMessage("Error: Player does not exist!");
			return false;
		}
	}
}

