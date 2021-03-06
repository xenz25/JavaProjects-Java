package main_pack;

import java.util.regex.*;

public class EliminateDuplicatedWord {

	public static void main(String[] args) {
		String regexString = "\\b(\\w+)(?:\\W+\\1\\b)+";
		String wordString = "Goodbye bye bye world world world";
		
		Pattern pattern = Pattern.compile(regexString);
		Matcher matcher = pattern.matcher(wordString);
		
		while(matcher.find()) {
			System.out.println(matcher.group());
			wordString = wordString.replaceAll(matcher.group(), matcher.group(1));
		}
		System.out.println(wordString);
	}

}
