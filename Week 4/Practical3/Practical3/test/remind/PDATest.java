package remind;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PDATest {

    private final PrintStream standardOut = System.out;
    private final InputStream systemIn = System.in;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();


    @ParameterizedTest(name = "Testing create and list memo")
    @CsvSource(value = {"Test, memo: Test"})
    void createMemo(String input, String output) {

        System.setOut(new PrintStream(outputStreamCaptor));
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        PDA pda = new PDA();
        pda.createMemo("Test");
        pda.listMemo();
        String expected = output.trim().replace("\r\n", "\n");
        String actual = outputStreamCaptor.toString().trim().replace("\r\n", "\n");
        assertEquals(expected, actual);

    }


    @ParameterizedTest(name = "Testing createPhone")
    @CsvSource(value = {"Test, 0425331452 , phone: Test"})
    void createPhone(String input, String number, String output) {

        System.setOut(new PrintStream(outputStreamCaptor));
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        PDA pda = new PDA();
        pda.createPhone(input,number);
        pda.listPhone();
        String expected = output.trim().replace("\r\n", "\n") + " "+ number.trim().replace("\r\n", "\n");;
        String actual = outputStreamCaptor.toString().trim().replace("\r\n", "\n");
        assertEquals(expected, actual);

    }


    @ParameterizedTest(name = "Testing createPhone and listPhone")
    @CsvSource(value = {"Test, 0425331452 , phone: Test"})
    void listPhone(String input, String number, String output) {

        System.setOut(new PrintStream(outputStreamCaptor));
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        PDA pda = new PDA();
        pda.createPhone(input, number);
        pda.listPhone(number);
        pda.listPhoneAlphabetically();
        String expected = output.trim().replace("\r\n", "\n") + " " + number.trim().replace("\r\n", "\n");
        String actual = outputStreamCaptor.toString().trim().replace("\r\n", "\n");
        assertEquals(expected, actual);
    }

    @ParameterizedTest(name = "Testing todo print")
    @CsvSource(value = { "5/11/20, test"})
    void createTodo(String input, String output) {

        System.setOut(new PrintStream(outputStreamCaptor));
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        PDA pda = new PDA();
        Date date = Todo.dateParse(input);
        pda.createTodo(date, output);
        pda.listTodo();
        pda.listTodoByDate();
        pda.listTodo(date);
        pda.list();

        String actual = outputStreamCaptor.toString().trim().replace("\r\n", "\n");
        String expected = actual;
        assertEquals(expected, actual);




    }
}