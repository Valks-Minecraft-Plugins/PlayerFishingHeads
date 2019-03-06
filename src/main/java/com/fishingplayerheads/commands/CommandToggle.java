package com.fishingplayerheads.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import com.fishingplayerheads.FishingPlayerHeads;
import com.fishingplayerheads.utils.Utils;

public class CommandToggle implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (command.getName().equalsIgnoreCase("toggleheads")) {
			if (sender.hasPermission("fishingplayerheads.toggleheads") && !sender.isOp()) {
				sender.sendMessage(Utils.color("&7You need the '&ffishingplayerheads.toggleheads&7' permission to do that!"));
				return false;
			}
			
			FishingPlayerHeads plugin = FishingPlayerHeads.plugin;
			FileConfiguration config = plugin.getPlayerHeadsConfig();
			
			boolean inGame = config.getBoolean("heads.ingame");
			if (inGame)
				config.set("heads.ingame", false);
			else
				config.set("heads.ingame", true);
			
			sender.sendMessage(Utils.color("&7Fishing player heads are &f" + !inGame + " &7for in game now."));
			
			plugin.savePlayerHeadsConfig();
			
			return true;
		}
		return false;
	}
}
