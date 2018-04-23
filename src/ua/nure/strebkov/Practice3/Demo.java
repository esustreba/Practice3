package ua.nure.strebkov.Practice3;

import ua.nure.strebkov.Practice3.part4.Part4;
import ua.nure.strebkov.Practice3.part1.Part1;
import ua.nure.strebkov.Practice3.part2.Part2;
import ua.nure.strebkov.Practice3.part3.Part3;
import ua.nure.strebkov.Practice3.part5.Part5;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * Class demo to all parts of Practice3
 * @author Strebkov D.
 */
public class Demo {
    static final String[] ARG = {""};

    public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        System.out.println("=========Part1=========");
        Part1.main(ARG);
        System.out.println("=========Part2=========");
        Part2.main(ARG);
        System.out.println("=========Part3=========");
        Part3.main(ARG);
        System.out.println("=========part4=========");
        Part4.main(ARG);
        System.out.println("=========Part5=========");
        Part5.main(ARG);

    }
}
