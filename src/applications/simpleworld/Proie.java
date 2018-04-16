package applications.simpleworld;

import java.util.ArrayList;

import com.jogamp.opengl.GL2;

import worlds.World;

public class Proie extends Agent {

	public Proie(int __x, int __y, World __world) {
		super(__x, __y, __world);
		// TODO Auto-generated constructor stub
	}
	
	public boolean peut_manger(Plante p) {
		return (this.distance(p)<=1);
	}
	
	public Plante rechercher_plante(){
		double min_dis=Double.POSITIVE_INFINITY;
		Plante p=null;
		for(int i=0;i<world.getPlante().size();i++){
			double dis=distance(world.getPlante().get(i));
			if(dis<min_dis){
				min_dis=dis;
				p=world.getPlante().get(i);
			}
		}
		return p;
	}
	
	@Override
	public void step() {
		if ( world.getIteration() % 10 == 0 ){
		
			setHp(getHp() - 0.1);
			energy-=0.1;
			if(estDangerous()){
				ArrayList<Predator> pred=predatorTropProch();
				enfuir(lePlusProch(pred));
				
			}
			else{
			if(energy<=20){
				dormir();
				return;
			}
			if(getHp()<80&& world.getPlante().size()!=0){
				Plante p=rechercher_plante();
				System.out.println(p);
					if(peut_manger(p)){
						manger(p);
					}
					else{
						
						bouger_ver_plante(p);
					}
			}
			else{
				bouge();
				}
			}
		}
	}

	public void bouger_ver_plante(Plante p) {
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
	public void manger(Plante p) {
		if(peut_manger(p)){
				this.x=p.getCoordinate()[0];
				this.y=p.getCoordinate()[1];
				p.alive=false;
				setHp(getHp() + 30);
		}
	}
	
	public ArrayList<Predator> predatorTropProch(){
		ArrayList<Predator> predators=new ArrayList<Predator>();
		for(int i=0;i<world.getPredator().size();i++){
			double dis=distance(world.getPredator().get(i));
			if(dis<20){
				predators.add(world.getPredator().get(i));
			}
		}
		return predators;
	} 
	public Predator lePlusProch(ArrayList<Predator> p){
		double min_dis=Double.POSITIVE_INFINITY;
		Predator pred=null;
		for(int i=0;i<p.size();i++){
			double dis=distance(p.get(i));
			if(dis<min_dis){
				min_dis=dis;
				pred=p.get(i);
			}
		}
		return pred;
	}
	public boolean estDangerous(){
		for(int i=0;i<world.getPredator().size();i++){
			double dis=distance(world.getPredator().get(i));
			if(dis<20){
				return true;
			}
		}
		return false;
	}
	public void enfuir(Predator p) {
		double r=0.5;
		int disy=p.getCoordinate()[1]-y;
		int disx=p.getCoordinate()[0]-x;
		if(disx==0){
			if(disy<0){
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
			if(disx<0){
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
			
		if(disx>0&&disy>0){
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
		
		
		if(disx<0&&disy>0){
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
		
		
		if(disx>0&&disy<0){
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
		
		
		if(disx<0&&disy<0){
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
	
	public void displayUniqueObject(World myWorld, GL2 gl, int offsetCA_x, 
			int offsetCA_y, float offset, float stepX, float stepY, float lenX, float lenY, float normalizeHeight){
	int x2 = (x-(offsetCA_x%myWorld.getWidth()));
	if ( x2 < 0) x2+=myWorld.getWidth();
	int y2 = (y-(offsetCA_y%myWorld.getHeight()));
	if ( y2 < 0) y2+=myWorld.getHeight();

	float height = Math.max ( 0 , (float)myWorld.getCellHeight(x, y) );
	
	gl.glPushMatrix();
		gl.glTranslatef(offset+x2*stepX, offset+y2*stepY, height*normalizeHeight);
		
//    gl.glColor3f(1.f,1.f,1.f);
//    gl.glVertex3f( offset+x2*stepX-lenX, offset+y2*stepY-lenY, height*normalizeHeight);
//    gl.glVertex3f( offset+x2*stepX-lenX, offset+y2*stepY-lenY, height*normalizeHeight + 4.f);
//    gl.glVertex3f( offset+x2*stepX+lenX, offset+y2*stepY-lenY, height*normalizeHeight + 4.f);
//    gl.glVertex3f( offset+x2*stepX+lenX, offset+y2*stepY-lenY, height*normalizeHeight);
//
//    gl.glColor3f(1.f,1.f,1.f);
//    gl.glVertex3f( offset+x2*stepX+lenX, offset+y2*stepY+lenY, height*normalizeHeight);
//    gl.glVertex3f( offset+x2*stepX+lenX, offset+y2*stepY+lenY, height*normalizeHeight + 4.f);
//    gl.glVertex3f( offset+x2*stepX-lenX, offset+y2*stepY+lenY, height*normalizeHeight + 4.f);
//    gl.glVertex3f( offset+x2*stepX-lenX, offset+y2*stepY+lenY, height*normalizeHeight);
//    
//    gl.glColor3f(1.f,1.f,1.f);
//    gl.glVertex3f( offset+x2*stepX+lenX, offset+y2*stepY-lenY, height*normalizeHeight);
//    gl.glVertex3f( offset+x2*stepX+lenX, offset+y2*stepY-lenY, height*normalizeHeight + 4.f);
//    gl.glVertex3f( offset+x2*stepX+lenX, offset+y2*stepY+lenY, height*normalizeHeight + 4.f);
//    gl.glVertex3f( offset+x2*stepX+lenX, offset+y2*stepY+lenY, height*normalizeHeight);
//
//    gl.glColor3f(1.f,1.f,1.f);
//    gl.glVertex3f( offset+x2*stepX-lenX, offset+y2*stepY+lenY, height*normalizeHeight);
//    gl.glVertex3f( offset+x2*stepX-lenX, offset+y2*stepY+lenY, height*normalizeHeight + 4.f);
//    gl.glVertex3f( offset+x2*stepX-lenX, offset+y2*stepY-lenY, height*normalizeHeight + 4.f);
//    gl.glVertex3f( offset+x2*stepX-lenX, offset+y2*stepY-lenY, height*normalizeHeight);
//
//    gl.glColor3f(1.0f,1.f,0.f);
//    gl.glVertex3f( offset+x2*stepX-lenX, offset+y2*stepY-lenY, height*normalizeHeight + 5.f);
//    gl.glVertex3f( offset+x2*stepX-lenX, offset+y2*stepY+lenY, height*normalizeHeight + 5.f);
//    gl.glVertex3f( offset+x2*stepX+lenX, offset+y2*stepY+lenY, height*normalizeHeight + 5.f);
//    gl.glVertex3f( offset+x2*stepX+lenX, offset+y2*stepY-lenY, height*normalizeHeight + 5.f);
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

        gl.glColor3f(1.0f,1.0f,0.f);
        gl.glVertex3f( -lenX, -lenY, 5.f);
        gl.glVertex3f( -lenX, lenY, 5.f);
        gl.glVertex3f( lenX, lenY, 5.f);
        gl.glVertex3f( lenX, -lenY, 5.f);
        gl.glEnd();
        gl.glPopMatrix();
	}	
}
