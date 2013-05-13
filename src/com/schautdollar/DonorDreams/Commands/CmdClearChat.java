package com.schautdollar.DonorDreams.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.schautdollar.DonorDreams.DonorDreams;

public class CmdClearChat implements ICommand {

	final String COMMAND = "clearchat";
	final String PERMISSION_NODE = "donordreams.clearchat";
	
	public String getCommand() {
		return this.COMMAND;
	}

	public String getPermissionNode() {
		return this.PERMISSION_NODE;
	}
	public boolean runCommand(CommandSender sender, Command cmd, String lbl, String[] args) {
		
		if(cmd.getName().equalsIgnoreCase(this.COMMAND)) {
			if(sender instanceof Player) {
				Player player = (Player) sender;
				if(DonorDreams.permManager.playerHasPerm(player, this.PERMISSION_NODE)) {
				
					for(int i = 0; i < 50; i++) 
						player.sendMessage("      ");
					
				}
			}
		}
		return false;
	}
}