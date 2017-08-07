package terms;

import java.text.DecimalFormat;

public class EVAL {
	Mylist Pa;
	int r;
	double e;
	public EVAL(Mylist p1,char a,double d) {
		Pa=new Mylist(p1);
		 r=(int)a-97;
		 e=d;
	}
	public Mylist evaluate() {
		NodeMylist x=Pa.firstNode;
		while (x!=null) {
			if(x.expo[r]!=0){
				double c=Math.pow(e,x.expo[r]);
				double c2=x.coef*c;
				
				if(c2<0)
					x.sign=rverse(x.sign);
				c2=Math.abs(c2);
				
				
				x.coef=c2+0.0000001;
				x.expo[r]=0;
				
			}
			if(x.nextNode!=null)
			x=x.nextNode;
			else break;
		}
		(Pa.currentNodeMylist).previousNode=x;
		return Pa;
	}
	public char rverse(char sign) {
		if(sign=='+')
		return '-';
		else return '+';
	}
}
