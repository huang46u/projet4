package behaivortree;

import java.util.ArrayList;

public abstract class CompositeNode extends BehaviorTree {
	protected final static int Running=2;
	protected final static int Success=1;
	protected final static int Failed =0;
	protected BehaviorTree running_node;
	protected int runningIndex;
	protected ArrayList<BehaviorTree> children;
	public CompositeNode(){
		runningIndex=0;
		running_node=null;
		children=new ArrayList<BehaviorTree>();
	}
	
	public ArrayList<BehaviorTree> getChildren() {
		return children;
	}
	public void addNode(BehaviorTree node){
		children.add(node);
	}
	public void deleteNode(BehaviorTree node){
		children.remove(node);
	}

}
