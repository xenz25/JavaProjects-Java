package main_pack;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TimeConversionTest {

	public static void main(String[] args) {
		String s = "11:05:45PM";
		/*//String regex = "[APM]{2}";
		String regex = "(\\d{2})|([APM]{2})";
        Matcher matcher = Pattern.compile(regex).matcher(s);
        String tokens[] = new String[4];
        int i = 0;
        while (matcher.find()){
			tokens[i] = matcher.group();
			i++;
		}*/

		String[] time_parts = s.trim().split(":");
		boolean isPM = time_parts[2].substring(2).compareTo("PM") == 0;
		time_parts[2] = time_parts[2].substring(0,2);

		if(!isPM){
			if(time_parts[0].equals("12")) time_parts[0] = "00";
		} else {
			int hour = Integer.parseInt(time_parts[0]);
			if(hour >= 1 && hour <= 11){
				time_parts[0] = String.valueOf(Integer.parseInt(time_parts[0]) + 12);
			}
		}
		System.out.print(Arrays.toString(time_parts));

	}

}
