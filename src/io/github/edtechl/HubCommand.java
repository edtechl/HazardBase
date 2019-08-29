package io.github.edtechl;
 
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
 
public class HubCommand implements CommandExecutor {
	
	//For linking commands with Main you don't use listener, instead you use CommandExecutor
	
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
    	if(sender instanceof Player){
    		Player player = (Player) sender;
    		if(cmd.getName().equalsIgnoreCase("hub")){
				if(sender.isOp()){
    			String hub = "spawn " + player.getName();
    			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), hub);
    			player.sendMessage(ChatColor.AQUA + "Returning to Hub!");
				} else {
					sender.sendMessage(ChatColor.RED + "You do not have permission!");
				}
    		}
    	}
    return false;
    }
    
}