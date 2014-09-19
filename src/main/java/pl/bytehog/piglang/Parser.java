package pl.bytehog.piglang;

import java.util.*;
import pl.bytehog.piglang.*;

public class Parser {

	private static String parseVowel(String input) {
		return input + "way";
	}

	private static String parseConsonant(String input) {
		return input.substring(1) + input.charAt(0) + "ay";
	}

	public static ArrayList<String> parse(ArrayList<Token> tokens) {
		ArrayList<String> result = new ArrayList<String>();

		ListIterator it = tokens.listIterator();
		Token token;
		while (it.hasNext()) {
			token = (Token) it.next();
			switch (token.getType()) {
				case vowel:
					result.add(Parser.parseVowel(token.getData()));
					break;
				case consonant:
					result.add(Parser.parseConsonant(token.getData()));
					break;
				default:
					result.add(token.getData());
					break;
			}
		}

		return result;
	}
}
