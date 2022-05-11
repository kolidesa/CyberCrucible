package com.example.adamkolidesassignment1;


import javax.validation.constraints.NotBlank;

public class Update {
    @NotBlank
    private String courseNumber;
    @NotBlank
    private String updateInfo;

    public Update(String courseNumber, String updateInfo) {
        this.courseNumber = courseNumber;
        this.updateInfo = updateInfo;
    }

    public String getCourseNumber() {
        return courseNumber;
    }
    public String getUpdateInfo() {
        return updateInfo;
    }
}
