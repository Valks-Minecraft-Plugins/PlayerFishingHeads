package com.fishingplayerheads.listeners;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import com.fishingplayerheads.FishingPlayerHeads;
import com.fishingplayerheads.utils.Utils;

public class ListenerFish implements Listener {
	@SuppressWarnings("deprecation")
	@EventHandler
	private void fishEvent(PlayerFishEvent e) {
		FileConfiguration config = FishingPlayerHeads.plugin.getPlayerHeadsConfig();

		if (e.getCaught() != null) {
			if (Math.random() < config.getDouble("heads.chance")) {
				Player p = e.getPlayer();
				Location loc = p.getLocation();
				String randomHead;

				if (!config.getBoolean("heads.ingame")) {
					List<String> configHeads = config.getStringList("heads.heads");
					randomHead = configHeads.get(new Random().nextInt(configHeads.size()));
				} else {
					ArrayList<Player> players = new ArrayList<Player>(Bukkit.getOnlinePlayers());
					Player headPlayer = players.get(new Random().nextInt(players.size()));
					randomHead = headPlayer.getName();
				}
				
				ItemStack skull = new ItemStack(Material.PLAYER_HEAD);
				SkullMeta meta = (SkullMeta) skull.getItemMeta();
				meta.setDisplayName(Utils.color("&f" + randomHead));
				meta.setOwner(randomHead);
				skull.setItemMeta(meta);
				
				loc.getWorld().dropItemNaturally(loc, skull);
				p.sendMessage(Utils.color("&7You fished out &f" + randomHead + "&7's head!"));
			}
		}
	}
}
