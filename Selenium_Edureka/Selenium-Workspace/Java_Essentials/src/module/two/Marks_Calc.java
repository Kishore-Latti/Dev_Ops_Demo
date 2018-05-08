package module.two;

import java.util.Scanner;

public class Marks_Calc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println(" Input Student Marks");
		System.out.println(" Input Student  Maths Marks");
		int math = scan.nextInt();
		System.out.println(" Input Student  Science Marks");
		int sci = scan.nextInt();
		System.out.println(" Input Student  English Marks");
		int eng = scan.nextInt();
		System.out.println(" Input Student  Social Science Marks");
		int ssci = scan.nextInt();
        if ((math >100 || math <0)||(sci >100 || sci <0)||(ssci >100 || ssci <0)||(eng >100 || eng <0))
        {
        	System.out.println(" enter Marks again");
        	System.exit(0);
        }
        	
		double per = (math+sci+ssci+eng)/4;
		
		System.out.println( " Percentage obtained is " + per);
		
		if (per >=90)
			System.out.println(" Grade is Excellent ");
		else if (per >=80)
		System.out.println(" Grade is Very good ");
		else if (per >=60)
			System.out.println(" Grade is Good ");
		else if (per >=40)
			System.out.println(" Grade is Average ");
		else if (per < 40)
			System.out.println(" Grade is Poor ");
		else 
			System.out.println(" Bad data");
		
		

	}

}
