package by.epam_tc.string.reg_ex.text;

import java.io.Serializable;
import java.util.*;

public class Text implements Serializable{
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private String[]paragraphs;
	private String[][]sentences;
	
	public Text() {
		this("");
	}
	
	public Text(String text) {
		paragraphs = text.split("\r\n");
		
		sentences = new String[paragraphs.length][];
		for(int i = 0; i < paragraphs.length; i++) {
			sentences[i] = paragraphs[i].split("[.?!]"); 
		}
	}

	public String[] getParagraphs() {
		return paragraphs;
	}

	public void setParagraphs(String[] paragraphs) {
		this.paragraphs = paragraphs;
	}

	public String[][] getSentences() {
		return sentences;
	}

	public void setSentences(String[][] sentences) {
		this.sentences = sentences;
	}
	
	public void setSentence(String newSentence, int paragraphNumb, int sentenceNumb){
		sentences[paragraphNumb][sentenceNumb] = newSentence;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(paragraphs);
		result = prime * result + Arrays.deepHashCode(sentences);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Text other = (Text) obj;
		if (!Arrays.equals(paragraphs, other.paragraphs))
			return false;
		if (!Arrays.deepEquals(sentences, other.sentences))
			return false;
		return true;
	}

	public void saveParagraphs() {
	
	}
	
	public void print() {
		for(int i = 0; i < paragraphs.length; i++) {
			System.out.println("\n\t\tParagraph " + (i + 1) + "\n" );
			for(int j = 0; j < sentences[i].length; j++) {
				System.out.print("Sentence " + (j + 1) + ":\t");
				System.out.println(sentences[i][j]);
			}
		}
	}
	@Override
	public String toString() {
		return "Text [paragraphs=" + Arrays.toString(paragraphs) + ", sentences=" + Arrays.toString(sentences) + "]";
	}
	
	
}
