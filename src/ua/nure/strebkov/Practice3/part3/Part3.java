package ua.nure.strebkov.Practice3.part3;

/**
 * read text from part3.txt and convert first letter to upper case.
 */

import ua.nure.strebkov.Practice3.Util;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class Part3 {

    public static String firstLetterToUpperCase(String input) {
        StringBuilder sb = new StringBuilder();
        Pattern pattern = Pattern.compile("(?U)\\s*\\w+.?\\s*");
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            Character tmp = Character.toUpperCase(matcher.group().charAt(0));
            sb.append(matcher.group().replaceFirst("^\\p{javaLowerCase}", Character.toString(tmp)));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String input = Util.getInput("part3.txt");
        System.out.println(firstLetterToUpperCase(input));
    }
}
