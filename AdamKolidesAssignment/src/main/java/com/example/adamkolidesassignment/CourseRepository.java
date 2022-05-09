package com.example.adamkolidesassignment;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface CourseRepository extends MongoRepository<Course, String> {
    public Course findByCourseNumber(String courseNumber);
    public List<Course> findByInstructor(String instructor);

}
