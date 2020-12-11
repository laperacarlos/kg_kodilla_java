package com.kodilla.testing.collection;


import java.util.*;

public class OddNumbersExterminator {


    public List<Integer> exterminate(List<Integer> numbers) {

        List<Integer> newList = new ArrayList<>();

        if (numbers.isEmpty()) {
            System.out.println("The list is empty!");
        } else {
            for (Integer numberCheck : numbers) {
                if (numberCheck % 2 == 0) {
                    newList.add(numberCheck);
                }
            }
            System.out.println("\nList size to be compared with test list: " + newList.size());
            System.out.println("Numbers to be compared with test numbers: " + newList.toString());

        }
        return newList;
    }
}
