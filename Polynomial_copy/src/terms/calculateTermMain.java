package terms;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class calculateTermMain {
	Mylist ml;
	String input;
	String[]terms;
	int k;
	public calculateTermMain(String x,Mylist a ){
		input=x;
		ml=a;
		k=0;
		terms=new String[5];
		Mysplit();
	}
	public  void Mysplit(){
		if(input.substring(1,input.length()).contains("+")&&input.substring(1,input.length()).contains("-")){
			
			int i=input.substring(1,input.length()).indexOf("+")+1;
			int j=input.substring(1,input.length()).indexOf("-")+1;
		if(i>j){
				equiblirem(k);
				terms[k]=input.substring(0,j);
				input=input.substring(j,input.length());
				k++;
				Mysplit();
				
		}else{
			equiblirem(k);
			
			terms[k]=input.substring(0,i);
			input=input.substring(i,input.length());
			k++;
			Mysplit();
			
		}
		}else if(input.substring(1,input.length()).contains("+")&&input.substring(1,input.length()).contains("-")==false){
			int i=input.substring(1,input.length()).indexOf("+")+1;
			equiblirem(k);
			terms[k]=input.substring(0,i);
			input=input.substring(i,input.length());
			k++;
			Mysplit();
		}else if(input.substring(1,input.length()).contains("+")==false&&input.substring(1,input.length()).contains("-")){
			int j=input.substring(1,input.length()).indexOf("-")+1;
			equiblirem(k);
			terms[k]=input.substring(0,j);
			input=input.substring(j,input.length());
			k++;
			Mysplit();
		}
		else{terms[k]=input;
		}
	}
	
	public void equiblirem(int k){
		if(k>=terms.length-1){
			String[]terms2=new String[2*terms.length];
			for (int k3 = 0; k3 < terms.length; k3++) 
				terms2[k3]=terms[k3];
				terms=terms2;
			}
	}
	public Mylist putToMyList (){
		NodeMylist nm=new NodeMylist();
		int w=terms[0].length();
		boolean z=false;
		if(terms[0].charAt(0)=='+'||terms[0].charAt(0)=='-'){
			nm.sign=terms[0].charAt(0);
			for (int i = 0; i < terms[0].length(); i++) {
				if(isNumeric(terms[0].substring(1,terms[0].length()-i))){
					double c=Double.parseDouble(terms[0].substring(1,terms[0].length()-i));
					nm.coef=c;
					z=true;
					w=i;
					break;
				}
			}
			if(z==false){nm.coef=1;
			if(terms[0].substring(1,terms[0].length()).length()!=0)
			calculateexp(nm,terms[0].substring(1,terms[0].length()));}
			else {if(terms[0].substring(terms[0].length()-w,terms[0].length()).length()!=0)calculateexp(nm,terms[0].substring(terms[0].length()-w,terms[0].length()));}
		
		}else{
			nm.sign='+';
			w=terms[0].length();
			for (int i = 0; i < terms[0].length(); i++) {
				if(isNumeric(terms[0].substring(0,terms[0].length()-i))){
					double c=Double.parseDouble(terms[0].substring(0,terms[0].length()-i));
					nm.coef=c;
					
					z=true;
					w=i;
					break;
				}
			}
			if(z==false){nm.coef=1;
			if(terms[0].substring(0,terms[0].length()).length()!=0)
				calculateexp(nm,terms[0].substring(0,terms[0].length()));
			}else{
			if(terms[0].substring(terms[0].length()-w,terms[0].length()).length()!=0)
			calculateexp(nm,terms[0].substring(terms[0].length()-w,terms[0].length()));
			}}
		ml=new Mylist(nm);
		for (int i = 1; i < k+1; i++) {
			NodeMylist nm1=new NodeMylist();
			int w1=terms[i].length();
			boolean z1=false;
			
				nm1.sign=terms[i].charAt(0);
				for (int i1 = 0; i1 < terms[i].length(); i1++) {
					if(isNumeric(terms[i].substring(1,terms[i].length()-i1))){
						double c=Double.parseDouble(terms[i].substring(1,terms[i].length()-i1));
						nm1.coef=c;
						
						z1=true;
						w1=i1;
						break;
					}
				}
				if(z1==false){nm1.coef=1;
				if(terms[i].substring(1,terms[i].length()).length()!=0)
					calculateexp(nm1,terms[i].substring(1,terms[i].length()));
				}else{
					if(terms[i].substring(terms[i].length()-w1,terms[i].length()).length()!=0)
				calculateexp(nm1,terms[i].substring(terms[i].length()-w1,terms[i].length()));
				
				}ml.addNodetoMylist(nm1);
			}
		return ml;
		
	}
	public void calculateexp(NodeMylist nm,String b){
		int w=b.length();
		boolean z=false;
		char a= b.charAt(0);
		int assci= (int) a;
		for (int i = 0; i < b.length(); i++) {
			if(isNumeric(b.substring(1,b.length()-i))){
				double c=Double.parseDouble(b.substring(1,b.length()-i));
				nm.expo[assci-97]=c;
				z=true;
				w=i;
				break;
			}
			
		}
		if (z==false){nm.expo[assci-97]=nm.expo[assci-97]+1;
		
		if(b.substring(b.length()-w+1,b.length()).length()!=0){
			calculateexp(nm,b.substring(b.length()-w+1,b.length()));
		}}
		else{
			if(b.substring(b.length()-w,b.length()).length()!=0)
			calculateexp(nm,b.substring(b.length()-w,b.length()));
		}
	} 
	
	public static boolean isNumeric(String str)  
	{  
	  try  
	  {  if(str.length()==0){
		  return false;}
	  
	  else if(str.contains("e")||str.contains("d")||str.contains("f")||str.contains("i")){
			  return false; 
		  }
		  else{
	    double d = Double.parseDouble(str);  }
	  }  
	  catch(NumberFormatException nfe)  
	  {  
	    return false;  
	  }  
	  return true;  
	}
	
}
















