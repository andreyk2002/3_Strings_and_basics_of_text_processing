package by.epam_tc.string.reg_ex.text;

public class TextDemo {
	public static void main(String[]argc) {
		String txtStr  = " There are some test strings for my application. Hello! ABCD FGHT LKM."
				+ "\r\n" + " Oracle Corporation is an American multinational computer technology corporation headquartered in Redwood Shores, California."
				+ "\r\n" + " Dasfhlh zcc adssfhasd daffasd dasfadsf dsafqfauih dssfai. Fdahh vsifobjlj jh i jzcx qiluhv fajkdlfhzv fajskdhpzv fa hd. Fajhfaad adf."
						+ " Fdjahqvdvahjn dajh afd vnjmn jkvr h.";
		
		TextLogic logic = new TextLogic();
		Text text = new Text(txtStr);
		
		text.print();
		System.out.println("\nText sorted by paragraphs : ");
		logic.sortParagraphs(text);
		text.print();
		System.out.println("\nSentences sorted by words length : ");
		logic.sortSentencesByWordsLen(text);
		text.print();
		logic.sortSentencesByChosenSymbol(text, 'c');
		text.print();
		
	}
}
