package com.kodilla.patterns2.adapter.bookclasifier.librarya;

import java.util.Set;

public interface Classifier {
    int publicationYear(Set<Book> bookSet);
}
