package module.one;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class charTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String inputVal = "I am the one";

		char[] inputArr = inputVal.toCharArray();

		System.out.println(inputArr);

		HashMap<Character, Integer> hmap = new HashMap<Character, Integer>();
		int count = 0;
		int prevCount = 0;

		for (int i = 0; i < inputVal.length(); i++) {
			char val = Character.toLowerCase(inputVal.charAt(i));
			if (hmap.containsKey(val)) {
				count = count + 1;
				prevCount = hmap.get(val) + 1;
				hmap.put(val, prevCount);

			} else {
				hmap.put(val, 1);
				count = 1;
			}

		}

		/* Display content using Iterator */
		Set set = hmap.entrySet();
		Iterator iterator = set.iterator();
		while (iterator.hasNext()) {
			Map.Entry mentry = (Map.Entry) iterator.next();
			System.out.print("key is: " + mentry.getKey() + " & Value is: ");
			System.out.println(mentry.getValue());

		}

	}

}
