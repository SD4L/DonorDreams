package com.schautdollar.DonorDreams.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.schautdollar.DonorDreams.DonorDreams;

public class CmdRepair implements ICommand {

	final String COMMAND = "repair"; 
	final String PERMISSION_NODE = "donordreams.repair";
	
	public String getCommand() {
		return this.COMMAND;
	}

	public String getPermission() {
		return this.PERMISSION_NODE;
	}
	
	public boolean runCommand(CommandSender sender, Command cmd, String lbl,String[] args) {
		if(cmd.getName().equalsIgnoreCase(this.COMMAND)) {
			if(sender instanceof Player) {
				Player player = (Player) sender;
				if(DonorDreams.permManager.playerHasPerm(player, this.PERMISSION_NODE)) {					
					ItemStack itemInHand = player.getItemInHand();
					if(itemInHand.getAmount() > 0){
						itemInHand.setDurability((short)0);
						player.sendMessage(ChatColor.GRAY + "Repaired!");
						return true;
					}
					else{
						player.sendMessage(ChatColor.RED + "You need to be holding something to repair.");
						return true;					
					}
				}
				else{
					player.sendMessage(ChatColor.RED + "You do not have permissions to use " + this.getCommand() + ".");
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