package io.github.edtechl;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class NoMoreTNT implements Listener {
	
	public Main main;
	
	public NoMoreTNT(Main instance){
		main = instance;
	}
	
	public static Material[] banList = {Material.TNT};
	
	@EventHandler
	
	public void onBlockPlace(BlockPlaceEvent event){
		Material block = event.getBlock().getType();
		Player player = event.getPlayer();
		
		for(Material blocked : banList){
			if(blocked == block){
				if(player.isOp()){
					//Nothing, so blocks can be placed.
				}
				else{
					event.getBlock().setType(Material.CAKE_BLOCK);
					player.sendMessage(ChatColor.DARK_RED + "You are not permitted to place TNT!");
				}
			}
			
		}
	}
	
}