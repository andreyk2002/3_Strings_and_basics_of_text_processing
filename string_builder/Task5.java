//Подсчитать, сколько раз среди символов заданной строки встечается 'a'

package by.epam_tc.string.string_builder;

public class Task5 {
	public static int countA(String string) {
		int result = 0;
		for (int i = 0; i < string.length(); i++) {
			if (string.charAt(i) == 'a') {
				result++;
			}
		}
		return result;
	}

	public static void main(String[] argc) {

		String string = "adfa__aanbkaioa";
		int result = countA(string);
		System.out.println(result);
	}

}
