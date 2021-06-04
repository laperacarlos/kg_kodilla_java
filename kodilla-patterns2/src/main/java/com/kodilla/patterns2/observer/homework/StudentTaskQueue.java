package com.kodilla.patterns2.observer.homework;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class StudentTaskQueue implements Observable {
    private final String studentName;
    private final Deque<String> taskQueue;
    private final List<Observer> observers;

    public StudentTaskQueue(String studentName) {
        this.studentName = studentName;
        taskQueue = new ArrayDeque<>();
        observers = new ArrayList<>();
    }

    public void addTask(String newTask) {
        taskQueue.offerLast(newTask);
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer: observers) {
            observer.update(this);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public String getStudentName() {
        return studentName;
    }

    public Deque<String> getTaskQueue() {
        return taskQueue;
    }
}
