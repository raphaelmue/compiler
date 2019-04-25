package de.raphaelmuesseler.compiler.lexer;

import de.raphaelmuesseler.compiler.filereader.FileReader;
import de.raphaelmuesseler.compiler.filereader.FileReaderIntf;

import java.io.InputStream;

public class LexerTest extends test.TestBase {

	public LexerTest(String fileName) throws Exception {
		super(fileName);
	}

	public String executeTest(String input) throws Exception {
		InputStream inputStream = stringToInputStream(input);
		FileReaderIntf fileReader = new FileReader(inputStream);
        Lexer lexer = new Lexer(fileReader);
        Token currentToken;
        StringBuilder output = new StringBuilder();
        do {
        	currentToken = lexer.lookAheadToken();
        	output.append(currentToken.toString()).append("\n");
        	lexer.advance();
        } while (currentToken.type != Token.Type.EOF);
		return output.toString();
	}
}
