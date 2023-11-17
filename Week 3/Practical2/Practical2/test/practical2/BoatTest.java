package practical2;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;


import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;



import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
class BoatTest {



    @Test
    @DisplayName("test")
    void Task1() {

        Boat boat = new Boat("Popeye","Test", 1);
        Boat boat2 = new Boat();
        Long big = 9999999L;

        assertAll("Grouped Assertions of Constructor and setter methods tests",
                () -> boat.setName("Boat"),
                () -> assertEquals( "Boat", boat.getName()),

                () -> boat.setbClass("Test2"),
                () -> assertEquals("Test2", boat.getbClass()),

                () -> boat.setbClass(null),
                () -> assertNull(boat.getbClass()),

                () -> boat.setRegNum(0),
                () -> assertTrue((boat.getRegNum() == 0)),

                () -> boat.setRegNum(Math.toIntExact(big)),
                () -> assertTrue((boat.getRegNum() == big)),

                () -> boat2.setRegNum(0),
                () -> assertTrue((boat2.getRegNum() == 0)),

     //           () -> assertThrows(IllegalArgumentException.class, () -> boat.setName(null)), // null is allowed for the set name class
        //        () -> assertThrows(NullPointerException.class, () -> boat.setName(null)),

                Boat::printTotal



                );
    }




@ParameterizedTest
@ValueSource(strings = {"Boat"})
void Task2(String input) {


    Boat boat = new Boat("Popeye","Test", 1);

    assertAll("Grouped Assertions of Value source using strings",
            () -> boat.setName(input),
            () -> assertEquals( "Boat", boat.getName()),

            () -> boat.setbClass("Test2"),
            () -> assertEquals("Test2", boat.getbClass())

    );
}
    @ParameterizedTest
    @ValueSource(ints = {6,5,7,8,9,0,11,})
    void Task2part1(int input) {


        Boat boat = new Boat("Popeye","Test", 1);

        assertAll("Grouped Assertions of Value source using ints",
                () -> boat.setRegNum(input),
                () -> assertTrue((boat.getRegNum() == input))

        );
    }

    @ParameterizedTest
    @CsvSource(value= {"boat,boat2", "test,test1","popeye,Popeye"})
    void Task2part2(String input) {

        Boat boat = new Boat("Popeye","Test", 1);

        assertAll("Grouped Assertions of CsvSource using 3 parameters",
                () -> boat.setName(input),
                () -> assertEquals( input, boat.getName()),

                () -> boat.setbClass(input),
                () -> assertEquals(input, boat.getbClass())

        );
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/params/boats.csv", numLinesToSkip = 1)
    void Task2part3(String input) {

        Boat boat = new Boat("Popeye","Test", 1);



        assertAll("Grouped Assertions of CsvFileSource using a CSV file",
                () -> boat.setName(input),
                () -> assertEquals( input, boat.getName()),

                () -> boat.setbClass(input),
                () -> assertEquals(input, boat.getbClass())

        );
    }

    @RepeatedTest(3)
    @DisplayName("test")
    void Task3() {

        Boat boat = new Boat("Popeye","Test", 1);
        BoatRegister boatRegister = new BoatRegister();

        Set<String> crew = new HashSet<>();

        crew.add("test");

        // The boat.getCrew gets a string list but the boat.addCrew adds as just a regular string.
        // I instead use the string list to compare the expected string vs the string that comes back.
        // As per feedback from Carl Mooney, instead of creating a string list for adding to the crew.

        assertAll("Grouped Assertions to test that the addCrew and BoatRegister is working as it should",
                () -> boat.addCrew("test"),
                () -> assertEquals(crew, boat.getCrew()),

                () -> boatRegister.addBoat(boat),
                () -> assertEquals(boat, boatRegister.getBoat(1))
        );
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/params/boats.csv", numLinesToSkip = 1)
    void Task4(String input) {

        Boat boat = new Boat("Popeye","Test", 1);

        assumeTrue(boat.getRegNum()== 1,
                () -> "RegNum does not equal to 1");

        assertAll("Grouped Assertions of Constructor and setter methods test",
                () -> boat.setName(input),
                () -> assertEquals( input, boat.getName()),

                () -> boat.setbClass(input),
                () -> assertEquals(input, boat.getbClass())

        );
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/params/boats.csv", numLinesToSkip = 1)
    void Task4Part1(String input) {

        Boat boat = new Boat("Popeye","Test", 1);

        assumingThat(boat.getRegNum()== 1,
                () -> boat.setRegNum(2));

        assertAll("Grouped Assertions of Constructor and setter methods test",
                () -> boat.setName(input),
                () -> assertEquals( input, boat.getName()),

                () -> boat.setbClass(input),
                () -> assertEquals(input, boat.getbClass())

        );
    }




}


