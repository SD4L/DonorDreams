package com.schautdollar.DonorDreams.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.schautdollar.DonorDreams.DonorDreams;

/**
 *
 * @author Shinxs, SchautDollar
 *
 */

public class CmdGod implements ICommand {

	final String SETTING_ISGOD = "isGod";
	final String COMMAND = "god";
	final String PERMISSION_NODE = "donordreams.admin";

	public String getCommand() {
		return this.COMMAND;
	}

	public String getPermissionNode() {
		return this.PERMISSION_NODE;
	}

	public boolean runCommand(CommandSender sender, Command cmd, String lbl, String[] args) {
		Player player = (Player) sender;

		DonorDreams.userSettings.getSetting(player.getName(), "isGod"); //example

		if(cmd.getName().equalsIgnoreCase(this.COMMAND)) {
			if(sender instanceof Player) {
				if(DonorDreams.permManager.playerHasPerm(player, this.PERMISSION_NODE)) {
					if((Boolean)DonorDreams.userSettings.getSetting(player.getName(), "isGod")) {


						player.setAllowFlight(false);
						player.setFlying(false);

						player.sendMessage(ChatColor.GOLD + "You are not a god anymore!");
						//Set setting for user that they are no longer in god mode
						DonorDreams.userSettings.setSetting(player.getName(), this.SETTING_ISGOD, false);

					} else {
						player.sendMessage(ChatColor.GOLD + "You are a god now!");
						player.setAllowFlight(true);

						//Set setting for user that they are now in god mode
						DonorDreams.userSettings.setSetting(player.getName(), this.SETTING_ISGOD, true);
					}
				} else {
					player.sendMessage(ChatColor.RED + "You don't have the permission for this command!");
				}
			}
		}
		return false;
	}
}