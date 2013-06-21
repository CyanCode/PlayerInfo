package com.github.walk2222;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class InformationRecieverTwo {

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

	//Player level
	public static int getlevel(Player player, CommandSender sender){
		int playerlevel = player.getLevel();
		sender.sendMessage(ChatColor.AQUA + "Experience Points: "+ChatColor.GREEN + playerlevel);

		logToFile(player + " : Experience Points : " + playerlevel);

		return playerlevel;
	}

	//Player Item in Hand
	public static String getitem(Player player, CommandSender sender){
		ItemStack item = player.getItemInHand();
		sender.sendMessage(ChatColor.AQUA + "Item in Hand: " +ChatColor.GREEN + item);

		logToFile(player + " : Item in Hand : " + item);

		return null;
	}

	//Player is Flying?
	public static String getflying(Player player, CommandSender sender){
		Location playerloc = player.getLocation();
		Block block = playerloc.getBlock();		

		Block finalblock = block.getRelative(BlockFace.DOWN);
		if(finalblock.getType().equals(Material.AIR)){
			sender.sendMessage(ChatColor.AQUA + "Is in the air: "+ChatColor.GREEN + "Yes");
			logToFile(player + " : Flying : Yes");
		}else{
			sender.sendMessage(ChatColor.AQUA + "Is in the air: "+ChatColor.GREEN + "No");
			logToFile(player + " : Flying : No");
		}
		return null;
	}

	//Player is dead?
	public static int getdeath(Player player, CommandSender sender){
		if(player.isDead()){
			sender.sendMessage(ChatColor.AQUA + "Is Dead: " +ChatColor.GREEN + "Yes");
			logToFile(player + " : Dead : Yes");
		}else{
			sender.sendMessage(ChatColor.AQUA + "Is Dead: " +ChatColor.GREEN + "No");
			logToFile(player + " : Dead : No");
		}
		return 0;
	}

	//Player direction
	public static String getdirection(Player player, CommandSender sender){
		String dir = "";
		float y = player.getLocation().getYaw();
		if( y < 0 ){y += 360;}
		y %= 360;
		int i = (int)((y+8) / 22.5);
		if(i == 0){dir = "west";}
		else if(i == 1){dir = "West northwest";}
		else if(i == 2){dir = "Northwest";}
		else if(i == 3){dir = "North northwest";}
		else if(i == 4){dir = "North";}
		else if(i == 5){dir = "North northeast";}
		else if(i == 6){dir = "Northeast";}
		else if(i == 7){dir = "East northeast";}
		else if(i == 8){dir = "East";}
		else if(i == 9){dir = "East southeast";}
		else if(i == 10){dir = "Southeast";}
		else if(i == 11){dir = "South southeast";}
		else if(i == 12){dir = "South";}
		else if(i == 13){dir = "South southwest";}
		else if(i == 14){dir = "Southwest";}
		else if(i == 15){dir = "West southwest";}
		else {dir = "west";}

		sender.sendMessage(ChatColor.AQUA + "Direction: " + ChatColor.GREEN + dir);
		logToFile(player + " : Direction : " + dir);

		return dir;
	}

	//End of logging for page two
	public static void endloggingtwo(Player player){
		logToFile("---- End of Logging for player " + player + " on page two ----");
	}
}