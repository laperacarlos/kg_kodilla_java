package com.kodilla.testing.shape;


import java.util.ArrayList;
import java.util.List;

public class ShapeCollector {

    List<Shape> figureList = new ArrayList<>();

    public void addFigure(Shape shape) {
               figureList.add(shape);
        }

    public boolean removeFigure(Shape shape) {
        if (figureList.contains(shape)) {
            figureList.remove(shape);
            return true;
        } else {
            System.out.println("This figure is not listed!");
            return false;
        }
    }

    public Shape getFigure(int n) {
        if (figureList.size() == 0) {
            System.out.println("This list is empty!");
            return null;
        } else {
            return figureList.get(n);
        }
    }

    public String showFigures() {
        if (figureList.size() == 0) {
            System.out.println("This list is empty!");
            return null;
        } else {
            StringBuilder builder = new StringBuilder();

            for (int n = 0; n < figureList.size(); n++) {

                if (n < (figureList.size() - 1)) {
                    builder.append(figureList.get(n).getShapeName()).append(", ");
                } else {
                    builder.append(figureList.get(n).getShapeName());
                }
            }
            return builder.toString();
        }
    }
}
