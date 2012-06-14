package fr.Shayana.dragonThing;

import net.minecraft.server.WorldServer;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.CraftWorld;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;



public class Commands{
	protected Main plugin;
	protected Dragon dragon;
	public Commands(Main plugin){
		this.plugin = plugin;
		
	}
	
	
	
	@EventHandler
	public boolean onCommand(CommandSender sender, Command command, String label, String args[]){
		
		if (label.equalsIgnoreCase("dragon")){
			Player p = (Player) sender;
			WorldServer world = ((CraftWorld) p.getWorld()).getHandle();
			dragon = new Dragon(p.getLocation(), world);
			world.addEntity(dragon);
		}
		return true;
	}
	
	
	
}
