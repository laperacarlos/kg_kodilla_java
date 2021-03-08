package com.kodilla.patterns.factory.tasks;

public class TaskFactory {
    public static final String SHOPPING = "SHOPPING";
    public static final String PAINTING = "PAINTING";
    public static final String DRIVING = "DRIVING";

    public final Task makeTask(final String taskClass) {
        switch (taskClass) {
            case SHOPPING:
                return new ShoppingTask("Shopping task", "Thing to buy", 20.0);
            case PAINTING:
                return new PaintingTask("Painting task", "Blue", "Thing to be painted");
            case DRIVING:
                return new DrivingTask("Driving task", "Warsaw", "By car");
            default:
                return null;
        }
    }
}
