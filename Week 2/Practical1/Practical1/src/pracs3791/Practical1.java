package pracs3791;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;


public class Practical1 {

    public static int max3(int num1, int num2, int num3) {
        return -1;
    }


}


class Task2 {
    public static int max3(int num1, int num2, int num3) {
        int max = Math.max(num1, num2);
        return Math.max(num1, num2);
    }
}


class Task3 {

    public static Integer sumsl (ArrayList<Integer>list) {
        return (Collections.max(list) + Collections.min(list));
    }
   public static String concat(ArrayList<String> test) {
       return String.join(", ", test);
   }
        static String test (ArrayList<String> test) {

//            test = new ArrayList<String>();
//            test.add("one");
//            test.add("two");
//            test.add("three");
            return Task3.concat(test);
        }
    static int sumSL(ArrayList<Integer> test) {
//        test = new ArrayList<Integer>();
//        test.add(9);
//        test.add(2);
//        test.add(4);
//        test.add(10);

        return Task3.sumSL(test);
    }

}

class Student{
    int idNumber;
    String familyName;
    String personalName;
    int yearOfBirth;

    public Student(int idNumber, String familyName, String personalName, int yearOfBirth) {
        this.idNumber = idNumber;
        this.familyName = familyName;
        this.personalName = personalName;
        this.yearOfBirth = yearOfBirth;
    }



    public String getFamilyName() {
        return this.familyName;
    }
}


class Student2{
    int idNumber;
    String familyName;
    String personalName;
    static int yearOfBirth;



    public Student2(int idNumber, String familyName, String personalName, int yearOfBirth) {
        this.idNumber = idNumber;
        this.familyName = familyName;
        this.personalName = personalName;
        this.yearOfBirth = yearOfBirth;

    }


    public String getFamilyName() {
        return familyName;
    }

    public static int getAge() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        return currentYear - yearOfBirth;
    }


}