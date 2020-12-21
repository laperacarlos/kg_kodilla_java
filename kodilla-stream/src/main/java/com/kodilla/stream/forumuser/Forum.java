package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class Forum {

    private final List<ForumUser> listOfUsers = new ArrayList<>();

    public Forum() {
        listOfUsers.add(new ForumUser(1, "shark", 'M', LocalDate.of(1991, 5, 11), 7));
        listOfUsers.add(new ForumUser(2, "dancingbeauty", 'F', LocalDate.of(1985, 5, 31), 2));
        listOfUsers.add(new ForumUser(3, "youngeagle", 'M', LocalDate.of(2007, 9, 16), 8));
        listOfUsers.add(new ForumUser(4, "bigmama", 'F', LocalDate.of(1988, 2, 4), 7));
        listOfUsers.add(new ForumUser(5, "raven", 'M', LocalDate.of(1999, 4, 9), 0));
    }

    public List<ForumUser> getListOfUsers() {

        return new ArrayList<>(listOfUsers);
    }
}
