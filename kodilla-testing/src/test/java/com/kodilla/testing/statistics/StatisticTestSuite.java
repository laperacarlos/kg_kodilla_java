package com.kodilla.testing.statistics;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StatisticTestSuite {
    private static int testCounter = 0;

    @Mock
    private Statistics statistics;

    @BeforeEach
    public void beforeEach() {
        testCounter++;
        System.out.println("Test Number: " + testCounter);

        int testPostCount = 1000;
        int testCommentCount = 1000;

        List<String> testUserList = new ArrayList<>();
        for (int n=0; n<100; n++) {
            String user = "User" + n;
            testUserList.add(user);
        }

        when(statistics.usersNames()).thenReturn(testUserList);
        when(statistics.postCount()).thenReturn(testPostCount);
        when(statistics.commentsCount()).thenReturn(testCommentCount);
    }

    @Test
    void test0Posts() {
        //Given
        CalculateStatistics newStats = new CalculateStatistics(statistics);
        when(statistics.postCount()).thenReturn(0);

        //When
        newStats.calculateAdvStatistics(statistics);
        newStats.showStatistics();

        //Then
        Assertions.assertEquals(0, newStats.getPostPerUser());
        Assertions.assertEquals(10, newStats.getCommentPerUser());
        Assertions.assertEquals(0, newStats.getCommentsPerPost());
    }

    @Test
    void test1000Posts() {
        //Given
        CalculateStatistics newStats = new CalculateStatistics(statistics);

        //When
        newStats.calculateAdvStatistics(statistics);
        newStats.showStatistics();

        //Then
        Assertions.assertEquals(10, newStats.getPostPerUser());
        Assertions.assertEquals(10, newStats.getCommentPerUser());
        Assertions.assertEquals(1, newStats.getCommentsPerPost());

    }

    @Test
    void test0Comments() {
        //Given
        CalculateStatistics newStats = new CalculateStatistics(statistics);
        when(statistics.commentsCount()).thenReturn(0);

        //When
        newStats.calculateAdvStatistics(statistics);
        newStats.showStatistics();

        //Then
        Assertions.assertEquals(10, newStats.getPostPerUser());
        Assertions.assertEquals(0, newStats.getCommentPerUser());
        Assertions.assertEquals(0, newStats.getCommentsPerPost());
    }

    @Test
    void testLessCommentsThanPosts() {
        //Given
        CalculateStatistics newStats = new CalculateStatistics(statistics);
        when(statistics.commentsCount()).thenReturn(100);

        //When
        newStats.calculateAdvStatistics(statistics);
        newStats.showStatistics();

        //Then
        Assertions.assertEquals(10, newStats.getPostPerUser());
        Assertions.assertEquals(1, newStats.getCommentPerUser());
        Assertions.assertEquals(0.1, newStats.getCommentsPerPost());
    }

    @Test
    void testMoreCommentsThanPosts() {
        //Given
        CalculateStatistics newStats = new CalculateStatistics(statistics);
        when(statistics.commentsCount()).thenReturn(2000);

        //When
        newStats.calculateAdvStatistics(statistics);
        newStats.showStatistics();

        //Then
        Assertions.assertEquals(10, newStats.getPostPerUser());
        Assertions.assertEquals(20, newStats.getCommentPerUser());
        Assertions.assertEquals(2, newStats.getCommentsPerPost());
    }

    @Test
    void test0Users() {
        //Given
        CalculateStatistics newStats = new CalculateStatistics(statistics);
        List<String> testUsersList = new ArrayList<>();
        when(statistics.usersNames()).thenReturn(testUsersList);

        //When
        newStats.calculateAdvStatistics(statistics);
        newStats.showStatistics();

        //Then
        Assertions.assertEquals(0, newStats.getPostPerUser());
        Assertions.assertEquals(0, newStats.getCommentPerUser());
        Assertions.assertEquals(1, newStats.getCommentsPerPost());
    }

    @Test
    void test100Users() {
        //Given
        CalculateStatistics newStats = new CalculateStatistics(statistics);

        //When
        newStats.calculateAdvStatistics(statistics);
        newStats.showStatistics();

        //Then
        Assertions.assertEquals(10, newStats.getPostPerUser());
        Assertions.assertEquals(10, newStats.getCommentPerUser());
        Assertions.assertEquals(1, newStats.getCommentsPerPost());
    }
}
