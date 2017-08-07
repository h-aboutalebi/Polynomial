package terms;

public class ADD {
	Mylist Pa;
	Mylist Pb;
	
	public ADD(Mylist p1, Mylist p2) throws CloneNotSupportedException {
		Pa=new Mylist(p1);
		Pb=new Mylist(p2);
	}

	public Mylist newList() {
		
		Mylist x=new Mylist(Pa);
		x.addNodetoMylist(new NodeMylist(Pb.firstNode));
		NodeMylist r=Pb.firstNode;
		
		while(r.nextNode!=null){
			x.addNodetoMylist(new NodeMylist(r.nextNode));
			if(r.nextNode!=null)
			r=r.nextNode;
			else break;
		}
		
		x.currentNodeMylist=Pb.currentNodeMylist;
	
		return x;
		

}

	public Mylist subtract() {
		Mylist x=new Mylist(Pa);
		NodeMylist pa=Pb.firstNode;
		
		
		while (pa!=null) {
			(pa).sign =reverse((pa).sign);
			if(pa.nextNode!=null)
			pa=pa.nextNode;
			else break;
		}
		
		
		x.addNodetoMylist(new NodeMylist(Pb.firstNode));
		
		NodeMylist r=Pb.firstNode;
		while(r.nextNode!=null){
			
			x.addNodetoMylist(new NodeMylist(r.nextNode));
			
			if(r.nextNode!=null)
			r=r.nextNode;
			else break;
		}
	
		x.currentNodeMylist=Pb.currentNodeMylist;
		
		return x;
	}

	public char reverse(char sign) {
		if(sign=='-')
		return '+';
		else return '-';
	}}






























