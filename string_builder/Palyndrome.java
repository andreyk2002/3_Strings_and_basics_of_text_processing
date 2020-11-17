// Определить, является ли слово палиндромом
package by.epam_tc.string.string_builder;


public class Palyndrome {
	
	
	 public static boolean isPalindrome(String str) {
		 		 
		 for(int i = 0; i < str.length() / 2; i++ ) {
			 if(str.charAt(i) == str.charAt(str.length() - i - 1)) {
				continue;
			 }
			 else {
				 return false;
			 }
			 
		 }
		 
		 return true;
		 
	 }
	
	public static void main(String[] argc) {
		
		String notPalindrome = "mko_omk" ;
		String palindrome = "fghjkllkjhgf";
		System.out.println(notPalindrome + " " + isPalindrome(notPalindrome));
		System.out.println(palindrome + " " +isPalindrome(palindrome));
	}
}
