package module.three;

import java.util.ArrayList;
import java.util.Scanner;

public class Array_List {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList al= new ArrayList();
		Scanner scan = new Scanner(System.in);
		int count=0;
		while(count==0) {
			System.out.println(" Enter elements to array list");
			String val = scan.nextLine();		
			al.add(val);
			System.out.println(" Do u want to add another element if yes type 1 else type anything ");
			Scanner scan1 = new Scanner(System.in);
			int cal = scan1.nextInt();
			if (cal!=1)
			{
				count =90;
			}
		}
		
		System.out.println(" Elements of list are" + al);
		
		for ( Object val : al ) {
			System.out.println(" val" + val);
		}
		

	}

}
