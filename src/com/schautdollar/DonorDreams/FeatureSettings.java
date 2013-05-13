package com.schautdollar.DonorDreams;

import java.util.Hashtable;

public class FeatureSettings {

	private final DonorDreams PLUGIN;
	private final String USER_SETTINGS_FOLDER_NAME = "feature_settings";
	private Hashtable<String, Hashtable<String, Object>> settings;
	
	/**
	 * @param plugin
	 */
	public FeatureSettings(final DonorDreams plugin){
		this.PLUGIN = plugin;
	}
	/**
	 * @param feature
	 */
	public void loadFeaturesSettings(String feature){
	
	}
	/**
	 * @param feature
	 */
	public void saveFeaturesSettings(String feature){
		
	}
	/**
	 * @param feature
	 */
	public void unloadFeaturesSettings(String feature){
		
	}
	/**
	 * @param feature
	 */
	public void purgeFeaturesSettings(String feature){
		
	}
	/**
	 * @param feature
	 * @param setting
	 * @return
	 */
	public Object getSetting(String feature, String setting){
		if(this.doesSettingExists(feature, setting))
			return this.settings.get(feature).get(setting);
		return null;
	}
	/**
	 * @param feature
	 * @param setting
	 * @param value
	 */
	public void setSetting(String feature, String setting, Object value){
		if(!this.isFeatureLoadedIntoSettings(feature))
			this.settings.put(feature,new Hashtable<String, Object>());
		this.settings.get(feature).put(setting, value);
	
	}
	/**
	 * @param feature
	 * @return
	 */
	public boolean isFeatureLoadedIntoSettings(String feature){
		return this.settings.containsKey(feature);
	}
	/**
	 * @param feature
	 * @param setting
	 * @return
	 */
	public boolean doesSettingExists(String feature, String setting){
		if(this.isFeatureLoadedIntoSettings(feature) && this.settings.get(feature).containsKey(setting))
			return true;
		return false;
	}
	 
	/**
	 * @param feature
	 * @param setting
	 */
	public void removeSetting(String feature,String setting){
		if(this.doesSettingExists(feature, setting))
			this.settings.get(feature).remove(setting);
	}
	
}
