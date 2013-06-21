package com.github.walk2222;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class InformationReciever {

	
	//Logging to File
	public static void logToFile(String message){
		try{
			File saveTo = new File("plugins/PlayerInfo/logs.txt");
			FileWriter fw = new FileWriter(saveTo, true);
			PrintWriter pw = new PrintWriter(fw);

			pw.println(message);
			pw.flush();
			pw.close();

		} catch (IOException e){
			e.printStackTrace();
		}
	}

	//Player Distance
	public static int getdistance(Player player, CommandSender sender){
		
		Player playersender = (Player)sender;

		int playerx = (int) player.getLocation().getX();
		int playery = (int) player.getLocation().getY();

		int senderx = (int) playersender.getLocation().getX();
		int sendery = (int) playersender.getLocation().getY();

		int finalx = playerx - senderx;
		int finaly = playery - sendery;

		if(finalx <= 0){
			finalx = -finalx;
		}
		if(finaly <= 0){
			finaly = -finaly;
		}
		sender.sendMessage(ChatColor.AQUA + "Distance X: "+ChatColor.GREEN + finalx +ChatColor.AQUA + " Distance Y: "+ChatColor.GREEN + finaly);

		logToFile(player + " : Distance From : " +sender+ " : " + finalx + finaly);

		return 0;
	}

	//Player Health
	public static int gethealth(Player player, CommandSender sender){
		int playerhealth = player.getHealth();
		sender.sendMessage(ChatColor.AQUA + "Health: "+ChatColor.GREEN + playerhealth+"/20");

		logToFile(player + " : Health :" + playerhealth);

		return playerhealth;
	}

	//Player Hunger
	public static int gethunger(Player player, CommandSender sender){
		int playerhunger = player.getFoodLevel();
		sender.sendMessage(ChatColor.AQUA + "Hunger: "+ChatColor.GREEN + playerhunger+"/20");

		logToFile(player + " : Hunger : " + playerhunger);

		return playerhunger;
	}

	//Player Ip
	public static String getip(Player player, CommandSender sender){

		String playerIp = player.getAddress().getHostString();
		if(player != null){
			sender.sendMessage(ChatColor.AQUA + "IP Address: "+ChatColor.GREEN + playerIp);
		}

		logToFile(player + " : Ip Address : " + playerIp);

		return playerIp;	
	}

	//Player Location
	public static void getlocation(Player player, CommandSender sender){
		int px = (int) player.getLocation().getX();
		int py = (int) player.getLocation().getY();
		int pz = (int) player.getLocation().getZ();
		Player playerloc = Bukkit.getPlayer(sender.getName());

		playerloc.sendMessage(ChatColor.AQUA + "X: "+ChatColor.GREEN +px + ChatColor.AQUA +" Y: "+ChatColor.GREEN +py+ ChatColor.AQUA +" Z: "+ChatColor.GREEN +pz);

		logToFile(player + " : Location : " + px + " - " + py + " - " + pz);

	}

	//Player Op
	public static String getop(Player player, CommandSender sender){

		if(player.isOp()){
			sender.sendMessage(ChatColor.AQUA + "Is Op:"+ChatColor.GREEN + " Yes");
			logToFile(player + " : Is Op : Yes");
		}
		else{
			sender.sendMessage(ChatColor.AQUA + "Is Op: "+ChatColor.GREEN + " No");
			logToFile(player + " : Is Op : No");
		}

		return null;
	}

	//Player World
	public static String getworld(Player player, CommandSender sender){
		World world = player.getWorld();
		String playerworld = world.getName();
		sender.sendMessage(ChatColor.AQUA + "World: "+ChatColor.GREEN + playerworld);

		logToFile(player + " : World : " + playerworld);

		return playerworld;
	}

	//Player Gamemode
	public static String getgamemode(Player player, CommandSender sender){

		GameMode playerGameMode = player.getGameMode();

		if(player.getGameMode() == GameMode.CREATIVE){
			sender.sendMessage(ChatColor.AQUA + "Gamemode: "+ChatColor.GREEN + "Creative");
		}if(player.getGameMode() == GameMode.SURVIVAL){
			sender.sendMessage(ChatColor.AQUA + "Gamemode: "+ChatColor.GREEN + "Survival");
		}if(player.getGameMode() == GameMode.ADVENTURE){
			sender.sendMessage(ChatColor.AQUA + "Gamemode: "+ChatColor.GREEN + "Adventure");
		}

		logToFile(player + " : GameMode : " + playerGameMode);

		return null;
	}

	//End of logging for page one
	public static void endlogging(Player player){
		logToFile("---- End of Logging for player " + player + " on page one ----");
	}
}
