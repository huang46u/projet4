package behaivortree;

import applications.simpleworld.Agent;
import applications.simpleworld.Predator;
import applications.simpleworld.WorldOfTrees;
import worlds.World;

public class TestBehavoirTree {
	
	
	public static void main(String[] args) {
		
		World myworld=new WorldOfTrees();
		Agent a= new Predator(5,5,myworld);
		NodeCanEat Node_eat=new NodeCanEat(a, myworld);
		NodeChass Node_Chass=new NodeChass(a,myworld);
		NodeHungry Node_Hungry=new NodeHungry(a,myworld);
		NodeMove Node_move=new NodeMove(a,myworld);
		NodeSleep Node_Sleep=new NodeSleep(a,myworld);
		NodeTired Node_Tired=new NodeTired(a,myworld);
		CompositeNode Selector=new SelectorNode();
		CompositeNode Sleep=new SequenceNode();
		CompositeNode Eat=new SequenceNode();
		CompositeNode Chass=new SequenceNode();
		Selector.addNode(Sleep);
		Selector.addNode(Eat);
		Sleep.addNode(Node_Tired);
		Sleep.addNode(Node_Sleep);
		Eat.addNode(Node_Hungry);
		Eat.addNode(Chass);
		Eat.addNode(Node_eat);
		Chass.addNode(Node_Chass);
		Selector.addNode(Node_move);
		
		for(int i=0;i<100;i++){
			Selector.run();		
		}
	}
}
