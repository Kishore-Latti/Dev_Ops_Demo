package module.three;

import java.util.Scanner;

public class Math_Func {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(" Entet the values");
		System.out.println(" Enter the value of no1 ");
		Scanner scan = new Scanner(System.in);
		int val = scan.nextInt();
		System.out.println(" Enter the value of no2 ");
		int val1 = scan.nextInt();
		System.out.println(" Addition is " + (val+val1));
		System.out.println(" Substraction is " + (val-val1));
		System.out.println(" Multiplication  is " + val*val1);
	}

}
