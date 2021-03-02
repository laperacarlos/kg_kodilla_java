package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LoggerTestSuite {

    @Test
    void testGetLastLog() {
        //Given
        Logger logger = Logger.INSTANCE;
        logger.log("This is requested last log");

        //When
        String testLog = logger.getLastLog();
        System.out.println(testLog);

        //Then
        assertEquals("This is requested last log", testLog);
    }
}
