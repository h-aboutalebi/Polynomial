package terms;

import java.text.DecimalFormat;

public class Multiply {
	
	Mylist Pa;
	Mylist Pb;
	
	public Multiply(Mylist p1, Mylist p2)  {
		Pa=new Mylist(p1);
		Pb=new Mylist(p2);
	}

	public Mylist multy() {
		NodeMylist pa=Pa.firstNode;
		NodeMylist pb=Pb.firstNode;
		NodeMylist t=new NodeMylist();
		t.coef=0;
		t.sign='-';
		for (int i = 0; i < (t.expo).length; i++) {
			t.expo[i]=0;
		}
		Mylist mul=new Mylist(t);
		NodeMylist m=t;
		while (pa!=null) {
			while (pb!=null) {
				
				m=new NodeMylist();
				double c2=pa.coef*pb.coef+0.0000001;
				
				m.coef=c2;
				
				m.sign=returnsign(pa.sign, pb.sign);
				for (int i = 0; i < (pb.expo).length; i++) {
					m.expo[i]=pa.expo[i]+pb.expo[i];
				}  
				mul.addNodetoMylist(m);
				pb=pb.nextNode;
			}
			pa=pa.nextNode;
			pb=Pb.firstNode;
		}
		
		(mul.currentNodeMylist).previousNode=m;
		return mul;
	}
	public char returnsign(char a,char b){
		if(a==b)
			return '+';
		else 
			return '-';
	}
	
}
