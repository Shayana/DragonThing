package fr.Shayana.dragonThing;

import java.lang.reflect.Method;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin {

	
	protected Commands commands;


	public void onEnable(){
		this.commands = new Commands(this);
		
		  try{
	            @SuppressWarnings("rawtypes")
	            Class[] args = new Class[3];
	            args[0] = Class.class;
	            args[1] = String.class;
	            args[2] = int.class;
	 
	            Method a = net.minecraft.server.EntityTypes.class.getDeclaredMethod("a", args);
	            a.setAccessible(true);
	 
	            a.invoke(a, Dragon.class, "Dragon", 63);
	        }catch (Exception e){
	            e.printStackTrace();
	            this.setEnabled(false);
	        }
		  System.out.println(this.getDescription().getName() + " par " + this.getDescription().getAuthors()+ " activé !");
	}
	
	
	public void onDisable(){
		
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command,String label, String args[]){
		return commands.onCommand(sender, command, label, args);
	}
	
	
	
}