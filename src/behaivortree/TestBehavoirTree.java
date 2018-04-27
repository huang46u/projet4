package behaivortree;

import applications.simpleworld.Agent;
import applications.simpleworld.Predator;
import applications.simpleworld.WorldOfTrees;
import behaivortree.actionnode.NodeChass;
import behaivortree.actionnode.NodeMove;
import behaivortree.actionnode.NodeSleep;
import behaivortree.conditionnode.NodeHungry;
import behaivortree.conditionnode.NodeTired;
import worlds.World;

public class TestBehavoirTree {
	
	
	public static void main(String[] args) {
		World myworld=new WorldOfTrees();
		Agent a= new Predator(5,5,myworld);
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
		Sleep.addNode(Node_Tired);
		Sleep.addNode(Node_Sleep);
		Selector.addNode(Eat);
		Eat.addNode(Node_Hungry);
		Eat.addNode(Chass);
		Chass.addNode(Node_Chass);
		Selector.addNode(Node_move);
		for(int i=0;i<10;i++){
			Selector.run();		
		}
	}
}
