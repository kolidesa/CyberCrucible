package com.example.adamkolidesassignment1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
public class AdamKolidesAssignment1Controller {

    //Create repository for courses
    @Autowired
    private CourseRepository repository;

    //Create course
    @PostMapping("/addCourse")
    public ResponseEntity addCourse(@Valid @RequestBody Course course) {
        repository.save(course);
        return new ResponseEntity(HttpStatus.OK);
    }

    //Find a course by number
    @GetMapping("/findCourse/{courseNumber}")
    public ResponseEntity findCourse(@PathVariable @NotBlank String courseNumber) {
        repository.findByCourseNumber(courseNumber);
        return new ResponseEntity(repository.findByCourseNumber(courseNumber),HttpStatus.OK);
    }

    //Find all the courses an instructor teaches
    @GetMapping("/findInstructor/{instructor}")
    public ResponseEntity findInstructor(@PathVariable @NotBlank String instructor) {
        return new ResponseEntity(repository.findByInstructor(instructor), HttpStatus.OK);
    }

    //Finds all courses
    @GetMapping("/findAllCourses")
    public ResponseEntity findAllCourses() {
        return new ResponseEntity(repository.findAll(), HttpStatus.OK);
    }

    //Updates course number
    @GetMapping("/updateCourseNumber")
    public ResponseEntity updateCourseNumber(@Valid @RequestBody Update u) {
        List<Course> c = repository.findByCourseNumber(u.getCourseNumber());
        if (c.isEmpty() == false) {
            for (int i = 0; i < c.size(); i++) {
                c.get(i).setCourseNumber(u.getUpdateInfo());
                repository.save(c.get(i));
            }
            return new ResponseEntity(HttpStatus.OK);
        }
        else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    //Updates Course Name
    @GetMapping("/updateCourseName")
    public ResponseEntity updateCourseName(@Valid @RequestBody Update u) {
        List<Course> c = repository.findByCourseNumber(u.getCourseNumber());
        if (c.isEmpty() == false) {
            for (int i = 0; i < c.size(); i++) {
                c.get(i).setCourseName(u.getUpdateInfo());
                repository.save(c.get(i));
            }
            return new ResponseEntity(HttpStatus.OK);
        }
        else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    //Updates course instructor
    @GetMapping("/updateCourseInstructor")
    public ResponseEntity updateCourseInstructor(@Valid @RequestBody Update u) {
        List<Course> c = repository.findByCourseNumber(u.getCourseNumber());
        if (c.isEmpty() == false) {
            for (int i = 0; i < c.size(); i++) {
                c.get(i).setInstructor(u.getUpdateInfo());
                repository.save(c.get(i));
            }
            return new ResponseEntity(HttpStatus.OK);
        }
        else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    //Delete a specific course
    @DeleteMapping( "/delete/{id}")
    public ResponseEntity deleteCourse(@PathVariable @NotBlank String id) {
        List<Course> c = repository.findByCourseNumber(id);
        while (!c.isEmpty()) {
            repository.delete(c.get(0));
            c = repository.findByCourseNumber(id);
        }
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
        return new ResponseEntity("An error occurred", HttpStatus.BAD_REQUEST);

    }
}
