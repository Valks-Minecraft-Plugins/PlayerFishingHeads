package com.fishingplayerheads.utils;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;

public class Utils {
	public static String color(String msg) {
		return ChatColor.translateAlternateColorCodes('&', msg);
	}
	
	public static void setConfigValue(FileConfiguration config, String path, String value) {
		if (!config.isSet(path))
			config.set(path, value);
	}
	
	public static void setConfigValue(FileConfiguration config, String path, int value) {
		if (!config.isSet(path))
			config.set(path, value);
	}
	
	public static void setConfigValue(FileConfiguration config, String path, double value) {
		if (!config.isSet(path))
			config.set(path, value);
	}
	
	public static void setConfigValue(FileConfiguration config, String path, boolean value) {
		if (!config.isSet(path))
			config.set(path, value);
	}
	
	public static void setConfigValue(FileConfiguration config, String path, List<String> value) {
		if (!config.isSet(path))
			config.set(path, value);
	}
}
