package com.schautdollar.DonorDreams.Commands;

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
		Player player = (Player) sender;
		
		if(cmd.getName().equalsIgnoreCase(this.COMMAND)) {
			if(sender instanceof Player) {
				if(DonorDreams.permManager.playerHasPerm(player, this.PERMISSION_NODE)) {
					ItemStack itemInHand = player.getItemInHand();
					player.getInventory().setItemInHand(player.getInventory().getHelmet());
					player.getInventory().setHelmet(itemInHand);
				}
			}
		}
		return false;
	}
}
