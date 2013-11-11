package com.github.walk2222;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class HelpMenu {

	public static void help(){
		File file = new File("plugins/PlayerInfo/Read Me.txt");

		if(!file.exists()){
			try {
				System.out.println("Help file not found, creating new one.");
				file.createNewFile();
				HelpMenu.filecontent();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void filecontent() throws FileNotFoundException, UnsupportedEncodingException{
		PrintWriter writer = new PrintWriter("plugins/PlayerInfo/Read Me.txt", "UTF-8");
		writer.println("===== Player Info =====");
		writer.println("===== By WALK2222 =====");
		writer.println("");
		writer.println("==Commands==");
		writer.println("Player Info returns a series of informational methods about the requested player");
		writer.println("To access the plugin simply type '/playerinfo name' to see the first page");
		writer.println("To access the plugin's second page, type '/playerinfo page-two name'");
		writer.println("Replace 'name' with the person you would like information on.  And obviously do not use ''s ");
		writer.println("");
		writer.println("==Configuration==");
		writer.println("Player Info will automatically generate a config file in it's data folder");
		writer.println("Simply replace 'true' with 'false' if you would like to disable");
		writer.println("Certain pieces of information from showing up");
		writer.println("By default, all information methods will be set to 'true'");
		writer.println("");
		writer.println("==Permissions==");
		writer.println("playerinfo.distance");
		writer.println("playerinfo.health");
		writer.println("playerinfo.hunger");
		writer.println("playerinfo.ip");
		writer.println("playerinfo.location");
		writer.println("playerinfo.op");
		writer.println("playerinfo.world");
		writer.println("playerinfo.gamemode");
		writer.println("playerinfo.level");
		writer.println("playerinfo.iteminhand");
		writer.println("playerinfo.flying");
		writer.println("playerinfo.dead");
		writer.println("playerinfo.direction");
		writer.println("");
		writer.println("Enjoy!");
		writer.println("- WALK2222");
		writer.close();
	}
}
