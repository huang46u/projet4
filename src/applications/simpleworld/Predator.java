package applications.simpleworld;

import com.jogamp.opengl.GL2;

import behaivortree.CompositeNode;
import behaivortree.SelectorNode;
import behaivortree.SequenceNode;
import behaivortree.actionnode.NodeChass;
import behaivortree.actionnode.NodeMove;
import behaivortree.actionnode.NodeSleep;
import behaivortree.conditionnode.NodeHungry;
import behaivortree.conditionnode.NodeIsSummer;
import behaivortree.conditionnode.NodeIsWinter;
import behaivortree.conditionnode.NodeTired;
import worlds.World;

public class Predator extends Agent{
	private Proie cible;
	private CompositeNode AI;
	public Proie getCible() {
		return cible;
	}

	public void setCible(Proie cible) {
		this.cible = cible;
	}

	public Predator(int __x, int __y, World __world) {
		super(__x, __y, __world);
		this.generateBehaivortree();
		// TODO Auto-generated constructor stub
	}
	
	/*public Proie rechercher_Proie(){
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
				setHp(getHp() + 30);
		}
	}
	*/
	
	
	@Override
	public void step() {
		if ( world.getIteration() % 10 == 0 ){
			//AI.run();
			setHp(getHp() - 0.01);
			/*energy-=0.1;
			if(energy<=20){
				dormir();
				return;
			}
			if(getHp()<80&& world.getProie().size()!=0){
				Proie p=rechercher_Proie();
					if(peut_manger(p)){
						manger(p);
					}
					else{
						chasser(p);
					}
			}
			else{
				bouge();
			}*/
		}
	}

