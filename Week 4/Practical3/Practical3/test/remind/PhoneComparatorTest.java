package remind;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class PhoneComparatorTest {



    @Test
    public void PhoneComparator() {

        String input1 = "test";
        String number1 = "0472729710";

        String input2 = "Test";
        String number2 =  "0291298982";
        Phone phone1 = new Phone(input1, number1);
        Phone phone2 = new Phone(input2, number2);

        PhoneComparator phonecomparator = new PhoneComparator();
        int test = phonecomparator.compare(phone1, phone2);
        assertEquals(32,test);

    }


}