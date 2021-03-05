package com.kodilla.patterns.prototype;

import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private final String name;
    private final List<Task> tasks = new ArrayList<>();

    public TaskList(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    @Override
    public String toString() {
        String s = "   List [" + name + "]";
        for (Task task : tasks) {
            s = s + "\n" + task.toString();
        }
        return s;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TaskList taskList = (TaskList) o;

        if (!name.equals(taskList.name)) return false;
        return tasks.equals(taskList.tasks);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + tasks.hashCode();
        return result;
    }
}
