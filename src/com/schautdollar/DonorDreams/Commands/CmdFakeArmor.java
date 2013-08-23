package com.schautdollar.DonorDreams.Commands;

import net.minecraft.server.v1_6_R2.Packet5EntityEquipment;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_6_R2.inventory.CraftItemStack;
import org.bukkit.craftbukkit.v1_6_R2.entity.CraftPlayer;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.schautdollar.DonorDreams.DonorDreams;
/*
 * Author: Burnett1
 *
 */
public class CmdFakeArmor implements ICommand {


	final String COMMAND = "fakearmor";
	final String PERMISSION_NODE = "donordreams.fakearmor";
	final String SETTING_ISUSING_FAKE = "faActive";
	final String SETTING_SLOT_1 = "fakeArmor1";
	final String SETTING_SLOT_2 = "fakeArmor2";
	final String SETTING_SLOT_3 = "fakeArmor3";
	final String SETTING_SLOT_4 = "fakeArmor4";


	public String getCommand() {

		return this.COMMAND;
	}

	public String getPermissionNode(){
		return this.PERMISSION_NODE;
	}

	public boolean runCommand(CommandSender sender, Command cmd, String lbl,
			String[] args) {
		Player player = (Player) sender;

		if (cmd.getName().equalsIgnoreCase(COMMAND) && DonorDreams.permManager.playerHasPerm(player, PERMISSION_NODE)){
			if (args.length > 1 || args.length < 1) {
				DonorDreams.userSettings.setSetting(player.getName(), SETTING_ISUSING_FAKE, false);
				player.sendMessage(ChatColor.RED + "Stopped using fake armor");
				return true;
			}
			switch (Integer.parseInt(args[0])) {
			case 1:
				DonorDreams.userSettings.setSetting(player.getName(), SETTING_ISUSING_FAKE, true);
				DonorDreams.userSettings.setSetting(player.getName(), SETTING_SLOT_1, IStoString(player.getItemInHand()));
				break;
			case 2:
				DonorDreams.userSettings.setSetting(player.getName(), SETTING_ISUSING_FAKE, true);
				DonorDreams.userSettings.setSetting(player.getName(), SETTING_SLOT_2, IStoString(player.getItemInHand()));
				break;
			case 3:
				DonorDreams.userSettings.setSetting(player.getName(), SETTING_ISUSING_FAKE, true);
				DonorDreams.userSettings.setSetting(player.getName(), SETTING_SLOT_3, IStoString(player.getItemInHand()));
				break;
			case 4:
				DonorDreams.userSettings.setSetting(player.getName(), SETTING_ISUSING_FAKE, true);
				DonorDreams.userSettings.setSetting(player.getName(), SETTING_SLOT_4, IStoString(player.getItemInHand()));
				break;
			default:
				player.sendMessage(ChatColor.RED + "Wrong usage! Use /fa <slot> \n Slots are 1-4 for armor");
				return true;
			}
		} else {
			player.sendMessage(ChatColor.RED + "You do not have permission.");
			return true;
		}
		return false;
	}

	public static String IStoString(ItemStack st) {
		boolean enchanted = false;
		for (Enchantment c : Enchantment.values()) {
			if (st.containsEnchantment(c)) enchanted = true;
		}
		String str = new StringBuilder().append(st.getTypeId()).append(":").append(String.valueOf(enchanted)).toString();
		return str;
	}
	public static void sendFakeArmorPacket(Player fromPlayer, Player toPlayer, int slot, ItemStack item) {
		Packet5EntityEquipment packet = new Packet5EntityEquipment(((CraftPlayer) fromPlayer).getEntityId(), slot, CraftItemStack.asNMSCopy(item));
		((CraftPlayer) toPlayer).getHandle().playerConnection.sendPacket(packet);
	}
	public static ItemStack stringToIS(String str) {
		String[] values = str.split(":");
		ItemStack i = new ItemStack(Integer.parseInt(values[0]));
		if (Boolean.getBoolean(values[1])) {
			i.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, -1);
		}
		return i;
	}
}
