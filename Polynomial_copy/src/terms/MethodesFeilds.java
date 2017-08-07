package terms;



import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;

public class MethodesFeilds {
	static Object []ss=new Object[10];
	String input;
	HashMap<String,Object>map=new HashMap<String,Object>();
	Object o=null;
	int j=3;
	public MethodesFeilds(String x, HashMap<String,Object> map2){
		map=map2;
		input=x;
		
	}
	
	

	
	
	public Object main() throws Exception {
		
		
		
		if(input.contains("java.lang.")){
		
			
			
		
		String a=input.substring(0, input.indexOf("("));
		String b=input.substring(input.indexOf("(")+1, input.indexOf(")"));
		String[]x=a.split("\\.");
		
		Class c=Class.forName("java.lang."+x[2]);
	
		int i=x.length-4;
		while(input.equals("")==false){
		while(i>=0){
			
			if((b.equals("")==false)&&i==0){
				String[] Minput=b.split(",");
				Class []cInput=Getinput(Minput);
				if(cInput.length==0){
					Method m= c.getDeclaredMethod(x[x.length-1], null);
					o=m.invoke(o, null);
					if(o==null)break;
				}else if(cInput.length==1){
					Method m= c.getDeclaredMethod(x[x.length-1], cInput[0]);
					
					o=m.invoke(o, ss[0]);
				if(o==null)break;
				}else if(cInput.length==2){
					Method m= c.getDeclaredMethod(x[x.length-1], cInput[0],cInput[1]);
					o=m.invoke(o, ss[0],ss[1]);
					if(o==null)break;
				}else if(cInput.length==3){
					Method m= c.getClass().getDeclaredMethod(x[x.length-1], cInput[0],cInput[1],cInput[2]);
					o=m.invoke(o, ss[0],ss[1],ss[2]);
					if(o==null)break;
				}
				
			}else{
				Field f=c.getDeclaredField(x[j]);
		      o=f.get(o);
		      
			}
			i--;
			j++;
			
			c=o.getClass();
		}input=input.substring( input.indexOf(")")+1, input.length());
			if(input.equals("")==false) {
			a=input.substring(0, input.indexOf("("));
			x=a.split("\\.");
				b=input.substring(input.indexOf("(")+1, input.indexOf(")"));}
				
		
		
	}
		}else
		{
			
			
				String a=input.substring(0, input.indexOf("("));
				String b=input.substring(input.indexOf("(")+1, input.indexOf(")"));
				String[]x=a.split("\\.");
				
				Class c=Class.forName(x[0]);
			j=1;
				int i=x.length-2;
				while(input.equals("")==false){
				while(i>=0){
					
					if(input.contains("(")&&i==0){
						String[] Minput=b.split(",");
						Class []cInput=Getinput(Minput);
						if(cInput.length==0){
							Method m= c.getDeclaredMethod(x[x.length-1], null);
							o=m.invoke(o, null);
							if(o==null)break;
						}else if(cInput.length==1){
							Method m= c.getDeclaredMethod(x[x.length-1], cInput[0]);
							o=m.invoke(o, ss[0]);
							if(o==null)break;
						}else if(cInput.length==2){
							Method m= c.getDeclaredMethod(x[x.length-1], cInput[0],cInput[1]);
							o=m.invoke(o, ss[0],ss[1]);
							if(o==null)break;
						}else if(cInput.length==3){
							Method m= c.getClass().getDeclaredMethod(x[x.length-1], cInput[0],cInput[1],cInput[2]);
							o=m.invoke(o, ss[0],ss[1],ss[2]);
							if(o==null)break;
						}
						
					}else{
						Field f=c.getDeclaredField(x[j]);
				        Object o=f.get(null);
					}
					i--;
					j++;
					
					c=o.getClass();
				}input=input.substring( input.indexOf(")")+1, input.length());
					if(input.equals("")==false) {
					a=input.substring(0, input.indexOf("("));
					x=a.split("\\.");
					b=input.substring(input.indexOf("(")+1, input.indexOf(")"));
					}
				
				
			}
			
		}
		return o;
	}
	public  Class[] Getinput( String[] input) {
		if(input.length==1&&input[0].equals("")){
			Class[]o2=new Class[0];
			return o2;}
		else{
		Class[]o=new Class[input.length];
		for (int i = 0; i < input.length; i++) {
			if(  map.containsKey(input[i])   ){
				ss[i]=map.get(input[i]);
				if(ss[i].getClass().equals(Long.class))
					o[i]=long.class;
				
				else if(ss[i].getClass().equals(Double.class)){
					o[i]=double.class;
					
						}
				 else if (ss[i].getClass().equals(String.class)) {
						o[i]=String.class;
						
				 }else if((ss[i].toString().charAt(0)==('f')||ss[i].toString().charAt(0)==('t'))) {
						o[i]=boolean.class;
						
				 }else{
					 o[i]=int.class;
					
				 }
			}	
			else if(input[i].contains(".")){
			o[i]=double.class;
			ss[i]=Double.parseDouble(input[i] ); 
				}
			
			else if (input[i].charAt(0)==('"')||input[i].contains("'")) {
				o[i]=String.class;
				ss[i]=input[i].substring(1,input[i].length()-1);
		 }else if((input[i].charAt(0)==('f')||input[i].charAt(0)==('t'))) {
				o[i]=boolean.class;
				ss[i]=Boolean.parseBoolean (input[i] ); 
		 }else{
			 o[i]=int.class;
			 ss[i]=Integer.parseInt(input[i] ); 
		 }
		
	
		
	}
		return o;
	}}
	
	
}
