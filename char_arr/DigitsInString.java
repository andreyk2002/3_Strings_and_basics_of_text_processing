package by.epam_tc.string.char_arr;

public class DigitsInString {

	public static int countDigits(char[] charArr) {
		int result = 0;
		for (int i = 0; i < charArr.length; i++) {
			if (isDigit(charArr[i])) {
				result++;
			}
		}
		return result;
	}

	public static boolean isDigit(char ch) {

		return ((int)ch > 47 && (int)ch < 58);
	}

	public static void main(String[] argc) {
		String string = "rgjanh375kjfn8nj800n0";
		char[] charArr = string.toCharArray();
		int result = countDigits(charArr);

		System.out.print(result);

	}
}
