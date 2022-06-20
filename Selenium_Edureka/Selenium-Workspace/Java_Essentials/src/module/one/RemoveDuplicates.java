package module.one;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class RemoveDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		char[] a = {'a','a','D','d','b','a','c','d'} ;
		
		HashSet<Character> hashSet = new HashSet<Character>();
		
		for ( int i = 0 ; i < a.length ; i++ ) {
			hashSet.add(a[i]);
		}
		
		Iterator ite = hashSet.iterator();
		
//		while( ite.hasNext()) {
//			System.out.println(ite.next());
//		}
		
		Arrays.sort(a);
		
		
	//	System.out.println(Arrays.toString(b));
		
		for ( Character in : a) {
			System.out.println(in);
			
				}
	}

}
