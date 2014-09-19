package pl.bytehog.piglang;

import pl.bytehog.piglang.*;

import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;
import java.io.FileNotFoundException;

public class App {
    public static void main(String[] args) {
        StringBuilder str = new StringBuilder();
        InputStream stream = System.in;
        if (args.length == 1) {
            try {
                stream = new FileInputStream(args[0]);
            } catch (FileNotFoundException e) {
                System.err.println("File not found");
                System.exit(1);
            } catch (IOException e) {
                System.err.println("I/O error");
                System.exit(1);
            }
        } 
        
        int i;
        try {
            while ((i = stream.read()) != -1) {
                str.append((char) i);
            }
        } catch (IOException e) {
            System.err.println("I/O error");
            System.exit(1);
        }

        ArrayList<Token> lexed = Lexer.lex(str.toString(), "\\s"); //, Compiler.DELIMITER);
        ArrayList<String> parsed = Parser.parse(lexed);
        System.out.println(Compiler.compile(parsed));
    }
}
