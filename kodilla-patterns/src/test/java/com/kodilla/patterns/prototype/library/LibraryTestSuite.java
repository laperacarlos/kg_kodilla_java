package com.kodilla.patterns.prototype.library;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTestSuite {

    @Test
    void testGetBooks() {
        //Given
        //creating library
        Library baseLibrary = new Library("Base Library");
        Book book1 = new Book("Title1", "Author1", LocalDate.now().minusYears(21));
        Book book2 = new Book("Title2", "Author2", LocalDate.now().minusYears(22));
        Book book3 = new Book("Title3", "Author3", LocalDate.now().minusYears(23));

        baseLibrary.getBooks().addAll(Arrays.asList(book1, book2, book3));

        //shallow copy
        Library shallowClonedLibrary = null;
        try {
            shallowClonedLibrary = baseLibrary.shallowCopy();
            shallowClonedLibrary.setName("Shallow cloned Library");
        } catch (CloneNotSupportedException exception) {
            System.out.println(exception);
        }

        //deep copy
        Library deepClonedLibrary = null;
        try {
            deepClonedLibrary = baseLibrary.deepCopy();
            deepClonedLibrary.setName("Deep cloned Library");
        } catch (CloneNotSupportedException exception) {
            System.out.println(exception);
        }

        //When
        baseLibrary.getBooks().remove(book1);

        //Then
        System.out.println(baseLibrary);
        System.out.println(shallowClonedLibrary);
        System.out.println(deepClonedLibrary);
        assertEquals(2, baseLibrary.getBooks().size());
        assertEquals(2, shallowClonedLibrary.getBooks().size());
        assertEquals(3, deepClonedLibrary.getBooks().size());
        assertNotEquals(baseLibrary.getBooks(), deepClonedLibrary.getBooks());
        assertEquals(baseLibrary.getBooks(), shallowClonedLibrary.getBooks());

    }
}
