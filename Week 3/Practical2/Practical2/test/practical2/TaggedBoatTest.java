package practical2;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

@TestMethodOrder(MethodOrderer.MethodName.class)
class TaggedBoatTest {



    @Test
    @DisplayName("test")
    void Task1() {

        Boat boat = new Boat("Popeye","Test", 1);

        assertAll("Grouped Assertions of Constructor and setter methods test",
                () -> boat.setName("Boat"),
                () -> assertEquals( "Boat", boat.getName()),

                () -> boat.setbClass("Test2"),
                () -> assertEquals("Test2", boat.getbClass()),

                () -> boat.setRegNum(6),
                () -> assertTrue((boat.getRegNum() == 6))

                );
    }




@ParameterizedTest
@ValueSource(strings = {"Boat"})
void Task2(String input) {


    Boat boat = new Boat("Popeye","Test", 1);

    assertAll("Grouped Assertions of Constructor and setter methods test",
            () -> boat.setName(input),
            () -> assertEquals( "Boat", boat.getName()),

            () -> boat.setbClass("Test2"),
            () -> assertEquals("Test2", boat.getbClass())

    );
}
    @ParameterizedTest
    @ValueSource(ints = {6,5})
    void Task2part1(int input) {


        Boat boat = new Boat("Popeye","Test", 1);

        assertAll("Grouped Assertions of Constructor and setter methods test",
                () -> boat.setRegNum(input),
                () -> assertTrue((boat.getRegNum() == 6))

        );
    }

    @ParameterizedTest
    @CsvSource(value= {"boat,boat2", "test,test1"})
    void Task2part2(String input) {

        Boat boat = new Boat("Popeye","Test", 1);

        assertAll("Grouped Assertions of Constructor and setter methods test",
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



        assertAll("Grouped Assertions of Constructor and setter methods test",
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


        assertAll("Grouped Assertions of Constructor and setter methods test",
                () -> boat.addCrew("boat"),
                () -> assertEquals("[boat]", boat.getCrew()),

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
                () -> assertEquals( input, boat.getName()),

                () -> boat.setbClass(input),
                () -> assertEquals(input, boat.getbClass())

        );
    }



    @ParameterizedTest
    @Tag("sanity")
    @Tag("acceptance")
    @ValueSource(strings = {"Boat"})
    void Task5(String input) {


        Boat boat = new Boat("Popeye","Test", 1);

        assertAll("Grouped Assertions of Constructor and setter methods test",
                () -> boat.setName(input),
                () -> assertEquals( "Boat", boat.getName()),

                () -> boat.setbClass("Test2"),
                () -> assertEquals("Test2", boat.getbClass())

        );
    }




}


