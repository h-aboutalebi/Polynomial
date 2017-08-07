package terms;


public class Mylist  {
	
	 NodeMylist firstNode;
	 NodeMylist currentNodeMylist=new NodeMylist();
	int sizeMylist=0;
 
	
	public Mylist(){}
	public Mylist(NodeMylist Node1){
		firstNode=Node1;
		firstNode.nextNode=null;	
		firstNode.previousNode=null;
		currentNodeMylist.previousNode=firstNode;
		sizeMylist++;
	}
	public Mylist(Mylist t){
		firstNode=new NodeMylist(t.firstNode);
		NodeMylist v=t.firstNode;
		currentNodeMylist.previousNode=Alocatenext(v,firstNode);
		sizeMylist=t.sizeMylist;
		
		
	} 
	public NodeMylist   Alocatenext(NodeMylist v, NodeMylist firstNode2) {
		if(v.nextNode!=null){
			firstNode2.nextNode=new NodeMylist(v.nextNode);
			(firstNode2.nextNode).previousNode=firstNode2;
			NodeMylist b=v.nextNode;
			NodeMylist t=firstNode2.nextNode;
			return Alocatenext(b, t);
		}
		else 
			return firstNode2;
	}
	public void	addNodetoMylist(NodeMylist Node){
		
		NodeMylist x=Node;
		
		x.nextNode=null;
		NodeMylist y=(currentNodeMylist.previousNode);
		x.previousNode=y;
		y.nextNode=x;
		
		currentNodeMylist=new NodeMylist();
		currentNodeMylist.previousNode=x;
		sizeMylist++;
	}
	
		
	
		
	public void	deleteNodetoMylist(NodeMylist Node){
		
		
		if(Node.nextNode!=null&&Node.previousNode!=null){
			NodeMylist	x=Node.nextNode;
			Node.previousNode.nextNode=x;
			x.previousNode=Node.previousNode;
			
			
		}
		else if(Node.nextNode==null&&Node.previousNode!=null){
			
			Node.previousNode.nextNode=null;
			
			
		}
		else if(Node.nextNode!=null&&Node.previousNode==null){
			
			
			Node.nextNode.previousNode=null;
			firstNode=Node.nextNode;
			
		}
		else {firstNode=null;}
		sizeMylist--;
		}
	
	
}
