package com.schautdollar.DonorDreams.Features;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import com.schautdollar.DonorDreams.DonorDreams;

public class FtrDonorChat implements IFeature, Listener {
	
	
	final String FEATURE_NAME = "donorchat";
	
	final String SETTING_CHAT_NAME = "chatname";
	final String SETTING_IS_IN_CHAT = "isInChat"; //If a player is in the chat room or not
	final String SETTING_IS_OWNER = "isOwner"; //What room the player is a owner off.
	final String SETTING_HAS_INVITE = "hasInvite"; //What room a player has an invite to.
	final String SETTING_SHOW_MAIN_CHAT_MESSAGES = "showMainMessages"; //Shows the main feed of chat.
	final String SETTING_FORCE_SHOW_ALL_CHAT = "forceShow";//Allows mods to make everyone see there messages.
	

	@Override
	public String getFeatureName() {
		return this.FEATURE_NAME;	
	}
	public FtrDonorChat(){
		DonorDreams.featureSettings.setSetting(this.FEATURE_NAME, this.SETTING_CHAT_NAME, new ArrayList<String>());
		
	
	}
	
	@EventHandler
	public void chatEvent(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		
		
		if(!(Boolean)DonorDreams.userSettings.getSetting(p.getName(), this.SETTING_IS_IN_CHAT)){
			if((Boolean)DonorDreams.userSettings.getSetting(p.getName(), this.SETTING_FORCE_SHOW_ALL_CHAT)){
				return;
			}
			for(Player player : Bukkit.getServer().getOnlinePlayers()){
				if((Boolean)DonorDreams.userSettings.getSetting(player.getName(), this.SETTING_IS_IN_CHAT)){
					if((Boolean)DonorDreams.userSettings.getSetting(player.getName(), this.SETTING_SHOW_MAIN_CHAT_MESSAGES)){
						return;
					}
					e.getRecipients().remove(player.getName());
				}
			}
		}

			
		if ((Boolean) DonorDreams.userSettings.getSetting(p.getName(), this.SETTING_IS_IN_CHAT)) {
			
			e.getRecipients().clear();
			
			for (Player rec : Bukkit.getServer().getOnlinePlayers()) {
				
				if (DonorDreams.userSettings.getSetting(rec.getName(), SETTING_CHAT_NAME) == DonorDreams.userSettings.getSetting(p.getName(), this.SETTING_CHAT_NAME)) {
					
					
					e.getRecipients().add(rec);
					
				}else if (DonorDreams.userSettings.getSetting(rec.getName(), SETTING_CHAT_NAME) != DonorDreams.userSettings.getSetting(p.getName(), this.SETTING_CHAT_NAME)) {
					return;
				}
			}
		} else if (!(Boolean) DonorDreams.userSettings.getSetting(
				p.getName(), this.SETTING_IS_IN_CHAT)) {
			return;
		}

	}
	
	

}
