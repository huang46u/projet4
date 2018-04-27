package behaivortree;

public class SequenceNode extends CompositeNode {

	public SequenceNode(){
		super();
	}
	@Override
	public int run() {
		int result;
		if(running_node!=null){
			result=running_node.run();
			if(result!=Running){
				running_node=null;
				if(result==Success){
					for(int i=runningIndex;i<this.children.size();i++){
						result=children.get(i).run();
						if(result==Running){
							running_node=children.get(i);
							runningIndex=i;
							return Running;
						}
						if(result==Success){
							continue;
						}
					}
					return Failed;
				}
				return result;
			}
			
		}
		for(int i=0;i<this.children.size();i++){
			result=children.get(i).run();
			if(result==Running){
				running_node=children.get(i);
				runningIndex=i;
				return Running;
			}
			if(result==Success){
				continue;
			}
			return Failed;
		}
		return Success;
		
	}

}
