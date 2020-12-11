package com.kodilla.testing.collection;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@DisplayName("Collection Test Suite")
public class CollectionTestSuite {

    @BeforeEach
    public void before() {
        System.out.println("Collection Test Case: begin");
    }

    @AfterEach
    public void after() {
        System.out.println("Collection Taste Case: end\n");
    }

    @DisplayName("when create empty list, then exterminate method also should return empty list and info that list is empty")
    @Test
    void testOddNumbersExterminatorEmptyList() {
        //Given
        List<Integer> numbers = new ArrayList<>();
        OddNumbersExterminator newExterminator = new OddNumbersExterminator();
        //When
        Boolean result = newExterminator.exterminate(numbers).isEmpty();
        //Then
        Assertions.assertEquals(numbers.isEmpty(), result);
    }
    @DisplayName("when create normal list, then exterminate method should return list with even numbers")
    @Test
    void testOddNumbersExterminatorNormalList() {
        //Given
        Random numberGenerator = new Random();

        OddNumbersExterminator newExterminator = new OddNumbersExterminator();

        List<Integer> numbers = new ArrayList<>();
        for (int n=0; n<100; n++) {
            Integer randomNumber = numberGenerator.nextInt(100)+1;
            numbers.add(randomNumber);
        }
        System.out.println("Items to check: " + numbers.size());

        Integer[] intArray = new Integer[numbers.size()];
        intArray = numbers.toArray(intArray);
        System.out.println("Test numbers to check: " + Arrays.toString(intArray));

        List<Integer> listToCompare = new ArrayList<>();
        for (Integer numCheck : numbers) {
            if (numCheck % 2 == 0) {
                listToCompare.add(numCheck);
            }
        }
        System.out.println("\nTest list size after extermination: " + listToCompare.size());

        Integer[] evenArray = new Integer[listToCompare.size()];
        evenArray = listToCompare.toArray(evenArray);
        System.out.println("Test numbers after examination: " + Arrays.toString(evenArray));
        // When
        List<Integer> result = newExterminator.exterminate(numbers);
        //Then
        Assertions.assertEquals(listToCompare, result);
    }
}
