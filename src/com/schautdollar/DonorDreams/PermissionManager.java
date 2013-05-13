package com.schautdollar.DonorDreams;

import java.util.Hashtable;
import java.util.List;

import org.bukkit.entity.Player;

public class PermissionManager {

	final DonorDreams PLUGIN;
	private Hashtable<String,List<String>> groupCommands;
	
	public PermissionManager(final DonorDreams plugin){
		this.PLUGIN = plugin;
		this.groupCommands = new Hashtable<String,List<String>>();
	}
	public boolean playerHasPerm(Player player, String permNode){
		if(player.hasPermission(permNode) || player.isOp())
			return true;
		else if(this.groupCommands.size() > 0)
			for(String group : this.groupCommands.keySet())
				if(this.groupHasPerm(group, permNode))
					return true;
		return false;
	}
	private boolean groupHasPerm(String group, String permNode){
		if(this.groupCommands.size() > 0 && this.groupCommands.containsKey(group))
			return this.groupCommands.get(group).contains(permNode);
		return false;
	}

}
