package com.kodilla.exception.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SecondChallengeTestSuite {

    @Test
    void testSecondChallenge() {
        //Given
        SecondChallenge secondChallenge = new SecondChallenge();

        //When & Then
        assertAll(
                () -> assertDoesNotThrow(() -> secondChallenge.probablyIWillThrowException(1, 1.6)),
                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(0.99, 1.6)),
                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(1, 1.5)),
                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(0.99, 1.5))
        );
    }
}
