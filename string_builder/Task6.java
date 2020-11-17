// Из данной строки получить новую, повторив каждый символ дважды
package by.epam_tc.string.string_builder;

public class Task6 {
	public static StringBuilder duplicate(StringBuilder strBuilder) {
		StringBuilder twinStrBuilder = new StringBuilder();
		
		for(int i = 0; i < strBuilder.length(); i++) {
			char ch = strBuilder.charAt(i);
			twinStrBuilder.append(ch);
			twinStrBuilder.append(ch);
			
		}
		
		return twinStrBuilder;
	}
	
	public static void main(String []argc) {
		StringBuilder stringBuilder = new StringBuilder("1234567890q");
		
		StringBuilder twinStringBuilder;
		twinStringBuilder = duplicate(stringBuilder);
		System.out.println(twinStringBuilder);
	}

}
