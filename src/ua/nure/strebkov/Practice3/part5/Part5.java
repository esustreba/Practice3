package ua.nure.strebkov.Practice3.part5;

/**
 * Created a class with two static methods of translation
 * from the decimal system to the Roman numerals and vice versa.
 *
 * @author Strebkov D.
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part5 {

    /**
     * Method translate decimal to Roman numerals.
     * @param x
     * @return
     */
    public static String decimal2Roman(int x) {
        StringBuilder sb = new StringBuilder();
        int tmp = x;
        if (tmp / 100 > 0) {
            for (int i = 0; i < tmp / 100; i++) {
                sb.append("C");
            }
        }
        tmp %= 100;
        if (tmp > 89) {
            sb.append("XC");
        } else {
            if (tmp / 50 > 0) {
                sb.append("L");
            }
            tmp %= 50;
            if (tmp / 10 > 0) {
                if (tmp / 10 == 4) {
                    sb.append("XL");
                } else {
                    for (int i = 0; i < tmp / 10; i++) {
                        sb.append("X");
                    }
                }
            }

        }
        tmp %= 10;
        if (tmp == 9) {
            sb.append("IX");
        } else {
            if (tmp / 5 > 0) {
                sb.append("V");
            }
            tmp %= 5;
            if (tmp > 0) {
                if (tmp == 4) {
                    sb.append("IV");
                } else {
                    for (int i = 0; i < tmp; i++) {
                        sb.append("I");
                    }
                }
            }
        }

        return sb.toString();
    }

    /**
     * Method translate Roman to decimal numerals.
     * @param s
     * @return
     */
    public static int roman2Decimal(String s) {
        int res = 0;
        Pattern pattern = Pattern.compile("(C*)((XC)?)(L*)((XL)?)(X*)((IX)?)(V?)((IV)?)(I*)");
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()) {
            res += matcher.group(1).length() * 100 + (matcher.group(2).equals("") ? 0 : 90)
                    + (matcher.group(4).equals("") ? 0 : 50) + (matcher.group(5).equals("") ? 0 : 40)
                    + matcher.group(7).length() * 10 + (matcher.group(8).equals("") ? 0 : 9)
                    + (matcher.group(10).equals("") ? 0 : 5) + (matcher.group(11).equals("") ? 0 : 4)
                    + matcher.group(13).length();
        }
        return res;
    }

    /**
     * Print result decimal ==> Roman ==> decimal.
     * @param i
     */

    public static void printPair(int i) {
        String roman = decimal2Roman(i);
        System.out.println(i + " ====> " + roman + " ====> " + roman2Decimal(roman));
    }

    /**
     * Main method has a for loop to show process of translation numerals.
     * @param args
     */

    public static void main(String[] args) {
        for (int i = 0; i < 100;) {
            printPair(++i);
        }
    }
}
