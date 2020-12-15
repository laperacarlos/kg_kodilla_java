package com.kodilla.testing.shape;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("TDD: Shape Collector Test Suite")
public class ShapeCollectorTestSuite {

    @Nested
    @DisplayName("List Builder test Suite")

    class BuildingTests {

        @Test
        void testAddFigure() {
            //Given
            ShapeCollector newCollector = new ShapeCollector();
            Triangle newTriangle = new Triangle("Triangle", 55);

            //When
            newCollector.addFigure(newTriangle);

            //Then
            Assertions.assertEquals(newTriangle, newCollector.getFigure(0));
        }

        @Test
        void testRemoveFigure() {

            //Given
            ShapeCollector newCollector = new ShapeCollector();
            Square square = new Square("Square", 85);
            newCollector.addFigure(square);

            //When
            boolean result = newCollector.removeFigure(square);

            //Then
            Assertions.assertTrue(result);
        }

        @Test
        void testRemoveFigureNotExisting() {
            //Given
            ShapeCollector newCollector = new ShapeCollector();
            Circle circle = new Circle("Circle", 45);

            //When
            boolean result = newCollector.removeFigure(circle);

            //Then
            Assertions.assertFalse(result);
        }
    }

    @Nested
    @DisplayName("List checking Test Suite")
    class ListChecking {

        @Test
        void testGetFigureWhileListIsEmpty() {
            //Given
            ShapeCollector newCollector = new ShapeCollector();

            //When
            Shape result = newCollector.getFigure(0);

            //Then
            Assertions.assertNull(result);
        }

        @Test
        void testGetFigure() {
            //Given
            ShapeCollector newCollector = new ShapeCollector();
            Circle circle = new Circle("Circle", 33);
            newCollector.addFigure(circle);

            //When
            Shape result = newCollector.getFigure(0);

            //Then
            Assertions.assertEquals(circle, result);
        }

        @Test
        void testListShowUp() {
            //Given
            ShapeCollector newCollector = new ShapeCollector();
            Circle circle = new Circle("circle", 97);
            Square square = new Square("square", 56);
            Triangle triangle = new Triangle("triangle", 55);
            newCollector.addFigure(circle);
            newCollector.addFigure(square);
            newCollector.addFigure(triangle);

            //When
            String result = newCollector.showFigures();

            //Then
            Assertions.assertEquals(circle.getShapeName() + ", " + square.getShapeName() + ", " + triangle.getShapeName(), result);
        }

        @Test
        void testListShowUpWhileEmpty() {
            //Given
            ShapeCollector newCollector = new ShapeCollector();

            //When
            String result = newCollector.showFigures();

            //Then
            Assertions.assertNull(result);
        }

    }

}
