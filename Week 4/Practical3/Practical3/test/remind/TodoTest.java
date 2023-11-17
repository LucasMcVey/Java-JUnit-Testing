package remind;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Date;

class TodoTest {

    private final PrintStream standardOut = System.out;
    private final InputStream systemIn = System.in;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @ParameterizedTest(name = "Testing todo print")
    @CsvSource(value = { "5/11/20, todo: 5/11/20 test"})
    public void print(String input, String output) {

        System.setOut(new PrintStream(outputStreamCaptor));
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        Date date = Todo.dateParse(input);
        Todo todo = new Todo(date, "test");
        todo.print();
        String expected = output.trim().replace("\r\n", "\n");
        String actual = outputStreamCaptor.toString().trim().replace("\r\n", "\n");

        assertEquals(expected, actual);


    }


}