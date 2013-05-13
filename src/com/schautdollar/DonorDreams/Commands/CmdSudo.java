package com.schautdollar.DonorDreams.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.schautdollar.DonorDreams.DonorDreams;

/**
 * 
 * @author Shinxs
 *
 */

public class CmdSudo implements ICommand {

	final String COMMAND = "sudo";
	final String PERMISSION_NODE = "donordreams.sudo";
	
	public String getCommand() {
		return this.COMMAND;
	}

	public String getPermissionNode() {
		return this.PERMISSION_NODE;
	}

	public boolean runCommand(CommandSender sender, Command cmd, String lbl, String[] args) {
		
		if(cmd.getName().equalsIgnoreCase(COMMAND)) {
			if(sender instanceof Player) {
				Player player = (Player) sender;
				if(DonorDreams.permManager.playerHasPerm(player, PERMISSION_NODE)) {
					
					if(args.length == 1) {
						Player tPlayer = player.getServer().getPlayer(args[0]);
						player.setDisplayName(tPlayer.getName());
					} else {
						player.sendMessage(ChatColor.RED + "Inproper Syntax: /sudo <target name> <message>");
					}
				}
			}
		}
		
		return false;
	}
}