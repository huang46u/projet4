package behaivortree;

import applications.simpleworld.Agent;
import worlds.World;

public abstract class ActionNode extends BehaviorTree{
		protected static final int Running=2;
		protected static final int Complete=1;
		protected Agent animal;
		protected World myWorld;
		public ActionNode(Agent animal,World myWorld){
			this.animal=animal;
			this.myWorld=myWorld;
		}
	
}
