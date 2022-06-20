package module.one;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StringHigestCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		System.out.println(" .. Please Enter the String value which needs verification .. ");
		String s = sc.next();
		int count = 1;
		int highCount = 1;
		char highCountChar = 0;
		HashMap<Character, Integer> hmap = new HashMap<Character, Integer>();

		char[] arrRev = new char[s.length()];

		arrRev = s.toCharArray();
		for (int j = 0; j < arrRev.length; j++) {
			if (arrRev[j] != '0') {
				for (int i = j + 1; i < arrRev.length; i++) {

					if (arrRev[j] == arrRev[i]) {
						arrRev[i] = '0';
						count = count + 1;
					}

				}
				hmap.put(arrRev[j], count);

				count = 1;
			}
		}

		for (Map.Entry entry : hmap.entrySet()) {
			if (highCount <= (Integer) entry.getValue()) {
				highCount = (Integer) entry.getValue();
				highCountChar = (Character) entry.getKey();
			}
		}

		System.out.println(" Highest Value char is : " + highCountChar + " with value " + highCount);

	}

}
