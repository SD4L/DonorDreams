package com.schautdollar.DonorDreams.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;


 
/**
 * @author SchautDollar
 *
 */
public interface ICommand {
	
	/**
	 * @return Returns the relating command.
	 */
    String getCommand();
	/**
	 * @param sender The command instantiator. Either player, console, or another command.
	 * @param cmd The command being ran.
	 * @param lbl The label of the command.
	 * @param args The arguments give to the command.
	 * @return
	 */
	boolean runCommand(CommandSender sender,
							Command cmd,
								String lbl,
									String[] args);

}
