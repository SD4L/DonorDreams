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
	final String PERMISSION_NODE_OTHERS = "donordreams.workbench.others";

	public String getCommand() {
		
		return this.COMMAND;
	}
	
	public String getPermissionNode(){
		return this.PERMISSION_NODE;
	}

	public boolean runCommand(CommandSender sender, Command cmd, String lbl, String[] args) {
		if(cmd.getName().equalsIgnoreCase(this.COMMAND)) {
			if(sender instanceof Player) {
				Player player = (Player) sender;
				if(DonorDreams.permManager.playerHasPerm(player, this.PERMISSION_NODE)){
					if(args.length == 0){
						player.openWorkbench(null,true);
						return true;
					}else if(args.length == 1 && DonorDreams.permManager.playerHasPerm(player, PERMISSION_NODE_OTHERS)){
						player.getServer().getPlayer(args[0]).openWorkbench(null,true);;
						return true;
					}else{
						player.sendMessage(ChatColor.RED + "You do not have permission to lend a portable workbench.");
						return true;
					}
				}
				else{
					player.sendMessage(ChatColor.RED + "You do not have permission to use a portable workbench.");
					return true;
				}
			}
			else{
				//implement TARGETED PLAYER
				DonorDreams.logMessage(ChatColor.RED + "Silly console. The command \"" + this.getCommand() + "\" can only be used by a player.");
				return true;
			}
		}
		else
			return false;
	}
}
