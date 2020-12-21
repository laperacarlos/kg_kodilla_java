package com.kodilla.stream;

import com.kodilla.stream.book.BookDirectory;
import com.kodilla.stream.book.Book;
import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;
import com.kodilla.stream.person.People;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class StreamMain {

    public static void main(String[] args) {

        People.getList().stream()
                .forEach(System.out::println);

        People.getList().stream()
                .map(String::toUpperCase)
                .forEach(s -> System.out.println(s));

        People.getList().stream()
                .map(String::toUpperCase)
                .filter(s -> s.length() > 11)
                .map(s -> s.substring(0, s.indexOf(' ') + 2) + ".")
                .filter(s -> s.substring(0,1).equals("M"))
                .forEach(System.out::println);

        BookDirectory theBookDirectory = new BookDirectory();
        List<Book> theResultListOfBooks = theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .collect(Collectors.toList());

        System.out.println("# elements: " + theResultListOfBooks.size());
        theResultListOfBooks.stream()
                .forEach(System.out::println);


        Map<String,Book> theResultMapOfBooks = theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .collect(Collectors.toMap(Book::getSignature, book -> book));

        System.out.println("# elements: " + theResultMapOfBooks.size());
        theResultMapOfBooks.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);

        String theResultStringOfBooks = theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .map(Book::toString)
                .collect(Collectors.joining(",\n", "<<", ">>"));

        System.out.println(theResultStringOfBooks);

        System.out.println("\n7.3 Final Task \n");

        Forum newForum = new Forum();
        Map<Integer, ForumUser> resultListOfUsers = newForum.getListOfUsers().stream()
                .filter(u -> u.getSex() == 'M')
                .filter (u -> Period.between(u.getDateOfBirth(), LocalDate.now()).getYears() >= 20)
                .filter(u -> u.getNumberOfPosts() >= 1)
                .collect(Collectors.toMap(ForumUser::getIdUser, user -> user));

        resultListOfUsers.entrySet().stream()
                .map(entry -> entry.getKey().toString() + ": " + entry.getValue())
                .forEach(System.out::println);

        System.out.println("\n7.3 End of Task \n\n");

  }
}
