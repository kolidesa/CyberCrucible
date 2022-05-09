package com.example.adamkolidesassignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdamKolidesAssignmentController {

    //Create repository for courses
    @Autowired
    private CourseRepository repository;

    //Create course
    @PostMapping("/addCourse")
    public ResponseEntity addCourse(@RequestBody Course course) {
        System.out.print(course);
        repository.save(course);
        return new ResponseEntity(HttpStatus.OK);
    }

    //Find a course by number
    @GetMapping("/findCourse/{id}")
    public Course findCourse(@PathVariable String id) {
        return repository.findByCourseNumber(id);
    }

    //Find all the courses an instructor teaches
    @GetMapping("/findInstructor/{instructor}")
    public List<Course> findInstructor(@PathVariable String instructor) {
        return repository.findByInstructor(instructor);
    }

    //Finds all courses
    @GetMapping("/findAllCourses")
    public List<Course> findAllCourses() {
        return repository.findAll();
    }

    //Updates course number
    @GetMapping("/updateCourseNumber/{id}&{updateInfo}")
    public ResponseEntity updateCourseNumber(@PathVariable String id, @PathVariable String updateInfo) {
        Course c = repository.findByCourseNumber(id);
        c.setCourseNumber(updateInfo);
        repository.save(c);
        return new ResponseEntity(HttpStatus.OK);
    }

    //Updates course name
    @GetMapping("/updateCourseName/{id}&{updateInfo}")
    public ResponseEntity updateCourseName(@PathVariable String id, @PathVariable String updateInfo) {
        Course c = repository.findByCourseNumber(id);
        c.setCourseName(updateInfo);
        repository.save(c);
        return new ResponseEntity(HttpStatus.OK);
    }

    //Updates course instructor
    @GetMapping("/updateCourseInstructor/{id}&{updateInfo}")
    public ResponseEntity updateCourseInstructor(@PathVariable String id, @PathVariable String updateInfo) {
        Course c = repository.findByCourseNumber(id);
        c.setInstructor(updateInfo);
        repository.save(c);
        return new ResponseEntity(HttpStatus.OK);
    }

    //Delete a specific course
    @DeleteMapping( "/delete/{id}")
    public ResponseEntity deleteCourse(@PathVariable String id) {
        repository.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    //Delete all courses
    @DeleteMapping("/deleteAll")
    public ResponseEntity deleteAllCourses() {
        repository.deleteAll();
        return new ResponseEntity(HttpStatus.OK);
    }

    //Exception Handler
    @ExceptionHandler(Exception.class)
    public ResponseEntity handleException() {
        return new ResponseEntity("An eror occurred", HttpStatus.BAD_REQUEST);

    }
}
