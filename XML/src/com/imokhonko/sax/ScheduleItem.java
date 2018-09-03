package com.imokhonko.sax;

import java.util.ArrayList;
import java.util.List;

public class ScheduleItem {

    private String group;
    private int day;
    List<Lesson> lessons = new ArrayList<>(4);

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    public void setLesson(Lesson lesson) {
        this.lessons.add(lesson);
    }


    @Override
    public String toString() {
        return "ScheduleItem{" +
                "group='" + group + '\'' +
                ", day=" + day +
                ", lessons=" + lessons +
                '}';
    }
}
