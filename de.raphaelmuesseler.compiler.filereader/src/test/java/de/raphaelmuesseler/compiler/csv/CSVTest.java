package de.raphaelmuesseler.compiler.csv;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CSVTest {
    @Test
    public void testCSV() throws IOException {
        CSVLexer lexer = new CSVLexer(CharStreams.fromStream(getClass().getResourceAsStream("./data.csv")));
        CSVParser parser = new CSVParser(new CommonTokenStream(lexer));
        parser.setBuildParseTree(true);
        ParseTree parseTree = parser.csvfile();
        System.out.println(parseTree.toStringTree(parser));
        Assertions.assertEquals("(csvfile (line (expr 123) , (line (expr 43) , (line (expr \"hello\") , (line (expr 7) \\r\\n)))) (line (expr 34) , (line (expr 0) , (line (expr \"world\") , (line (expr 435) \\r\\n)))) (line (expr -22) , (line (expr 7777) , (line (expr \"test\") , (line (expr -99) \\r\\n)))))",
                parseTree.toStringTree(parser));
    }
}
