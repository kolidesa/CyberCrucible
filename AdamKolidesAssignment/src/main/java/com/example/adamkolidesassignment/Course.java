package com.example.adamkolidesassignment;

import org.springframework.data.annotation.Id;

public class Course {

    @Id
    private String courseNumber;
    private String courseName;
    private String instructor;

    public Course(String courseNumber, String courseName, String instructor) {
        this.courseNumber = courseNumber;
        this.courseName = courseName;
        this.instructor = instructor;
    }

    public String getCourseNumber() {
        return courseNumber;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }

    public void setCourseName(String name) {
        courseName = name;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    @Override
    public String toString() {
        return String.format(
                "Course[courseNumber=%s, courseName='%s', instructor='%s']",
                courseNumber, courseName, instructor);
    }
}
