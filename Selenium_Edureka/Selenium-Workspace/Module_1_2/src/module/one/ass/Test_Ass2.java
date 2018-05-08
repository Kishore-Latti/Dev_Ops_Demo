package module.one.ass;

import java.util.Scanner;

public class Test_Ass2 {

	static int val;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Test_Ass2 text = new Test_Ass2();
		// text.printMonth();
		// text.reverseString();
		text.atmTrial();

	}

	public void printMonth() {
		Scanner scanner = new Scanner(System.in);
		System.out.println(" Enter any value between 1 to 12");
		val = scanner.nextInt();
		if (val == 1)
			System.out.println(" Month is January ");
		else if (val == 2)
			System.out.println(" Month is February ");
		else if (val == 3)
			System.out.println(" Month is March ");
		else if (val == 4)
			System.out.println(" Month is April ");
		else if (val == 5)
			System.out.println(" Month is May ");
		else if (val == 6)
			System.out.println(" Month is June ");
		else if (val == 7)
			System.out.println(" Month is July");
		else if (val == 8)
			System.out.println(" Month is August ");
		else if (val == 9)
			System.out.println(" Month is September ");
		else if (val == 10)
			System.out.println(" Month is October ");
		else if (val == 11)
			System.out.println(" Month is November ");
		else if (val == 12)
			System.out.println(" Month is December ");
		else
			System.out.println(" Invalid Entry");

	}

	public void reverseString() {
		String input = "January";

		StringBuilder input1 = new StringBuilder();

		// append a string into StringBuilder input1
		input1.append(input);

		// reverse StringBuilder input1
		input1 = input1.reverse();

		System.out.println(input1);
	}

	public void atmTrial() {
		Scanner scanner = new Scanner(System.in);
		int pin;
		int real_pin = 9999;

		int count = 0;

		while (count < 3) {
			System.out
					.println(" Enter the correct pin ( you have maximum 3 chances )");
			pin = scanner.nextInt();
			if (pin == real_pin) {
				System.out.println(" Correct pin entered ");
				count = 10;
			} else {
				System.out.println(" Re Enter the pin Properly  ");
				count = count + 1;
			}
		}

		if (count == 3) {
			System.out.println(" you exceeded maximum limit");
		}

	}

}
