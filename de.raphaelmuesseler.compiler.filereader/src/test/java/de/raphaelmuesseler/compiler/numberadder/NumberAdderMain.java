package de.raphaelmuesseler.compiler.numberadder;

import de.raphaelmuesseler.compiler.filereader.FileReader;
import de.raphaelmuesseler.compiler.filereader.FileReaderIntf;

import java.io.InputStream;

public class NumberAdderMain extends TestBase {

	public NumberAdderMain(String fileName) throws Exception {
		super(fileName);
	}

	public String executeTest(String input) throws Exception {
		InputStream inputStream = stringToInputStream(input);
		FileReaderIntf fileReader = new FileReader(inputStream);
		String output = new String();
		NumberAdderIntf numberAdder = new NumberAdder(fileReader);
		int number = numberAdder.getSum();
		output += Integer.toString(number);
		output += '\n';
		return output;
	}
}
