package com.kodilla.spring.portfolio;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class BoardTestSuite {

    @Test
    void testAddTask() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);

        //When
        board.toDoList.addTask("New task to do");
        board.inProgressList.addTask("New task in progress");
        board.doneList.addTask("New finished task");

        //Then
        assertEquals("New task to do", board.toDoList.getTasks().get(0));
        assertEquals("New task in progress", board.inProgressList.getTasks().get(0));
        assertEquals("New finished task", board.doneList.getTasks().get(0));
    }
}
