package main_pack;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexPractice1 {

	public static void main(String[] args) {
		String[] ipStrings = {
				"259.259.259.259",
				"266.266.266.266",
				"255.255.255.255",
				"555.555.555.555",
				"666.666.666.666",
				"249.249.249.249",
				"249.249.249.256"
		};
		
		//String zeroTo255 = "(\\d{1,2}|(0|1)\\d{2}|2[0-4]\\d|25[0-5])";
		//String pattern = zeroTo255 + "\\." + zeroTo255 + "\\." + zeroTo255 + "\\." + zeroTo255;
		
	
		String base_pattern = "(\\d{1,2}|[01]\\d\\d|2[0-4]\\d|25[0-5])";
		String patternString = base_pattern + "\\." + base_pattern + "\\." + base_pattern + "\\." + base_pattern;
		
		Pattern pattern = Pattern.compile(patternString);
		Matcher matcher = pattern.matcher("249.249.249.256");
		
		String inputString = "Goodbye bye bye bye world";
		Pattern pattern2  = Pattern.compile("b[a-z]*e");
		Matcher matcher2 = pattern2.matcher(inputString);
		
		System.out.println(pattern2.pattern());
		
		while (matcher2.find()) {
            System.out.println("Full match: " + matcher2.group(0));
            
            for (int i = 1; i <= matcher2.groupCount(); i++) {
                System.out.println("Group " + i + ": " + matcher2.group(i));
            }
        }	
		
		System.out.println(inputString.replaceAll("b[a-z]*e", "").replaceAll("\s", ""));
		
		
		
		
		

	}

}