	 public void displayUniqueObject(World myWorld, GL2 gl, int offsetCA_x, int offsetCA_y, float offset, float stepX, float stepY, float lenX, float lenY, float normalizeHeight)
	 {
 			int x2 = (x-(offsetCA_x%myWorld.getWidth()));
	    	if ( x2 < 0) x2+=myWorld.getWidth();
	    	int y2 = (y-(offsetCA_y%myWorld.getHeight()));
	    	if ( y2 < 0) y2+=myWorld.getHeight();
	    	float trans_x=offset+x2*stepX;
	    	float trans_y=offset+y2*stepY;
	    	float height = Math.max ( 0 , (float)myWorld.getCellHeight(x, y) );
	    	
	    	gl.glPushMatrix();
	    		gl.glTranslatef(trans_x, trans_y, height*normalizeHeight);
	    		
	        // display a monolith1
	        
	        //gl.glColor3f(0.f+(float)(0.5*Math.random()),0.f+(float)(0.5*Math.random()),0.f+(float)(0.5*Math.random()));
	       
//	        gl.glColor3f(1.f,1.f,1.f);
//	        gl.glVertex3f( offset+x2*stepX-lenX, offset+y2*stepY-lenY, height*normalizeHeight);
//	        gl.glVertex3f( offset+x2*stepX-lenX, offset+y2*stepY-lenY, height*normalizeHeight + 4.f);
//	        gl.glVertex3f( offset+x2*stepX+lenX, offset+y2*stepY-lenY, height*normalizeHeight + 4.f);
//	        gl.glVertex3f( offset+x2*stepX+lenX, offset+y2*stepY-lenY, height*normalizeHeight);
//
//	        gl.glColor3f(1.f,1.f,1.f);
//	        gl.glVertex3f( offset+x2*stepX+lenX, offset+y2*stepY+lenY, height*normalizeHeight);
//	        gl.glVertex3f( offset+x2*stepX+lenX, offset+y2*stepY+lenY, height*normalizeHeight + 4.f);
//	        gl.glVertex3f( offset+x2*stepX-lenX, offset+y2*stepY+lenY, height*normalizeHeight + 4.f);
//	        gl.glVertex3f( offset+x2*stepX-lenX, offset+y2*stepY+lenY, height*normalizeHeight);
//	        
//	        gl.glColor3f(1.f,1.f,1.f);
//	        gl.glVertex3f( offset+x2*stepX+lenX, offset+y2*stepY-lenY, height*normalizeHeight);
//	        gl.glVertex3f( offset+x2*stepX+lenX, offset+y2*stepY-lenY, height*normalizeHeight + 4.f);
//	        gl.glVertex3f( offset+x2*stepX+lenX, offset+y2*stepY+lenY, height*normalizeHeight + 4.f);
//	        gl.glVertex3f( offset+x2*stepX+lenX, offset+y2*stepY+lenY, height*normalizeHeight);
//
//	        gl.glColor3f(1.f,1.f,1.f);
//	        gl.glVertex3f( offset+x2*stepX-lenX, offset+y2*stepY+lenY, height*normalizeHeight);
//	        gl.glVertex3f( offset+x2*stepX-lenX, offset+y2*stepY+lenY, height*normalizeHeight + 4.f);
//	        gl.glVertex3f( offset+x2*stepX-lenX, offset+y2*stepY-lenY, height*normalizeHeight + 4.f);
//	        gl.glVertex3f( offset+x2*stepX-lenX, offset+y2*stepY-lenY, height*normalizeHeight);
//
//	        gl.glColor3f(1.0f,0.f,0.f);
//	        gl.glVertex3f( offset+x2*stepX-lenX, offset+y2*stepY-lenY, height*normalizeHeight + 5.f);
//	        gl.glVertex3f( offset+x2*stepX-lenX, offset+y2*stepY+lenY, height*normalizeHeight + 5.f);
//	        gl.glVertex3f( offset+x2*stepX+lenX, offset+y2*stepY+lenY, height*normalizeHeight + 5.f);
//	        gl.glVertex3f( offset+x2*stepX+lenX, offset+y2*stepY-lenY, height*normalizeHeight + 5.f);
	        gl.glBegin(GL2.GL_QUADS);
	    	gl.glColor3f(1.f,1.f,1.f);
	        gl.glVertex3f(-lenX,-lenY, 0.0f);
	        gl.glVertex3f( -lenX, -lenY,4.f);
	        gl.glVertex3f( lenX, -lenY,4.f);
	        gl.glVertex3f( lenX, -lenY, 0.0f);

	        gl.glColor3f(1.f,1.f,1.f);
	        gl.glVertex3f( lenX, lenY, 0.0f);
	        gl.glVertex3f( lenX, lenY,  4.f);
	        gl.glVertex3f( -lenX, lenY,  4.f);
	        gl.glVertex3f( -lenX, lenY, 0.0f);
	        
	        gl.glColor3f(1.f,1.f,1.f);
	        gl.glVertex3f( lenX, -lenY, 0.0f);
	        gl.glVertex3f( lenX, -lenY,  4.f);
	        gl.glVertex3f( lenX, lenY, 4.f);
	        gl.glVertex3f( lenX, lenY, 0.0f);

	        gl.glColor3f(1.f,1.f,1.f);
	        gl.glVertex3f( -lenX, lenY, 0.0f);
	        gl.glVertex3f( -lenX, lenY, 4.f);
	        gl.glVertex3f( -lenX, -lenY,  4.f);
	        gl.glVertex3f( -lenX, -lenY, 0.0f);

	        gl.glColor3f(1.0f,0.f,0.f);
	        gl.glVertex3f( -5*lenX, -5*lenY, 5.f);
	        gl.glVertex3f( -5*lenX, 5*lenY, 5.f);
	        gl.glVertex3f( 5*lenX, 5*lenY, 5.f);
	        gl.glVertex3f( 5*lenX, -5*lenY, 5.f);
	        gl.glEnd();
	        gl.glPopMatrix();
	    }

	@Override
	public void generateBehaivortree() {
		AI=new SelectorNode();
		CompositeNode Summer=new SequenceNode();
		CompositeNode Winter=new SequenceNode(); 
		NodeIsSummer Node_Summer=new NodeIsSummer(this,world);
		NodeIsWinter Node_Winter=new NodeIsWinter(this,world);
		NodeChass Node_Chass=new NodeChass(this,world);
		NodeHungry Node_Hungry=new NodeHungry(this,world);
		NodeMove Node_move=new NodeMove(this,world);
		NodeSleep Node_Sleep=new NodeSleep(this,world);
		NodeTired Node_Tired=new NodeTired(this,world);
		CompositeNode Comportement=new SelectorNode();
		CompositeNode Sleep=new SequenceNode();
		CompositeNode Eat=new SequenceNode();
		CompositeNode Chass=new SequenceNode();
		Comportement.addNode(Sleep);
		Sleep.addNode(Node_Tired);
		Sleep.addNode(Node_Sleep);
		Comportement.addNode(Eat);
		Eat.addNode(Node_Hungry);
		Eat.addNode(Chass);
		Chass.addNode(Node_Chass);
		Comportement.addNode(Node_move);
		Summer.addNode(Node_Summer);
		Summer.addNode(Comportement);
		Winter.addNode(Node_Winter);
		Winter.addNode(Node_Sleep);
		AI.addNode(Summer);
		AI.addNode(Winter);
		
	}



	
}
