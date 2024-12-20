
public class Expressions {
  public static void main(String[] args){
    int a = 3;
    int b = 4;
    int c = 5;
    int d = 17;
    
    /*
     * 3 and 4 are added with sum 7       
     * 7 is divided by 5 with 1 the result of integer division
     * the value displayed is 1
     */
    System.out.println((a + b) / c);   
    
    /*
     * Because division has higher precedence, 4 is divided by 5 with 0 the result of integer division       
     * 3 is added to 0 with sum 3
     *  the value displayed is 3
     */
    System.out.println(a + b / c);       
    
	/*
	* preincrement is added to 3 with sum 4
	* the value displayed is 4
	*/
    System.out.println(++a);

	/* now that the value is 4 the predecrement is subtracted from 4 giving a difference of 3
	* the value displayed is 3
	*/
    System.out.println(--a);
	
	/* postincrement will be added to the value after used in a expression 
	* the value displayed is 3
	*/
    System.out.println(a++);
	
	/*
	* the postincrement from the line before is now in effect so the value is 4
	* the postdiscrement in this expression will take effect after the value is displayed
	* the value displayed is 4
	*/
    System.out.println(a--);
	
	/*
	* adding 3 to 1 with sum 4
	* the value displayed is 4
	*/
    System.out.println(a + 1);

	/*
	* Finding the remainder of 17 divided by 5 which is 2
	* the value displayed is 2
	*/
    System.out.println(d % c); 
	/*
	* 17 divided by 5 which is 3
	* because they aren't defined as real numbers
	* the answer will be rounded to 3
	* The value displayed is 3
	*/
    System.out.println(d / c);
	
	/* 
	* 17 will be divided by 4 and show the remainder
	* the remainder is 1
	* the value displayed is 1
	*/
    System.out.println(d % b);
	
	/*
	* 17 will be divided by 4
	* the numbers arent defined as real numbers so the answer will be rounded
	* the value displayed is 4
	*/
    System.out.println(d / b);

	/*
	* 3 will be divided into 17 resuting in 0
	* 17 added to 0 for a sum of 17
	* 17 will be added to 4 for a sum of 21
	* the value displayed is 21
	*/
    System.out.println(d + a / d + b); 

	/*
	* the values in parentheses will be added first
	* so 17 will be added to 3 for a sum of 20
	* then 17 will be added to 4 for a sum of 21 
	* then 20 will be divided into 21 resultin in 0
	* the value displayed will be 0
	*/
    System.out.println((d + a) / (d + b)); 

	/*
	* the value 4 will be squared
	* the square root of 4 is 2
	* the value displayed will be returned as a real number
	* the value displayed is 2.0
	*/
    System.out.println(Math.sqrt(b));

	/*
	* the value 3 is being raised to the 4th power
	* the value displayed will return as a real number
	* the value displayed is 81.0
	*/
    System.out.println(Math.pow(a, b));

	/*
	* a negative sign is being assigned to the value
	* but it is being assinged an absolute value 
	* the negative sign will be taken away
	*the value displayed is 3
	*/
    System.out.println(Math.abs(-a));
	
	/*
	* this expression is determining the larger value
	* 4 is larger than 3
	*The value displayed is 4
	*/
    System.out.println(Math.max(a, b));    
  } 
} 
