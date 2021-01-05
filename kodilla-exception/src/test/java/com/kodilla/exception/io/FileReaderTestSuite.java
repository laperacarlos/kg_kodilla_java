package com.kodilla.exception.io;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FileReaderTestSuite {

    @Test
    void testReadFile() {
        //Given
        FileReader fileReader = new FileReader();

        //When & Then
        assertDoesNotThrow(() -> fileReader.readFile());
    }

    @Test
     void whenFileDoseNotExistsReadFileShouldThrowException() {

        //Given
        FileReader fileReader = new FileReader();
        String fileName = "nie_ma_takiego_pliku.txt";

        //When & Then
        assertThrows(FileReaderException.class, () -> fileReader.readFileToTest(fileName));
    }

    @Test
    void testReadFileWithName() {
        //Given
        FileReader fileReader = new FileReader();

        //When & Then
        assertAll(
                () -> assertThrows(FileReaderException.class, () -> fileReader.readFileToTest("nie_ma_takiego_pliku.txt")),
                () -> assertThrows(FileReaderException.class, () -> fileReader.readFileToTest(null)),
                () -> assertDoesNotThrow(() -> fileReader.readFileToTest("names.txt"))
        );
    }
}
