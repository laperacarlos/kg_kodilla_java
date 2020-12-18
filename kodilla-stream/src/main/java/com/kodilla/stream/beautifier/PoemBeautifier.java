package com.kodilla.stream.beautifier;

public class PoemBeautifier {

    public void beautify(String textToBeautify, PoemDecorator decorator) {
        String beautifulWord = decorator.decorate(textToBeautify);
        System.out.println(beautifulWord);
    }
}
