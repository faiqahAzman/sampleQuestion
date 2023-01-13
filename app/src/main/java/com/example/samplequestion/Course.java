package com.example.samplequestion;

public class Course {

    private String day;
    private String time;
    private String course;
    private String grade;

    public Course(String day, String time, String course,String grade) {
        this.day = day;
        this.time = time;
        this.course = course;
        this.grade = grade;
    }

    public String getDay() {
        return day;
    }

    public String getTime() {
        return time;
    }

    public String getCourse() {
        return course;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
