package com.schautdollar.DonorDreams.Features;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import com.schautdollar.DonorDreams.DonorDreams;

/**
 * @author SchautDollar
 *
 */
public class FtrGod implements IFeature, Listener {
	
	final String SETTING_ISGOD = "isGod";
	final String FEATURE_NAME = "god";
	final String PERMISSION_NODE = "donordreams.god";
	
	public String getFeatureName() {
		return this.FEATURE_NAME;
	}

	public String getPermissionNode() {
		return this.PERMISSION_NODE;
	}
	/**
	 * @param e Event provided by bukkit.
	 */
	@EventHandler(priority = EventPriority.NORMAL)
	public void onEntityDamage(EntityDamageByEntityEvent e){
		Entity damagee = e.getEntity();
		if(damagee instanceof Player && DonorDreams.permManager.playerHasPerm((Player)e, this.PERMISSION_NODE) &&(Boolean)DonorDreams.userSettings.getSetting(((Player)damagee).getName(), this.SETTING_ISGOD))
			e.setCancelled(true);
	}

	
}
