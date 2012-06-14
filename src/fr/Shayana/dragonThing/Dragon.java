package fr.Shayana.dragonThing;



import net.minecraft.server.EntityComplexPart;
import net.minecraft.server.EntityEnderDragon;
import net.minecraft.server.World;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Entity;


public class Dragon extends EntityEnderDragon{

	Entity dragon = this.getBukkitEntity();
	org.bukkit.World bukkitWorld;
	
	//Object location
	private double locX;
	private double locY;
	private double locZ;

	// Dragon Start
	
	private double startX;
	private double startY;
	private double startZ;

	
	//Where dragon flies down and up

	private double downY;
	
	private double upX;
	
	// Dragon's move points
	
	private double mX;
	private double mZ;
	private double mY;
	private double distanceX;
	private double distanceZ;
	private double distanceY;
	
	//Dragon's travel end
	
	private double lastX;
	private double lastZ;
	private double lastY = 150;
	private Location target;
	//Dragon location
	
	private double currentX; 
	private double currentZ; 
	private double currentY; 
	
	

	public Dragon(Location loc, World world){
		super(world);
		this.children = new EntityComplexPart[] { this.g = new EntityComplexPart(this, "head", 6.0F, 6.0F),  this.h = new EntityComplexPart(this, "body", 8.0F, 8.0F), this.i = new EntityComplexPart(this, "tail", 4.0F, 4.0F), this.j = new EntityComplexPart(this, "tail", 4.0F, 4.0F), this.k = new EntityComplexPart(this, "tail", 4.0F, 4.0F), this.l = new EntityComplexPart(this, "wing", 4.0F, 4.0F), this.m = new EntityComplexPart(this, "wing", 4.0F, 4.0F) };

		//Get the objet location
		this.locX = loc.getX();
		this.locY = loc.getY();
		this.locZ = loc.getZ();
		
		//Set up start Location
		
		this.bukkitWorld = loc.getWorld();
		this.startX = loc.getX() - 30;
		this.startZ = loc.getZ();
		this.startY = 130; //Clouds are at 127
		setPosition(startX, startY, startZ);
		//Set up stop flying down height
		
		this.downY = loc.getY() + 20;
		
		//Set up flying up location
		
		this.upX = loc.getX() + 20;
		
		//Set up remove points
		
		this.lastX = loc.getX() + 40;
		this.lastZ = loc.getZ();
		this.target = new Location(bukkitWorld, lastX, lastY, lastZ);
	}
	
	
	
		
		

//The dragon flies straight
	public void fly(){

		distanceX = lastX - currentX;
        distanceZ = lastZ - currentZ;
        
        double tick = Math.sqrt((distanceX * distanceX) + 0 + (distanceZ * distanceZ));
        mX = Math.abs(distanceX) / tick;
        mZ = Math.abs(distanceZ) / tick;
        mY = currentY;
       
    }
		

	
//The dragon flies down from the clouds
	public void flyDown(){
		
		distanceX = lastX - currentX ;
        distanceZ = lastZ - currentZ;
        distanceY = downY - currentY;
        double tick = Math.sqrt((distanceX * distanceX) + (distanceY * distanceY) + (distanceZ * distanceZ));
        mX = Math.abs(distanceX) / tick;
        mZ = Math.abs(distanceZ) / tick;
        mY = Math.abs(distanceY) / tick;
        

	}
	
	
//The dragon flies up to the clouds
	public void flyUp(){
		distanceX = lastX - currentX;
        distanceZ = lastZ - currentZ;
        distanceY = lastY - currentY;
        double tick = Math.sqrt((distanceX * distanceX) + (distanceY * distanceY) + (distanceZ * distanceZ));
        mX = Math.abs(distanceX) / tick;
        mZ = Math.abs(distanceZ) / tick;
        mY = Math.abs(distanceY) / tick;

	}
	

//What happens each server tick
		@Override
	public void e(){
		Bukkit.getServer().broadcastMessage(dragon.getLocation().toString());
		currentX = dragon.getLocation().getX();
		currentZ = dragon.getLocation().getZ();
		currentY = dragon.getLocation().getY();
		//The dragon is at the right height to disappear, and has made its travel allready
		if (currentY == lastY && currentX > locX){
			dragon.remove();
		}
		
		//The dragon is higher than the Y position where he's got to fly and has not done its travel
		if (currentY > downY && currentX < upX ){
			flyDown();
		}
		
		//The dragon is at the X position where he has to fly up
		if (currentX >= upX){
			flyUp();
		}
		else{
			fly();
		}
		Location mLoc = new Location(bukkitWorld, mX, mY, mZ);
		dragon.setVelocity(mLoc.toVector());
        setPosition(mX, mY, mZ);
        return;
		 
	}
	
	
	


	
	
	
	
}