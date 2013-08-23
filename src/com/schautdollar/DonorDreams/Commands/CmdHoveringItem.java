package com.schautdollar.DonorDreams.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.schautdollar.DonorDreams.DonorDreams;

/**
 * @author Shinxs, SchautDollar
 *	Sets whatever is in the hand of player as the helmet for player while moving helmet to hand.
 */
public class CmdHoveringItem implements ICommand{

	final String SETTING_HI = "hoveringitem";
	final String COMMAND = "hoveringitem";
	final String PERMISSION_NODE = "donordreams.hi";

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
					//I need some way to get the feature class! How would i do that?
					//REPLY - use user settings
					if (DonorDreams.userSettings.doesSettingExists(player.getName(), this.SETTING_HI)){
						int currentItem = (Integer)DonorDreams.userSettings.getSetting(player.getName(), this.SETTING_HI);
						if (this.hasHoveringItem(player)) {
							this.removeHoveringItem(player);
							this.addHoveringItemToPlayer(player, player.getItemInHand());
						} else {
							this.addHoveringItemToPlayer(player, player.getItemInHand());
						}
					}
				}
			}
		}
		return false;
	}
	/**
	 * @param p
	 * @param itemStack
	 */
	public void addHoveringItemToPlayer(Player p, ItemStack itemStack) {
		Item i = p.getWorld().dropItem(p.getLocation(), itemStack);
		DonorDreams.userSettings.setSetting(p.getName(), this.SETTING_HI, i.getEntityId());
		p.setPassenger(i);
	}
	public boolean hasHoveringItem(Player p) {
		if (DonorDreams.userSettings.doesSettingExists(p.getName(), this.SETTING_HI))
			return true;
		return false;
	}

	// Remove the hovering item
	public void removeHoveringItem(Player p) {
		p.getPassenger().remove();
		DonorDreams.userSettings.removeSetting(p.getName(), this.SETTING_HI);
	}

}
