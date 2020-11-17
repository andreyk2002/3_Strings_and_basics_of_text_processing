// Найти наибольшее количество идущих вподряд пробелов в тексте
package by.epam_tc.string.string_builder;

public class Task1 {
	
	public static int countSpaces(String str) {
		int howMany = 0;
		int maxSp = 0;
		
		for(int i = 0; i < str.length(); i++) {
			
			if(str.charAt(i) == ' ') {
				howMany++;
			}else {
				howMany = 0;
			}
			if(howMany > maxSp) {
				maxSp = howMany;
			}
		}
		return maxSp;
	}

	public static void main(String[]argc) {
		
		String str = "fgnjgfiokj   jhfodh fhjofdh fhjf   fhfhh    jfhkfsh   ";
		int result;
		result = countSpaces(str);
		System.out.println(result);
	}
}
