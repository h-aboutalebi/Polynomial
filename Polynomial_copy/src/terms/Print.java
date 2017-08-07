package terms;

import java.text.DecimalFormat;

public class Print {
	Mylist ml;
	NodeMylist node;
	int k=1;
	int h=0;
	int l=0;
	boolean etminan=false;
	NodeMylist[]outputs;
	NodeMylist[]eqoutputs;
	public Print(Mylist x){
		ml=new Mylist(x);
		node=ml.firstNode;
		outputs=new NodeMylist[ml.sizeMylist];
		
		outputs[0]=node;
		if(node.nextNode!=null)
		print(node.nextNode);
		else
			realprint();
	}
	public void print(NodeMylist n) {
		outputs[k]=n;
		boolean like =true;
		for (int i = k-1; i >=0; i--) {
			int x=0;
			
			for(int j=0;j<=25;j++){
				if((h==2)==false){
				if(n.expo[j]==outputs[i].expo[j]){
					x++;
					
				}}
				}
			if(x==26){
				int y=geti(n);
				
				if(outputs[i].sign=='-')
					outputs[i].coef=-outputs[i].coef;
				if(outputs[y].sign=='-')
					outputs[y].coef=-outputs[y].coef;
				outputs[y].coef=outputs[y].coef+outputs[i].coef;
				double d=outputs[y].coef;
				outputs[y].coef=Math.abs(outputs[y].coef);
				if(d>=0)
						outputs[y].sign='+';
					else{
						d=-d;
						outputs[y].sign='-';
					}
//				for (int j = y; j <= k; j++) {
//					outputs[j-1]=outputs[j];
//				}
				
//				outputs[k]=null;
//				k--;
				outputs[i].coef=0;
				outputs[i].sign='-';
			}
			
			if(n.sign=='-'&&outputs[i].sign=='+'){
				swap(n,outputs[i]);
				like =false;
			}
			if(etminan==true)
			if(n.sign=='+'&&outputs[i].sign=='-'){
				break;
			}
			
			if (like){
			for(int j=0;j<=25;j++){
				
				
				if(n.expo[j]<outputs[i].expo[j]){
					swap(n,outputs[i]);
					break;
				}
				if(n.expo[j]>outputs[i].expo[j]){
					
					break;
				}
				
			}
			}
			like=true;
		}
		k++;
		if(n.nextNode!=null)
		print(n.nextNode);
		else{
			if(l==0){
				l++;
				Mylist mx=new Mylist(outputs[0]);
				
				for (int j = 1; j < outputs.length; j++) {
					if(outputs[j]!=null){
						mx.addNodetoMylist(outputs[j]);
					}
				}
				
				
				node=mx.firstNode;
				outputs=new NodeMylist[mx.sizeMylist];
				etminan=true;
				outputs[0]=node;
				if(node.nextNode!=null){
					
					k=1;
					h++;
					print(node.nextNode);
					}
				
				
			}else
			realprint();
		}		
	}
	
	
	
	
	
	public void realprint() {
		String x="";
		DecimalFormat df = new DecimalFormat("#.#####");
		for(int i=outputs.length-1;i>=0;i--){
			 
			
			if (outputs[i]!=null){
				double r=outputs[i].coef;
				long a=(long)r;
				double f=r-a;
				double h=(Math.round(f*100000));
				double g=h/100000;
				String co=df.format(g+a);
			if(co.equals("0")==false){
				x=x+outputs[i].sign;
					if(co.equals("1")==false){
						x=x+co;
				for (int j =0; j < outputs[i].expo.length; j++) {
					int rr=j+97;
					double r3=outputs[i].expo[j];
					long a3=(long)r3;
					double f3=r3-a3;
					double h3=(Math.round(f3*100000));
					double g3=h3/100000;
					String expo=df.format(g3+a3);
					if(expo.equals("0")==false){
						if(expo.equals("1")==false){
							x=x+Character.toString ((char) rr)+expo;
						}else
							x=x+Character.toString ((char) rr);
					}
				}
			
			}
					else{
						for (int j =0; j < outputs[i].expo.length; j++) {
							int rr=j+97;
							double r3=outputs[i].expo[j];
							long a3=(long)r3;
							double f3=r3-a3;
							double h3=(Math.round(f3*100000));
							double g3=h3/100000;
							String expo=df.format(g3+a3);
							if(expo.equals("0")==false){
								if(expo.equals("1")==false){
									x=x+Character.toString ((char) rr)+expo;
								}else
									x=x+Character.toString ((char) rr);
							}
						}
						
					
					}
					
			}
			
			}
			
		}
		if(x.equals( ""))
			System.out.println("0");
		else	if(x.equals("+")||x.equals("-"))
			System.out.println(x+"1");
		else
		System.out.print(x);
		
		System.out.println();
		
	}
	public void swap(NodeMylist x1,NodeMylist x2){
		boolean yes1=false;
		boolean yes2=false;
		int ix1=-1;
		int ix2=-1;
		for (int i = 0; i <= k; i++) {
			if(outputs[i]==x1){
				ix1=i;
				yes1=true;
			}
			if(outputs[i]==x2){
				ix2=i;
				yes2=true;
			}
			if (yes1&&yes2){
				outputs[ix1]=x2;
				outputs[ix2]=x1;
				break;
			}
		}
		
	}
	public int geti(NodeMylist x1){
		boolean yes1=false;
		int ix1=-1;
		for (int i = 0; i <= k; i++) {
			if(outputs[i]==x1){
				ix1=i;
				return i;
				
			}
			
		}
		return -1;
	}
	
	
}
