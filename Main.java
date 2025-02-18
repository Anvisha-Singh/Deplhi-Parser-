import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            System.out.println("Please provide the input file name as a command line argument.");
            return;
        }

        String fileName = args[0];
        String input = new String(Files.readAllBytes(Paths.get(fileName)));


        CharStream inputStream = CharStreams.fromString(input);
        DelphiLexer lexer = new DelphiLexer(inputStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        DelphiParser parser = new DelphiParser(tokens);
        ParseTree tree = parser.program();
        System.out.println(tree.toStringTree(parser));
        Interpreter analyzer = new Interpreter();
        analyzer.visit(tree);
    }



}
