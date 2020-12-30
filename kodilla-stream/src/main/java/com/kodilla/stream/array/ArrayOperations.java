package com.kodilla.stream.array;

import java.util.OptionalDouble;
import java.util.stream.IntStream;

public interface ArrayOperations {

    static double getAverage(int[] numbers) {

        IntStream.range(0, numbers.length)
                .forEach(n -> System.out.println(numbers[n]));

        OptionalDouble optAvg = IntStream.range(0, numbers.length)
                .map(n -> numbers[n])
                .average();

        double average = 0;

        if (optAvg.isPresent()) {
            average = optAvg.getAsDouble();
        }

        return average;
    }
}
