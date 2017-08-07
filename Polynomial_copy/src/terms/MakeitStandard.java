package terms;

public class MakeitStandard {
	
	Mylist ml;
	NodeMylist node;
	int k=1;
	int h=0;
	int l=0;
	boolean etminan=false;
	NodeMylist[]outputs;
	NodeMylist[]eqoutputs;
	public MakeitStandard(Mylist x){
		ml=new Mylist(x);
		node=ml.firstNode;
		outputs=new NodeMylist[ml.sizeMylist];
		
		outputs[0]=node;
		
		
		
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
			
			
				
			}
			
	
		
		k++;
		if(n.nextNode!=null)
		print(n.nextNode);
		
			
			
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
