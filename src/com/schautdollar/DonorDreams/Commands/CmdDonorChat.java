package com.schautdollar.DonorDreams.Commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.schautdollar.DonorDreams.DonorDreams;

/*
 * Author: Burnett1
 * 
 * 
 * 
 * Comments/Ideas:
 *
 */

public class CmdDonorChat implements ICommand{
	
	
	
	final String FEATURE_NAME = "donorchat";
	
	final String COMMAND = "donorchat";// Aliases /ddc
	
	final String SETTING_IS_IN_CHAT = "isInChat"; //If a player is in the chat room or not
	final String SETTING_CHAT_NAME = "chatname"; //What chat room a player is in.
	final String SETTING_IS_OWNER = "isOwner"; //What room the player is a owner off.
	final String SETTING_HAS_INVITE = "hasInvite"; //What room a player has an invite to.
	final String SETTING_SHOW_MAIN_CHAT_MESSAGES = "showMainMessages"; //Shows the main feed of chat.
	final String SETTING_FORCE_SHOW_ALL_CHAT = "forceShow";//Allows mods to make everyone see there messages.
	
	final String PERMISSION_NODE_ADMIN_ALL = "donordreams.chat.admin.*";// All permissions for admin chat commands.
	final String PERMISSION_NODE_USER = "donordreams.chat.user"; 
	
	//Admin Command permissions
	final String PERMISSION_NODE_FORCE_KICK = "donordreams.chat.admin.forekick"; //Force kick a player from any chat room.
	final String PERMISSION_NODE_FORCE_DELETE = "donordreams.chat.admin.forcedelete"; //Force delete any chat room.
	final String PERMISSION_NODE_FORCE_JOIN = "donordreams.chat.admin.forcejoin";  //Force join a chat room.
	final String PERMISSION_NODE_FORCE_LEAVE = "donordreams.chat.admin.forceleave"; //Force leave a chat room. (Incase anything mucks up). 
	final String PERMISSION_NODE_FORCE_OWNER = "donordreams.chat.admin.forceowner"; //Force a player to be admin of a chat room.
	final String PERMISSION_NODE_FORCE_SHOW = "donordreams.chat.admin.forceshow";//Force show his/her chat to all rooms.	
	

		

	@Override
	public String getCommand() {
		return this.COMMAND;
	}

	public String getPermissionNodeAdminAll() {
		return this.PERMISSION_NODE_ADMIN_ALL;
	}

	public String getPermissionNodeForceKick() {
		return this.PERMISSION_NODE_FORCE_KICK;
	}

	public String getPermissionNodeForeDelete() {
		return this.PERMISSION_NODE_FORCE_DELETE;
	}

	public String getPermissionNodeForceJoin() {
		return this.PERMISSION_NODE_FORCE_JOIN;
	}

	public String getPermissionNodeForceOwner() {
		return this.PERMISSION_NODE_FORCE_OWNER;
	}

	public String getPermissionNodeUserAll() {
		return this.PERMISSION_NODE_USER;
	}
	
	public String getPermissionNodeForceShow() {
		return this.PERMISSION_NODE_FORCE_SHOW;
	}
	
