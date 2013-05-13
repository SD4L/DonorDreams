package com.schautdollar.DonorDreams.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.enchantments.*;
import org.bukkit.inventory.ItemStack;

import com.schautdollar.DonorDreams.DonorDreams;

public class CmdEnchant implements ICommand {


	final String COMMAND = "enchant";
	final String PERMISSION_NODE = "donordreams.enchantcommand";
	final String PERMISSION_NODE_2 = "donordreams.enchantmentlevel";

	public String getCommand() {
		return this.COMMAND;
	}
	
	public String getPermissionNode(){
		return this.PERMISSION_NODE;
	}

	public boolean runCommand(CommandSender sender, Command cmd, String lbl, String[] args) {
		
		if(cmd.getName().equalsIgnoreCase(COMMAND)) {
			if(sender instanceof Player) {
				Player player = (Player) sender;
				if(DonorDreams.permManager.playerHasPerm(player, PERMISSION_NODE)) {
				
					ItemStack itemInHand = player.getItemInHand();
					Enchantment ench;
					
					if(args.length == 0) {
						player.sendMessage("");
						player.sendMessage("");
						player.sendMessage("");
						player.sendMessage("");
						player.sendMessage("");
					}
					
					//always level 1
					else if(args.length == 1) {
						if(args[0] == Enchantment.DURABILITY.getName()) {
							ench = Enchantment.DURABILITY;
							itemInHand.addEnchantment(ench, 1);
						}
					}
					
					else if(args.length == 2) {
						if(DonorDreams.permManager.playerHasPerm(player, PERMISSION_NODE_2)) {
							if(args[0] == Enchantment.DURABILITY.getName()) {
								int level = Integer.parseInt(args[1]);
								if(level > 0) {
									ench = Enchantment.DURABILITY;
									itemInHand.addEnchantment(ench, level);
								}
							}
						}
					}
					
				} else {
					player.sendMessage(ChatColor.RED + "You don't have the permission to perform this command!");
				}
			}
		}
		return false;
	}
}