/*
   Удалить в строке все лишние пробелы.
   Крайние пробелы удалитьж
*/
package by.epam_tc.string.char_arr;

public class Task5 {

	public static char[] deletingSpaces(char[] charArr) {
		boolean isPrevSpace = false;
		int size = charArr.length;

		while (charArr[size - 1] == ' ') {
			size--;
		}

		for (int i = 0; i < size; i++) {
			if ((i == 0 || isPrevSpace) && (charArr[i] == ' ')) {
				for (int j = i; j < charArr.length - 1; j++) {
					charArr[j] = charArr[j + 1];
				}
				isPrevSpace = true;
				i--;
				size--;
			}

			else if (charArr[i] == ' ') {
				isPrevSpace = true;
			} else {
				isPrevSpace = false;
			}
		}

		char[] res = new char[size];

		for (int i = 0; i < size; i++) {
			res[i] = charArr[i];
		}
		return res;
	}

	public static void main(String[] argc) {
		String str = "  gjkdgj   gjgd jgdkgj j       jngd   ";

		char[] charArr;
		charArr = str.toCharArray();
		char[] result;
		result = deletingSpaces(charArr);
		String res = new String(result);

		System.out.println(str);
		System.out.println(res);

	}

}
