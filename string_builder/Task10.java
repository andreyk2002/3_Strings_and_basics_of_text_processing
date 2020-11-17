//Строка X состоит из нескольких предложений.
//Каждое предложение оканчивается точкой, вопросительным или восклицательным знаком.
//Подсчитать количество предложений.

package by.epam_tc.string.string_builder;

public class Task10 {

	public static int countSentences(String str) {
		int res = 0;
		boolean isPrev = false;
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch == '.' || ch == '!' || ch == '?') {
				if (!isPrev) {
					res++;

				}
				isPrev = true;
			} else {
				isPrev = false;
			}
		}

		return res;

	}

	public static void main(String[] argc) {
		String text = "But matter consisting entirely of mirrors!\r\n" + "\r\n"
				+ "That was his first impression of the 2456th. " + "Every surface reflected and glinted light. "
				+ "Everywhere was the illusion of complete smoothness; " + "the effect of a molecular film."
				+ " And in the ever-repeated reflection of himself, of Sociologist Voy,"
				+ " of everything he could see, in scraps and wholes, in all angles, "
				+ "there was confusion. Garish confusion and nausea!\r\n";

		int res = countSentences(text);
		System.out.println("There are " + res + " sentences in this text");

	}

}
