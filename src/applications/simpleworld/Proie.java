package applications.simpleworld;

import java.util.ArrayList;

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
		
			hp-=0.1;
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
			if(hp<80&& world.getPlante().size()!=0){
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
				hp+=30;
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
}