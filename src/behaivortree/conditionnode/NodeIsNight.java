package behaivortree.conditionnode;

import applications.simpleworld.Agent;
import behaivortree.ConditionNode;
import worlds.World;

public class NodeIsNight extends ConditionNode {

	public NodeIsNight(Agent animal, World myWorld) {
		super(animal, myWorld);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int run() {
		// TODO Auto-generated method stub
		if(myWorld.isNIGHT()){
			return True;
		}
		return False;
	}

}
