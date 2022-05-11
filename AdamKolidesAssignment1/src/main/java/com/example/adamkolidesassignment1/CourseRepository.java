package com.example.adamkolidesassignment1;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface CourseRepository extends MongoRepository<Course, String> {
    public List<Course> findByCourseNumber(String courseNumber);
    public List<Course> findByInstructor(String instructor);

}