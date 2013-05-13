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

public class CmdHeal implements ICommand{
	
	
	final String COMMAND = "heal";
	final String PERMISSION_NODE = "donordreams.heal";
	final String PERMISSION_NODE_OTHERS = "donordreams.heal.others";

	@Override
	public String getCommand() {
		return this.COMMAND;
	}

	public String getPermissionNode() {
		
		return this.PERMISSION_NODE;
	}
	
	public String getPermissionNodeOthers(){
		return this.PERMISSION_NODE_OTHERS;
	}

	@Override
	public boolean runCommand(CommandSender sender, Command cmd, String lbl,String[] args) {
		Player player = (Player) sender;
		
		
		//Heal will only heal the player, Feed will feed and Revive will do both
		//Where is the revive. Do i set it up or is it already in?
		//It will need to be created. I'll have a list of commands shortly
		if(cmd.getName().equalsIgnoreCase(COMMAND) && DonorDreams.permManager.playerHasPerm(player, this.PERMISSION_NODE)){
			if(args.length == 0){
				player.setHealth(20);
				player.setFireTicks(0);
				player.setFoodLevel(20);
				
				player.sendMessage(ChatColor.GRAY + "Healed!");
				
				return true;
			
			}else if(args.length == 1 && DonorDreams.permManager.playerHasPerm(player, PERMISSION_NODE_OTHERS)){
				Player targetPlayer = player.getServer().getPlayer(args[0]);
				
				targetPlayer.setHealth(20);
				targetPlayer.setFireTicks(0);
				targetPlayer.setFoodLevel(20);
				targetPlayer.sendMessage(ChatColor.GRAY + "You got healed!");
			
				return true;
			}else{
				player.sendMessage(ChatColor.RED + "You do not have permission to do this.");
				return true;
			}
			
		}
			
		return false;
	}
	
	

}
