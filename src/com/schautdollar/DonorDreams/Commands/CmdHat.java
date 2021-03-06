package com.schautdollar.DonorDreams.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.schautdollar.DonorDreams.DonorDreams;

/**
 * @author Shinxs, SchautDollar
 *	Sets whatever is in the hand of player as the helmet for player while moving helmet to hand.
 */
public class CmdHat implements ICommand {

	final String COMMAND = "hat";
	final String PERMISSION_NODE = "donordreams.hat";

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
					ItemStack itemInHand = player.getItemInHand();
					if(itemInHand.getAmount() > 0 || player.getInventory().getHelmet() != null){
						player.getInventory().setItemInHand(player.getInventory().getHelmet());
						player.getInventory().setHelmet(itemInHand);
						player.sendMessage(ChatColor.GRAY + "Nice Hat!");
						return true;
					}
					else{
						player.sendMessage(ChatColor.RED + "You need to be holding something or wearing a hat!");
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
