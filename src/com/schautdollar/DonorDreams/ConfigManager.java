package com.schautdollar.DonorDreams;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author SchautDollar, Molen
 *
 */
public class ConfigManager extends JavaPlugin {
	
	
	final String BASE_NODE = "DonorDreams";
    final DonorDreams PLUGIN;
	private FileConfiguration config;
	
	/**
	 * @param plugin
	 */
	public ConfigManager(final DonorDreams plugin){
		this.PLUGIN = plugin;
	}
	
	/**
	 * @param feature The feature to check.
	 * @return True or False depending on if feature is enabled.
	 */
	public boolean isFeatureEnabled(String feature){
		return config.getBoolean(this.BASE_NODE + ".Features." + feature + ".Enabled");
	}
	public void saveDefaultts(){
		//
		this.PLUGIN.getConfig().options().copyDefaults(true);
		this.config = getConfig();
		//this.config.options().header(Config.configHeader);
		this.PLUGIN.saveConfig();
	}
	/**
	 * Loads the configuration from the disk.
	 */
	public void loadConfig(){
		this.PLUGIN.reloadConfig();
		this.config = this.PLUGIN.getConfig();
	}
	
	/**
	 * Saves the configuration to the disk. Will overwrite any changes made to file.
	 */
	public void saveConfig(){
		getConfig().options().copyDefaults(true);
		this.config = this.PLUGIN.getConfig();//Gets old settings
		
		//this.PLUGIN.config.options().header(configHeader);
		
		//this.PLUGIN.config.set("SD.Messages", helpMessages);
		
		saveConfig();
	}
	
	/**
	 * 
	 */
	public void reloadConfig(){
		this.loadConfig();
	}
	
	/**
	 * 
	 */
	public void resetConfig(){
		
	}

	public boolean isMetricsEnabled() {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