	@Override
	public boolean runCommand(CommandSender sender, Command cmd, String lbl, String[] args) {
		
		
		Player p = (Player) sender;
		List<String> roomName = new ArrayList<String>();
		
		
		
		if(cmd.getName().equalsIgnoreCase(this.COMMAND) && DonorDreams.permManager.playerHasPerm(p, this.PERMISSION_NODE_USER)){
			if((args.length == 0) && !DonorDreams.permManager.playerHasPerm(p, this.PERMISSION_NODE_ADMIN_ALL)){
				p.sendMessage(ChatColor.AQUA + "DonorDreams Chat Help");
				p.sendMessage(" ");
				p.sendMessage(ChatColor.BLUE + "/ddc" + ChatColor.GRAY + " - Display's the DonorDreams Chat Help.");
				p.sendMessage(ChatColor.BLUE + "/ddc <join> <ChatRoomName>" + ChatColor.GRAY + " - Join's a specified chat room.");
				p.sendMessage(ChatColor.BLUE + "/ddc <leave>" + ChatColor.GRAY + " - Leave the current chat room.");
				p.sendMessage(ChatColor.BLUE + "/ddc <request> <ChatRoom>" + ChatColor.GRAY + " - Request the owner of the chat room to invite you.");
				p.sendMessage(ChatColor.BLUE + "/ddc <list>" + ChatColor.GRAY + " - Lists all the chat room's.");	
				p.sendMessage(ChatColor.BLUE + "/ddc <create> <ChatRoomName>" + ChatColor.GRAY + " - Create a chat room.");
				p.sendMessage(ChatColor.BLUE + "/ddc <invite> <Player>" + ChatColor.GRAY + " - Invite a player to your chat room.");
				p.sendMessage(ChatColor.BLUE + "/ddc <delete>" + ChatColor.GRAY + " - Delete the chat room. Have to be the owner it.");
				p.sendMessage(ChatColor.BLUE + "/ddc <kick> <Player>" + ChatColor.GRAY + " - Kick a player from the chat room");
				p.sendMessage(ChatColor.BLUE + "/ddc <setowner> <Player>" + ChatColor.GRAY + " - Pass ownership of the chat room to another player.");

				
			}else if(DonorDreams.permManager.playerHasPerm(p, this.PERMISSION_NODE_ADMIN_ALL)){
				p.sendMessage(ChatColor.AQUA + "DonorDreams Chat Help");
				p.sendMessage(" ");
				p.sendMessage(ChatColor.BLUE + "/ddc" + ChatColor.GRAY + " - Display's the DonorDreams Chat Help.");
				p.sendMessage(ChatColor.BLUE + "/ddc <join> <ChatRoomName>" + ChatColor.GRAY + " - Join's a specified chat room.");
				p.sendMessage(ChatColor.BLUE + "/ddc <leave>" + ChatColor.GRAY + " - Leave the current chat room.");
				p.sendMessage(ChatColor.BLUE + "/ddc <request> <ChatRoom>" + ChatColor.GRAY + " - Request the owner of the chat room to invite you.");
				p.sendMessage(ChatColor.BLUE + "/ddc <list>" + ChatColor.GRAY + " - Lists all the chat room's.");	
				p.sendMessage(ChatColor.BLUE + "/ddc <create> <ChatRoomName>" + ChatColor.GRAY + " - Create a chat room.");
				p.sendMessage(ChatColor.BLUE + "/ddc <invite> <Player>" + ChatColor.GRAY + " - Invite a player to your chat room.");
				p.sendMessage(ChatColor.BLUE + "/ddc <delete>" + ChatColor.GRAY + " - Delete the chat room. Have to be the owner it.");
				p.sendMessage(ChatColor.BLUE + "/ddc <kick> <Player>" + ChatColor.GRAY + " - Kick a player from the chat room");
				p.sendMessage(ChatColor.BLUE + "/ddc <setowner> <Player>" + ChatColor.GRAY + " - Pass ownership of the chat room to another player.");
				p.sendMessage(ChatColor.GOLD + "/ddc <forcejoin> <ChatRoomName>" + ChatColor.GRAY + " - Force join a chatroom.");
				p.sendMessage(ChatColor.GOLD + "/ddc <forceleave>" + ChatColor.GRAY + " - Force leave a chatroom.");
				p.sendMessage(ChatColor.GOLD + "/ddc <forcekick> <ChatRoomName> <Player>" + ChatColor.GRAY + " - Force kick a player from a chat room.");
				p.sendMessage(ChatColor.GOLD + "/ddc <forcedelete> <ChatRoomName>" + ChatColor.GRAY + " - Force delete a chat room.");
				p.sendMessage(ChatColor.GOLD + "/ddc <forceowner> <ChatRoomName> <Player>" + ChatColor.GRAY + " - Force a player to become a chat room owner.");
			}
			
			if(args.length == 1){
				if(args[0].equalsIgnoreCase("list")){
					p.sendMessage(" ");
					p.sendMessage(ChatColor.GOLD + "DonorDreams Chat List:");
					p.sendMessage(ChatColor.BLUE + roomName.toString().replace("[", " ").replace("]", " "));
					return true;
				}
				
				if(args[0].equalsIgnoreCase("show")){
					if((Boolean)DonorDreams.userSettings.getSetting(p.getName(), this.SETTING_SHOW_MAIN_CHAT_MESSAGES)){
						DonorDreams.userSettings.setSetting(p.getName(), this.SETTING_SHOW_MAIN_CHAT_MESSAGES, false);
						p.sendMessage(ChatColor.GREEN + "Disabling viewing of main chat message's.");
						return true;
					}
					else if(!(Boolean)DonorDreams.userSettings.getSetting(p.getName(), this.SETTING_SHOW_MAIN_CHAT_MESSAGES)){
						DonorDreams.userSettings.setSetting(p.getName(), this.SETTING_SHOW_MAIN_CHAT_MESSAGES, true);
						p.sendMessage(ChatColor.GREEN + "Enabling viewing of main chat message's.");
						return true;
					}
				}
				
				if(args[0].equalsIgnoreCase("forceshow")){
					if(DonorDreams.permManager.playerHasPerm(p, this.PERMISSION_NODE_FORCE_SHOW)){
						if((Boolean)DonorDreams.userSettings.getSetting(p.getName(), this.SETTING_FORCE_SHOW_ALL_CHAT)){
							DonorDreams.userSettings.setSetting(p.getName(), this.SETTING_FORCE_SHOW_ALL_CHAT, false);
							p.sendMessage(ChatColor.GREEN + "Disabling broadcasting of messages to all chat rooms.");
							return true;
						}
						else if(!(Boolean)DonorDreams.userSettings.getSetting(p.getName(), this.SETTING_FORCE_SHOW_ALL_CHAT)){
							DonorDreams.userSettings.setSetting(p.getName(), this.SETTING_FORCE_SHOW_ALL_CHAT, true);
							p.sendMessage(ChatColor.GREEN + "Enabling broadcasting of messages to all chat rooms.");
							return true;
						}
					}else if(!DonorDreams.permManager.playerHasPerm(p, this.PERMISSION_NODE_FORCE_SHOW)){
						p.sendMessage(ChatColor.RED + "You do not have permission to do this.");
					}
				}

			}
			
			if(args.length == 2){
				
				if(args[0].equalsIgnoreCase("create")){
					
					if(!roomName.contains(args[1])){
						DonorDreams.userSettings.setSetting(p.getName(), this.SETTING_IS_OWNER, args[1]);
						DonorDreams.userSettings.setSetting(p.getName(), this.SETTING_CHAT_NAME, args[1]);
						DonorDreams.userSettings.setSetting(p.getName(), this.SETTING_IS_IN_CHAT, true);

						roomName.add(args[1]);
						p.sendMessage(ChatColor.GREEN + "Chat room " + ChatColor.GOLD + args[1] +ChatColor.GREEN + " created." );
						return true;
					}else if(roomName.contains(args[1])){
						p.sendMessage(ChatColor.RED + "A room with that name already exists.");
					}
					return true;
				}
				
				if(args[0].equalsIgnoreCase("delete")){
					if(DonorDreams.userSettings.getSetting(p.getName(), this.SETTING_CHAT_NAME) == DonorDreams.userSettings.getSetting(p.getName(), this.SETTING_IS_OWNER)){
						roomName.remove(DonorDreams.userSettings.getSetting(p.getName(), this.SETTING_CHAT_NAME));
						for(Player inChat : Bukkit.getServer().getOnlinePlayers()){
							if(inChat.getName() == p.getName()){
								return true;
							}
							else if(DonorDreams.userSettings.getSetting(inChat.getName(), this.SETTING_CHAT_NAME) == DonorDreams.userSettings.getSetting(p.getName(), this.SETTING_CHAT_NAME)){
								DonorDreams.userSettings.setSetting(inChat.getName(), this.SETTING_IS_IN_CHAT, false);
								DonorDreams.userSettings.setSetting(inChat.getName(), this.SETTING_CHAT_NAME, null);
								DonorDreams.userSettings.setSetting(inChat.getName(), this.SETTING_IS_IN_CHAT, false);
								inChat.sendMessage(ChatColor.RED + "The chat room has been deleted by the owner.");

							}
						}
						DonorDreams.userSettings.setSetting(p.getName(), this.SETTING_IS_OWNER, null);
						DonorDreams.userSettings.setSetting(p.getName(), this.SETTING_IS_IN_CHAT, false);
						DonorDreams.userSettings.setSetting(p.getName(), this.SETTING_CHAT_NAME, null);	
						p.sendMessage(ChatColor.GREEN + "Chat room " + ChatColor.GOLD + args[1] +ChatColor.GREEN + " deleted." );

					}else if(DonorDreams.userSettings.getSetting(p.getName(), this.SETTING_CHAT_NAME) != DonorDreams.userSettings.getSetting(p.getName(), this.SETTING_IS_OWNER)){
						p.sendMessage(ChatColor.RED + "You are not the owner of that room.");
					}
					return true;
				}
				
				if(args[0].equalsIgnoreCase("join")){
					if(!(Boolean)DonorDreams.userSettings.getSetting(p.getName(), this.SETTING_IS_IN_CHAT)){
						if(roomName.contains(args[1])){
							if(DonorDreams.userSettings.getSetting(p.getName(), this.SETTING_HAS_INVITE) == args[1]){
								DonorDreams.userSettings.setSetting(p.getName(), this.SETTING_CHAT_NAME, args[1]);
								DonorDreams.userSettings.setSetting(p.getName(), this.SETTING_IS_IN_CHAT, true);
								DonorDreams.userSettings.setSetting(p.getName(), this.SETTING_HAS_INVITE, null);
								p.sendMessage(ChatColor.AQUA + "Joined chat room '" + ChatColor.GOLD + args[1] + ChatColor.AQUA + "." );
								return true;
							}else if(DonorDreams.userSettings.getSetting(p.getName(), this.SETTING_HAS_INVITE) != args[1]){
								p.sendMessage(ChatColor.RED + "You do not have an invite to this room.");
								return true;
							}
						}else if(!roomName.contains(args[1])){
							p.sendMessage(ChatColor.RED + "That chat room does not exist.");
							return true;
						}
					}else if((Boolean)DonorDreams.userSettings.getSetting(p.getName(), this.SETTING_IS_IN_CHAT)){
						p.sendMessage(ChatColor.RED + "You are already in a chat room.");
						return true;
					}
					return true;
				}
				
				if(args[0].equalsIgnoreCase("leave")){
					if(	DonorDreams.userSettings.getSetting(p.getName(), this.SETTING_IS_OWNER) == DonorDreams.userSettings.getSetting(p.getName(), this.SETTING_CHAT_NAME)){
						roomName.remove(DonorDreams.userSettings.getSetting(p.getName(), this.SETTING_CHAT_NAME));
						for(Player inChat : Bukkit.getServer().getOnlinePlayers()){
							if(inChat.getName() == p.getName()){
								return true;
							}
							else if(DonorDreams.userSettings.getSetting(inChat.getName(), this.SETTING_CHAT_NAME) == DonorDreams.userSettings.getSetting(p.getName(), this.SETTING_CHAT_NAME)){
								DonorDreams.userSettings.setSetting(inChat.getName(), this.SETTING_IS_IN_CHAT, false);
								DonorDreams.userSettings.setSetting(inChat.getName(), this.SETTING_CHAT_NAME, null);
								DonorDreams.userSettings.setSetting(inChat.getName(), this.SETTING_IS_IN_CHAT, false);
								inChat.sendMessage(ChatColor.RED + "Chat room closing because owner left.");
							}
						}
						DonorDreams.userSettings.setSetting(p.getName(), this.SETTING_IS_OWNER, null);
						DonorDreams.userSettings.setSetting(p.getName(), this.SETTING_CHAT_NAME, null);
						DonorDreams.userSettings.setSetting(p.getName(), this.SETTING_IS_IN_CHAT, false);
						p.sendMessage(ChatColor.AQUA + "Left the chat room.");
						return true;
					}
					
					else{
						DonorDreams.userSettings.setSetting(p.getName(), this.SETTING_CHAT_NAME, null);
						DonorDreams.userSettings.setSetting(p.getName(), this.SETTING_IS_IN_CHAT, false);
						DonorDreams.userSettings.setSetting(p.getName(), this.SETTING_IS_OWNER, null);
						p.sendMessage(ChatColor.RED + "Left the chat room.");
					}	
					return true;
				}
				
				if(args[0].equalsIgnoreCase("invite")){
					
					if((Boolean)DonorDreams.userSettings.getSetting(p.getName(), this.SETTING_IS_IN_CHAT)){
						
						if(DonorDreams.userSettings.getSetting(p.getName(), this.SETTING_IS_OWNER) == DonorDreams.userSettings.getSetting(p.getName(), this.SETTING_CHAT_NAME)){
							
							Player tp = Bukkit.getServer().getPlayer(args[1]);
							
							if(tp instanceof Player){
								
								if((Boolean)DonorDreams.permManager.playerHasPerm(tp, this.PERMISSION_NODE_USER)){
									
									tp.sendMessage(ChatColor.GOLD + "You have recieved an invite to join " + ChatColor.GOLD + p.getName() + "'s" + ChatColor.GOLD +  " chat room");
									p.sendMessage(ChatColor.GOLD + "Your invite has been sent to " + ChatColor.GOLD + tp.getName());
									
									DonorDreams.userSettings.setSetting(tp.getName(), this.SETTING_HAS_INVITE, DonorDreams.userSettings.getSetting(p.getName(), this.SETTING_CHAT_NAME));
									return true;
								}else if(!(Boolean)DonorDreams.permManager.playerHasPerm(tp, this.PERMISSION_NODE_USER)){
									p.sendMessage(ChatColor.RED + "This player does not have permission to join donor chat rooms.");
									return true;
								}
							}else if(!(tp instanceof Player)){
								p.sendMessage(ChatColor.RED + "That player does not exist.");
								return true;
							}
						}else if(DonorDreams.userSettings.getSetting(p.getName(), this.SETTING_IS_OWNER) != DonorDreams.userSettings.getSetting(p.getName(), this.SETTING_CHAT_NAME)){
							p.sendMessage(ChatColor.RED + "You are not the owner of the chat room so you can not invite.");
							return true;
						}
					}else if(!(Boolean)DonorDreams.userSettings.getSetting(p.getName(), this.SETTING_IS_IN_CHAT)){
						
						p.sendMessage(ChatColor.RED + "You are not in a chat room so you can not invite players.");
						p.sendMessage(ChatColor.RED + "Use /ddc create <ChatRoomName> to create your own chat room.");
						return true;
					}
					return true;
				}
					
				if(args[0].equalsIgnoreCase("request")){
					if(roomName.contains(args[1])){
						for(Player owner : Bukkit.getServer().getOnlinePlayers()){
							if(DonorDreams.userSettings.getSetting(owner.getName(), this.SETTING_IS_OWNER) == args[1]){
								owner.sendMessage(ChatColor.GOLD + p.getName() + " has requested to join your chat room. Do " +ChatColor.AQUA +  "/ddc invite " + p.getName() + ChatColor.GOLD + "to invite him.");
								p.sendMessage(ChatColor.GOLD + "Your request has been sent to the owner of the chat room.");
							}
						}
						p.sendMessage(ChatColor.RED + "Your request has failed to reach the owner.");
					}else if(!roomName.contains(args[1])){
						p.sendMessage(ChatColor.RED + "This room does not exist. Check your spelling.");
					}
					return true;
				}
				
				if(args[0].equalsIgnoreCase("kick")){
					if((Boolean)DonorDreams.userSettings.getSetting(p.getName(), this.SETTING_IS_IN_CHAT)){
						
						if(DonorDreams.userSettings.getSetting(p.getName(), this.SETTING_IS_OWNER) == DonorDreams.userSettings.getSetting(p.getName(), this.SETTING_CHAT_NAME)){
							
							Player tp = Bukkit.getServer().getPlayer(args[1]);
							if(DonorDreams.userSettings.getSetting(tp.getName(), this.SETTING_CHAT_NAME) == DonorDreams.userSettings.getSetting(p.getName(), this.SETTING_CHAT_NAME)){
								
								DonorDreams.userSettings.setSetting(tp.getName(), this.SETTING_CHAT_NAME, null);
								DonorDreams.userSettings.setSetting(tp.getName(), this.SETTING_IS_IN_CHAT, false);
								tp.sendMessage(ChatColor.RED + "You got kicked from the chat room.");
								p.sendMessage(ChatColor.AQUA + "You kicked " + ChatColor.GOLD +  tp.getName() + " from your chat room.");
								return true;
							}else if(DonorDreams.userSettings.getSetting(tp.getName(), this.SETTING_CHAT_NAME) == DonorDreams.userSettings.getSetting(p.getName(), this.SETTING_CHAT_NAME)){
								p.sendMessage(ChatColor.RED + "This player is not in your chat room.");
							}
						}else if(!(DonorDreams.userSettings.getSetting(p.getName(), this.SETTING_IS_OWNER) == DonorDreams.userSettings.getSetting(p.getName(), this.SETTING_CHAT_NAME))){
							p.sendMessage(ChatColor.RED + "You need to be the owner to kick players from the chat room.");
						}
					}else if(!(Boolean)DonorDreams.userSettings.getSetting(p.getName(), this.SETTING_IS_IN_CHAT)){
						p.sendMessage(ChatColor.RED + "You are not in a chat room.");
					}
					return true;
				}
				
				if(args[0].equalsIgnoreCase("setowner")){
					if((Boolean)DonorDreams.userSettings.getSetting(p.getName(), this.SETTING_IS_IN_CHAT)){
						if(DonorDreams.userSettings.getSetting(p.getName(), this.SETTING_IS_OWNER) == DonorDreams.userSettings.getSetting(p.getName(), this.SETTING_CHAT_NAME)){
							Player tp = Bukkit.getServer().getPlayer(args[1]);
							
							DonorDreams.userSettings.setSetting(tp.getName(), this.SETTING_IS_OWNER, DonorDreams.userSettings.getSetting(p.getName(), this.SETTING_CHAT_NAME));
							DonorDreams.userSettings.setSetting(p.getName(), this.SETTING_IS_OWNER, null);
							
						}else if(!(DonorDreams.userSettings.getSetting(p.getName(), this.SETTING_IS_OWNER) == DonorDreams.userSettings.getSetting(p.getName(), this.SETTING_CHAT_NAME))){
							p.sendMessage(ChatColor.RED + "You need to be the owner to set a new chat room owner.");
						}
					}else if(!(Boolean)DonorDreams.userSettings.getSetting(p.getName(), this.SETTING_IS_IN_CHAT)){
						p.sendMessage(ChatColor.RED + "You are not in a chat room.");
					}
					return true;
				}
				
				
				if(args[0].equalsIgnoreCase("forcejoin") && DonorDreams.permManager.playerHasPerm(p, this.PERMISSION_NODE_FORCE_JOIN)){
					if(roomName.contains(args[1])){							
								DonorDreams.userSettings.setSetting(p.getName(), this.SETTING_CHAT_NAME, args[1]);
								DonorDreams.userSettings.setSetting(p.getName(), this.SETTING_IS_IN_CHAT, true);
								DonorDreams.userSettings.setSetting(p.getName(), this.SETTING_IS_OWNER, null);
								p.sendMessage((ChatColor.GOLD + "You have forced joined chat room " + args[1] + "."));
					}else if(!roomName.contains(args[1])){
						p.sendMessage(ChatColor.RED + "This is not a chat room.");
					}
					return true;
				}
				
				if(args[0].equalsIgnoreCase("forceleave") && DonorDreams.permManager.playerHasPerm(p, this.PERMISSION_NODE_FORCE_LEAVE)){
					DonorDreams.userSettings.setSetting(p.getName(), this.SETTING_CHAT_NAME, null);
					DonorDreams.userSettings.setSetting(p.getName(), this.SETTING_IS_IN_CHAT, false);
					DonorDreams.userSettings.setSetting(p.getName(), this.SETTING_IS_OWNER, null);
					p.sendMessage(ChatColor.GOLD + "You have force quit your current chat room.");
					return true;
				}
				
				if(args[0].equalsIgnoreCase("forcekick") && DonorDreams.permManager.playerHasPerm(p, this.PERMISSION_NODE_FORCE_KICK)){
					Player tp = Bukkit.getServer().getPlayer(args[1]);
					
					if(tp instanceof Player){
						DonorDreams.userSettings.setSetting(tp.getName(), this.SETTING_CHAT_NAME, null);
						DonorDreams.userSettings.setSetting(tp.getName(), this.SETTING_IS_IN_CHAT, false);
						DonorDreams.userSettings.setSetting(tp.getName(), this.SETTING_IS_OWNER, null);
					}else if(!(tp instanceof Player)){
						p.sendMessage(ChatColor.RED + "That player does not exist.");
					}
					return true;
				}
				
				if(args[0].equalsIgnoreCase("forcedelete") && DonorDreams.permManager.playerHasPerm(p, this.PERMISSION_NODE_FORCE_DELETE)){
					if(roomName.contains(args[1])){
						for(Player inRoom : Bukkit.getServer().getOnlinePlayers()){
							if(DonorDreams.userSettings.getSetting(inRoom.getName(), this.SETTING_CHAT_NAME) == args[1]){
								DonorDreams.userSettings.setSetting(inRoom.getName(), this.SETTING_CHAT_NAME, null);
								DonorDreams.userSettings.setSetting(inRoom.getName(), this.SETTING_IS_IN_CHAT, false);
								DonorDreams.userSettings.setSetting(inRoom.getName(), this.SETTING_IS_OWNER, null);
								inRoom.sendMessage(ChatColor.AQUA + "This chat room has been deleted by an admin.");
							}
						}
						roomName.remove(args[1]);
						
					}else if(!roomName.contains(args[1])){
						p.sendMessage(ChatColor.RED + "That chat room does not exist.");
					}
					return true;
				}
				
				
				
				
			}
			
			if(args.length == 3){
				
				
				
				if(args[0].equalsIgnoreCase("forceowner") && DonorDreams.permManager.playerHasPerm(p, this.PERMISSION_NODE_FORCE_OWNER)){
					if(roomName.contains(args[1])){
						for(Player owner : Bukkit.getServer().getOnlinePlayers()){
							if(DonorDreams.userSettings.getSetting(owner.getName(), this.SETTING_IS_OWNER) == args[1]){
								DonorDreams.userSettings.setSetting(owner.getName(), this.SETTING_IS_OWNER, null);
							}
						}
						
						Player tp = Bukkit.getServer().getPlayer(args[2]);
						if(tp instanceof Player){
							DonorDreams.userSettings.setSetting(tp.getName(), this.SETTING_IS_OWNER, args[1]);
							tp.sendMessage(ChatColor.GOLD + "You have been forced to become the owner of the current chat room.");
							p.sendMessage(ChatColor.GOLD + "You have made " + tp.getName() + " the owner of chat room " + args[1] + "."); 
						}else if(!(tp instanceof Player)){
							p.sendMessage(ChatColor.RED + "That player does not exist.");
						}
						
					}else if(!roomName.contains(args[1])){
						p.sendMessage(ChatColor.RED + "That chat room does not exist.");
					}
					return true;
				}

			}
		}else if(!DonorDreams.permManager.playerHasPerm(p, this.PERMISSION_NODE_USER)){
			p.sendMessage(ChatColor.RED + "You do not have permission to do this.");
		}
		return false;
	}	
}
