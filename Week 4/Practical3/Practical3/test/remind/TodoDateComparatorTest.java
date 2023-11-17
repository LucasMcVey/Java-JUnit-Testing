package remind;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Date;

class TodoDateComparatorTest {
    @Test
    public void TodoDateComparator() {

        Date date = Todo.dateParse("10/11/22");
        Date date2 = Todo.dateParse("10/11/20");

        Todo todo = new Todo(date, "test");
        Todo todo2 = new Todo(date2, "test2");


        TodoDateComparator tododatecomparator = new TodoDateComparator();
        int test = tododatecomparator.compare(todo,todo2);
        assertEquals(1,test);

    }
}