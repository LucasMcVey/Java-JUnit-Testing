package pracs3791;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.NullString;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static pracs3791.Task3.concat;
import static pracs3791.Task3.test;


class Practical1Test {


    @Test
    public void task1() {
        Practical1 practical1 = new Practical1();
        double result = Practical1.max3(-1, 0, 0);
        Assertions.assertEquals(-1, result, 0);

        double result2 = Practical1.max3(10, 40, 20);
        Assertions.assertEquals(40, result2, 0);


    }
    @Test
    public void task1part2() {
        Practical1 practical1 = new Practical1();

        double result3 = Practical1.max3((int) 10.5, 40, 20);
        Assertions.assertEquals(40, result3, 0);

    }
    @Test
    public void task1part3() {
        Practical1 practical1 = new Practical1();

        double result4 = Practical1.max3('a', Integer.parseInt("abc"), 20);
        Assertions.assertEquals(40, result4, 0);
    }



    @Test
    public void task2() {
        Task2 task2 = new Task2();

        double result = Task2.max3(-1, 0, 0);
        Assertions.assertEquals(0, result, 0);

        double result2 = Task2.max3(10, 40, 20);
        Assertions.assertEquals(40, result2, 0);
    }

    @Test
    public void task2part2() {
        Task2 task2 = new Task2();

        double result = Task2.max3('a', Integer.parseInt("abc"), 20);
        Assertions.assertEquals(0, result, 0);

        double result2 = Task2.max3((int) 10.5, 40, 20);
        Assertions.assertEquals(40, result2, 0);
    }



    @Test
    public void task3() {
        Task3 task3 = new Task3();

        ArrayList<Integer> testList3 = new ArrayList<Integer>();
        testList3.add(12);
        testList3.add(19);
        testList3.add(11);
        testList3.add(26);
        equals(Task3.sumsl(testList3) == 37);



    }
    @Test
    public void task3part1() {
        Task3 task3 = new Task3();
//        ArrayList<String> testList3 = new ArrayList<String>();


//        testList3.add("one");
//        testList3.add("two");
//        testList3.add("three");
//        testList3.add(null);

        assertThrows(NullPointerException.class, () -> Task3.concat(null));
    }

    @Test
    public void task4() {
            System.out.println("getFamilyName");
            Student instance = new Student(1,"Bloggs","Fred",1980);
            String expResult = "Bloggs";
            String result = instance.getFamilyName();
            Assertions.assertEquals(expResult,result);
        }
@Test
    public void task4part2() {
        System.out.println("getFamilyName");
        Student instance = new Student(-876,"~","Fred",0);
        String expResult = "Bloggs";
        String result = instance.getFamilyName();
        Assertions.assertEquals(expResult,result);
    }



    @Test
    public void task5() {
        System.out.println("getFamilyName");
        Student2 instance = new Student2(1,"Bloggs","Fred",1980);
        String expResult = "Bloggs";
        String result = instance.getFamilyName();
        Assertions.assertEquals(expResult,result);

        int i;
        i = Student2.getAge();


    }

@Test
    public void task5part2() {
        System.out.println("getFamilyName");
        Student2 instance = new Student2(5,"Bloggs","Fred",-1);
        String expResult = "123";
        String result = instance.getFamilyName();
        Assertions.assertEquals(expResult,result);

        int i;
        i = Student2.getAge();


    }
}
