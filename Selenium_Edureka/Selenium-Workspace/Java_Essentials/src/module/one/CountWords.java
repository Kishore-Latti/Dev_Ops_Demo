package module.one;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class CountWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		// System.out.println("Enter the string value ");

		// String inputVal = sc.nextLine();

		String inputVal = "Life is all about Life";

		String[] arrWords = inputVal.split(" ");

		HashMap<String, Integer> hmap = new HashMap<String, Integer>();

		int count = 1;

		for (int i = 0; i < arrWords.length; i++) {
			if (arrWords[i] != "@") {
				for (int j = i + 1; j < arrWords.length; j++) {

					if (arrWords[i].contentEquals(arrWords[j])) {
						count = count + 1;
						arrWords[j] = "@";
					}

				}
				hmap.put(arrWords[i], count);
				count = 1;
			}

		}

		Set set = hmap.entrySet();
		Iterator iterator = set.iterator();
		while (iterator.hasNext()) {
			Map.Entry mentry = (Map.Entry) iterator.next();
			System.out.print("key is: " + mentry.getKey() + " & Value is: ");
			System.out.println(mentry.getValue());
		}

	}

}
