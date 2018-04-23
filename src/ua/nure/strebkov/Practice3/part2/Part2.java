package ua.nure.strebkov.Practice3.part2;

import ua.nure.strebkov.Practice3.Util;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Iterator;

/** Read text from part2.txt and
 * output words with maximum and minimum length.
 *
 * @author Strebkov D.
 */

public class Part2 {

    private static int minVal = Integer.MAX_VALUE;
    private static int maxVal = 0;

    public static final String REGEXP = "([A-z]+)";


    /**
     * Method find min & max value.
     * @param input
     */
    public static void foundMinMaxValue(String input) {


        Pattern pattern = Pattern.compile(REGEXP);
        Matcher m = pattern.matcher(input);

        while (m.find()) {
            if (m.group().length() < minVal) {
                minVal = m.group().length();
            }

            if (m.group().length() > maxVal) {
                maxVal = m.group().length();
            }
        }
    }

    /**
     *
     * @param input
     * @return toString
     */
    public static String getMinMax(String input) {
        foundMinMaxValue(input);
        StringBuilder sb = new StringBuilder();
        Pattern pattern = Pattern.compile(REGEXP);
        Matcher m = pattern.matcher(input);
        Set min = new LinkedHashSet();
        Set max = new LinkedHashSet();

        while (m.find()) {
            if (m.group().length() == minVal) {
                min.add(m.group());
            }

            if (m.group().length() == maxVal) {
                max.add(m.group());
            }
        }

        sb.append("Min: ");
        concat(min.iterator(), sb);
        sb.delete(sb.length() - 2, sb.length());
        sb.append("\n");

        sb.append("Max: ");
        concat(max.iterator(), sb);
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }

    private static void concat(Iterator i, StringBuilder sb) {
        while (i.hasNext()) {
            sb.append(i.next() + ", ");
        }
    }

    /**
     * Main method.
     * @param args
     */
    public static void main(String[] args) {
        String input = Util.getInput("part2.txt");
        System.out.println(getMinMax(input));
    }
}
