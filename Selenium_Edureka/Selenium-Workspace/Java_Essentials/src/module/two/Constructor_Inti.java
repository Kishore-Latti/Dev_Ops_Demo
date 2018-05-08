package module.two;

public class Constructor_Inti {
	
	float fval;;
	int ival;

	public Constructor_Inti(float val) {
		fval = val;
		System.out.println(" Float val is " + fval);
	}
	
	public Constructor_Inti(int val1) {
		ival = val1;
		System.out.println(" Integer val is " +ival);
	}
	
	public Constructor_Inti() {
		System.out.println( "empty constructor");
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Constructor_Inti con = new Constructor_Inti(10.4f);
		con = new Constructor_Inti(4);
		con = new Constructor_Inti();
		
	}

}
