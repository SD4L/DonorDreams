package com.schautdollar.DonorDreams.Commands;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.schautdollar.DonorDreams.DonorDreams;

/**
 * @author Shinxs
 * 
 * Donor Dreams plugin command.
 * Subcommands:
 * config
 * reload
 * save
 * resetconfig
 */
public class CmdDonorDreams implements ICommand {
	
	final String COMMAND = "donordreams";
	final String PERMISSION_NODE = "donordreams.admin";
	
	public String getCommand() {
		return this.COMMAND;
	}

	public String getPermissionNode() {
		return this.PERMISSION_NODE;
	}

	public boolean runCommand(CommandSender sender, Command cmd, String lbl, String[] args) {
		Player player = (Player) sender;
		
		if(cmd.getName().equalsIgnoreCase(this.COMMAND)) {
			if(args.length == 0) {
				player.sendMessage(ChatColor.GOLD + "==== " + ChatColor.AQUA + "Donor Dreams Help" + ChatColor.GOLD + " ====");
				player.sendMessage("");
				
				// all the subcommands here. See plugin desc.
				player.sendMessage(ChatColor.BLUE + "/dd" + " - " + "Show all of the commands");
			}
			
			else if(args[0].equalsIgnoreCase("admin")) {
				if(DonorDreams.permManager.playerHasPerm(player, this.PERMISSION_NODE)) {
					player.sendMessage(ChatColor.GOLD + "==== " + ChatColor.AQUA + "Donor Dreams Admin Help" + ChatColor.GOLD + " ====");
					player.sendMessage("");
					
					// all the admin subcommands here. See plugin desc.
					player.sendMessage(ChatColor.BLUE + "/dd" + " - " + "Show all of the commands.");
				} else {
					player.sendMessage(ChatColor.RED + "You don't have the permission to run this command!");
				}
			}
			
		}
		
		return false;
	}
	
	public boolean equals(Object obj){
		if (obj == null)
            return false;
        if (obj == this)
            return true;
        if (obj.getClass() != getClass())
            return false;

        CmdDonorDreams other = (CmdDonorDreams) obj;
        return new EqualsBuilder().
            append(this.PERMISSION_NODE, other.PERMISSION_NODE).
            append(this.COMMAND, other.COMMAND).
            isEquals();
	}
	
	public int hashCode(){
		return new HashCodeBuilder(17, 31).
	            append(this.PERMISSION_NODE).
	            append(this.COMMAND).
	            toHashCode();
	}

}