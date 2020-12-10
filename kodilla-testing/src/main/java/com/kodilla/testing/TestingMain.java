package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;
import com.kodilla.testing.user.SimpleUser;

public class TestingMain {

    public static void main(String[] args) {

        SimpleUser simpleUser = new SimpleUser("theForumUser");

        String result = simpleUser.getUsername();

        if (result.equals("theForumUser")) {
            System.out.println("Test accepted");
        } else {
            System.out.println("Fatal error!");
        }

        System.out.println("\nCalculator tests\n");

        Calculator newCalculator = new Calculator(90, 40);

        System.out.println("Calculator test - addition.");

        int addTest = newCalculator.add();

        if (addTest == newCalculator.getA() + newCalculator.getB()) {
            System.out.println("Addition test accepted.");
        } else {
            System.out.println("Addition test failed.");
        }

        System.out.println("\nCalculator test - substraction.");

        int subTest = newCalculator.substract();

        if (subTest == newCalculator.getA() - newCalculator.getB()) {
            System.out.println("Substraction test accepted.");
        } else {
            System.out.println("Substraction test failed.");
        }
    }
}
