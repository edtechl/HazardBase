package io.github.edtechl;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HealCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(label.equalsIgnoreCase("heal")) {
			if(sender.isOp()) {
				if(args.length == 0) {
					Player player = (Player) sender;
					player.setHealth(20);
					player.sendMessage(ChatColor.GOLD + "You have been healed!");
				}
				else {
					sender.sendMessage(ChatColor.RED + "Incorrect Usage");
				}
			}
			else {
				sender.sendMessage(ChatColor.RED + "You do not have permission!"); //the no permission thingy goes here because this line is under the 
																					//squiggly bracket that asks the server if the sender is op
			}
		}
		return false;
	}
	
}
