package com.schautdollar.DonorDreams.Features;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.util.Vector;

import com.schautdollar.DonorDreams.DonorDreams;

/**
 * 
 * @author Shinxs, Schautdollar
 *
 */

public class FtrDoubleJump implements IFeature, Listener {

	final String SETTING_HAS_DJ = "hasDoubleJump";
	final String SETTING_JUST_JUMPED = "justJumped";
	final String FEATURE_NAME = "doublejump";
	final String PERMISSION_NODE = "donordreams.doublejump";
	
	public FtrDoubleJump(){
		DonorDreams.featureSettings.setSetting(this.FEATURE_NAME, this.SETTING_JUST_JUMPED, new ArrayList<String>());
		
	}
	
	public String getFeatureName() {
		return this.FEATURE_NAME;
	}

	public String getPermissionNode() {
		return this.PERMISSION_NODE;
	}
	
	@EventHandler
	public void join(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		
		if(DonorDreams.permManager.playerHasPerm(player, this.PERMISSION_NODE)) {
			if((Boolean)DonorDreams.userSettings.getSetting(player.getName(), "hasDoubleJump")) {
					player.setAllowFlight(true);
			}
		}
	}
	
	@EventHandler
	public void setFlyOnJump(PlayerToggleFlightEvent event) {
		Player player = event.getPlayer();
		Vector jump = player.getLocation().getDirection().multiply(0.1).setY(1);
		Location loc = player.getLocation();
		Block block = loc.add(0, -1, 0).getBlock();
		
		if(DonorDreams.permManager.playerHasPerm(player, this.PERMISSION_NODE)) {
			if((Boolean)DonorDreams.userSettings.getSetting(player.getName(),this.SETTING_HAS_DJ)) {
				List<String> justJumped = (List<String>) DonorDreams.featureSettings.getSetting(this.FEATURE_NAME, this.SETTING_JUST_JUMPED);
				if(event.isFlying() && event.getPlayer().getGameMode() != GameMode.CREATIVE) {
					
					if(block.getType() == Material.AIR) {
						
						if(!justJumped.contains(player.getName())) {
							player.setFlying(false);
							player.setVelocity(player.getVelocity().add(jump));
							justJumped.add(player.getName());
							DonorDreams.featureSettings.setSetting(this.FEATURE_NAME, this.SETTING_JUST_JUMPED, justJumped);
						} 				
						else if(justJumped.contains(player.getName())) {
							player.setFlying(false);
							player.setAllowFlight(true);					
						}
					} else {
						if(!justJumped.contains(player.getName())) {
							player.setFlying(false);
							player.setVelocity(player.getVelocity().add(jump));
							justJumped.add(player.getName());	
							DonorDreams.featureSettings.setSetting(this.FEATURE_NAME, this.SETTING_JUST_JUMPED, justJumped);
						} else {
							player.setFlying(false);
							player.setAllowFlight(true);
							justJumped.remove(player.getName());
							DonorDreams.featureSettings.setSetting(this.FEATURE_NAME, this.SETTING_JUST_JUMPED, justJumped);
						}
					}
					event.setCancelled(true);
			    }
			}
		}
	}
}
