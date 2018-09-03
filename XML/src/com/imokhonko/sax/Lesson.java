package com.imokhonko.sax;

public class Lesson {

    private String title;
    private String type;
    private String teacher;
    private byte count;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public void setCount(byte count) {
        this.count = count;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public String getTeacher() {
        return teacher;
    }

    public byte getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", teacher='" + teacher + '\'' +
                ", count=" + count +
                '}';
    }
}
