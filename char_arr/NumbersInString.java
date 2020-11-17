package by.epam_tc.string.char_arr;

public class NumbersInString {

	public static int countNumbers(char[] charArr) {
		int result = 0;
		boolean isDigitPrev = false;

		for (int i = 0; i < charArr.length; i++) {
			if (isDigit(charArr[i])) {
				if (!isDigitPrev) {
					result++;
					isDigitPrev = true;
				}

			} else {

				isDigitPrev = false;
			}

		}
		return result;
	}

	public static boolean isDigit(char ch) {

		return ((int)ch > 47 && (int)ch < 58);
	}

	public static void main(String[] argc) {
		String string = "1ןגאמ8dhs99990n9kg0";
		char[] charArr = string.toCharArray();
		int result = countNumbers(charArr);

		System.out.print(result);

	}
}
