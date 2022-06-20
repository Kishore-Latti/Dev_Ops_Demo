package module.one;

import java.util.ArrayList;
import java.util.Arrays;

public class ReverseWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	   // String word = "i.like.this.program.very.much";
	    
	    String word = "i$like$this$program$very$much";
		
		String[] arrwords =  word.split("\\$");
		
		for ( int i = arrwords.length-1 ; i >= 0 ; i--) {
			if ( i != 0) System.out.print(arrwords[i]+"$");
			else System.out.print(arrwords[i]);			
		}
		
		
	}

}
