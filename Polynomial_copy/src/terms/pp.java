package terms;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class pp {
public static void main(String[] args) {
	

	double p=0.000015;
	
	long a=(long)p;
	double f=p-a;
	double h=(Math.round(f*100000));
	double g=h/100000;
//	System.out.printf("%lf", d);
	DecimalFormat df = new DecimalFormat("#.#####");
	String s5=df.format(1.4999999999999999E-5);
	System.out.println(s5);
}


public static double round(double d, int decimalPlace) {
	    BigDecimal bd = new BigDecimal(d);
	    bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
	    double test = 0.000001;
	    Double test2 = new Double(test);
	    
	    System.out.println(String.valueOf(test));
	    return bd.doubleValue();
	}
}
