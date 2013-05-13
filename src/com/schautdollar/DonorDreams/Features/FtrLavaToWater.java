package com.schautdollar.DonorDreams.Features;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import com.schautdollar.DonorDreams.DonorDreams;

/**
 * 
 * @author Shinxs
 *
 */

public class FtrLavaToWater implements IFeature, Listener {

	final String FEATURE_NAME = "LavaToWater";
	final String PERMISSION_NODE = "donordreams.lavatowater";
	
	public String getFeatureName() {
		return this.FEATURE_NAME;
	}
	
	public String getPermissionNode() {
		return this.PERMISSION_NODE;
	}

	@EventHandler
	public void onPlayerHitLava(EntityDamageEvent event) {
		Entity e = event.getEntity();
		
		if(e instanceof Player) {
			Player p = (Player) e;
			
			if(DonorDreams.permManager.playerHasPerm(p, this.PERMISSION_NODE)) {
				if(event.getCause() == EntityDamageEvent.DamageCause.LAVA) {
					
					if(p.isSneaking()) {
						
						Location loc = p.getLocation();
						Block b = loc.getBlock();
						Block bD = b.getRelative(BlockFace.DOWN);
						Block bDN = bD.getRelative(BlockFace.NORTH);
						Block bDS = bD.getRelative(BlockFace.SOUTH);
						Block bDE = bD.getRelative(BlockFace.EAST);
						Block bDW = bD.getRelative(BlockFace.WEST);
						Block bDNE = bD.getRelative(BlockFace.NORTH_EAST);
						Block bDNW = bD.getRelative(BlockFace.NORTH_WEST);
						Block bDSE = bD.getRelative(BlockFace.SOUTH_EAST);
						Block bDSW = bD.getRelative(BlockFace.SOUTH_WEST);
						// //////
						Block bN = b.getRelative(BlockFace.NORTH);
						Block bNN = bN.getRelative(BlockFace.NORTH);
						Block bNNW = bNN.getRelative(BlockFace.WEST);
						Block bNNE = bNN.getRelative(BlockFace.EAST);
						Block bNNU = bNN.getRelative(BlockFace.UP);
						Block bNNUE = bNNU.getRelative(BlockFace.EAST);
						Block bNNUW = bNNU.getRelative(BlockFace.WEST);
						Block bNNUU = bNNU.getRelative(BlockFace.UP);
						Block bNNUUE = bNNUU.getRelative(BlockFace.EAST);
						Block bNNUUW = bNNUU.getRelative(BlockFace.WEST);
						Block bNNUUU = bNNUU.getRelative(BlockFace.UP);
						Block bNNUUUE = bNNUUU.getRelative(BlockFace.EAST);
						Block bNNUUUW = bNNUUU.getRelative(BlockFace.WEST);
						// /////////
						Block bS = b.getRelative(BlockFace.SOUTH);
						Block bSS = bS.getRelative(BlockFace.SOUTH);
						Block bSSW = bSS.getRelative(BlockFace.WEST);
						Block bSSE = bSS.getRelative(BlockFace.EAST);
						Block bSSU = bSS.getRelative(BlockFace.UP);
						Block bSSUE = bSSU.getRelative(BlockFace.EAST);
						Block bSSUW = bSSU.getRelative(BlockFace.WEST);
						Block bSSUU = bSSU.getRelative(BlockFace.UP);
						Block bSSUUE = bSSUU.getRelative(BlockFace.EAST);
						Block bSSUUW = bSSUU.getRelative(BlockFace.WEST);
						Block bSSUUU = bSSUU.getRelative(BlockFace.UP);
						Block bSSUUUE = bSSUUU.getRelative(BlockFace.EAST);
						Block bSSUUUW = bSSUUU.getRelative(BlockFace.WEST);
						// //////////////
						Block bE = b.getRelative(BlockFace.EAST);
						Block bEE = bE.getRelative(BlockFace.EAST);
						Block bEES = bEE.getRelative(BlockFace.SOUTH);
						Block bEEN = bEE.getRelative(BlockFace.NORTH);
						Block bEEU = bEE.getRelative(BlockFace.UP);
						Block bEEUN = bEEU.getRelative(BlockFace.NORTH);
						Block bEEUS = bEEU.getRelative(BlockFace.SOUTH);
						Block bEEUU = bEEU.getRelative(BlockFace.UP);
						Block bEEUUN = bEEUU.getRelative(BlockFace.NORTH);
						Block bEEUUS = bEEUU.getRelative(BlockFace.SOUTH);
						Block bEEUUU = bEEUU.getRelative(BlockFace.UP);
						Block bEEUUUN = bEEUUU.getRelative(BlockFace.NORTH);
						Block bEEUUUS = bEEUUU.getRelative(BlockFace.SOUTH);
						// //////////////////////////////////
						Block bW = b.getRelative(BlockFace.WEST);
						Block bWW = bW.getRelative(BlockFace.WEST);
						Block bWWS = bWW.getRelative(BlockFace.SOUTH);
						Block bWWN = bWW.getRelative(BlockFace.NORTH);
						Block bWWU = bWW.getRelative(BlockFace.UP);
						Block bWWUN = bWWU.getRelative(BlockFace.NORTH);
						Block bWWUS = bWWU.getRelative(BlockFace.SOUTH);
						Block bWWUU = bWWU.getRelative(BlockFace.UP);
						Block bWWUUN = bWWUU.getRelative(BlockFace.NORTH);
						Block bWWUUS = bWWUU.getRelative(BlockFace.SOUTH);
						Block bWWUUU = bWWUU.getRelative(BlockFace.UP);
						Block bWWUUUN = bWWUUU.getRelative(BlockFace.NORTH);
						Block bWWUUUS = bWWUUU.getRelative(BlockFace.SOUTH);
			
						Block bU = b.getRelative(BlockFace.UP);
						Block bUU = bU.getRelative(BlockFace.UP);
						Block bUUU = bUU.getRelative(BlockFace.UP);
						Block bUUUU = bUUU.getRelative(BlockFace.UP);
						Block bUUUUN = bUUUU.getRelative(BlockFace.NORTH);
						Block bUUUUS = bUUUU.getRelative(BlockFace.SOUTH);
						Block bUUUUE = bUUUU.getRelative(BlockFace.EAST);
						Block bUUUUW = bUUUU.getRelative(BlockFace.WEST);
						Block bUUUUNE = bUUUU.getRelative(BlockFace.NORTH_EAST);
						Block bUUUUNW = bUUUU.getRelative(BlockFace.NORTH_WEST);
						Block bUUUUSE = bUUUU.getRelative(BlockFace.SOUTH_EAST);
						Block bUUUUSW = bUUUU.getRelative(BlockFace.SOUTH_WEST);
						
						
						Block bNE = b.getRelative(BlockFace.NORTH_EAST);
						Block bNW = b.getRelative(BlockFace.NORTH_WEST);
						Block bSE = b.getRelative(BlockFace.SOUTH_EAST);
						Block bSW = b.getRelative(BlockFace.SOUTH_WEST);
						
						Block bNEU = bNE.getRelative(BlockFace.UP);
						Block bNWU = bNW.getRelative(BlockFace.UP);
						Block bSEU = bSE.getRelative(BlockFace.UP);
						Block bSWU = bSW.getRelative(BlockFace.UP);
			
						Block bNEUU = bNEU.getRelative(BlockFace.UP);
						Block bNWUU = bNWU.getRelative(BlockFace.UP);
						Block bSEUU = bSEU.getRelative(BlockFace.UP);
						Block bSWUU = bSWU.getRelative(BlockFace.UP);
						
						Block bNEUUU = bNEUU.getRelative(BlockFace.UP);
						Block bNWUUU = bNWUU.getRelative(BlockFace.UP);
						Block bSEUUU = bSEUU.getRelative(BlockFace.UP);
						Block bSWUUU = bSWUU.getRelative(BlockFace.UP);
						
						Block bNU = bN.getRelative(BlockFace.UP);
						Block bSU = bS.getRelative(BlockFace.UP);
						Block bEU = bE.getRelative(BlockFace.UP);
						Block bWU = bW.getRelative(BlockFace.UP);
						
						Block bNUU = bNU.getRelative(BlockFace.UP);
						Block bSUU = bSU.getRelative(BlockFace.UP);
						Block bEUU = bEU.getRelative(BlockFace.UP);
						Block bWUU = bWU.getRelative(BlockFace.UP);
						
						Block bNUUU = bNUU.getRelative(BlockFace.UP);
						Block bSUUU = bSUU.getRelative(BlockFace.UP);
						Block bEUUU = bEUU.getRelative(BlockFace.UP);
						Block bWUUU = bWUU.getRelative(BlockFace.UP);
			
			
						if (bD.getType() == Material.LAVA
								|| bD.getType() == Material.STATIONARY_LAVA) {
							bD.setType(Material.DIRT);
			
						}
						if (bDN.getType() == Material.LAVA
								|| bDN.getType() == Material.STATIONARY_LAVA) {
							bDN.setType(Material.DIRT);
			
						}
						if (bDS.getType() == Material.LAVA
								|| bDS.getType() == Material.STATIONARY_LAVA) {
							bDS.setType(Material.DIRT);
			
						}
						if (bDE.getType() == Material.LAVA
								|| bDE.getType() == Material.STATIONARY_LAVA) {
							bDE.setType(Material.DIRT);
			
						}
						if (bDW.getType() == Material.LAVA
								|| bDW.getType() == Material.STATIONARY_LAVA) {
							bDW.setType(Material.DIRT);
			
						}
						if (bDNE.getType() == Material.LAVA
								|| bDNE.getType() == Material.STATIONARY_LAVA) {
							bDNE.setType(Material.DIRT);
						}
						if (bDNW.getType() == Material.LAVA
								|| bDNW.getType() == Material.STATIONARY_LAVA) {
							bDNW.setType(Material.DIRT);
						}
						if (bDSE.getType() == Material.LAVA
								|| bDSE.getType() == Material.STATIONARY_LAVA) {
							bDSE.setType(Material.DIRT);
						}
						if (bDSW.getType() == Material.LAVA
								|| bDSW.getType() == Material.STATIONARY_LAVA) {
							bDSW.setType(Material.DIRT);
						}
			
						if (bNN.getType() == Material.LAVA
								|| bNN.getType() == Material.STATIONARY_LAVA) {
							bNN.setType(Material.DIRT);
						}
						if (bNNW.getType() == Material.LAVA
								|| bNNW.getType() == Material.STATIONARY_LAVA) {
							bNNW.setType(Material.DIRT);
						}
						if (bNNE.getType() == Material.LAVA
								|| bNNE.getType() == Material.STATIONARY_LAVA) {
							bNNE.setType(Material.DIRT);
						}
						if (bNNU.getType() == Material.LAVA
								|| bNNU.getType() == Material.STATIONARY_LAVA) {
							bNNU.setType(Material.DIRT);
						}
						if (bNNUE.getType() == Material.LAVA
								|| bNNUE.getType() == Material.STATIONARY_LAVA) {
							bNNUE.setType(Material.DIRT);
						}
						if (bNNUW.getType() == Material.LAVA
								|| bNNW.getType() == Material.STATIONARY_LAVA) {
							bNNUW.setType(Material.DIRT);
						}
						if (bNNUU.getType() == Material.LAVA
								|| bNNUU.getType() == Material.STATIONARY_LAVA) {
							bNNUU.setType(Material.DIRT);
						}
						if (bNNUUE.getType() == Material.LAVA
								|| bNNUUE.getType() == Material.STATIONARY_LAVA) {
							bNNUUE.setType(Material.DIRT);
						}
						if (bNNUUW.getType() == Material.LAVA
								|| bNNUUW.getType() == Material.STATIONARY_LAVA) {
							bNNUUW.setType(Material.DIRT);
						}
						if (bNNUUU.getType() == Material.LAVA
								|| bNNUUU.getType() == Material.STATIONARY_LAVA) {
							bNNUUU.setType(Material.DIRT);
						}
						if (bNNUUUE.getType() == Material.LAVA
								|| bNNUUUE.getType() == Material.STATIONARY_LAVA) {
							bNNUUUE.setType(Material.DIRT);
						}
						if (bNNUUUW.getType() == Material.LAVA
								|| bNNUUUW.getType() == Material.STATIONARY_LAVA) {
							bNNUUUW.setType(Material.DIRT);
						}
			
						if (bSS.getType() == Material.LAVA
								|| bSS.getType() == Material.STATIONARY_LAVA) {
							bSS.setType(Material.DIRT);
						}
						if (bSSW.getType() == Material.LAVA
								|| bSSW.getType() == Material.STATIONARY_LAVA) {
							bSSW.setType(Material.DIRT);
						}
						if (bSSE.getType() == Material.LAVA
								|| bSSE.getType() == Material.STATIONARY_LAVA) {
							bSSE.setType(Material.DIRT);
						}
						if (bSSU.getType() == Material.LAVA
								|| bSSU.getType() == Material.STATIONARY_LAVA) {
							bSSU.setType(Material.DIRT);
						}
						if (bSSUE.getType() == Material.LAVA
								|| bSSUE.getType() == Material.STATIONARY_LAVA) {
							bSSUE.setType(Material.DIRT);
						}
						if (bSSUW.getType() == Material.LAVA
								|| bSSUW.getType() == Material.STATIONARY_LAVA) {
							bSSUW.setType(Material.DIRT);
						}
						if (bSSUU.getType() == Material.LAVA
								|| bSSUU.getType() == Material.STATIONARY_LAVA) {
							bSSUU.setType(Material.DIRT);
						}
						if (bSSUUE.getType() == Material.LAVA
								|| bSSUUE.getType() == Material.STATIONARY_LAVA) {
							bSSUUE.setType(Material.DIRT);
						}
						if (bSSUUW.getType() == Material.LAVA
								|| bSSUUW.getType() == Material.STATIONARY_LAVA) {
							bSSUUW.setType(Material.DIRT);
						}
						if (bSSUUU.getType() == Material.LAVA
								|| bSSUUU.getType() == Material.STATIONARY_LAVA) {
							bSSUUU.setType(Material.DIRT);
						}
						if (bSSUUUE.getType() == Material.LAVA
								|| bSSUUUE.getType() == Material.STATIONARY_LAVA) {
							bSSUUUE.setType(Material.DIRT);
						}
						if (bSSUUUW.getType() == Material.LAVA
								|| bSSUUUW.getType() == Material.STATIONARY_LAVA) {
							bSSUUUW.setType(Material.DIRT);
						}
			
						if (bEE.getType() == Material.LAVA
								|| bEE.getType() == Material.STATIONARY_LAVA) {
							bEE.setType(Material.DIRT);
						}
						if (bEES.getType() == Material.LAVA
								|| bEES.getType() == Material.STATIONARY_LAVA) {
							bEES.setType(Material.DIRT);
						}
						if (bEEN.getType() == Material.LAVA
								|| bEEN.getType() == Material.STATIONARY_LAVA) {
							bEEN.setType(Material.DIRT);
						}
						if (bEEU.getType() == Material.LAVA
								|| bEEU.getType() == Material.STATIONARY_LAVA) {
							bEEU.setType(Material.DIRT);
						}
						if (bEEUN.getType() == Material.LAVA
								|| bEEUN.getType() == Material.STATIONARY_LAVA) {
							bEEUN.setType(Material.DIRT);
						}
						if (bEEUS.getType() == Material.LAVA
								|| bEEUS.getType() == Material.STATIONARY_LAVA) {
							bEEUS.setType(Material.DIRT);
						}
						if (bEEUU.getType() == Material.LAVA
								|| bEEUU.getType() == Material.STATIONARY_LAVA) {
							bEEUU.setType(Material.DIRT);
						}
						if (bEEUUN.getType() == Material.LAVA
								|| bEEUUN.getType() == Material.STATIONARY_LAVA) {
							bEEUUN.setType(Material.DIRT);
						}
						if (bEEUUS.getType() == Material.LAVA
								|| bEEUUS.getType() == Material.STATIONARY_LAVA) {
							bEEUUS.setType(Material.DIRT);
						}
						if (bEEUUU.getType() == Material.LAVA
								|| bEEUUU.getType() == Material.STATIONARY_LAVA) {
							bEEUUU.setType(Material.DIRT);
						}
						if (bEEUUUN.getType() == Material.LAVA
								|| bEEUUUN.getType() == Material.STATIONARY_LAVA) {
							bEEUUUN.setType(Material.DIRT);
						}
						if (bEEUUUS.getType() == Material.LAVA
								|| bEEUUUS.getType() == Material.STATIONARY_LAVA) {
							bEEUUUS.setType(Material.DIRT);
						}
			
						if (bWW.getType() == Material.LAVA
								|| bWW.getType() == Material.STATIONARY_LAVA) {
							bWW.setType(Material.DIRT);
						}
						if (bWWS.getType() == Material.LAVA
								|| bWWS.getType() == Material.STATIONARY_LAVA) {
							bWWS.setType(Material.DIRT);
						}
						if (bWWN.getType() == Material.LAVA
								|| bWWN.getType() == Material.STATIONARY_LAVA) {
							bWWN.setType(Material.DIRT);
						}
						if (bWWU.getType() == Material.LAVA
								|| bWWU.getType() == Material.STATIONARY_LAVA) {
							bWWU.setType(Material.DIRT);
						}
						if (bWWUN.getType() == Material.LAVA
								|| bWWUN.getType() == Material.STATIONARY_LAVA) {
							bWWUN.setType(Material.DIRT);
						}
						if (bWWUS.getType() == Material.LAVA
								|| bWWUS.getType() == Material.STATIONARY_LAVA) {
							bWWUS.setType(Material.DIRT);
						}
						if (bWWUU.getType() == Material.LAVA
								|| bWWUU.getType() == Material.STATIONARY_LAVA) {
							bWWUU.setType(Material.DIRT);
						}
						if (bWWUUN.getType() == Material.LAVA
								|| bWWUUN.getType() == Material.STATIONARY_LAVA) {
							bWWUUN.setType(Material.DIRT);
						}
						if (bWWUUS.getType() == Material.LAVA
								|| bWWUUS.getType() == Material.STATIONARY_LAVA) {
							bWWUUS.setType(Material.DIRT);
						}
						if (bWWUUU.getType() == Material.LAVA
								|| bWWUUU.getType() == Material.STATIONARY_LAVA) {
							bWWUUU.setType(Material.DIRT);
						}
						if (bWWUUUN.getType() == Material.LAVA
								|| bWWUUUN.getType() == Material.STATIONARY_LAVA) {
							bWWUUUN.setType(Material.DIRT);
						}
						if (bWWUUUS.getType() == Material.LAVA
								|| bWWUUUS.getType() == Material.STATIONARY_LAVA) {
							bWWUUUS.setType(Material.DIRT);
						}
		
						if (bUUUU.getType() == Material.LAVA
								|| bUUUU.getType() == Material.STATIONARY_LAVA) {
							bUUUU.setType(Material.DIRT);
						}
						if (bUUUUN.getType() == Material.LAVA
								|| bUUUUN.getType() == Material.STATIONARY_LAVA) {
							bUUUUN.setType(Material.DIRT);
						}
						if (bUUUUS.getType() == Material.LAVA
								|| bUUUUS.getType() == Material.STATIONARY_LAVA) {
							bUUUUS.setType(Material.DIRT);
						}
						if (bUUUUE.getType() == Material.LAVA
								|| bUUUUE.getType() == Material.STATIONARY_LAVA) {
							bUUUUE.setType(Material.DIRT);
						}
						if (bUUUUW.getType() == Material.LAVA
								|| bUUUUW.getType() == Material.STATIONARY_LAVA) {
							bUUUUW.setType(Material.DIRT);
						}
						if (bUUUUNE.getType() == Material.LAVA
								|| bUUUUNE.getType() == Material.STATIONARY_LAVA) {
							bUUUUNE.setType(Material.DIRT);
						}
						if (bUUUUNW.getType() == Material.LAVA
								|| bUUUUNW.getType() == Material.STATIONARY_LAVA) {
							bUUUUNW.setType(Material.DIRT);
						}
						if (bUUUUSE.getType() == Material.LAVA
								|| bUUUUSE.getType() == Material.STATIONARY_LAVA) {
							bUUUUSE.setType(Material.DIRT);
						}
						if (bUUUUSW.getType() == Material.LAVA
								|| bUUUUSW.getType() == Material.STATIONARY_LAVA) {
							bUUUUSW.setType(Material.DIRT);
						}
						////////////////////////////////////////////
						if (b.getType() == Material.LAVA
								|| b.getType() == Material.STATIONARY_LAVA) {
							b.setType(Material.AIR);
						}
						
						if (bN.getType() == Material.LAVA
								|| bN.getType() == Material.STATIONARY_LAVA) {
							bN.setType(Material.AIR);
						}
						
						if (bS.getType() == Material.LAVA
								|| bS.getType() == Material.STATIONARY_LAVA) {
							bS.setType(Material.AIR);
						}
						
						if (bE.getType() == Material.LAVA
								|| bE.getType() == Material.STATIONARY_LAVA) {
							bE.setType(Material.AIR);
						}
						
						if (bW.getType() == Material.LAVA
								|| bW.getType() == Material.STATIONARY_LAVA) {
							bW.setType(Material.AIR);
						}
						
						if (bU.getType() == Material.LAVA
								|| bU.getType() == Material.STATIONARY_LAVA) {
							bU.setType(Material.AIR);
						}
						
						if (bUU.getType() == Material.LAVA
								|| bUU.getType() == Material.STATIONARY_LAVA) {
							bUU.setType(Material.AIR);
						}
						
						if (bUUU.getType() == Material.LAVA
								|| bUUU.getType() == Material.STATIONARY_LAVA) {
							bUUU.setType(Material.AIR);
						}
						
						if (bNE.getType() == Material.LAVA
								|| bNE.getType() == Material.STATIONARY_LAVA) {
							bNE.setType(Material.AIR);
						}
						
						if (bNW.getType() == Material.LAVA
								|| bNW.getType() == Material.STATIONARY_LAVA) {
							bNW.setType(Material.AIR);
						}
						
						if (bSE.getType() == Material.LAVA
								|| bSE.getType() == Material.STATIONARY_LAVA) {
							bSE.setType(Material.AIR);
						}
						
						if (bSW.getType() == Material.LAVA
								|| bSW.getType() == Material.STATIONARY_LAVA) {
							bSW.setType(Material.AIR);
						}
						
						if (bNEU.getType() == Material.LAVA
								|| bNEU.getType() == Material.STATIONARY_LAVA) {
							bNEU.setType(Material.AIR);
						}
						
						if (bNWU.getType() == Material.LAVA
								|| bNWU.getType() == Material.STATIONARY_LAVA) {
							bNWU.setType(Material.AIR);
						}
						
						if (bSEU.getType() == Material.LAVA
								|| bSEU.getType() == Material.STATIONARY_LAVA) {
							bSEU.setType(Material.AIR);
						}
						
						if (bSWU.getType() == Material.LAVA
								|| bSWU.getType() == Material.STATIONARY_LAVA) {
							bSWU.setType(Material.AIR);
						}
						
						if (bNEUU.getType() == Material.LAVA
								|| bNEUU.getType() == Material.STATIONARY_LAVA) {
							bNEUU.setType(Material.AIR);
						}
						
						if (bNWUU.getType() == Material.LAVA
								|| bNWUU.getType() == Material.STATIONARY_LAVA) {
							bNWUU.setType(Material.AIR);
						}
						
						if (bSEUU.getType() == Material.LAVA
								|| bSEUU.getType() == Material.STATIONARY_LAVA) {
							bSEUU.setType(Material.AIR);
						}
						
						if (bSWUU.getType() == Material.LAVA
								|| bSWUU.getType() == Material.STATIONARY_LAVA) {
							bSWUU.setType(Material.AIR);
						}
						
						if (bNEUUU.getType() == Material.LAVA
								|| bNEUUU.getType() == Material.STATIONARY_LAVA) {
							bNEUUU.setType(Material.AIR);
						}
						
						if (bNWUUU.getType() == Material.LAVA
								|| bNWUUU.getType() == Material.STATIONARY_LAVA) {
							bNWUUU.setType(Material.AIR);
						}
						
						if (bSEUUU.getType() == Material.LAVA
								|| bSEUUU.getType() == Material.STATIONARY_LAVA) {
							bSEUUU.setType(Material.AIR);
						}
						
						if (bSWUUU.getType() == Material.LAVA
								|| bSWUUU.getType() == Material.STATIONARY_LAVA) {
							bSWUUU.setType(Material.AIR);
						}
						
						if (bNU.getType() == Material.LAVA
								|| bNU.getType() == Material.STATIONARY_LAVA) {
							bNU.setType(Material.AIR);
						}
						
						if (bSU.getType() == Material.LAVA
								|| bSU.getType() == Material.STATIONARY_LAVA) {
							bSU.setType(Material.AIR);
						}
						
						if (bEU.getType() == Material.LAVA
								|| bEU.getType() == Material.STATIONARY_LAVA) {
							bEU.setType(Material.AIR);
						}
						
						if (bWU.getType() == Material.LAVA
								|| bWU.getType() == Material.STATIONARY_LAVA) {
							bWU.setType(Material.AIR);
						}
						
						if (bNUU.getType() == Material.LAVA
								|| bNUU.getType() == Material.STATIONARY_LAVA) {
							bNUU.setType(Material.AIR);
						}
						
						if (bSUU.getType() == Material.LAVA
								|| bSUU.getType() == Material.STATIONARY_LAVA) {
							bSUU.setType(Material.AIR);
						}
						
						if (bEUU.getType() == Material.LAVA
								|| bEUU.getType() == Material.STATIONARY_LAVA) {
							bEUU.setType(Material.AIR);
						}
						
						if (bWUU.getType() == Material.LAVA
								|| bWUU.getType() == Material.STATIONARY_LAVA) {
							bWUU.setType(Material.AIR);
						}
						
						if (bWUUU.getType() == Material.LAVA
								|| bWUUU.getType() == Material.STATIONARY_LAVA) {
							bWUUU.setType(Material.AIR);
						}
						
						if (bNUUU.getType() == Material.LAVA
								|| bNUUU.getType() == Material.STATIONARY_LAVA) {
							bNUUU.setType(Material.AIR);
						}
						
						if (bSUUU.getType() == Material.LAVA
								|| bSUUU.getType() == Material.STATIONARY_LAVA) {
							bSUUU.setType(Material.AIR);
						}
						
						if (bEUUU.getType() == Material.LAVA
								|| bEUUU.getType() == Material.STATIONARY_LAVA) {
							bEUUU.setType(Material.AIR);
						}
						
						if (bWUUU.getType() == Material.LAVA
								|| bWUUU.getType() == Material.STATIONARY_LAVA) {
							bWUUU.setType(Material.AIR);
						}			
						
						p.setFireTicks(0);
						event.setCancelled(true);
					}
				}
			}
		}
	}
}