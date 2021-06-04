package com.kodilla.patterns2.observer.homework;

public class Mentor implements Observer {
    private final String name;
    private int updateCounter;

    public Mentor(String name) {
        this.name = name;
    }

    @Override
    public void update(StudentTaskQueue studentTaskQueue) {
        System.out.println(name + ": There are new tasks from " + studentTaskQueue.getStudentName() + " to be checked" + "\n"
        + "(total number of tasks in the queue: " + studentTaskQueue.getTaskQueue().size() + ")" + System.lineSeparator());
        updateCounter++;
    }

    public int getUpdateCounter() {
        return updateCounter;
    }
}
