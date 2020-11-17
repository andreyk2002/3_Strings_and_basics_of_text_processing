
package by.epam_tc.string.reg_ex;

import java.io.IOException;
import java.util.regex.*;

public class XML {

	private static String AnalyseDoc(String document) throws IOException {
		if (!checkRules(document)) {

			throw new IOException("Error while parsing xml document\n");

		}
		StringBuilder strBuilder = new StringBuilder();
		Pattern openTag;
		Pattern closeTag;
		Pattern singleTag;
		Pattern bodyTag;

		openTag = Pattern.compile("<[A-Za-z][A-Za-z0-9]*?>");
		closeTag = Pattern.compile("</[A-Za-z][A-Za-z0-9]*?>");
		singleTag = Pattern.compile("<[A-Za-z][A-Za-z0-9]*?/>");
		bodyTag = Pattern.compile("<([A-Za-z][A-Za-z0-9]*)[^>]*>(.+?)</[A-Za-z][A-Za-z0-9]*?>");
		// bodyTag =
		// Pattern.compile<([A-Za-z][A-Za-z0-9]*)[^>]*>(.+?)</[A-Za-z][A-Za-z0-9]*?>

		String[] lines;
		lines = document.split("\n\\s*");

		for (int i = 0; i < lines.length; i++) {
			Matcher mOpen;
			Matcher mClose;
			Matcher mSingle;
			Matcher mBody;

			mOpen = openTag.matcher(lines[i]);
			mClose = closeTag.matcher(lines[i]);
			mSingle = singleTag.matcher(lines[i]);
			mBody = bodyTag.matcher(lines[i]);
			if (mSingle.find()) {
				strBuilder.append(mSingle.group());
				strBuilder.append("\t - tag without body\n");
			} else if (mOpen.find()) {
				strBuilder.append(mOpen.group());
				strBuilder.append("\t - opened tag\n");
			}
			if (mBody.find()) {
				strBuilder.append(mBody.group(2));
				strBuilder.append("\t - tag consists\n");
			}
			if (mClose.find()) {
				strBuilder.append(mClose.group());
				strBuilder.append("\t - closed tag\n");
			}

		}
		return strBuilder.toString();
	}

	public static boolean checkRules(String document) {
		String[] lines;
		lines = document.split("\n\\s*");

		String[] openedTags = new String[lines.length];

		Pattern openTag;
		Pattern closeTag;
		Pattern singleTag;

		openTag = Pattern.compile("<\\w.+?>");
		closeTag = Pattern.compile("</\\w+>");
		singleTag = Pattern.compile("<\\w.+?/>");

		int level = 0;

		for (int i = 0; i < lines.length; i++) {
			Matcher mOpen;
			Matcher mClose;
			Matcher mSingle;

			mOpen = openTag.matcher(lines[i]);
			mClose = closeTag.matcher(lines[i]);
			mSingle = singleTag.matcher(lines[i]);

			if (mSingle.find()) {
				continue;
			} else if (mOpen.find()) {
				openedTags[level] = mOpen.group();
				level++;

			}

			if (mClose.find()) {
				if (level != 0) {
					if (equalsLikeTags(openedTags[level - 1], mClose.group())) {
						deleting(openedTags, level - 1);
						level--;
					} else {
						return false;
					}
				} else {
					return false;
				}
			}
		}
		return true;
	}

	private static void deleting(String[] arr, int index) {
		for (int i = index; i < arr.length - 1; i++) {
			arr[i] = arr[i + 1];
		}
	}

	private static boolean equalsLikeTags(String opened, String closed) {
		int j = 2;
		int i = 1;
		char ch1 = opened.charAt(i);
		char ch2 = closed.charAt(j);
		while (i < opened.length()) {
			ch1 = opened.charAt(i);
			ch2 = closed.charAt(j);
			if (ch1 == ' ') {
				break;
			}
			if (ch1 != ch2) {
				return false;
			}
			i++;
			j++;

		}
		return true;
	}

	public static void main(String[] argc) {

		String document = "<note>\r\n" + "<to>Tove</to>\r\n" + "<from>Jani</from>\r\n"
				+ "<heading>Reminder</heading>\r\n" + "<body>Don't forget me this weekend!</body>\r\n" + "</note>";
		String xmlAnalysis = null;
		try {
			xmlAnalysis = AnalyseDoc(document);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (xmlAnalysis != null) {
			System.out.println(xmlAnalysis);
		}
	}

}
