package behaivortree;

import applications.simpleworld.Agent;
import worlds.World;

public class NodeChass extends ActionNode {

	public NodeChass(Agent animal, World myWorld) {
		super(animal, myWorld);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int run() {
		System.out.println("chass");
		return Complete;
	}

}
