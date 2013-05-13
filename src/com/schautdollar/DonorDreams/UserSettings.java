package com.schautdollar.DonorDreams;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;


/**
 * @author SchautDollar
 *
 */
public class UserSettings {
	
	private final DonorDreams PLUGIN;
	private final String USER_SETTINGS_FOLDER_NAME = "user_settings";
	private Hashtable<String, Hashtable<String, Object>> settings;
	private HashMap<String, ConfigAccessor> configFiles = new HashMap<String, ConfigAccessor>();
	
	/**
	 * @param plugin
	 */
	public UserSettings(final DonorDreams plugin){
		this.PLUGIN = plugin;
		this.settings = new Hashtable<String, Hashtable<String, Object>>();
	}
	/**
	 * @param user
	 */
	public void loadUsersSettings(String user){
		if (!configFiles.containsKey(user)) {
			ConfigAccessor config = new ConfigAccessor(this.PLUGIN, this.USER_SETTINGS_FOLDER_NAME+"/config_"+user+".yml");
			config.saveDefaultConfig();
			configFiles.put(user, config);
			Set<String> configKeys = configFiles.get(user).getConfig().getKeys(true);
			if (!this.isUserLoadedIntoSettings(user)) 
				settings.put(user, new Hashtable<String, Object>());
			for (String key : configKeys) {
				if (key.contains("HMAP") || key.contains("HTABLE")) {
					//In case of HashMap, Hashtable
					settings.get(user).put(key.replace("HMAP", "").replace("HTABLE", ""), config.getConfig().getConfigurationSection(key.replace("HMAP", "").replace("HTABLE", "")));
				} else if (key.contains("LIST")) {
					settings.get(user).put(key.replace("LIST", ""), config.getConfig().getList(key));
				} else {
					String strippedKey = key.replace("BLN", "").replace("STR", "").replace("INT", "");
					settings.get(user).put(strippedKey, config.getConfig().get(key));
				}
			}
		}
	}
	/**
	 * @param user
	 */
	@SuppressWarnings("rawtypes")
	public void saveUsersSettings(String user){
		if (configFiles.containsKey(user)) {
			Enumeration<String> keys = settings.get(user).keys();
			while (keys.hasMoreElements()) {
			  String key = keys.nextElement();
			  Object value = settings.get(key);	
			  if (value instanceof String)
				  configFiles.get(user).saveWrapper.saveString(key, (String) value);
			  if (value instanceof Boolean)
				  configFiles.get(user).saveWrapper.saveBoolean(key, (Boolean) value);
			  if (value instanceof Integer)
				  configFiles.get(user).saveWrapper.saveInt(key, (Integer) value);
			  if (value instanceof Object[])
				  configFiles.get(user).saveWrapper.saveArray(key, (Object[]) value);
			  if (value instanceof List)
				  configFiles.get(user).saveWrapper.saveList(key, (List) value);
			  if (value instanceof HashMap)
				  configFiles.get(user).saveWrapper.saveHashMap(key, (HashMap) value);
			  if (value instanceof Hashtable)
				  configFiles.get(user).saveWrapper.saveHashTable(key, (Hashtable) value);
			}
			configFiles.get(user).saveConfig();
		}
	}
	/**
	 * @param user
	 */
	public void unloadUsersSettings(String user){
		if (configFiles.containsKey(user)) {
			configFiles.get(user).saveConfig();
			configFiles.remove(user);
			settings.remove(user);
		}
	}
	/**
	 * @param user
	 */
	public void purgeUsersSettings(String user){
		if (configFiles.containsKey(user)) {
			configFiles.get(user).configFile.delete();
			configFiles.get(user).reloadConfig();
			settings.put(user, new Hashtable<String, Object>());
		}
	}
	/**
	 * @param player
	 * @param setting
	 * @return
	 */
	public Object getSetting(String player, String setting){
		if(this.doesSettingExists(player, setting))
			return this.settings.get(player).get(setting);
		return null;
	}
	/**
	 * @param player
	 * @param setting
	 * @param value
	 */
	public void setSetting(String player, String setting, Object value){
		if(!this.isUserLoadedIntoSettings(player))
			this.settings.put(player,new Hashtable<String, Object>());
		this.settings.get(player).put(setting, value);
	
	}
	/**
	 * @param player
	 * @return
	 */
	public boolean isUserLoadedIntoSettings(String player){
		return this.settings.containsKey(player);
	}
	/**
	 * @param player
	 * @param setting
	 * @return
	 */
	public boolean doesSettingExists(String player, String setting){
		if(this.isUserLoadedIntoSettings(player) && this.settings.get(player).containsKey(setting))
			return true;
		return false;
	}
	
	/**
	 * @param player
	 * @param setting
	 */
	public void removeSetting(String player,String setting){
		if(this.doesSettingExists(player, setting))
			this.settings.get(player).remove(setting);
	}
	
	
	
}