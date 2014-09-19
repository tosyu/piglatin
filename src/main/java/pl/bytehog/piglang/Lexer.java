package pl.bytehog.piglang;

import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import pl.bytehog.piglang.*;

public class Lexer {
    public static ArrayList<Token> lex(ArrayList<String> input) {
        ArrayList<Token> result = new ArrayList<Token>();
        Pattern vowel = Pattern.compile("^[aeiouy].*");
        Pattern consonant = Pattern.compile("^[^aeiouy].*");
        Matcher m;

        String element;
        ListIterator<String> it = input.listIterator();
        while (it.hasNext()) {
            element = (String) it.next();
            if (vowel.matcher(element).matches()) {
                result.add(new Token(TokenType.vowel, element));
            } else if (consonant.matcher(element).matches()) {
                result.add(new Token(TokenType.consonant, element));
            } else {
                result.add(new Token(TokenType.unknown, element));
            }
        }

        return result;
    }

    public static ArrayList<Token> lex(String input, String tokenDelimiterRegex) {
        return Lexer.lex(new ArrayList<String>(Arrays.asList(input.split(tokenDelimiterRegex))));
    }

    public static ArrayList<Token> lex(String input) {
        return Lexer.lex(input, "\\s");
    }
}
