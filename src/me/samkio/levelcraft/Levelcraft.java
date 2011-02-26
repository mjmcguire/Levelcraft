package me.samkio.levelcraft;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import me.samkio.levelcraft.Listeners.LCBlockListener;
import me.samkio.levelcraft.Listeners.LCEntityListener;
import me.samkio.levelcraft.Listeners.LCPlayerListener;
import me.samkio.levelcraft.SamToolbox.DataMySql;
import me.samkio.levelcraft.SamToolbox.DataSqlite;

import org.bukkit.Server;
import org.bukkit.event.Event;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginLoader;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;


public class Levelcraft extends JavaPlugin {
	@SuppressWarnings("unused")
	private final Admin Admin = new Admin(this);
	private static final Logger log = Logger.getLogger("Minecraft");
	private final LCPlayerListener playerListener = new LCPlayerListener(this);
	private final LCBlockListener blockListener = new LCBlockListener(this);
	private final LCEntityListener entityListener = new LCEntityListener(this);
	public static String maindirectory = "LevelCraft/";
	public static String datadirectory = "Experience/";
	public static String configdirectory = "Config/";
	public static File WCExpFile = new File(maindirectory + datadirectory
			+ "WoodCutting.exp");
	public static File MiExpFile = new File(maindirectory + datadirectory
			+ "Mining.exp");
	public static File SlayExpFile = new File(maindirectory + datadirectory
			+ "Slaying.exp");
	public static File RangeExpFile = new File(maindirectory + datadirectory
			+ "Slaying.exp");

	public Levelcraft(PluginLoader pluginLoader, Server instance,
			PluginDescriptionFile desc, File folder, File plugin,
			ClassLoader cLoader) {
		super(pluginLoader, instance, desc, folder, plugin, cLoader);
	}

	@Override
	public void onDisable() {
		System.out.println("Levelcraft Disabled");

	}

	@Override
	public void onEnable() {
		load();
		registerEvents();

		PluginDescriptionFile pdfFile = this.getDescription();
		System.out.println(pdfFile.getName() + " version "
				+ pdfFile.getVersion() + " is enabled!");

	}

	void load() {
		new File(maindirectory).mkdirs();
		new File(maindirectory + datadirectory).mkdirs();
		new File(maindirectory + configdirectory).mkdirs();

		Settings.loadMain();
		Settings.loadWoodcut();
		Settings.loadSlayer();
		Settings.loadMine();
		Settings.loadWhitelist();
		
		if (Settings.database.equalsIgnoreCase("flatfile")) {
			
			if (!WCExpFile.exists() || !MiExpFile.exists()
					|| !SlayExpFile.exists() || !RangeExpFile.exists())
				try {
					WCExpFile.createNewFile();
					MiExpFile.createNewFile();
					SlayExpFile.createNewFile();
					RangeExpFile.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
		} else if (Settings.database.equalsIgnoreCase("mysql")) {
			DataMySql.PrepareDB();
		} else if (Settings.database.equalsIgnoreCase("sqlite")) {
			DataSqlite.PrepareDB();
		}else{
			log.severe("[Levelcraft] Nowhere to save data! Edit MainConfig Database.");
			getServer().getPluginManager().disablePlugin(this);
		}
	}

	void registerEvents() {
		PluginManager pm = getServer().getPluginManager();

		pm.registerEvent(Event.Type.PLAYER_COMMAND, this.playerListener,
				Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.ENTITY_DAMAGEDBY_ENTITY,
				this.entityListener, Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.ENTITY_DAMAGEDBY_PROJECTILE,
				this.entityListener, Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.PLAYER_JOIN, this.playerListener,
				Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.BLOCK_DAMAGED, blockListener,
				Event.Priority.Normal, this);
	}

}
