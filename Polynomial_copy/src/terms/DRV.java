package terms;

import java.text.DecimalFormat;

public class DRV {
	Mylist Pa;
	int r;
	public DRV(Mylist p1,char a) {
		Pa=new Mylist(p1);
		 r=(int)a-97;
	}
	public Mylist devy() {
		NodeMylist x=Pa.firstNode;
		while (x!=null) {
			if(x.expo[r]!=0){
				if(x.expo[r]<0){
					if(x.sign=='+')
						x.sign='-';
						else x.sign='+';
					
					
				}
				double c=Math.abs(x.expo[r]);
				double c2=x.coef*c;
				
				
				x.coef=c2+0.0000001;
				x.expo[r]--;
				
			}else
				x.coef=0;
			if(x.nextNode!=null)
			x=x.nextNode;
			else break;
		}
		(Pa.currentNodeMylist).previousNode=x;
		return Pa;
	}

}
