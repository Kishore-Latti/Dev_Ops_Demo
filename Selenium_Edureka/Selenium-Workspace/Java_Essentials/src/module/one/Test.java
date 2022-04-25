package module.one;

import java.util.*;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList arrList = new ArrayList();

//		arrList.add("Hi");
//
//		arrList.add(" Bye");
//
//		System.out.println(arrList);

		String str = "aBccdD";

		char[] ch = new char[str.length()];

		StringBuilder st = new StringBuilder();

		ch = str.toCharArray();

		char prv = 0;
		int count = 1;

		for (char c : ch) {
			// System.out.println(" char is " + c);

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

		System.out.println(" string is : " + st);
	}

}
