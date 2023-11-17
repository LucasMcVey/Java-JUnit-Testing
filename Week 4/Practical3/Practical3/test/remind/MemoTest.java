package remind;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MemoTest {

    private final PrintStream standardOut = System.out;
    private final InputStream systemIn = System.in;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    @ParameterizedTest(name = "Testing memo print")
    @CsvSource(value = {"Test, memo: Test"})
    public void print(String input, String output) {

        System.setOut(new PrintStream(outputStreamCaptor));
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        Memo memo = new Memo(input);
        memo.print();
        String expected = output.trim().replace("\r\n", "\n");
        String actual = outputStreamCaptor.toString().trim().replace("\r\n", "\n");
        assertEquals(expected, actual);
    }
}