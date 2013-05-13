package com.schautdollar.DonorDreams.Commands;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.FireworkMeta;

import com.schautdollar.DonorDreams.DonorDreams;

/*
 * Author: Burnett1
 * 
 */

public class CmdFireWorkRide implements ICommand{
	

	
	Player name;
	
	final String SETTING_ISFW = "isFW";
	final String COMMAND = "fireworkride";
	final String PERMISSION_NODE = "donordreams.fireworkride";

	@Override
	public String getCommand() {
		return this.COMMAND;
	}
	
	public String getPermissionNode(){
		return this.PERMISSION_NODE;
	}

	@Override
	public boolean runCommand(CommandSender sender, Command cmd, String lbl,
			String[] args) {
		Player player = (Player) sender;
		
		name = player;
		
		if(cmd.getName().equalsIgnoreCase(this.COMMAND) && DonorDreams.permManager.playerHasPerm(player, this.PERMISSION_NODE)){
			if(player instanceof Player){
				shootFireWork();
				DonorDreams.userSettings.setSetting(player.getName(), this.SETTING_ISFW, true);
			}
		}else{
			player.sendMessage(ChatColor.RED + "You do not have permission to do this.");
			return true;
		}
		
		return false;
	}

	public void shootFireWork(){
		
		Firework fw = (Firework) name.getWorld().spawn(name.getLocation(), Firework.class);
		FireworkMeta fm = fw.getFireworkMeta();
		Random r = new Random();
		
		int fType = r.nextInt(5) + 1;
		Type type = Type.BALL;
		switch (fType){
		default:
		case 1:
			type = Type.BALL;
			break;
		case 2:
			type = Type.BALL_LARGE;
			break;
		case 3:
			type = Type.BURST;
			break;
		case 4:
			type = Type.STAR;
			break;
		case 5:
			type = Type.CREEPER;
		
		}
		
		int c1i = r.nextInt(17) + 1;
		int c2i = r.nextInt(17) + 1;
		Color c1 = getColor(c1i);
		Color c2  = getColor(c2i);
		FireworkEffect effect = FireworkEffect.builder().flicker(r.nextBoolean()).withColor(c1).withFade(c2).with(type).trail(r.nextBoolean()).build();
		fm.addEffect(effect);
		int power = r.nextInt(2) + 1;
		
		fm.setPower(power);
		fw.setFireworkMeta(fm);
		fw.setPassenger(name);
		
		}
	
	
	public Color getColor(int c){
		switch (c){
		case 1:return Color.BLACK;
		case 2:return Color.AQUA;
		case 3:return Color.BLUE;
		case 4:return Color.FUCHSIA;
		case 5:return Color.GRAY;
		case 6:return Color.GREEN;
		case 7:return Color.LIME;
		case 8:return Color.MAROON;
		case 9:return Color.NAVY;
		case 10:return Color.OLIVE;
		case 11:return Color.ORANGE;
		case 12:return Color.PURPLE;
		case 13:return Color.RED;
		case 14:return Color.SILVER;
		case 15:return Color.TEAL;
		case 16:return Color.WHITE;
		case 17:return Color.YELLOW;
			
		}
		return null;
		
	}

}
