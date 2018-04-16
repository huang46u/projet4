package behaivortree;

import applications.simpleworld.Agent;
import worlds.World;

public class NodeMove extends ActionNode {

	public NodeMove(Agent animal, World myWorld) {
		super(animal, myWorld);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int run() {
		animal.setEnergy(animal.getEnergy()-10);
		System.out.println("move");
		return Complete;
	}

}
