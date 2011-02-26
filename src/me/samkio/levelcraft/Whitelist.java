package me.samkio.levelcraft;


public class Whitelist {

	public static boolean isAdmin(String player) {
		boolean Admin = false;
		for (int i = 0; i < Settings.LCAdmins.length; i++) {
			if (Settings.LCAdmins[i].equalsIgnoreCase(player)) {
				Admin = true;
			} else {
				Admin = false;
			}
		}
		return Admin;
	}

	public static boolean isAvoid(String player) {
		boolean Avoid = false;
		for (int i = 0; i < Settings.LCAvoiders.length; i++) {
			if (Settings.LCAvoiders[i].equalsIgnoreCase(player)) {
				Avoid = true;
			} else {
				Avoid = false;
			}
		}
		return Avoid;
	}
}
