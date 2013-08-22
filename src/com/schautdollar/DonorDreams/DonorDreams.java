package com.schautdollar.DonorDreams;

import java.io.IOException;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import com.schautdollar.DonorDreams.Commands.CommandManager;
import com.schautdollar.DonorDreams.Features.FeatureManager;

/**
 * @author SchautDollar, Shinxs
 * 
 * http://dev.bukkit.org/server-mods/donor-dreams/
 *
 */

public class DonorDreams extends JavaPlugin {
	
	/**
	 * Prefix for messages being logged here.
	 */
	public static final String PREFIX = "[DD]";
	
	/**
	 * The logger for DonorDreams. Private forces logMessage() usage.
	 */
	private static Logger log;
	
	/**
	 * The Permissions manager for Donor Dreams.
	 */
	public static PermissionManager permManager;
	
	/**
	 * 
	 */
	public static ConfigManager configManager;
	/**
	 * 
	 */
	public static UserSettings userSettings;
	/**
	 * 
	 */
	public static FeatureSettings featureSettings;
	
	public static CommandManager commandManager;
	
	public static FeatureManager featureManager;
	public static Metrics metrics;
	/**
	 * @param msg Message to be displayed for log.
	 */
	public static void logMessage(String msg) {
		log.info(PREFIX + " " + msg);
	}
	
	final String SETTING_IS_IN_CHAT = "isInChat";
	final String SETTING_CHAT_NAME = "chatname"; 
	final String SETTING_IS_OWNER = "isOwner";
	final String SETTING_HAS_INVITE = "hasInvite"; 
	
	public void onEnable() {
		DonorDreams.log = Bukkit.getLogger();
		
		DonorDreams.configManager = new ConfigManager(this);
		
		DonorDreams.configManager.loadConfig();
		
		DonorDreams.permManager = new PermissionManager(this);
		
		DonorDreams.featureSettings = new FeatureSettings(this);
		DonorDreams.userSettings = new UserSettings(this);
		
		DonorDreams.commandManager = new CommandManager(this);
		
		DonorDreams.featureManager = new FeatureManager(this);
		
		if(DonorDreams.configManager.isMetricsEnabled())
			try {
				DonorDreams.metrics = new Metrics(this);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		DonorDreams.logMessage("Enabled");
		
	}
	
	public void onDisable() {
		
		for(Player p : Bukkit.getServer().getOnlinePlayers()){
			DonorDreams.userSettings.setSetting(p.getName(),this.SETTING_CHAT_NAME, null);
			DonorDreams.userSettings.setSetting(p.getName(),this.SETTING_HAS_INVITE, false);
			DonorDreams.userSettings.setSetting(p.getName(),this.SETTING_IS_IN_CHAT, false);
			DonorDreams.userSettings.setSetting(p.getName(),this.SETTING_IS_OWNER, null);
		}
		
		DonorDreams.logMessage("Disabled");
	}
	public void registerCommand(String cmd, CommandExecutor cmdExecutor){
		getCommand(cmd).setExecutor(cmdExecutor);
	}
	
	
}
