package ua.nure.strebkov.Practice3.part1;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ua.nure.strebkov.Practice3.Util;

public class Part1 {

	public static final String REGEXP = "(?m)^(.+);(.+);(.+)@(.+)$";

	public static String convert1(String input) {
		StringBuilder sb = new StringBuilder();
		Pattern pattern = Pattern.compile(REGEXP);
		Matcher m = pattern.matcher(input);

		
		while (m.find()) {
			sb.append(m.group(1)).append(" ==> ").append(m.group(3)).append("@").append(m.group(4)).append("\n");
		}

		return sb.toString();
	}

	public static String convert2(String input) {
		StringBuilder sb = new StringBuilder();
		Pattern pattern = Pattern.compile(REGEXP);
		Matcher m = pattern.matcher(input);

		
		while (m.find()) {
			sb.append(m.group(2)).append(" (email: ").append(m.group(3)).append("@").append(m.group(4)).append(")\n");
		}

		return sb.toString();
	}

	public static String convert3(String input) {
		Pattern pattern = Pattern.compile(REGEXP);
		Matcher m = pattern.matcher(input);
		StringBuilder sb = new StringBuilder();

		ArrayList<String> domens = new ArrayList<String>(2);
		while (m.find()) {
			if (!domens.contains(m.group(4))) {
				domens.add(m.group(4));
			}
		}

		for (String s : domens) {
			m.reset();
			sb.append(s).append(" ==> ");
			while (m.find()) {
				if (s.equals(m.group(4))) {
					sb.append(m.group(3)).append(", ");
				}
			}
			sb.delete(sb.length() - 2, sb.length()).append("\n");
		}
		return sb.toString();
	}
	
	public static String convert4(String input){
		Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        Pattern pattern = Pattern.compile("(?m)^(.+);(.+);(.+)$");
        Matcher m = pattern.matcher(input);


        if (m.find()){
            sb.append(m.group()).append(";Password").append("\n");
        }
        while(m.find()){
            sb.append(m.group()).append(";");
			for (int i = 0; i < 4; i++) {
				sb.append(rand.nextInt(10));
			}
			sb.append("\n");
        }

        return sb.toString();

    }

	public static void main(String[] args) {
		String input = Util.getInput("part1.txt");

		System.out.println(convert1(input));
		System.out.println("===================");
		System.out.println(convert2(input));
		System.out.println("===================");
		System.out.println(convert3(input));
		System.out.println("===================");
		System.out.println(convert4(input));

	}
}
