package module.one;

public class CountWordsConsecuted {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		String inputVal = "Life is all about Life";

		String[] arrWords = inputVal.split(" ");
		
		String prev = "";
		
		int count = 1;

		StringBuilder sb = new StringBuilder(); 
		
        for ( String s  : arrWords) {
        	if( s.equals(prev)) {
        		count = count + 1;        		
        	} 
        	else if ( prev != "") {
        		sb.append(prev).append(count);
        		count = 1 ; 
        	}
        	        	
        	prev = s;
        }
        
        sb.append(prev).append(count);

		System.out.println(" Sequence of string is : " + sb);
	}

}
