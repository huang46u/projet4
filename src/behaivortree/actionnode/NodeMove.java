package behaivortree.actionnode;

import applications.simpleworld.Agent;
import behaivortree.ActionNode;
import worlds.World;

public class NodeMove extends ActionNode {

	public NodeMove(Agent animal, World myWorld) {
		super(animal, myWorld);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int run() {
		System.out.println("move");
		animal.setEnergy(animal.getEnergy()-1);
		int x=animal.getCoordinate()[0];
		int y=animal.getCoordinate()[1];
		
		int d_pX=( x + 1 ) % myWorld.getWidth() ;
		int d_pY= ( y + 1 ) % myWorld.getHeight() ;
		int d_mX=( x - 1 +  myWorld.getWidth() ) % myWorld.getWidth();
		int d_mY=( y - 1 +  myWorld.getHeight() ) % myWorld.getHeight() ;
		double dice = Math.random();
		if ( dice < 0.25 ){
			if((myWorld.getCellHeight(d_pX, y)>0)&&(myWorld.getCellHeight(d_pX, y)<0.8))
				animal.setCoordinateX(d_pX);
			}
		else
			if ( dice < 0.5 ){
				if((myWorld.getCellHeight(d_mX, y)>0)&&(myWorld.getCellHeight(d_mX, y)<0.8))
					animal.setCoordinateX(d_mX);
			}
			else
				if ( dice < 0.75 ){
					if((myWorld.getCellHeight(x,d_pY)>0)&&(myWorld.getCellHeight(x, d_pY)<0.8))
						animal.setCoordinateY(d_pY);
					}
				else{
					if((myWorld.getCellHeight(x, d_mY)>0)&&(myWorld.getCellHeight(x, d_mY)<0.8))
						animal.setCoordinateX(d_mY);
				}	
		return Complete;
	}

}
