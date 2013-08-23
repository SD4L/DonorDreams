package com.schautdollar.DonorDreams.Commands;

import java.util.Hashtable;

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
		//Create required commands and add them to the hashtable
		this.addCommand(new CmdDonorDreams());
		//Check optional commands and add them to the hashtable
		if(DonorDreams.configManager.isCommandEnabled("hat"))
			this.addCommand(new CmdHat());
		if(DonorDreams.configManager.isCommandEnabled("god"))
			this.addCommand(new CmdGod());
		if(DonorDreams.configManager.isCommandEnabled("hoveringitem"))
			this.addCommand(new CmdHoveringItem());
		if(DonorDreams.configManager.isCommandEnabled("clearchat"))
			this.addCommand(new CmdClearChat());
		if(DonorDreams.configManager.isCommandEnabled("clearinv"))
			this.addCommand(new CmdClearInventory());
		if(DonorDreams.configManager.isCommandEnabled("donorchat"))
			this.addCommand(new CmdDonorChat());
		if(DonorDreams.configManager.isCommandEnabled("donordreams"))
			this.addCommand(new CmdDonorDreams());
		if(DonorDreams.configManager.isCommandEnabled("enchant"))
			this.addCommand(new CmdEnchant());
		if(DonorDreams.configManager.isCommandEnabled("enchantingtable"))
			this.addCommand(new CmdEnchantingTable());
		if(DonorDreams.configManager.isCommandEnabled("fakearmor"))
			this.addCommand(new CmdFakeArmor());
		if(DonorDreams.configManager.isCommandEnabled("feed"))
			this.addCommand(new CmdFeed());
		if(DonorDreams.configManager.isCommandEnabled("firework"))
			this.addCommand(new CmdFireWork());
		if(DonorDreams.configManager.isCommandEnabled("fireworkride"))
			this.addCommand(new CmdFireWorkRide());
		if(DonorDreams.configManager.isCommandEnabled("fly"))
			this.addCommand(new CmdFly());
		if(DonorDreams.configManager.isCommandEnabled("heal"))
			this.addCommand(new CmdHeal());
		if(DonorDreams.configManager.isCommandEnabled("revive"))
			this.addCommand(new CmdRevive());
		if(DonorDreams.configManager.isCommandEnabled("sudo"))
			this.addCommand(new CmdSudo());
		if(DonorDreams.configManager.isCommandEnabled("workbench"))
			this.addCommand(new CmdWorkBench());
		//if(DonorDreams.configManager.isCommandEnabled("doublejump"))
			//this.addCommand(new CmdWorkBench());
		//etc
		
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
