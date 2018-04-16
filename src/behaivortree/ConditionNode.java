package behaivortree;

import applications.simpleworld.Agent;
import worlds.World;

public abstract class ConditionNode extends BehaviorTree{
	protected static final int True=1;
	protected static final int False=0;
	protected Agent animal;
	protected World myWorld;
	public ConditionNode(Agent animal,World myWorld){
		this.animal=animal;
		this.myWorld=myWorld;
	}
	
}
