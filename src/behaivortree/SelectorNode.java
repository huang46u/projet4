package behaivortree;

public class SelectorNode extends CompositeNode{
		
	public SelectorNode() {
		super();
	}
	@Override
	public int run(){
		// TODO Auto-generated method stub
		int result;
		if(running_node!=null){
			result=running_node.run();
			if(result!=Running){
				running_node=null;
				if(result==Failed){
					for(int i=runningIndex;i<this.children.size();i++){
						result=children.get(i).run();
						if(result==Running){
							running_node=children.get(i);
							runningIndex=i;
							return Running;
						}
						if(result==Failed){
							continue;
						}
					}
					return Success;
				}
				return result;
			}
			else{
				return Running;
			}
			
		}
			for(int i=0;i<this.children.size();i++){
				result=children.get(i).run();
				if(result==Running){
					running_node=children.get(i);
					runningIndex=i;
					return Running;
				}
				if(result==Failed){
					continue;		
				}
				return Success;
			}
			return Failed;
			
	}

}
