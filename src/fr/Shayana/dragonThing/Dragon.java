package fr.Shayana.dragonThing;



import net.minecraft.server.EntityComplexPart;
import net.minecraft.server.EntityEnderDragon;
import net.minecraft.server.World;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;


public class Dragon extends EntityEnderDragon{

	Entity dragon = this.getBukkitEntity();

	// Player Location
	
	private double pX;
	private double pY;
	private double pZ;

	// Eye Location
	
	private double eX;
	private double eY;
	private double eZ;
	
	// Dragon Start
	
	private double sX;
	private double sY;
	private double sZ;
	
	// Dragon Target
	
	private double dX;
	private double dZ;
	
	// Dragon move points
	
	private double mX;
	private double mZ;
	private double mY;
	private double distanceX;
	private double distanceZ;
	
	

	public Dragon(Player p, World world){
		super(world);
		this.children = new EntityComplexPart[] { this.g = new EntityComplexPart(this, "head", 6.0F, 6.0F),  this.h = new EntityComplexPart(this, "body", 8.0F, 8.0F), this.i = new EntityComplexPart(this, "tail", 4.0F, 4.0F), this.j = new EntityComplexPart(this, "tail", 4.0F, 4.0F), this.k = new EntityComplexPart(this, "tail", 4.0F, 4.0F), this.l = new EntityComplexPart(this, "wing", 4.0F, 4.0F), this.m = new EntityComplexPart(this, "wing", 4.0F, 4.0F) };

		//Player position
		
		pX = p.getLocation().getX();
		pY = p.getLocation().getY();
		pZ = p.getLocation().getZ();
		
		// Player's eye direction
		
		eX = p.getTargetBlock(null, 100).getX();
		eY = p.getTargetBlock(null, 100).getY();
		eZ = p.getTargetBlock(null, 100).getZ();
		
		// Dragon start Location 
		sX = pX;
		sY = pY + 20;
		sZ = pZ;
		setPosition(sX, sY , sZ);
	}
		
			


	public void setMove(){
		
		
		if (eX > pX){
			dX = pX + 25;
		}
		if (eX < pX){
			dX = pX - 25;
		}
		if (eX == pX){
			dX = pX;
		}
		if (eZ > pZ){
			dZ = pZ + 25;
		}
		if (eY < pZ){
			dZ = pZ - 25;
		}
		if (eZ == pZ){
			dZ = pZ;
		}
		
		
		distanceX = pX - dX;
        distanceZ = pZ - dZ;
        
        double tick = Math.sqrt((distanceX * distanceX) + 0 + (distanceZ * distanceZ)) / 2;
        mX = Math.abs(distanceX) / tick;
        mZ = Math.abs(distanceZ) / tick;
        mY = sY;
    }
		
	
	
	
	
	@Override
	public void e(){
		 setMove();
		 setPosition(mX, mY, mZ);
	}
	


	
	
	
	
}