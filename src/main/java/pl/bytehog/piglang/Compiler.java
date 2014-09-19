package pl.bytehog.piglang;

import java.util.*;

public class Compiler {
	public static String DELIMITER = " ";

	public static String compile(ArrayList<String> words, String delimiter) {
		StringBuilder str = new StringBuilder();

		ListIterator it = words.listIterator();
		while (it.hasNext()) {
			if (it.previousIndex() > -1) {
				str.append(delimiter);
			}
			str.append(it.next());
		}

		return str.toString();
	}

	public static String compile(ArrayList<String> words) {
		return Compiler.compile(words, Compiler.DELIMITER);
	}
}
