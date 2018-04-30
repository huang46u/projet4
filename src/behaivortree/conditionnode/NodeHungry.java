package behaivortree.conditionnode;

import applications.simpleworld.Agent;
import behaivortree.ConditionNode;
import worlds.World;

public class NodeHungry extends ConditionNode {

	public NodeHungry(Agent animal, World myWorld) {
		super(animal, myWorld);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int run() {
		System.out.println("hp: "+animal.getHp());
		if(animal.getHp()>30){
			System.out.println("don't hungry");
			return False;
		}
		System.out.println("hungry");
		return True;
	}

}
