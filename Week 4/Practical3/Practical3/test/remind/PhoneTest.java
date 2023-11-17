package remind;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class PhoneTest {


    private final PrintStream standardOut = System.out;
    private final InputStream systemIn = System.in;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @ParameterizedTest(name = "Testing phone print")
    @CsvSource(value = {"Test, 0425331452 , phone: Test"})
    public void print(String input, String number, String output) {

        System.setOut(new PrintStream(outputStreamCaptor));
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        Phone phone = new Phone(input, number);
        phone.print();
        String expected = output.trim().replace("\r\n", "\n") + " " + number.trim().replace("\r\n", "\n");;
        String actual = outputStreamCaptor.toString().trim().replace("\r\n", "\n");
        assertEquals(expected, actual);


    }

    @Test
    public void matchname()
    {
        String input = "Test";
        String number = "0475872116";

        Phone phone = new Phone(input, number);

        assertTrue(phone.matchName(input), input);

    }

    @Test
    public void getName()
    {
        String input = "Test";
        String number = "0475872116";

        Phone phone = new Phone(input, number);

        assertEquals(input, phone.getName());

    }



}