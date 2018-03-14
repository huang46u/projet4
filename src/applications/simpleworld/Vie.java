package applications.simpleworld;


import objects.UniqueDynamicObject;
import objects.UniqueObject;
import worlds.World;

public abstract class Vie extends UniqueDynamicObject {
	
	protected int hp;
	protected boolean alive;
	
	public Vie(int __x, int __y, World __world) {
		super(__x, __y, __world);
		hp=100;
		alive=true;
		// TODO Auto-generated constructor stub
	}
	public double distance(Vie v){
		int detaX=x-v.x>0? x-v.x : v.x-x;
		int detaY=y-v.y>0? y-v.y : v.y-y;
		if(detaX>world.getWidth()/2){
			detaX=(2*world.getWidth()-2*detaX)/2;
		}
		if(detaY>world.getHeight()/2){
			detaY=(2*world.getHeight()-2*detaY)/2;
		}
		return Math.sqrt(detaX*detaX+detaY*detaY);
	}
	
	
}
