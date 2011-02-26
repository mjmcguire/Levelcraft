package me.samkio.levelcraft.SamToolbox;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;
public class FlatLands {
	private static final Logger log = Logger.getLogger("Minecraft");
	public static void writeDouble(String str, double var, File file) {
		Properties pro = new Properties();
		String stringvar = (new Double(var)).toString();
		try {
			FileInputStream in = new FileInputStream(file);
			pro.load(in);
			pro.setProperty(str, stringvar);
			pro.store(new FileOutputStream(file), null);
			in.close();
		} catch (IOException e) {
			log.severe("[Data] Unable to write double. To " + file);
		}
	}

	public static double getDouble(String str, File file) {
		Properties pro = new Properties();
		try {
			FileInputStream in = new FileInputStream(file);
			pro.load(in);
			String string = pro.getProperty(str);
			double var = Double.parseDouble(string);
			in.close();

			return var;
		} catch (IOException e) {
			log.severe("[Data] Unable to get double. From " + file);
		}
		return 0;
	}

	public static void writeBoolean(String str, boolean var, File file) {
		Properties pro = new Properties();
		String stringvar = new Boolean(var).toString();
		try {
			FileInputStream in = new FileInputStream(file);
			pro.load(in);
			pro.setProperty(str, stringvar);
			pro.store(new FileOutputStream(file), null);
			in.close();
		} catch (IOException e) {
			log.severe("[Data] Unable to write boolean. To " + file);
		}
	}

	public static boolean getBoolean(String str, File file) {
		Properties pro = new Properties();
		try {
			FileInputStream in = new FileInputStream(file);
			pro.load(in);
			String string = pro.getProperty(str);
			boolean var = Boolean.parseBoolean(string);
			in.close();

			return var;
		} catch (IOException e) {
			log.severe("[Data] Unable to get boolean. From " + file);
		}
		return false;
	}

	public static void writeString(String str, String var, File file) {
		Properties pro = new Properties();
		try {
			FileInputStream in = new FileInputStream(file);
			pro.load(in);
			pro.setProperty(str, var);
			pro.store(new FileOutputStream(file), null);
			in.close();
		} catch (IOException e) {
			log.severe("[Data] Unable to write string. To " + file);
		}
	}

	public static String getString(String str, File file) {
		Properties pro = new Properties();
		try {
			FileInputStream in = new FileInputStream(file);
			pro.load(in);
			String string = pro.getProperty(str);
			in.close();

			return string;
		} catch (IOException e) {
			log.severe("[Data] Unable to write string. From " + file);
		}
		return "";
	}

	public static void writeInteger(String str, int var, File file) {
		Properties pro = new Properties();
		String stringvar = (new Integer(var)).toString();
		try {
			FileInputStream in = new FileInputStream(file);
			pro.load(in);
			pro.setProperty(str, stringvar);
			pro.store(new FileOutputStream(file), null);
			in.close();
		} catch (IOException e) {
			log.severe("[Data] Unable to write integer. To " + file);
		}
	}

	public static int getInteger(String str, File file) {
		Properties pro = new Properties();
		try {
			FileInputStream in = new FileInputStream(file);
			pro.load(in);
			String string = pro.getProperty(str);
			int var = Integer.parseInt(string);
			in.close();

			return var;
		} catch (IOException e) {
			log.severe("[Data] Unable to write integer. From " + file);
		}
		return 0;
	}

	public static void removeKey(String str, File file) {
		Properties pro = new Properties();
		try {
			FileInputStream in = new FileInputStream(file);
			pro.load(in);
			pro.remove(str);
			pro.store(new FileOutputStream(file), null);
			in.close();
		} catch (IOException e) {
			log.severe("[Data] Unable remove key. From " + file);
		}
	}

	public static boolean containsKey(String str, File file) {
		Properties pro = new Properties();
		try {
			FileInputStream in = new FileInputStream(file);
			pro.load(in);

			if (pro.containsKey(str))

				return true;
		} catch (IOException e) {

			log.severe("[Data] Unable to get key. From " + file);
		}

		return false;
	}

}
