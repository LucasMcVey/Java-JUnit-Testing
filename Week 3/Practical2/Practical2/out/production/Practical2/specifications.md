## Practical 2 - JUnit 5 Tests

### Task 1

1. Write at least 5 tests in the `BoatTest` class to evaluate the <samp>constructor</samp> and several of the
   <samp>setter</samp>
   methods  
   You may have to use the `assertAll` assertion to ensure that all the tests run.
2. Add some display names using the `@DisplayName` annotation -- you don't have to add it to all.
3. Now, order them using each of the following annotations to see the results:
   - `@TestMethodOrder(MethodOrderer.MethodName.class)`
   - `@TestMethodOrder(MethodOrderer.DisplayName.class)`
   - `@TestMethodOrder(MethodOrderer.OrderAnnotation.class)`  <br><br>
     Only one can be used at a time.

### Task 2

1. Write <samp>Parameterized</samp> tests using the following annotations
   1. `@ValueSource` - using both <samp>ints</samp> and <samp>strings</samp> as parameters
   2. `@CsvSource` - using both 2 and 3 parameters for the <samp>CsvSource</samp>
   3. `@CsvFileSource` - you will need to create a file resource to accomplish this
      1. Create a directory in the <samp>_test_</samp> folder and mark it as "**Test Resources Root**"
      2. Create a folder in the <samp>_test_</samp> folder named <samp>_params_</samp> and then create a file in this
         folder and name it <samp>_boats.csv_</samp>
      3. The file header should look like  
         <br>
         `name,class,regnum`
         with the rest of the file completed with values for each of the headers
      4. Once you have set up the file you can set the second parameter of the `@CsvFileSource` to  
         <samp>numLinesToSkip = 1</samp> so that the headers are not read, thus avoiding possible errors

### Task 3

1. Write a <samp>RepeatedTest</samp> to test that the `addCrew` method is working as it should
2. Write a <samp>RepeatedTest</samp> to test that the `BoatRegister` is working as it should

In both cases use the `@RepeatedTest` annotation and the `@DisplayName` annotation to label your tests

### Task 4

1. Investigate the `assumeX` and `assumingThat` assertions and add them to the parameterized tests from the previous
   task.  
   Information on how to use these can be found at
   [JUnit 5 Assumptions](https://junit.org/junit5/docs/current/user-guide/#writing-tests-assumptions)

### Task 5

1. The `@Tag` annotation
   1. Copy the `BoatTest.java` file and paste it in the <samp>tet/practial2</samp> directory with the new name
      `TaggedBoatTest.java`
   2. copy one of the <samp>Parameterized Tests</samp> from **Task 2** (the first one will be fine) and paste it at the
      bottom of the `TaggedBoatTest.java` file
   3. Add the `@Tag` annotation to each of the methods (more than one can be added - one per new line)
      1. Choose two words that have some meaning e.g. "sanity" and "acceptance"
      2. Your test may look like the following:
      ```java
        @Test
        @Tag("sanity")
        @Tag("acceptance")
        @DisplayName("Testing the setName and setbClass methods")
        void assertEqualsSetter() {
      ```
   4. Select **Edit Configurations**
      1. Delete all the entries under JUnit
      2. Now select the JUnit configuration
      3. In the test kind drop down select the last item "Tags"
      4. In the "Tag expressions" box add one of the tags that you created earlier
      5. Select "Create configuration" and OK
      6. You should see the Configuration in the tool bar of IntelliJ - press the Run button
      7. You can negate by using the '!'
      8. You can run multiple tagged tests by concatenating tag values with a singe '&' 5.Experiment with this to get
         familiar with creating, applying and running different configurations.
