package applications.simpleworld;

import com.jogamp.opengl.GL2;

import worlds.World;

public class Predator extends Agent{

	public Predator(int __x, int __y, World __world) {
		super(__x, __y, __world);
		// TODO Auto-generated constructor stub
	}
	
	public Proie rechercher_Proie(){
		double min_dis=Double.MAX_VALUE;
		Proie p=null;
		for(int i=0;i<world.getProie().size();i++){
			double dis=distance(world.getProie().get(i));
			if(dis<min_dis){
				min_dis=dis;
				p=world.getProie().get(i);
			}
		}
		return p;
	}
	public boolean peut_manger(Proie p) {
		return (this.distance(p)<=1);
	}
		public void chasser(Proie p){
			double r=0.5;
			int disy=p.getCoordinate()[1]-y;
			int disx=p.getCoordinate()[0]-x;
			if(disx==0){
				if(disy>0){
					if(disy>world.getHeight()/2)
						this.y = ( this.y - 1 +  this.world.getHeight() ) % this.world.getHeight() ;
					else	
						this.y = ( this.y + 1 ) % this.world.getHeight() ;
				}else{
					if(-disy>world.getHeight()/2)
						this.y = ( this.y + 1 ) % this.world.getHeight() ;
					else
						this.y = ( this.y - 1 +  this.world.getHeight() ) % this.world.getHeight() ;
				}
			}
			
			if(disy==0){
				if(disx>0){
					if(disx>world.getWidth()/2)
						this.x = ( this.x - 1 +  this.world.getWidth() ) % this.world.getWidth() ;
					else
						this.x = ( this.x + 1 ) % this.world.getWidth() ;
				}else{
					if(-disx>world.getWidth()/2)
						this.x = ( this.x + 1 ) % this.world.getWidth() ;
					else
						this.x = ( this.x - 1 +  this.world.getWidth() ) % this.world.getWidth() ;
			}
			}	
				
			if(disx<0&&disy<0){
				if(Math.random()<r){
					if(-disx>world.getWidth()/2)
						this.x = ( this.x + 1 ) % this.world.getWidth() ;
					else
						this.x = ( this.x - 1 +  this.world.getWidth() ) % this.world.getWidth() ;
				}
				else{
					if(-disy>world.getHeight()/2)
						this.y = ( this.y + 1 ) % this.world.getHeight() ;
					else
						this.y = ( this.y - 1 +  this.world.getHeight() ) % this.world.getHeight() ;
				}
			}
			
			
			if(disx>0&&disy<0){
				if(Math.random()<r){
					if(disx>world.getWidth()/2)
						this.x = ( this.x - 1 +  this.world.getWidth() ) % this.world.getWidth() ;
					else
						this.x = ( this.x + 1 ) % this.world.getWidth() ;
				}
				else{
					if(-disy>world.getHeight()/2)
						this.y = ( this.y + 1 ) % this.world.getHeight() ;
					else
						this.y = ( this.y - 1 +  this.world.getHeight() ) % this.world.getHeight() ;
				}
			}
			
			
			if(disx<0&&disy>0){
				if(Math.random()<r){
					if(-disx>world.getWidth()/2)
						this.x = ( this.x + 1 ) % this.world.getWidth() ;
					else
						this.x = ( this.x - 1 +  this.world.getWidth() ) % this.world.getWidth() ;
				}
				else{
					if(disy>world.getHeight()/2)
						this.y = ( this.y - 1 +  this.world.getHeight() ) % this.world.getHeight() ;
					else	
						this.y = ( this.y + 1 ) % this.world.getHeight() ;
				}
			}
			
			
			if(disx>0&&disy>0){
				if(Math.random()<r){
					if(disx>world.getWidth()/2)
						this.x = ( this.x - 1 +  this.world.getWidth() ) % this.world.getWidth() ;
					else
						this.x = ( this.x + 1 ) % this.world.getWidth() ;
				}
				else{
					if(disy>world.getHeight()/2)
						this.y = ( this.y - 1 +  this.world.getHeight() ) % this.world.getHeight() ;
					else	
						this.y = ( this.y + 1 ) % this.world.getHeight() ;
				}
			}
		
	}
	
	public void manger(Proie p) {
		if(peut_manger(p)){
				this.x=p.getCoordinate()[0];
				this.y=p.getCoordinate()[1];
				p.alive=false;
				hp+=30;
		}
	}
	
