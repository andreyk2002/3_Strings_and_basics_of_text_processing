/* 
     Подсчитать кол-во строчных(маленьких) и прописных (больших) букв в введённой строке.
     Учитывать только английские буквы.
*/

package by.epam_tc.string.string_builder;

public class Task9 {

	public static boolean isUpperCase(char ch) {
		int code = ch;
		if (code > 64 && code < 91) {
			return true;
		}
		return false;
	}

	public static boolean isLowerCase(char ch) {
		int code = ch;
		if (code > 96 && code < 123) {
			return true;
		}
		return false;
	}

	public static int countUppers(String str) {
		int res = 0;

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (isUpperCase(ch)) {
				res++;
			}
		}
		return res;
	}

	public static int countLowers(String str) {
		int res = 0;

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (isLowerCase(ch)) {
				res++;
			}
		}
		return res;
	}

	public static void main(String[] argc) {

		String str = "Alan Turing was an English mathematician, computer scientist,"
				+ " logician, cryptanalyst, philosopher and theoretical biologist.";

		int numbOfUppers = countUppers(str);
		int numbOfLowers = countLowers(str);

		System.out.println("There are " + numbOfUppers + " upper case lettes");
		System.out.println("There are " + numbOfLowers + " lower case lettes");
	}

}
