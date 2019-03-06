package com.fishingplayerheads;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.fishingplayerheads.commands.CommandToggle;
import com.fishingplayerheads.listeners.ListenerFish;
import com.fishingplayerheads.utils.Utils;

public class FishingPlayerHeads extends JavaPlugin {
	public static FishingPlayerHeads plugin;
	private File playerHeadsConfigFile = new File(getDataFolder(), "heads.yml");
	private FileConfiguration playerHeadsConfig = YamlConfiguration.loadConfiguration(playerHeadsConfigFile);
	
	@Override
	public void onEnable() {
		plugin = this;
		registerListeners();
		registerCommands();
		registerPlayerHeadsConfig();
	}
	
	private void registerListeners() {
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new ListenerFish(), this);
	}
	
	private void registerCommands() {
		getCommand("toggleheads").setExecutor(new CommandToggle());
	}
	
	private void registerPlayerHeadsConfig() {
		Utils.setConfigValue(playerHeadsConfig, "heads.ingame", true);
		Utils.setConfigValue(playerHeadsConfig, "heads.chance", 1.0);
		List<String> heads = new ArrayList<String>();
		heads.add("valkyrienyanko");
		heads.add("bobthebuilder");
		heads.add("saladass69");
		Utils.setConfigValue(playerHeadsConfig, "heads.heads", heads);
		savePlayerHeadsConfig();
	}
	
	public void savePlayerHeadsConfig() {
		try {
			playerHeadsConfig.save(playerHeadsConfigFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public FileConfiguration getPlayerHeadsConfig() {
		return playerHeadsConfig;
	}
}
