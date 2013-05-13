package com.schautdollar.DonorDreams.Features;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import com.schautdollar.DonorDreams.DonorDreams;

/**
 * 
 * @author Shinxs
 *
 */

public class FtrTombstone implements IFeature, Listener {

	final String SETTING_TOMBSTONES = "tombstones"; //FOR FEATURE SETTINGS | Hashtable of tombstones >>>  Hashtable<String player, Location tombLoc>
	final String SETTING_HAS_TOMBSTONE = "hasTombstone";//FOR USER SETTINGS | Either true or false
	final String FEATURE_NAME = "tombchest";
	final String PERMISSION_NODE = "donordreams.tombstone";
	
	public FtrTombstone(){
		DonorDreams.featureSettings.setSetting(this.FEATURE_NAME, this.SETTING_HAS_TOMBSTONE, new Hashtable<String, Location>());
	}
	
	public String getFeatureName() {
		return this.FEATURE_NAME;
	}
	
	@EventHandler
	public void onEntityDamage(PlayerDeathEvent event) {
		Player player = event.getEntity();
		if(DonorDreams.permManager.playerHasPerm(player, this.PERMISSION_NODE))
			return;
		Location pl = player.getLocation();
		World world = player.getWorld();
		Location chestLocation = new Location(world, pl.getX(), pl.getY(), pl.getZ());
		
		chestLocation.getBlock().setType(Material.CHEST);
		Chest chest = (Chest) chestLocation.getBlock().getState();
		
		ItemStack[] playerInv = player.getInventory().getContents();
		ItemStack[] chestContents = new ItemStack[playerInv.length];
		
		for(int i = 0; i < player.getInventory().getSize(); i++) {
			chestContents[i] = playerInv[i];
		}
		
		for(int i = 0; i < chest.getInventory().getSize(); i++) {
			if(chestContents[i] != null) {
				chest.getInventory().addItem(chestContents);
			}
		}
	}
	
	@EventHandler
	public void onChestInteract(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		Block block = event.getClickedBlock();
		if(block.getTypeId() != 54 )
			return;
		if(DonorDreams.userSettings.doesSettingExists(player.getName(), this.SETTING_HAS_TOMBSTONE) && (Boolean)DonorDreams.userSettings.getSetting(player.getName(), this.SETTING_HAS_TOMBSTONE)){
			Hashtable tombs = (Hashtable)DonorDreams.featureSettings.getSetting(this.FEATURE_NAME, this.SETTING_TOMBSTONES);
			if(tombs.containsKey(player.getName())){
				if((Location)tombs.get(player.getName()) == block.getLocation()){
					
					
					DonorDreams.userSettings.removeSetting(player.getName(), this.SETTING_HAS_TOMBSTONE);
				return;
				}
			}
			else
				DonorDreams.userSettings.removeSetting(player.getName(), this.SETTING_HAS_TOMBSTONE);
		}
		event.setCancelled(true);
		
	}
}