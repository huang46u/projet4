package behaivortree.conditionnode;

import applications.simpleworld.Agent;
import behaivortree.ConditionNode;
import worlds.World;

public class NodeIsSummer extends ConditionNode {

	public NodeIsSummer(Agent animal, World myWorld) {
		super(animal, myWorld);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int run() {
		if(myWorld.isSUMMER()){
			return True;
		}
			return False;
	}

}
