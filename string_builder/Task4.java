//С помощью функции копирования и операции конкатенации 
//Из частей слова "информатика" составить слово "торт"
package by.epam_tc.string.string_builder;

public class Task4 {
	
	public final static String CAKE = "торт";
	
	public static StringBuilder makeCake(String str) {
	        StringBuilder strBuilder = new StringBuilder();

	        int j = 0;
	        while(!(strBuilder.toString().equals(CAKE))) {

	                char tmp = str.charAt(j);
	                if(strBuilder.length() == 0 && tmp == CAKE.charAt(0)) {
	                    strBuilder.append(tmp);
	                }
	                if(strBuilder.length() == 1 && tmp == CAKE.charAt(1)) {
	                    strBuilder.append(tmp);
	                }
	                if(strBuilder.length() == 2 && tmp == CAKE.charAt(2)) {
	                    strBuilder.append(tmp);
	                }
	                if(strBuilder.length() == 3 && tmp == CAKE.charAt(3)) {
	                    strBuilder.append(tmp);
	                }

	                if(j == str.length() - 1) {
	                    j = -1;
	                }
	                j++;
	            }
	        return strBuilder;
	    }

	    public static void main(String[] argc) {

	        String string = "информатика";

	        String cake =  new String(makeCake(string));
	        System.out.println(cake);

	    }
}
