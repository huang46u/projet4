// ### WORLD OF CELLS ### 
// created by nicolas.bredeche(at)upmc.fr
// date of creation: 2013-1-12

package applications.simpleworld;

import com.jogamp.opengl.GL2;

import objects.UniqueDynamicObject;

import worlds.World;

public abstract class Agent extends Vie {
	protected double energy;
	public Agent ( int __x , int __y, World __world )
	{
		super(__x,__y,__world);
		energy=100;
		
	}
	public void dormir(){
		energy+=20;
	};
	
	public void bouge(){
		double dice = Math.random();
		if ( dice < 0.25 )
			this.x = ( this.x + 1 ) % this.world.getWidth() ;
		else
			if ( dice < 0.5 )
				this.x = ( this.x - 1 +  this.world.getWidth() ) % this.world.getWidth() ;
			else
				if ( dice < 0.75 )
					this.y = ( this.y + 1 ) % this.world.getHeight() ;
				else
					this.y = ( this.y - 1 +  this.world.getHeight() ) % this.world.getHeight() ;
	
		
	}	
	
    public abstract void displayUniqueObject(World myWorld, GL2 gl, int offsetCA_x, int offsetCA_y, float offset, float stepX, float stepY, float lenX, float lenY, float normalizeHeight);
}
