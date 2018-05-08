package module.one.ass;

import java.util.Scanner;

public class Test_Ass1 {

	static String name;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner( System.in );
		System.out.println(" Input the name");
		name = scanner.nextLine();
		Test_Ass1 text = new Test_Ass1();
		text.getName(name);
		name = text.returnName();
		System.out.println( "Name passed by method is " + name);
		
		
		 
        
	}



public void getName(String Name)
{
	String name1=Name;
	System.out.println(" Name passed is :" + name1);
}

public String returnName()
{
	@SuppressWarnings("resource")
	Scanner scanner1 = new Scanner( System.in );
	System.out.println(" Input the name");
	String nam = scanner1.nextLine();
	return nam;
}

}