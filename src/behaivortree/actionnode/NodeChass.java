package behaivortree.actionnode;

import applications.simpleworld.Agent;
import applications.simpleworld.Plante;
import applications.simpleworld.Predator;
import applications.simpleworld.Proie;
import behaivortree.ActionNode;
import worlds.World;

public class NodeChass extends ActionNode {

	public NodeChass(Agent animal, World myWorld) {
		super(animal, myWorld);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int run() {
		Predator predator;
		Proie proie;
		Plante plante;
		if(animal instanceof Predator){
			 System.out.println("chass");
			 predator=(Predator)animal;
			 predator.setCible(rechercher_Proie());
			 proie=predator.getCible();
			 double r=0.5;
				int disy=proie.getCoordinate()[1]-animal.getCoordinate()[1];
				int disx=proie.getCoordinate()[0]-animal.getCoordinate()[0];
				if(disx==0){
					if(disy>0){
						if(disy>myWorld.getHeight()/2)
							animal.setCoordinateY((animal.getCoordinate()[1] - 1 +  this.myWorld.getHeight() ) % this.myWorld.getHeight()) ;
						else	
							animal.setCoordinateY(( animal.getCoordinate()[1] + 1 ) % this.myWorld.getHeight()) ;
					}else{
						if(-disy>myWorld.getHeight()/2)
							animal.setCoordinateY (( animal.getCoordinate()[1] + 1 ) % this.myWorld.getHeight() );
						else
							animal.setCoordinateY (( animal.getCoordinate()[1] - 1 +  this.myWorld.getHeight() ) % this.myWorld.getHeight() );
					}
				}
				
				if(disy==0){
					if(disx>0){
						if(disx>myWorld.getWidth()/2)
							animal.setCoordinateX( (animal.getCoordinate()[0] - 1 +  this.myWorld.getWidth() ) % this.myWorld.getWidth()) ;
						else
							animal.setCoordinateX( (animal.getCoordinate()[0] + 1 ) % this.myWorld.getWidth()) ;
					}else{
						if(-disx>myWorld.getWidth()/2)
							animal.setCoordinateX( (animal.getCoordinate()[0] + 1 ) % this.myWorld.getWidth()) ;
						else
							animal.setCoordinateX (( animal.getCoordinate()[0] - 1 +  this.myWorld.getWidth() ) % this.myWorld.getWidth() );
				}
				}	
					
				if(disx<0&&disy<0){
					if(Math.random()<r){
						if(-disx>myWorld.getWidth()/2)
							animal.setCoordinateX (( animal.getCoordinate()[0] + 1 ) % this.myWorld.getWidth() );
						else
							animal.setCoordinateX (( animal.getCoordinate()[0] - 1 +  this.myWorld.getWidth() ) % this.myWorld.getWidth()) ;
					}
					else{
						if(-disy>myWorld.getHeight()/2)
							animal.setCoordinateY (( animal.getCoordinate()[1] + 1 ) % this.myWorld.getHeight()) ;
						else
							animal.setCoordinateY (( animal.getCoordinate()[1] - 1 +  this.myWorld.getHeight() ) % this.myWorld.getHeight()) ;
					}
				}
				if(disx>0&&disy<0){
					if(Math.random()<r){
						if(disx>myWorld.getWidth()/2)
							animal.setCoordinateX (( animal.getCoordinate()[0] - 1 +  this.myWorld.getWidth() ) % this.myWorld.getWidth() );
						else
							animal.setCoordinateX(( animal.getCoordinate()[0] + 1 ) % this.myWorld.getWidth() );
					}
					else{
						if(-disy>myWorld.getHeight()/2)
							animal.setCoordinateY (( animal.getCoordinate()[1] + 1 ) % this.myWorld.getHeight()) ;
						else
							animal.setCoordinateY (( animal.getCoordinate()[1] - 1 +  this.myWorld.getHeight() ) % this.myWorld.getHeight()) ;
					}
				}
				if(disx<0&&disy>0){
					if(Math.random()<r){
						if(-disx>myWorld.getWidth()/2)
							animal.setCoordinateX (( animal.getCoordinate()[0] + 1 ) % this.myWorld.getWidth()) ;
						else
							animal.setCoordinateX (( animal.getCoordinate()[0] - 1 +  this.myWorld.getWidth() ) % this.myWorld.getWidth() );
					}
					else{
						if(disy>myWorld.getHeight()/2)
							animal.setCoordinateY  (( animal.getCoordinate()[1] - 1 +  this.myWorld.getHeight() ) % this.myWorld.getHeight() );
						else	
							animal.setCoordinateY (( animal.getCoordinate()[1] + 1 ) % this.myWorld.getHeight() );
					}
				}
				if(disx>0&&disy>0){
					if(Math.random()<r){
						if(disx>myWorld.getWidth()/2)
							animal.setCoordinateX (( animal.getCoordinate()[0] - 1 +  this.myWorld.getWidth() ) % this.myWorld.getWidth()) ;
						else
							animal.setCoordinateX( ( animal.getCoordinate()[0] + 1 ) % this.myWorld.getWidth()) ;
					}
					else{
						if(disy>myWorld.getHeight()/2)
							animal.setCoordinateY (( animal.getCoordinate()[1] - 1 +  this.myWorld.getHeight() ) % this.myWorld.getHeight()) ;
						else	
							animal.setCoordinateY( ( animal.getCoordinate()[1] + 1 ) % this.myWorld.getHeight() );
					}
				}
				if(animal.distance(proie)==0){
					proie.die();
					animal.setHp(100);
				}
		}
		else{
			proie= (Proie)animal;
			plante=proie.getCible();
			double r=0.5;
			int disy=plante.getCoordinate()[1]-animal.getCoordinate()[1];
			int disx=plante.getCoordinate()[0]-animal.getCoordinate()[0];
			if(disx==0){
				if(disy>0){
					if(disy>myWorld.getHeight()/2)
						animal.setCoordinateY ( ( animal.getCoordinate()[1] - 1 +  this.myWorld.getHeight() ) % this.myWorld.getHeight()) ;
					else	
						animal.setCoordinateY ( ( animal.getCoordinate()[1] + 1 ) % this.myWorld.getHeight()) ;
				}else{
					if(-disy>myWorld.getHeight()/2)
						animal.setCoordinateY(( animal.getCoordinate()[1] + 1 ) % this.myWorld.getHeight()) ;
					else
						animal.setCoordinateY (( animal.getCoordinate()[1] - 1 +  this.myWorld.getHeight() ) % this.myWorld.getHeight()) ;
				}
			}
			
			if(disy==0){
				if(disx>0){
					if(disx>myWorld.getWidth()/2)
						animal.setCoordinateX( (animal.getCoordinate()[0] - 1 +  this.myWorld.getWidth() ) % this.myWorld.getWidth()) ;
					else
						animal.setCoordinateX( (animal.getCoordinate()[0] + 1 ) % this.myWorld.getWidth()) ;
				}else{
					if(-disx>myWorld.getWidth()/2)
						animal.setCoordinateX( (animal.getCoordinate()[0] + 1 ) % this.myWorld.getWidth()) ;
					else
						animal.setCoordinateX ( (animal.getCoordinate()[0] - 1 +  this.myWorld.getWidth() ) % this.myWorld.getWidth()) ;
			}
			}	
				
			if(disx<0&&disy<0){
				if(Math.random()<r){
					if(-disx>myWorld.getWidth()/2)
						animal.setCoordinateX( (animal.getCoordinate()[0] + 1 ) % this.myWorld.getWidth()) ;
					else
						animal.setCoordinateX (( animal.getCoordinate()[0] - 1 +  this.myWorld.getWidth() ) % this.myWorld.getWidth()) ;
				}
				else{
					if(-disy>myWorld.getHeight()/2)
						animal.setCoordinateY ( ( animal.getCoordinate()[1] + 1 ) % this.myWorld.getHeight()) ;
					else
						animal.setCoordinateY (( animal.getCoordinate()[1] - 1 +  this.myWorld.getHeight() ) % this.myWorld.getHeight() );
				}
			}
			if(disx>0&&disy<0){
				if(Math.random()<r){
					if(disx>myWorld.getWidth()/2)
						animal.setCoordinateX (( animal.getCoordinate()[0] - 1 +  this.myWorld.getWidth() ) % this.myWorld.getWidth()) ;
					else
						animal.setCoordinateX (( animal.getCoordinate()[0] + 1 ) % this.myWorld.getWidth() );
				}
				else{
					if(-disy>myWorld.getHeight()/2)
						animal.setCoordinateY ( ( animal.getCoordinate()[1] + 1 ) % this.myWorld.getHeight()) ;
					else
						animal.setCoordinateY ( ( animal.getCoordinate()[1] - 1 +  this.myWorld.getHeight() ) % this.myWorld.getHeight() );
				}
			}
			if(disx<0&&disy>0){
				if(Math.random()<r){
					if(-disx>myWorld.getWidth()/2)
						animal.setCoordinateX(( animal.getCoordinate()[0] + 1 ) % this.myWorld.getWidth() );
					else
						animal.setCoordinateX (( animal.getCoordinate()[0] - 1 +  this.myWorld.getWidth() ) % this.myWorld.getWidth() );
				}
				else{
					if(disy>myWorld.getHeight()/2)
						animal.setCoordinateY ( ( animal.getCoordinate()[1] - 1 +  this.myWorld.getHeight() ) % this.myWorld.getHeight()) ;
					else	
						animal.setCoordinateY (( animal.getCoordinate()[1] + 1 ) % this.myWorld.getHeight() );
				}
			}
			if(disx>0&&disy>0){
				if(Math.random()<r){
					if(disx>myWorld.getWidth()/2)
						animal.setCoordinateX ( (animal.getCoordinate()[0] - 1 +  this.myWorld.getWidth() ) % this.myWorld.getWidth()) ;
					else
						animal.setCoordinateX(( animal.getCoordinate()[0] + 1 ) % this.myWorld.getWidth()) ;
				}
				else{
					if(disy>myWorld.getHeight()/2)
						animal.setCoordinateY (( animal.getCoordinate()[1] - 1 +  this.myWorld.getHeight() ) % this.myWorld.getHeight()) ;
					else	
						animal.setCoordinateY (( animal.getCoordinate()[1] + 1 ) % this.myWorld.getHeight()) ;
				}
			}
			if(proie.distance(plante)==0){
				plante.getGrammar().setResult(plante.getGrammar().getPrecRes());
			}
		} 
		return Complete;
	}
	
	public Proie rechercher_Proie(){
		double min_dis=Double.MAX_VALUE; 
		Proie p=null;
		for(int i=0;i<myWorld.getProie().size();i++){
			double dis=animal.distance(myWorld.getProie().get(i));
			if(dis<min_dis){
				min_dis=dis;
				p=myWorld.getProie().get(i);
			}
		}
		return p;
	}
		
	
}
