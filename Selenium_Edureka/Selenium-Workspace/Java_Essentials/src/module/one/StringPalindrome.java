package module.one;

import java.util.Scanner;

public class StringPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		System.out.println(" .. Please Enter the String value which needs verification .. ");
		String s = sc.next();
		
		String strRev="";
		
		char[] arrRev = new char[s.length()];
		
		arrRev = s.toCharArray();
		
		
		for ( int i = arrRev.length-1 ; i >=0 ; i-- ) {
			strRev = strRev + arrRev[i];
		
		}
		
		if ( strRev.contentEquals(s) ) {
			System.out.println("1");
		}
		else System.out.println("0");
	}

}
