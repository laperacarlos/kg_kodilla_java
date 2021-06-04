package com.kodilla.patterns2.observer.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StudentTaskQueueTestSuite {

    @Test
    void testNotifyObservers() {
        //given
        StudentTaskQueue studentTaskQueue1 = new StudentTaskQueue("First student");
        StudentTaskQueue studentTaskQueue2 = new StudentTaskQueue("Second student");
        StudentTaskQueue studentTaskQueue3 = new StudentTaskQueue("Third student");

        Mentor mentor1 = new Mentor("Mentor no.1");
        Mentor mentor2 = new Mentor("Mentor no.2");

        studentTaskQueue1.registerObserver(mentor1);
        studentTaskQueue2.registerObserver(mentor2);
        studentTaskQueue3.registerObserver(mentor1);
        studentTaskQueue3.registerObserver(mentor2);

        //when
        studentTaskQueue1.addTask("task 1");
        studentTaskQueue1.addTask("task 2");
        studentTaskQueue2.addTask("task 1");
        studentTaskQueue3.addTask("task 1");
        studentTaskQueue3.removeObserver(mentor1);
        studentTaskQueue3.addTask("task 2");

        //then
        assertEquals(3, mentor1.getUpdateCounter());
        assertEquals(3, mentor2.getUpdateCounter());
    }
}
