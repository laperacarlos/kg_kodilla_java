package com.kodilla.stream.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArrayOperationsTestSuite {

    @Test
    void testGetAverage() {
        //Given
        int[] numbers = new int[20];

        numbers[0] = 7;
        numbers[1] = 29;
        numbers[2] = 14;
        numbers[3] = 23;
        numbers[4] = 29;
        numbers[5] = 29;
        numbers[6] = 39;
        numbers[7] = 28;
        numbers[8] = 29;
        numbers[9] = 22;
        numbers[10] = 29;
        numbers[11] = 29;
        numbers[12] = 1;
        numbers[13] = 9;
        numbers[14] = 19;
        numbers[15] = 29;
        numbers[16] = 23;
        numbers[17] = 54;
        numbers[18] = 29;
        numbers[19] = 17;

        //When
        double avg = ArrayOperations.getAverage(numbers);

        //Then
        Assertions.assertEquals(24.4, avg);
    }
}
