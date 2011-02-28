package me.samkio.levelcraft;


public class Whitelist {

	public static boolean isAdmin(String player) {
		for (int i = 0; i < Settings.LCAdmins.length; i++) {
			if (Settings.LCAdmins[i].equalsIgnoreCase(player)) {
				return true;
			} 
		}
		return false;
	}

	public static boolean isAvoid(String player) {
		for (int i = 0; i < Settings.LCAvoiders.length; i++) {
			if (Settings.LCAvoiders[i].equalsIgnoreCase(player)) {
				return true;
			}
		}
		return false;
	}
}
