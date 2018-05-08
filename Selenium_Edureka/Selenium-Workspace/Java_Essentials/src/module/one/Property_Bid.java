package module.one;

import java.util.Scanner;
import java.util.concurrent.SynchronousQueue;

public class Property_Bid {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to Bidding system");
		
		System.out.println( " Enter the Bidding  vale of Michel");
		double mbid = scan.nextDouble();
		
		System.out.println( " Enter the Bidding  vale of Bruce");
		double bbid = scan.nextDouble();
		
		if (mbid>bbid)
			System.out.println(" Michel won the bid");
		else 
			System.out.println("bruce won the deal");
	}

}
