 /*
   Удалить из строки все повторяющиеся символы и все пробелы
*/
package by.epam_tc.string.string_builder;

public class Task7 {

	public static void removeDuplicatesAndSpaces(StringBuilder strBuilder) {
		char previousSymbol;
		previousSymbol = strBuilder.charAt(0);

		for (int i = 0; i < strBuilder.length(); i++) {
			char ch = strBuilder.charAt(i);
			if (ch == ' ' || ch == previousSymbol) {
				strBuilder.deleteCharAt(i);
				i--;
			} else {
				previousSymbol = ch;
			}
		}

	}

	public static void main(String[] argc) {
		StringBuilder stringBuilder = new StringBuilder("  ddasssd  gh  fff   jhk  ");
		removeDuplicatesAndSpaces(stringBuilder);
		System.out.println(stringBuilder);
	}

}
