// ### WORLD OF CELLS ### 
// created by nicolas.bredeche(at)upmc.fr
// date of creation: 2013-1-12

package applications.simpleworld;

import com.jogamp.opengl.GL2;

import objects.UniqueDynamicObject;

import worlds.World;

public abstract class Agent extends Vie {
	public double getEnergy() {
		return energy;
	}
	public void setEnergy(double energy) {
		this.energy = energy;
	}

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
		int d_pX=( this.x + 1 ) % this.world.getWidth() ;
		int d_pY= ( this.y + 1 ) % this.world.getHeight() ;
		int d_mX=( this.x - 1 +  this.world.getWidth() ) % this.world.getWidth();
		int d_mY=( this.y - 1 +  this.world.getHeight() ) % this.world.getHeight() ;
		double dice = Math.random();
		if ( dice < 0.25 ){
			
			if((world.getCellHeight(d_pX, y)>0)&&(world.getCellHeight(d_pX, y)<0.8))
			this.x = d_pX ;
			}
		else
			if ( dice < 0.5 ){
				if((world.getCellHeight(d_mX, y)>0)&&(world.getCellHeight(d_mX, y)<0.8))
				this.x =d_mX;
			}
			else
				if ( dice < 0.75 ){
					if((world.getCellHeight(x,d_pY)>0)&&(world.getCellHeight(x, d_pY)<0.8))
					this.y = d_pY ;
					}
				else{
					if((world.getCellHeight(x, d_mY)>0)&&(world.getCellHeight(x, d_mY)<0.8))
					this.y = d_mY;
				}
		
	}	
	
    public abstract void displayUniqueObject(World myWorld, GL2 gl, int offsetCA_x, int offsetCA_y, float offset, float stepX, float stepY, float lenX, float lenY, float normalizeHeight);
}
