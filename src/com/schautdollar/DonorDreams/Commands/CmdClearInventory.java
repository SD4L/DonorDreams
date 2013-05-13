package com.schautdollar.DonorDreams.Commands;

import org.bukkit.ChatColor;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.schautdollar.DonorDreams.DonorDreams;

/*
 * Author: Burnett1
 * 
 */

public class CmdClearInventory implements ICommand {

	
	final String COMMAND = "clearinv";
	final String PERMISSION_NODE = "donordreams.clearinv";
	
	
	@Override
	public String getCommand() {
		return this.COMMAND;
	}
	
	public String getPermissionNode(){
		
		return this.PERMISSION_NODE;
	}

	@Override
	public boolean runCommand(CommandSender sender, Command cmd, String lbl,
			String[] args) {
		
		Player player = (Player) sender;
		
		if(cmd.getName().equalsIgnoreCase(this.COMMAND) && DonorDreams.permManager.playerHasPerm(player, this.PERMISSION_NODE)){
			
			player.getInventory().clear();
			
			
		}else{
			player.sendMessage(ChatColor.RED + "You do not have permission to do this.");
			return true;
		}
		
		
		
		
		return false;
	}

}
