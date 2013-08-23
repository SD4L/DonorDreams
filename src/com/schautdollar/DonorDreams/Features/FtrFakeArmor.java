package com.schautdollar.DonorDreams.Features;

import net.minecraft.server.v1_6_R2.Packet5EntityEquipment;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_6_R2.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_6_R2.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

import com.schautdollar.DonorDreams.DonorDreams;
import com.schautdollar.DonorDreams.Commands.CmdFakeArmor;

public class FtrFakeArmor implements IFeature, Listener{
	
	final String SETTING_ISUSING_FAKE = "faActive";
	final String SETTING_SLOT_1 = "fakeArmor1";
	final String SETTING_SLOT_2 = "fakeArmor2";
	final String SETTING_SLOT_3 = "fakeArmor3";
	final String SETTING_SLOT_4 = "fakeArmor4";
	final String FEATURE_NAME = "fakearmor";
	final String PERMISSION_NODE = "donordreams.fakearmor"; 
	public int taskID = 0;
	public final DonorDreams PLUGIN;
	@Override
	public String getFeatureName() {
		
		return this.FEATURE_NAME;
	}
	
	public String getPermissionNode() {
		return this.PERMISSION_NODE;
	}
	
	public FtrFakeArmor(final DonorDreams instance) {
		this.PLUGIN = instance;
		taskID = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(PLUGIN, new Runnable() {
			
			public void run() {
				for (Player player : Bukkit.getServer().getOnlinePlayers()) {
					if ((Boolean) DonorDreams.userSettings.getSetting(player.getName(), SETTING_ISUSING_FAKE)) {
						if (!((String) DonorDreams.userSettings.getSetting(player.getName(), SETTING_SLOT_1)).equals("")) {
							for(Player playerInWorld : PLUGIN.getServer().getOnlinePlayers()) {
						        if(!playerInWorld.equals(player)) {
						            ItemStack item = CmdFakeArmor.stringToIS((String) DonorDreams.userSettings.getSetting(player.getName(), SETTING_SLOT_1));
						        	((CraftPlayer) playerInWorld).getHandle().playerConnection.sendPacket(new Packet5EntityEquipment(((CraftPlayer) player).getEntityId(), 1, CraftItemStack.asNMSCopy(item)));
						        }
						    }
						}
						if (!((String) DonorDreams.userSettings.getSetting(player.getName(), SETTING_SLOT_2)).equals("")) {
							for(Player playerInWorld : PLUGIN.getServer().getOnlinePlayers()) {
						        if(!playerInWorld.equals(player)) {
						            ItemStack item = CmdFakeArmor.stringToIS((String) DonorDreams.userSettings.getSetting(player.getName(), SETTING_SLOT_2));
						        	((CraftPlayer) playerInWorld).getHandle().playerConnection.sendPacket(new Packet5EntityEquipment(((CraftPlayer) player).getEntityId(), 2, CraftItemStack.asNMSCopy(item)));
						        }
						    }
						}
						if (!((String) DonorDreams.userSettings.getSetting(player.getName(), SETTING_SLOT_3)).equals("")) {
							for(Player playerInWorld : PLUGIN.getServer().getOnlinePlayers()) {
						        if(!playerInWorld.equals(player)) {
						            ItemStack item = CmdFakeArmor.stringToIS((String) DonorDreams.userSettings.getSetting(player.getName(), SETTING_SLOT_3));
						        	((CraftPlayer) playerInWorld).getHandle().playerConnection.sendPacket(new Packet5EntityEquipment(((CraftPlayer) player).getEntityId(), 3, CraftItemStack.asNMSCopy(item)));
						        }
						    }
						}
						if (!((String) DonorDreams.userSettings.getSetting(player.getName(), SETTING_SLOT_4)).equals("")) {
							for(Player playerInWorld : PLUGIN.getServer().getOnlinePlayers()) {
						        if(!playerInWorld.equals(player)) {
						            ItemStack item = CmdFakeArmor.stringToIS((String) DonorDreams.userSettings.getSetting(player.getName(), SETTING_SLOT_4));
						        	((CraftPlayer) playerInWorld).getHandle().playerConnection.sendPacket(new Packet5EntityEquipment(((CraftPlayer) player).getEntityId(), 4, CraftItemStack.asNMSCopy(item)));
						        }
						    }
						}
					}
				}
			}
		 
		}, 0L, 15L);
	}

}
