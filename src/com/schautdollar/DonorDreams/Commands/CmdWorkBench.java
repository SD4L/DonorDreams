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
public class CmdWorkBench implements ICommand {
	

	final String COMMAND = "workbench";
	final String PERMISSION_NODE = "donordreams.workbench";

	public String getCommand() {
		
		return this.COMMAND;
	}
	
	public String getPermissionNode(){
		return this.PERMISSION_NODE;
	}

	public boolean runCommand(CommandSender sender, Command cmd, String lbl,
			String[] args) {
		Player player = (Player) sender;
		
		if(cmd.getName().equalsIgnoreCase(COMMAND) && DonorDreams.permManager.playerHasPerm(player, PERMISSION_NODE)){
			
			player.openWorkbench(null,true);
			
			
		}else{
			player.sendMessage(ChatColor.RED + "You do not have permission.");
			return true;
		}
		
		
		
		return false;
	}
	
	

}
