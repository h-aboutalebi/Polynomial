package terms;

public class NodeMylist {
	double coef;
	
	
	
	char sign;
	double[] expo=new double[26];
	public NodeMylist nextNode;
	
	public NodeMylist previousNode;
	
    public NodeMylist(double coe,char s){
    	coef=coe;
    	sign=s;
    	for (int i = 0; i < expo.length; i++) {
			expo[i]=0;
		}
    }
    public NodeMylist(NodeMylist t){
    	coef=t.coef;
    	sign=t.sign;
    	for (int i = 0; i < expo.length; i++) {
    		expo[i]=t.expo[i];
		}
    	nextNode=null;
    	previousNode=null;
    }
    
	public NodeMylist(double coe){
    	coef=coe;
    	
    	for (int i = 0; i < expo.length; i++) {
			expo[i]=0;
		}
}
    public NodeMylist(){
		
	}

	
   
	
}
