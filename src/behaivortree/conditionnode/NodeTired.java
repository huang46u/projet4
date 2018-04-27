package behaivortree.conditionnode;

import applications.simpleworld.Agent;
import behaivortree.ConditionNode;
import worlds.World;

public class NodeTired extends ConditionNode {

	public NodeTired(Agent animal, World myWorld) {
		super(animal, myWorld);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int run() {
		if(animal.getEnergy()<30)
			return True;
		return False;
	}

}
