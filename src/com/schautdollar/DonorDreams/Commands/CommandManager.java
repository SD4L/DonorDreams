package com.schautdollar.DonorDreams.Commands;

import java.util.Hashtable;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.schautdollar.DonorDreams.DonorDreams;

/**
 * @author SchautDollar
 *
 */
public class CommandManager implements CommandExecutor {
	
	private Hashtable<String, ICommand> commands;
	private final DonorDreams PLUGIN;
	/**
	 * @param plugin
	 */
	public CommandManager(final DonorDreams plugin){
		this.PLUGIN = plugin;
		this.commands = new Hashtable<String, ICommand>();
		/*Create required commands and add them to the hashtable*/
		this.addCommand(new CmdDonorDreams());
		this.addCommand(new CmdHat()); //Working
		//this.addCommand(new CmdGod()); 
		//this.addCommand(new CmdHoveringItem());
		this.addCommand(new CmdClearChat()); //Working
		this.addCommand(new CmdClearInventory()); //Working
		//this.addCommand(new CmdDonorChat());
		//this.addCommand(new CmdEnchant());
		this.addCommand(new CmdEnchantingTable()); //Working
		//this.addCommand(new CmdFakeArmor());
		this.addCommand(new CmdFeed()); //Working
		//this.addCommand(new CmdFireWork());
		//this.addCommand(new CmdFireWorkRide());
		this.addCommand(new CmdFly()); //Working
		this.addCommand(new CmdHeal()); //Working
		this.addCommand(new CmdRevive()); //Working
		//this.addCommand(new CmdSudo());
		this.addCommand(new CmdWorkBench()); //Working
		this.addCommand(new CmdRepair()); //Working
		
	}
	
	/**
	 * @param sender
	 * @param cmd
	 * @param lbl
	 * @param args
	 * @return
	 */
	public boolean onCommand(CommandSender sender, Command cmd, String lbl, String[] args) {
		//DonorDreams.logMessage("Command Used: " + cmd.getName());
		if(this.doesCommandExist(cmd.getName())){
			//DonorDreams.logMessage("Command About To Be Ran: " + cmd.getName());
			return this.commands.get(cmd.getName()).runCommand(sender, cmd, lbl, args);
		}
		DonorDreams.logMessage(ChatColor.RED + "The command \"" + cmd + "\" does not seem to exist here. Contact a developer!");
		return false;
	} 
	
	/**
	 * @param cmd
	 */
	public void addCommand(ICommand cmd) {
		this.PLUGIN.registerCommand(cmd.getCommand(), this);
		//DonorDreams.logMessage(cmd.getCommand() + " Registered");
		this.commands.put(cmd.getCommand(), cmd);
	}
	
	/**
	 * @param cmd
	 * @return
	 */
	public boolean doesCommandExist(String cmd) {
		return this.commands.containsKey(cmd);
	}
	
	/**
	 * @param cmd
	 */
	public void removeCommand(String cmd) {
		if(this.doesCommandExist(cmd))
			this.commands.remove(cmd);
	}
	
	/**
	 * @param cmd
	 * @return
	 */
	public ICommand getCommand(String cmd){
		if(this.doesCommandExist(cmd))
			return this.commands.get(cmd);
		return null;
	}
}
