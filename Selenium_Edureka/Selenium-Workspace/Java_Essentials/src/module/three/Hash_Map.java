package module.three;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Hash_Map {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Integer, String> hmap = new HashMap<Integer, String>();

	      /*Adding elements to HashMap*/
	      hmap.put(12, "Chaitanya");
	      hmap.put(2, "Rahul");
	      hmap.put(7, "Singh");
	      hmap.put(49, "Ajeet");
	      hmap.put(3, "Anuj");
	      
	      System.out.println(hmap.get(3));

	      /* Display content using Iterator*/
	      Set set = hmap.entrySet();
	      Iterator iterator = set.iterator();
	      while(iterator.hasNext()) {
	         Map.Entry mentry = (Map.Entry)iterator.next();
//	         System.out.print("key is: "+ mentry.getKey() + " & Value is: ");
//	         System.out.println(mentry.getValue());
	         
	      }
	}

}
