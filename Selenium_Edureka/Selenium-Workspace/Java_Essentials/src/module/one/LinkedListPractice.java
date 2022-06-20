package module.one;

import java.util.LinkedList;

public class LinkedListPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedList< String > stringList = new LinkedList<String>();
		
		stringList.add("Hi");
		stringList.add("What to do " );
		stringList.add("bye");
		stringList.add("Adding value");
		
		System.out.println(stringList.getFirst());
		System.out.println(stringList.getLast());
		System.out.println(stringList.remove());
		System.out.println(stringList);
		

	}

}
