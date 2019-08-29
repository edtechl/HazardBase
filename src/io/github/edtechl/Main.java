package io.github.edtechl;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
 
public class Main extends JavaPlugin {
		
		PluginManager pm = Bukkit.getPluginManager();
	
	    public final HashMap<Player, ArrayList<Block>> hashmap = new HashMap<Player, ArrayList<Block>>();
	    
	    public final NoMoreTNT tnt = new NoMoreTNT(this); //linking NoMoreTNT with Main
	    public final FireworkJoin fire = new FireworkJoin(this); //linking FireworkJoin with Main
	   
    public void onEnable(){
		File file = new File(getDataFolder() + File.separator + "config.yml");
			
			if(!file.exists()){
				getLogger().info("Generating config.yml file....");
				
				getConfig().addDefault("Message", "This is my Message!");
				getConfig().options().copyDefaults(true);
				saveConfig();
			}
			
    	getLogger().info("HazardCommands Enabled!");
    	
    	pm.registerEvents(tnt, this); //registering NoMoreTNT
    	pm.registerEvents(fire, this); //registering FireworkJoin
    	
		getCommand("hub").setExecutor(new HubCommand()); //registering the Hub command using CommandExecutor
		getCommand("heal").setExecutor(new HealCommand()); //registering the Heal command using CommandExecutor
    	
    }
    public void onDisable() {
		getLogger().info("HazardCommands Disabled!");
    }
    
}