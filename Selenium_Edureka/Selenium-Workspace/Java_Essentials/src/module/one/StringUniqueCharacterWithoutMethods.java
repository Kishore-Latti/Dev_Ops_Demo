package module.one;

public class StringUniqueCharacterWithoutMethods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "aaacccfffh";		
		int count = 0;
		int highCount = 0;
		char highCountChar = 0;
		
		char[] arrRev = new char[s.length()];

		arrRev = s.toCharArray();
		for (int j = 0; j < arrRev.length; j++) {
			if (arrRev[j] != '0') {
				for (int i = j + 1; i < arrRev.length; i++) {

					if (arrRev[j] == arrRev[i]) {
						arrRev[i] = '0';
						count = count + 1;
					}

				}
				if (count == 0) {
					System.out.println(arrRev[j]);
					break;
				}

				count = 0;
			}
		}

	}

}
