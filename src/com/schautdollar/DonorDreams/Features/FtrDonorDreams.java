package com.schautdollar.DonorDreams.Features;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import com.schautdollar.DonorDreams.DonorDreams;

public class FtrDonorDreams implements IFeature, Listener {
    
	final String FEATURE_NAME = "donordreams";
	final String PERMISSION_NODE = "donordreams.admin";
	
	public String getFeatureName() {
		return this.FEATURE_NAME;
	}
	
	public String getPermissionNode() {
		return this.PERMISSION_NODE;
	}
	@SuppressWarnings("unused")
	@EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        String joinMessage = event.getJoinMessage();
    }
	@EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        DonorDreams.userSettings.saveUsersSettings(player.getName());
    }
	
	

}
