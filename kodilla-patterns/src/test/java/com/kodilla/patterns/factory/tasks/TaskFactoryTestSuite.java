package com.kodilla.patterns.factory.tasks;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskFactoryTestSuite {

    @Test
    void testShoppingTaskFactory() {
        //Given
        TaskFactory task = new TaskFactory();

        //When
        Task shoppingTask = task.makeTask(TaskFactory.SHOPPING);

        //Then
        assertFalse(shoppingTask.isTaskExecuted());
        assertEquals("Shopping task", shoppingTask.getTaskName());
    }

    @Test
    void testPaintingTaskFactory() {
        //Given
        TaskFactory task = new TaskFactory();

        //When
        Task paintingTask = task.makeTask(TaskFactory.PAINTING);
        paintingTask.executeTask();

        //Then
        assertTrue(paintingTask.isTaskExecuted());
        assertEquals("Painting task", paintingTask.getTaskName());
    }

    @Test
    void testDrivingTaskFactory() {
        //Given
        TaskFactory task = new TaskFactory();

        //When
        Task drivingTask = task.makeTask(TaskFactory.DRIVING);
        drivingTask.executeTask();

        //Then
        assertTrue(drivingTask.isTaskExecuted());
        assertEquals("Driving task", drivingTask.getTaskName());
    }
}
