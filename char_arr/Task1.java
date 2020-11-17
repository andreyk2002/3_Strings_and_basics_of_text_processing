/*Дан массив названий переменных в  camelCase
 * Преобразовать названия в snake_case
 * 
 */
package by.epam_tc.string.char_arr;

public class Task1 {

	public static void main(String[] argc) {

		String[] strings = { "hello", "thisIsACamelCase", "firstVariable", "secondVariable" };

		for (int i = 0; i < strings.length; i++) {

			strings[i] = toSnakeCase(strings[i]);
			//strings[i] = new String(toLowerCase(strings[i]));
		}

		for (int i = 0; i < strings.length; i++) {

			System.out.println(strings[i]);
		}

	}

	public static String toSnakeCase(String str) {
		int numbOfUppers = 0;
		for (int i = 0; i < str.length(); i++) {
			if (isUpperCase(str.charAt(i))) {
				numbOfUppers++;
			}
		}
		str = changeString(str, numbOfUppers);
		return str;
	}

	public static boolean isUpperCase(char ch) {

		int code;
		code = ch;
		// для русского и english
		if (code > 64 && code < 91) {
			return true;
		}
		if (code > 1039 && code < 1072) {
			return true;
		}
		return false;
	}

	public static String changeString(String str, int numb) {
		char[] charArr;
		charArr = new char[str.length() + numb];
		int i;
		i = charArr.length - 1;

		for (int j = str.length() - 1; j >= 0; j--) {
			char ch;
			ch = str.charAt(j);

			if (isUpperCase(ch)) {
				ch += 32;//toLowerCase
				charArr[i] = ch;
				i--;
				charArr[i] = '_';
			}

			else {
				charArr[i] = ch;
			}

			i--;
		}

		String str2 = new String(charArr);
		return str2;
	}


}
