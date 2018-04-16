package behaivortree;

import applications.simpleworld.Agent;
import worlds.World;

public class NodeCanEat extends ConditionNode {

	public NodeCanEat(Agent animal, World myWorld) {
		super(animal, myWorld);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int run() {
		return True;
	}

}
