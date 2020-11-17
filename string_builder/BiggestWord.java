//Вводится строка слов, разделённых пробелами.
//Найти самое длинное слово и вывести его на экран.
//Случай, когда таких слов несколько не обрабатывать

package by.epam_tc.string.string_builder;

public class BiggestWord {

	public static String findBiggestWord(String str) {
		int len = 0;
		int maxLen = 0;
		int last = 0;
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch != ' ') {
				len++;
			} else {
				len = 0;
			}
			if (len > maxLen) {
				maxLen = len;
				last = i;
			}

		}
		String res = new String((String) str.subSequence(last - maxLen + 1, last + 1));
		return res;

	}

	public static void main(String[] argc) {

		String str = "spam eggs hello world orange";
		String result = findBiggestWord(str);
		System.out.println(result);
	}

}
