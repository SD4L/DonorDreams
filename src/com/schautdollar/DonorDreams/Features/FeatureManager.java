package com.schautdollar.DonorDreams.Features;

import java.util.Hashtable;

import org.bukkit.plugin.PluginManager;

import com.schautdollar.DonorDreams.DonorDreams;

public class FeatureManager {

	private final DonorDreams PLUGIN;
	private Hashtable<String, IFeature> features;

	public FeatureManager(final DonorDreams plugin) {
		this.PLUGIN = plugin;
		this.features = new Hashtable<String, IFeature>();
		PluginManager pm = plugin.getServer().getPluginManager();

		FtrDonorDreams ftrDD = new FtrDonorDreams();
		pm.registerEvents(ftrDD, plugin);
		this.addFeature(ftrDD);

		if (DonorDreams.configManager.isFeatureEnabled("god")){
			FtrGod ftrGod = new FtrGod();
			pm.registerEvents(ftrGod, plugin);
			this.addFeature(ftrGod);
		}
		if (DonorDreams.configManager.isFeatureEnabled("hoveringitem")){
			FtrHoveringItem ftrHoveringItem = new FtrHoveringItem();
			pm.registerEvents(ftrHoveringItem, plugin);
			this.addFeature(ftrHoveringItem);
		}
		if (DonorDreams.configManager.isFeatureEnabled("doublejump")){
			FtrDoubleJump ftrDoubleJump = new FtrDoubleJump();
			pm.registerEvents(ftrDoubleJump, plugin);
			this.addFeature(ftrDoubleJump);
		}
		if (DonorDreams.configManager.isFeatureEnabled("fireworkride")){
			FtrFireworkRide ftrFireWorkRide = new FtrFireworkRide();
			pm.registerEvents(ftrFireWorkRide, plugin);
			this.addFeature(ftrFireWorkRide);
		}
		if (DonorDreams.configManager.isFeatureEnabled("lavatowater")){
			FtrLavaToWater ftrLavaToWater = new FtrLavaToWater();
			pm.registerEvents(ftrLavaToWater, plugin);
			this.addFeature(ftrLavaToWater);
		}
		if (DonorDreams.configManager.isFeatureEnabled("fakearmor")){
			FtrFakeArmor ftrFakeArmor = new FtrFakeArmor(plugin);
			pm.registerEvents(ftrFakeArmor, plugin);
			this.addFeature(ftrFakeArmor);
		}
		if (DonorDreams.configManager.isFeatureEnabled("donorchat")){
			FtrDonorChat ftrDonorChat = new FtrDonorChat();
			pm.registerEvents(ftrDonorChat, plugin);
			this.addFeature(ftrDonorChat);
		}
		if (DonorDreams.configManager.isFeatureEnabled("tombchest")){
			FtrTombstone ftrTombstone = new FtrTombstone();
			pm.registerEvents(ftrTombstone, plugin);
			this.addFeature(ftrTombstone);
		}

	}

	/**
	 * @param feature
	 */
	public void addFeature(IFeature feature) {
		this.features.put(feature.getFeatureName(), feature);
	}

	/**
	 * @param feature
	 * @return
	 */
	public boolean doesFeatureExist(String feature) {
		return this.features.contains(feature);
	}

	/**
	 * @param feature
	 */
	public void removeFeature(String feature) {
		if (this.features.contains(feature))
			this.features.remove(feature);
	}

	/**
	 * @param feature
	 *            The requested feature.
	 * @return Returns the requested feature if found, otherwise returns null.
	 */
	public IFeature getFeature(String feature) {
		if (this.features.contains(feature))
			return this.features.get(feature);
		return null;
	}

}
