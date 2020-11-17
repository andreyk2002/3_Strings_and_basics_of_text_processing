package by.epam_tc.string.reg_ex.text;

public class TextLogic {
	public void sortParagraphs(Text t) {
		int len = t.getParagraphs().length;
		int[] sentencesCount = new int[len];

		for (int i = 0; i < len; i++) {
			sentencesCount[i] = t.getSentences()[i].length;
		}
		mergeSort(t.getParagraphs(), sentencesCount, 0, len - 1, false);
	}

	public void sortSentencesByWordsLen(Text t) {
		for (int i = 0; i < t.getParagraphs().length; i++) {
			for (int j = 0; j < t.getSentences()[i].length; j++) {
				String sentence = t.getSentences()[i][j];
				String[] words = sentence.split("\\s");
				int[] wordsLens = new int[words.length];
				for (int k = 0; k < words.length; k++) {
					wordsLens[k] = words[k].length();
				}
				mergeSort(words, wordsLens, 0, words.length - 1, false);
				StringBuilder newSentence = new StringBuilder();
				for (int k = 0; k < words.length; k++) {
					newSentence.append(words[k]);
					newSentence.append(" ");
				}
				t.setSentence(newSentence.toString(), i, j);
			}

		}
		t.saveParagraphs();
	}

	public void sortSentencesByChosenSymbol(Text t, char c) {
		for (int i = 0; i < t.getParagraphs().length; i++) {
			for (int j = 0; j < t.getSentences()[i].length; j++) {
				String sentence = t.getSentences()[i][j];
				String[] words = sentence.split("\\s");
				int[] charCount = new int[words.length];
				for (int k = 0; k < words.length; k++) {
					charCount[k] = 0;
					for (int l = 0; l < words[k].length(); l++) {
						if (words[k].charAt(l) == c) {
							charCount[k]--;// для сортировки по убыванию
						}
					}
				}
				mergeSort(words, charCount, 0, words.length - 1, true);
				StringBuilder newSentence = new StringBuilder();
				for (int k = 0; k < words.length; k++) {
					newSentence.append(words[k]);
					newSentence.append(" ");
				}
				t.setSentence(newSentence.toString(), i, j);
			}
		}
	}

	private void mergeSort(String[] s, int[] n, int begin, int end, boolean checkAlphabet) {

		if (begin < end) {
			int mid = (begin + end) / 2;
			mergeSort(s, n, begin, mid, checkAlphabet);
			mergeSort(s, n, mid + 1, end, checkAlphabet);
			merge(s, n, begin, mid, end, checkAlphabet);
		}
	}

	private void merge(String[] arr, int[] n, int begin, int mid, int end, boolean checkAlphabet) {
		String[] tmpArr = new String[end - begin + 1];
		int[] tmpCount = new int[end - begin + 1];
		int index = 0;
		int i = 0;
		int j = 1;// что бы елемент mid не учитывать два раза
		while (begin + i <= mid || mid + j <= end) {

			if (begin + i > mid) {
				for (int k = mid + j; k <= end; k++) {
					tmpArr[index] = arr[k];
					tmpCount[index++] = n[k];
				}
				break;
			}

			if (mid + j > end) {
				for (int k = begin + i; k <= mid; k++) {
					tmpArr[index] = arr[k];
					tmpCount[index++] = n[k];
				}
				break;
			}

			if (n[mid + j] < n[begin + i]) {
				tmpArr[index] = arr[mid + j];
				tmpCount[index++] = n[mid + j];
				j++;
			} else if (!checkAlphabet || n[mid + j] > n[begin + i]) {
				tmpArr[index] = arr[begin + i];
				tmpCount[index++] = n[begin + i];
				i++;
			} else if (arr[begin + i].compareTo(arr[mid + j]) > 0) {
				tmpArr[index] = arr[mid + j];
				tmpCount[index++] = n[mid + j];
				j++;
			} else {
				tmpArr[index] = arr[begin + i];
				tmpCount[index++] = n[begin + i];
				i++;
			}
		}
		for (int k = begin, l = 0; k <= end; k++, l++) {
			arr[k] = tmpArr[l];
			n[k] = tmpCount[l];
		}
	}

}
