package com.schautdollar.DonorDreams.Features;

import org.bukkit.event.Listener;
import org.bukkit.event.entity.ItemDespawnEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

/**
 * @author molenzwiebel
 *  Class for hovering item feature
 * */

public class FtrHoveringItem implements IFeature, Listener {
	//private HashMap<String, Integer> hoveringItems = new HashMap<String, Integer>();
	//private DonorDreams plugin;
	
	final String SETTING_HI = "hoveringItem";
	final String FEATURE_NAME = "hoveringitem";
	final String PERMISSION_NODE = "donordreams.hi";
	
	public String getFeatureName() {
		return this.FEATURE_NAME;
	}
	
	public String getPermissionNode() {
		return this.PERMISSION_NODE;
	}
	
	/*//public FtrHoveringItem(DonorDreams instance) {
		//this.plugin = instance;
	//}

	// Spawn hovering item
	public void addHoveringItemToPlayer(Player p, ItemStack itemStack) {
		Item i = p.getWorld().dropItem(p.getLocation(), itemStack);
		hoveringItems.put(p.getName(), i.getEntityId());
		p.setPassenger(i);
	}

	// Check if the player already has a hovering item
	public boolean hasHoveringItem(Player p) {
		if (hoveringItems.containsKey(p.getName()))
			return true;
		return false;
	}

	// Remove the hovering item
	public void removeHoveringItem(Player p) {
		p.getPassenger().remove();
		hoveringItems.remove(p.getName());
	}

	*/// Events
	public boolean onPickup(PlayerPickupItemEvent e) {
		//if //hoveringItems.containsValue(e.getItem().getEntityId())) {
			//return true;
		//}
		return false;
	}

	public boolean onDespawn(ItemDespawnEvent e) {
		//if (//hoveringItems.containsValue(e.getEntity().getEntityId())) {
			//return true;
		//}
		return false;
	}
}
