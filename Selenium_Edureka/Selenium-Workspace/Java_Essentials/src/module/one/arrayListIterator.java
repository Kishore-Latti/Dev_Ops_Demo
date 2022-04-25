package module.one;

import java.util.ArrayList;
import java.util.Iterator;

public class arrayListIterator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<String> arrList = new ArrayList<String>();
		
		arrList.add("hi");
		arrList.add("iihi");
		arrList.add("iiihi");
		arrList.add("iihi");
		arrList.add("sshi");
		arrList.add("ssshi");
		
		Iterator<String> iterator = arrList.iterator();
		
		//System.out.println(iterator.next ()); // print single line 
		
		while ( iterator.hasNext()) {
			System.out.println(iterator.next ());
		}
		
		
		
		
	}

}
