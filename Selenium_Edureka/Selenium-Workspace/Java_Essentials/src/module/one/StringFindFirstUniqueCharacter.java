package module.one;

public class StringFindFirstUniqueCharacter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String val = "hlahlhamlhljlkjljlj;lsj;j;aj;ja;j;alj;lja;j;lja;lj;aahklhalkhalh";
		
		// Solution one 
        char present = 0;
		
		char[] charVal = new char [ val.length()];
		
		charVal = val.toCharArray();
		
		
		for ( char ch : charVal ) {
			if ( val.lastIndexOf(String.valueOf(ch)) == val.indexOf(String.valueOf(ch)) )
			{
				present = ch;
				break;
			} 
		}
		
		System.out.println(" char present is " + present); 
		
		// Solution two 
		present = 0;
		
		for ( int i = 0 ; i  < val.length(); i++) {
			
			if ( val.lastIndexOf(String.valueOf(val.charAt(i))) == val.indexOf(String.valueOf(val.charAt(i))) )
			{
				present = val.charAt(i) ;
				break;
			} 
		}
		
		System.out.println(" char present is " + present);
	}

}
