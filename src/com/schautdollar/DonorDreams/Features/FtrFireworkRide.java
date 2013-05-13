package com.schautdollar.DonorDreams.Features;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import com.schautdollar.DonorDreams.DonorDreams;

public class FtrFireworkRide implements IFeature, Listener{
	
	final String SETTING_ISFW = "isFW";
	final String FEATURE_NAME = "fireworkride";
	final String PERMISSION_NODE = "donordreams.firework"; 

	@Override
	public String getFeatureName() {
		
		return this.FEATURE_NAME;
	}
	
	public String getPermissionNode() {
		return this.PERMISSION_NODE;
	}
	
	@EventHandler
	public void onFallDamage(EntityDamageEvent e){
		
		if (e.getCause().equals(EntityDamageEvent.DamageCause.FALL)) {
			Entity en = e.getEntity();
			if(en instanceof Player){
				Player p = ((Player) en).getPlayer();
				if(DonorDreams.permManager.playerHasPerm(p, PERMISSION_NODE)){
					if((Boolean)DonorDreams.userSettings.getSetting(p.getName(), SETTING_ISFW)){
						e.setCancelled(true);
					}
				}
			}
		}
		
	}

}
