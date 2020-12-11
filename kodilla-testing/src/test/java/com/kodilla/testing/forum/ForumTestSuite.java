package com.kodilla.testing.forum;

import com.kodilla.testing.user.SimpleUser;
import org.junit.jupiter.api.*;

@DisplayName("Forum Test Suite")
public class ForumTestSuite {

    @BeforeEach
    public void before() {
        System.out.println("Taste Case: begin");
    }

    @AfterEach
    public void after() {
        System.out.println("Taste Case: end");
    }

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Taste Suite: begin");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("Taste Suite: end");
    }


    @DisplayName("when create SimpleUser with realName, then getRealName should return real user name")
    @Test
    void testCaseRealName() {
        //Given
        SimpleUser simpleUser = new SimpleUser("theForumUser", "Janek Smif");
        //When
        String result = simpleUser.getRealName();
        System.out.println("Testing " + result);
        //Then
        Assertions.assertEquals("Janek Smif", result );
    }

    @DisplayName("When created SimpleUser with name, " +
            "then getUsername should return correct name")

    @Test
    void testCaseUsername() {
        //Given
        SimpleUser simpleUser = new SimpleUser("theForumUser", "Janek Smif");
        String expectedResult = "theForumUser";
        //When
        String result = simpleUser.getUsername();
        //Then
        Assertions.assertEquals(expectedResult, result );
    }
}
