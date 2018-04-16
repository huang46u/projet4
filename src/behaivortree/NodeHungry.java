package behaivortree;

import applications.simpleworld.Agent;
import worlds.World;

public class NodeHungry extends ConditionNode {

	public NodeHungry(Agent animal, World myWorld) {
		super(animal, myWorld);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int run() {
		if(animal.getHp()>30)
			return False;
		return True;
	}

}