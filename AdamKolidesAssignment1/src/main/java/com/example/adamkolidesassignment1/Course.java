package com.example.adamkolidesassignment1;

import org.springframework.data.annotation.Id;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

public class Course {
    private static int id = 1;
    @Id
    private int courseId;
    @NotBlank
    private String courseNumber;
    @NotBlank
    private String courseName;
    @NotBlank
    private String instructor;

    public Course(String courseNumber, String courseName, String instructor) {
        courseId = id;
        id++;
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

    public int getCourseId() { return courseId; }

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
                "Course[courseId =%s, courseNumber=%s, courseName='%s', instructor='%s']",
                courseId, courseNumber, courseName, instructor);
    }
}