	@Override
	public void step() {
		if ( world.getIteration() % 10 == 0 ){
		
			hp-=0.1;
			energy-=0.1;
			if(energy<=20){
				dormir();
				return;
			}
			if(hp<80&& world.getProie().size()!=0){
				Proie p=rechercher_Proie();
				
					if(peut_manger(p)){
						manger(p);
					}
					else{
						chasser(p);
					}
			}
			else{
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
		}
	}

	 public void displayUniqueObject(World myWorld, GL2 gl, int offsetCA_x, int offsetCA_y, float offset, float stepX, float stepY, float lenX, float lenY, float normalizeHeight)
	    {

	        // display a monolith
	        
	        //gl.glColor3f(0.f+(float)(0.5*Math.random()),0.f+(float)(0.5*Math.random()),0.f+(float)(0.5*Math.random()));
	        
	    	int x2 = (x-(offsetCA_x%myWorld.getWidth()));
	    	if ( x2 < 0) x2+=myWorld.getWidth();
	    	int y2 = (y-(offsetCA_y%myWorld.getHeight()));
	    	if ( y2 < 0) y2+=myWorld.getHeight();

	    	float height = Math.max ( 0 , (float)myWorld.getCellHeight(x, y) );
	    	
	        gl.glColor3f(1.f,1.f,1.f);
	        gl.glVertex3f( offset+x2*stepX-lenX, offset+y2*stepY-lenY, height*normalizeHeight);
	        gl.glVertex3f( offset+x2*stepX-lenX, offset+y2*stepY-lenY, height*normalizeHeight + 4.f);
	        gl.glVertex3f( offset+x2*stepX+lenX, offset+y2*stepY-lenY, height*normalizeHeight + 4.f);
	        gl.glVertex3f( offset+x2*stepX+lenX, offset+y2*stepY-lenY, height*normalizeHeight);

	        gl.glColor3f(1.f,1.f,1.f);
	        gl.glVertex3f( offset+x2*stepX+lenX, offset+y2*stepY+lenY, height*normalizeHeight);
	        gl.glVertex3f( offset+x2*stepX+lenX, offset+y2*stepY+lenY, height*normalizeHeight + 4.f);
	        gl.glVertex3f( offset+x2*stepX-lenX, offset+y2*stepY+lenY, height*normalizeHeight + 4.f);
	        gl.glVertex3f( offset+x2*stepX-lenX, offset+y2*stepY+lenY, height*normalizeHeight);
	        
	        gl.glColor3f(1.f,1.f,1.f);
	        gl.glVertex3f( offset+x2*stepX+lenX, offset+y2*stepY-lenY, height*normalizeHeight);
	        gl.glVertex3f( offset+x2*stepX+lenX, offset+y2*stepY-lenY, height*normalizeHeight + 4.f);
	        gl.glVertex3f( offset+x2*stepX+lenX, offset+y2*stepY+lenY, height*normalizeHeight + 4.f);
	        gl.glVertex3f( offset+x2*stepX+lenX, offset+y2*stepY+lenY, height*normalizeHeight);

	        gl.glColor3f(1.f,1.f,1.f);
	        gl.glVertex3f( offset+x2*stepX-lenX, offset+y2*stepY+lenY, height*normalizeHeight);
	        gl.glVertex3f( offset+x2*stepX-lenX, offset+y2*stepY+lenY, height*normalizeHeight + 4.f);
	        gl.glVertex3f( offset+x2*stepX-lenX, offset+y2*stepY-lenY, height*normalizeHeight + 4.f);
	        gl.glVertex3f( offset+x2*stepX-lenX, offset+y2*stepY-lenY, height*normalizeHeight);

	        gl.glColor3f(1.0f,0.f,0.f);
	        gl.glVertex3f( offset+x2*stepX-lenX, offset+y2*stepY-lenY, height*normalizeHeight + 5.f);
	        gl.glVertex3f( offset+x2*stepX-lenX, offset+y2*stepY+lenY, height*normalizeHeight + 5.f);
	        gl.glVertex3f( offset+x2*stepX+lenX, offset+y2*stepY+lenY, height*normalizeHeight + 5.f);
	        gl.glVertex3f( offset+x2*stepX+lenX, offset+y2*stepY-lenY, height*normalizeHeight + 5.f);
	    }



	
}
