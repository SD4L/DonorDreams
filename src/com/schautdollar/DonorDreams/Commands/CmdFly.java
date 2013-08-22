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

public class CmdFly implements ICommand {

	final String COMMAND = "fly"; 
	final String PERMISSION_NODE = "donordreams.fly";
	
	public String getCommand() {
		return this.COMMAND;
	}

	public String getPermission() {
		return this.PERMISSION_NODE;
	}
	
	public boolean runCommand(CommandSender sender, Command cmd, String lbl,String[] args) {
		
		if(cmd.getName().equalsIgnoreCase(COMMAND)) {
			if(sender instanceof Player) {
				Player player = (Player) sender;
				if(DonorDreams.permManager.playerHasPerm(player, this.PERMISSION_NODE)) {
					Object isFlying = DonorDreams.userSettings.getSetting(player.getName(), "isFlying");
					if(isFlying != null && isFlying instanceof Boolean && (Boolean)isFlying) {
						player.setAllowFlight(false);
						player.setFlying(false);
						DonorDreams.userSettings.setSetting(player.getName(), "isFlying", false);
						player.sendMessage(ChatColor.GRAY + "Flying Disabled!");
						return true;
					} 
					else {
						player.setAllowFlight(true);
						DonorDreams.userSettings.setSetting(player.getName(), "isFlying", true);
						player.sendMessage(ChatColor.GRAY + "Flying Enabled!");
						return true;
					}
				} 
				else {
					player.sendMessage(ChatColor.RED + "You don't have permissions to fly!");
					return true;
				}
			}
			else{
				DonorDreams.logMessage(ChatColor.RED + "Silly console. The command \"" + this.getCommand() + "\" can only be used by a player.");
				return true;
			}
		}
		else
			return false;
	}
}