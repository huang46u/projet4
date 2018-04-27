package behaivortree.actionnode;

import applications.simpleworld.Agent;
import behaivortree.ActionNode;
import worlds.World;

public class NodeSleep extends ActionNode {

	public NodeSleep(Agent animal, World myWorld) {
		super(animal, myWorld);
		// TODO Auto-generated constructor stub
	}


	@Override
	public int run() {
		animal.setEnergy(animal.getEnergy()+10);
		if(animal.getEnergy()<100){
			System.out.println("sleep");
			return Running;
		}
		return Complete;
	}

}
