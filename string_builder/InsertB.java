//  В строке после каждого символа 'a' вставить 'b'.
package by.epam_tc.string.string_builder;

public class InsertB {
	
	public static StringBuilder addB(StringBuilder sb) {
		StringBuilder newStrBuilder = new StringBuilder();
		
		for(int i = 0 ; i < sb.length(); i++) {
			char tmp;
			tmp = sb.charAt(i);
			newStrBuilder.append(tmp);
			
			if(tmp == 'a') {
				newStrBuilder = newStrBuilder.append('b'); 
			}
			
		}
		
		return newStrBuilder;
	}
	
	public static void main(String []argc) {
		
		StringBuilder strBuilder = new StringBuilder("a_naaa_ffjbhfanja");
		
		StringBuilder result;
		result = addB(strBuilder);
		System.out.println(result);
	}

}
