package com.kodilla.patterns2.adapter.bookclasifier;

import com.kodilla.patterns2.adapter.bookclasifier.librarya.Book;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class MedianAdapterTestSuite {

    @Test
    void testPublicationYearMedian() {
        //given
        Set<Book> bookSet = new HashSet<>();
        bookSet.add(new Book("Author A", "Title 1", 1992, "tsn562"));
        bookSet.add(new Book("Author B", "Title 2", 2000, "tpr820"));
        bookSet.add(new Book("Author C", "Title 3", 2003, "jke465"));
        bookSet.add(new Book("Author D", "Title 4", 2006, "jke422"));
        bookSet.add(new Book("Author E", "Title 5", 2007, "jkr567"));

        MedianAdapter medianAdapter = new MedianAdapter();

        //when
        int medianPublicationYear = medianAdapter.publicationYear(bookSet);

        //then
        assertEquals(2003, medianPublicationYear);
    }
}
