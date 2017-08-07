package terms;

import java.text.DecimalFormat;

public class Diver {
	Mylist Pa;
	Mylist Pb;
	
	public Diver(Mylist p1, Mylist p2)  {
		Pa=new Mylist(p1);
		Pb=new Mylist(p2);
	}

	public Mylist Dive() {
		NodeMylist t=Pb.firstNode;
		for (int i = 0; i < (t.expo).length; i++) {
			t.expo[i]=-t.expo[i];
		}
		double c2=1/t.coef;
		
		t.coef=c2+0.0000001;
		Mylist k=new Mylist(t);
		Multiply add=new Multiply(Pa,k);
		Mylist v3=add.multy();
		return v3;
		
		
	}

}
