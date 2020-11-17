/*
   Заменить в строке все вхождения слова "word"
   на слово "letter"
*/

package by.epam_tc.string.char_arr;

public class Task2 {

	public static final String STR_TO_REPLACE = "word";
	public static final String REPLACING_STR = "letter";
	public static final int DELTA_LEN = REPLACING_STR.length() - STR_TO_REPLACE.length();

	public static void main(String[] argc) {
		String str = "word_letter_wordwordhello_worghgjfs_word";

		

		char []res;
		res = changeToLetter(str);
		String result = new String(res);
		System.out.print(result);
	}

	public static char[] changeToLetter(String source) {
		int newSize;

		newSize = DELTA_LEN * countWords(source) + source.length();
		char[] charArr = new char[newSize];
		char[] oldArr = source.toCharArray();
		for (int i = 0; i < STR_TO_REPLACE.length() - 1; i++) {
			charArr[i] = oldArr[i];
		}
		for (int i = 0; i <= oldArr.length - STR_TO_REPLACE.length(); i++) {
			if (isWord(oldArr, i)) {
				toLetter(oldArr, i);
			}
			charArr[i] = oldArr[i];
		}
		return charArr;
	}

	public static boolean isWord(char[] array, int first) {
		for (int i = 0, j = first; i < STR_TO_REPLACE.length(); i++, j++) {
			if (STR_TO_REPLACE.charAt(i) != array[j]) {
				return false;
			}
		}
		return true;
	}

	public static int countWords(String str) {
		char[] charArr;
		charArr = str.toCharArray();
		int res = 0;

		for (int i = 0; i <= charArr.length - STR_TO_REPLACE.length(); i++) {
			if (isWord(charArr, i)) {
				res++;
			}
		}
		return res;
	}

	public static void toLetter( char[] destination, int pos) {
		
		char prev;
		int oldLen = STR_TO_REPLACE.length();

//		здесь смещаем символы, стоявшие после заменяемой подстроки(word)

		for (int j = 0; j < DELTA_LEN; j++) {
			prev = destination[pos + oldLen + j];
			for (int i = pos + oldLen + j; i < destination.length - 2 + j; i++) {
				char tmp = destination[i + 1];
				destination[i + 1] = prev;
				prev = tmp;
			}
		}

		int j = 0;
		for (int i = pos; i < pos + 6; i++, j++) {
			destination[i] = REPLACING_STR.charAt(j);
		}
	}

}
