package ua.nure.strebkov.Practice3.part4;

/** Create method hash(String input, String algorithm)
 * The output must represent a string of hexadecimal digits:
 * each byte of corresponds to two hexadecimal digits.
 *
 * @author Strebkov D.
 */

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part4 {
    /**
     * Method return hash array of bytes.
     * @param input
     * @param algorithm
     * @return
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */

    public static String hash(String input, String algorithm) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder();
        MessageDigest digest = MessageDigest.getInstance(algorithm);
        digest.update(input.getBytes("UTF-8"));


        byte[] hash = digest.digest();

        Pattern pattern = Pattern.compile("(\\d{1,8})$");

        for (byte b : hash) {
            Matcher matcher = pattern.matcher(Integer.toBinaryString(b));
            while (matcher.find()) {
                if (matcher.group().length() < 5) {
                    sb.append(0);
                }
                sb.append(Integer.toHexString(Integer.parseInt(matcher.group(), 2)).toUpperCase());
            }
        }
        return sb.toString();
    }

    /**
     * method main prints strings of HEX.
     * @param args
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */

    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        System.out.println(hash("password", "SHA-256"));
        System.out.println(hash("passwort", "SHA-256"));
    }
}

