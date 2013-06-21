package com.github.walk2222;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.entity.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
	//Enabling plugin message
	@Override
	public void onEnable(){
		createFiles();
		HelpMenu.help();
		this.saveDefaultConfig();
		getLogger().info("has been enabled");

	}

	//File creation system on startup
	public void createFiles(){
		File folder = new File("plugins/PlayerInfo");
		File file = new File("plugins/PlayerInfo/logs.txt");
		if(!folder.exists()){
			folder.mkdir();
			getLogger().info("Folder was not found, creating a new one.");
		}
		if(!file.exists()){
			getLogger().info("Log file was not found, creating a new one.");
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	//Player info command entry
	public boolean onCommand(CommandSender sender, Command cmd, String label, String [] args){
		if(cmd.getName().equalsIgnoreCase("playerinfo")){
			Player player = Bukkit.getPlayer(sender.getName());

			if(args.length == 0){
				//If no arguments were entered
				player.sendMessage("Error:  You must enter a username");
				return false;
			}else if(args.length == 1){

				//Get target player from variable
				Player target = sender.getServer().getPlayer(args[0]);

				if(target == null){
					//If the player is offline
					player.sendMessage("That person is NOT online!");
				}else{

					//If the player is online
					//Start calling information methods for PAGE ONE
					if(this.getConfig().getString("location") == "true"
							&& player.hasPermission("playerinfo.location")){
						InformationReciever.getlocation(target, sender);

					} if(this.getConfig().getString("ip") == "true"
							&& player.hasPermission("playerinfo.ip")){
						InformationReciever.getip(target, sender);

					} if(this.getConfig().getString("health") == "true"
							&& player.hasPermission("playerinfo.health")){
						InformationReciever.gethealth(target, sender);

					} if(this.getConfig().getString("world") == "true"
							&& player.hasPermission("playerinfo.world")){
						InformationReciever.getworld(target, sender);

					} if(this.getConfig().getString("distance") == "true"
							&& player.hasPermission("playerinfo.distance")){
						InformationReciever.getdistance(target, sender);

					} if(this.getConfig().getString("hunger") == "true"
							&& player.hasPermission("playerinfo.hunger")){
						InformationReciever.gethunger(target, sender);

					} if(this.getConfig().getString("op") == "true"
							&& player.hasPermission("playerinfo.op")){
						InformationReciever.getop(target, sender);

					} if(this.getConfig().getString("gamemode") == "true"
							&& player.hasPermission("playerinfo.gamemode")){
						InformationReciever.getgamemode(target, sender);

					}
					InformationReciever.endlogging(target);
				}
			}
		}

		//Player info two command entry
		if(cmd.getName().equalsIgnoreCase("playerinfo")){
			Player player = Bukkit.getPlayer(sender.getName());

			if(args.length == 0){
				//If no arguments were entered 
				player.sendMessage("Error: You must enter a username");
				return false;
			}else if(args.length == 2){
				if (args[0].equalsIgnoreCase("page-two")) {
					//Get target player from variable
					Player target = sender.getServer().getPlayer(args[1]);

					if(target == null){
						//If the player is offline
						player.sendMessage("That person is NOT online!");
					}else{

						//If the player is online
						//Start calling information methods for PAGE TWO
						if(this.getConfig().getString("level") == "true"
								&& player.hasPermission("playerinfo.level")){
							InformationRecieverTwo.getlevel(target, sender);
							
						} if(this.getConfig().getString("iteminhand") == "true"
								&& player.hasPermission("playerinfo.iteminhand")){
							InformationRecieverTwo.getitem(target, sender);
							
						} if(this.getConfig().getString("flying") == "true"
								&& player.hasPermission("playerinfo.flying")){
							InformationRecieverTwo.getflying(target, sender);
							
						} if(this.getConfig().getString("dead") == "true"
								&& player.hasPermission("playerinfo.dead")){
							InformationRecieverTwo.getdeath(target, sender);
							
						} if(this.getConfig().getString("direction") == "true"
								&& player.hasPermission("playerinfo.direction")){
							InformationRecieverTwo.getdirection(target, sender);
						}
						InformationRecieverTwo.endloggingtwo(target);
					}
				}else{
					//If too many arguments were entered
					player.sendMessage("Error:  You have entered incorrect parameters");
				}
			}

		}
		return false;
	}


	//Disabling plugin message
	@Override
	public void onDisable(){
		getLogger().info("has been disabled");
	}
}
