package module.one;

import java.util.*;

public class CheckConsecutedRepeatedCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner ( System.in);
		
		System.out.print(" Please Enter Valid String : ");		
		
		String str = sc.next();

		char[] ch = new char[str.length()];

		StringBuilder st = new StringBuilder();

		ch = str.toCharArray();

		char prv = 0;
		int count = 1;

		for (char c : ch) {

			if (c == prv) {
				count = count + 1 ; 
			} 
			else if (prv != 0){
				st.append(count).append(prv);
				count = 1;
			}
			prv = c;
			
		}
		st.append(count).append(prv);

		System.out.println(" Sequence of string is : " + st);
	}

}
