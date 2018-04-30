package behaivortree.conditionnode;

import applications.simpleworld.Agent;
import behaivortree.ConditionNode;
import worlds.World;

public class NodeIsWinter extends ConditionNode {

	public NodeIsWinter(Agent animal, World myWorld) {
		super(animal, myWorld);
		// TODO Auto-generated constructor stub
	}
	@Override
	public int run() {
		if(myWorld.isWINTER()){
			return True;
		}
		return False;
	}
	

}
