// ### WORLD OF CELLS ### 
// created by nicolas.bredeche(at)upmc.fr
// date of creation: 2013-1-12

package applications.simpleworld;

import com.jogamp.opengl.GL2;

import worlds.World;

public abstract class Agent extends Vie {
	protected String sex;
	protected boolean majority;
	protected double energy;
	protected int iter;
	
	
	public Agent (int __x , int __y, World __world)
	{
		super(__x,__y,__world);
		if(Math.random()>0.5){
			sex="male";
		}
		else{
		sex="female";
	}
		majority=false;
		energy=100;
		
	}
	public int getIter() {
		return iter;
	}
	
	public void dormir(){
		if(world.isNIGHT()){
			energy=100;
		}
		else{
		if(energy<100)
		energy+=1;
		}
	};
	public boolean isMajority() {
		return majority;
	}
	public double getEnergy() {
		return energy;
	}
	public void setEnergy(double energy) {
		this.energy = energy;
	}
	public void bouge(){
		int d_pX=( this.x + 1 ) % this.world.getWidth() ;
		int d_pY= ( this.y + 1 ) % this.world.getHeight() ;
		int d_mX=( this.x - 1 +  this.world.getWidth() ) % this.world.getWidth();
		int d_mY=( this.y - 1 +  this.world.getHeight() ) % this.world.getHeight() ;
		double dice = Math.random();
		if ( dice < 0.25 ){
			if((world.getCellHeight(d_pX, y)>0)&&(world.getCellHeight(d_pX, y)<0.8))//volcan ou l'eau
				this.x = d_pX ;
			else{
				this.x=d_mX;
			}
		}
		else{
			if ( dice < 0.5 ){
				if((world.getCellHeight(d_mX, y)>0)&&(world.getCellHeight(d_mX, y)<0.8))
				this.x =d_mX;
				else{
					this.x=d_pX;
				}
			}
			else
				if ( dice < 0.75 ){
					if((world.getCellHeight(x,d_pY)>0)&&(world.getCellHeight(x, d_pY)<0.8))
						this.y = d_pY ;
					else{
						this.y=d_mY;
					}
				}
				else{
					if((world.getCellHeight(x, d_mY)>0)&&(world.getCellHeight(x, d_mY)<0.8))
					this.y = d_mY;
					else{
						this.y = d_pY;
					}
				
					
				}
		}
	}	
	public abstract void generateBehaivortree();
	
    public abstract void displayUniqueObject(World myWorld, GL2 gl, int offsetCA_x, int offsetCA_y, float offset, float stepX, float stepY, float lenX, float lenY, float normalizeHeight);
}
