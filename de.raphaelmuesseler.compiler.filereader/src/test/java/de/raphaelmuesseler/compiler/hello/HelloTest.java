package de.raphaelmuesseler.compiler.hello;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class HelloTest {
    @Test
    public void testHello() throws IOException {
        HelloLexer lexer = new HelloLexer(CharStreams.fromStream(getClass().getResourceAsStream("./hello.txt")));
        HelloParser parser = new HelloParser(new CommonTokenStream(lexer));
        parser.setBuildParseTree(true);
        ParseTree parseTree = parser.r();
        Assertions.assertEquals("(r hello test)", parseTree.toStringTree(parser));
    }
}
