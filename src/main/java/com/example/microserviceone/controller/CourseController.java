package com.example.microserviceone.controller;

import com.example.microserviceone.model.Course;
import com.example.microserviceone.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping
    public ResponseEntity<?> saveCourse(@RequestBody Course course){
        return new ResponseEntity<>(courseService.saveCourse(course), HttpStatus.CREATED);
    }

    @DeleteMapping("{courseId}")
    public ResponseEntity<?> deleteCourse(@PathVariable Long courseId){
        courseService.deleteCourse(courseId);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllCourses(){
        return new ResponseEntity<>(courseService.findAllCourses(), HttpStatus.OK);
    }


}
