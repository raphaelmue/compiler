package de.raphaelmuesseler.compiler.filereader;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public abstract class TestBase {
    private String[] m_fileContent;
    private int m_currentLine;

    private String[] readLines(String fileName) throws Exception {
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> lines = new ArrayList<>();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            lines.add(line);
        }
        bufferedReader.close();
        return lines.toArray(new String[0]);
    }

    public TestBase(String fileName) throws Exception {
        m_fileContent = readLines(fileName);
        m_currentLine = 0;
    }

    private String getCurrentLine() {
        if (m_currentLine == m_fileContent.length) {
            return null;
        } else {
            return m_fileContent[m_currentLine];
        }
    }

    public InputStream stringToInputStream(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    public abstract String executeTest(String input) throws Exception;

    private void singleTestRun() throws Exception {
        m_currentLine++; // $IN
        StringBuilder input = new StringBuilder();
        while (getCurrentLine() != null && !getCurrentLine().equals("$OUT")) {
            input.append(getCurrentLine());
            input.append('\n');
            m_currentLine++;
        }
        if (getCurrentLine() != null) {
            m_currentLine++;
        }
        StringBuilder output = new StringBuilder();
        while (getCurrentLine() != null && !getCurrentLine().equals("$IN")) {
            output.append(getCurrentLine());
            output.append('\n');
            m_currentLine++;
        }
        String result = executeTest(input.toString());
        result = result.substring(0, result.length() - 1);
        if (result.equals(output.toString())) {
            System.err.println("TEST SUCCEEDED");
            System.err.print(input);
            System.err.println("ACTUAL OUTPUT");
            System.err.print(result);
        } else {
            System.err.println("TEST FAILED");
            System.err.print(input);
            System.err.println("EXPECTED OUTPUT");
            System.err.print(output);
            System.err.println("ACTUAL OUTPUT");
            System.err.print(result);
            throw new Exception("TestFailure");
        }
    }

    public void testRun() throws Exception {
        while (getCurrentLine() != null) {
            while (getCurrentLine() != null && !getCurrentLine().equals("$IN")) {
                System.err.print(getCurrentLine());
                m_currentLine++;
            }
            if (getCurrentLine() != null) {
                singleTestRun();
            }
        }
    }
}
