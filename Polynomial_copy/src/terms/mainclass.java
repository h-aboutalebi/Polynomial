package terms;

import java.io.File;
import java.util.Scanner;
//more than 5-6 terms are not admmited !
//System.out.println("l/100000.0");
//double d=45.888879277;
//long l=(int)Math.round(d*100000);
//System.out.println(l/100000.0);
///Users/hosein/Desktop/MethodesFeilds.txt
//char a='z';
//int ascii = (int) a;
//System.out.println(ascii);
//System.out.println(Character.toString ((char) 121));
public class mainclass {
	static Mylist ACC;
	static Mylist P1;
	static Mylist P2;
	static Mylist M;
	static NodeMylist[]outputs;
	static NodeMylist nm=new NodeMylist(0);
	public static void main(String[] args) throws Exception{
		ACC=new Mylist(nm);
		P1=new Mylist(nm);
		P2=new Mylist(nm);
		M=new Mylist(nm);
		
		Scanner s=new Scanner(System.in);
		System.out.println("Please Enter File Name !");
		File x=new File(s.nextLine());
		Scanner sc=new Scanner(x);
		
		
		do{
			 
			String h=sc.nextLine();
			String[]inputs=h.split(" ");
			if(inputs[0].equals("Save")){
				
				
				Mylist a=getList(inputs[1]);
				Mylist b=getList(inputs[2]);
				
				if(a.equals(P1))
				P1=new Mylist(b);
				if(a.equals(P2))P2=new Mylist(b);if(a.equals(M))M=new Mylist(b);
				if(a.equals(ACC))ACC=new Mylist(b);
				
				
			}
			else if(inputs[0].equals("Load")){
				String A=inputs[1];
				
			calculateTermMain t=new calculateTermMain(A,ACC);
			ACC=standard(t.putToMyList());
			
			}else if(inputs[0].equals("Print")){
				Mylist a=getList(inputs[1]);
				Print r=new Print(a);
			}else if(inputs[0].equals("Add")||inputs[0].equals("AddIN")){
				if(inputs[0].equals("Add")){
				ADD add=new ADD(P1,P2);
				Mylist v6=add.newList();
				ACC=standard(v6);}
				else{
					ADD add=new ADD(ACC,P2);
					Mylist v6=add.newList();
					ACC=standard(v6);
				}
				
			}
			else if(inputs[0].equals("Sub")||inputs[0].equals("SubIN")){
				if(inputs[0].equals("Sub")){
				ADD add=new ADD(P1,P2);
				Mylist v1=add.subtract();
				ACC=standard(v1);}
				else{
					ADD add=new ADD(ACC,P2);
					Mylist v1=add.subtract();
					ACC=standard(v1);
					
				}
			}
			else if(inputs[0].equals("Mul")||inputs[0].equals("MulIN")){
				if(inputs[0].equals("Mul")){
				Multiply add=new Multiply(P1,P2);
				Mylist v3=add.multy();
				ACC=standard(v3);}
				else{
					Multiply add=new Multiply(ACC,P2);
					Mylist v3=add.multy();
					ACC=standard(v3);
				}
				
			}
			else if(inputs[0].equals("Div")||inputs[0].equals("DivIN")){
				if(inputs[0].equals("Div")){
				if(P2.sizeMylist>1||(P2.sizeMylist==1&&P2.firstNode.coef==0))
					System.out.println("Invalid Operation");
				else{
				Diver add=new Diver(P1,P2);
				Mylist v2=add.Dive();
				ACC=standard(v2);}}
				else{
					if(P2.sizeMylist>1||(P2.sizeMylist==1&&P2.firstNode.coef==0))
						System.out.println("Invalid Operation");
					else{
					Diver add=new Diver(ACC,P2);
					Mylist v2=add.Dive();
					ACC=standard(v2);}
				}
				
			}
			else if(inputs[0].equals("Drv")||inputs[0].equals("DrvIN")){
				if(inputs[0].equals("Drv")){
				char a=inputs[1].charAt(0);
				DRV drv=new DRV(P1,a);
				Mylist v4=drv.devy();
				ACC=standard(v4);}
				else{
					char a=inputs[1].charAt(0);
					DRV drv=new DRV(ACC,a);
					Mylist v4=drv.devy();
					ACC=standard(v4);
				}
			}
			else if(inputs[0].equals("Eval")||inputs[0].equals("EvalIN")){
				if(inputs[0].equals("Eval")){
				char a=inputs[1].charAt(0);
				double b=Double.parseDouble(inputs[2]);
				EVAL drv=new EVAL(P1,a,b);
				Mylist v5=drv.evaluate();
				ACC=v5;}
				else{
					char a=inputs[1].charAt(0);
					double b=Double.parseDouble(inputs[2]);
					EVAL drv=new EVAL(ACC,a,b);
					Mylist v5=drv.evaluate();
					ACC=v5;
				}
			}
		}while(sc.hasNext()==true);
	}
	public static Mylist getList(String a) throws Exception{
		if(a.equals("ACC")){
			return ACC;
		}else if(a.equals("P1")){
			return P1;
		}else if(a.equals("P2")){
			return P2;
		}else
			return M;
		
	}
	public static Mylist standard(Mylist t){
		Mylist s=new Mylist(t);
		
		NodeMylist node=s.firstNode;
		MakeitStandard ms=new MakeitStandard(s);
		if(node.nextNode!=null)
			ms.print(node.nextNode);
		outputs=ms.outputs;
		s=new Mylist(outputs[0]);
		
		for (int i = 1; i < outputs.length; i++) {
			s.addNodetoMylist(outputs[i]);
		}
		NodeMylist p=s.firstNode;
		
		while(p!=null){
			if(p.coef==0){
				if(p.nextNode!=null){
					if(p.previousNode!=null){
						(p.previousNode).nextNode=p.nextNode;
						(p.nextNode).previousNode=p.previousNode;
					}
					else{ (p.nextNode).previousNode=null;
					s.firstNode=p.nextNode;
					}
				}else{
					if(p.previousNode!=null){
						(p.previousNode).nextNode=null;
				(s.currentNodeMylist).previousNode=p.previousNode;}
					else{ 
						NodeMylist t2=new NodeMylist();
						t2.coef=0;
						t2.sign='-';
						s=new Mylist(t2);
						s.sizeMylist++;
					}}
				s.sizeMylist--;
			}
			if(p.nextNode!=null)
			p=p.nextNode;
			else break;
			
		}
		
		return s;
	}

}
