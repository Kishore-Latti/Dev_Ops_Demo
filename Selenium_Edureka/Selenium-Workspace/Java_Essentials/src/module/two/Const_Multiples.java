package module.two;

public class Const_Multiples {

	public Const_Multiples(int n) {
		for (int i=1;i<=10;i++)
		{
			System.out.println(n +"*"+i+"="+n*i);
		}
		
	}
	
	public static void main(String[] args) {
		for (int i=1;i<=5;i++)
		{
			new Const_Multiples(i);
			System.out.println("\n");
		}
	}

}
