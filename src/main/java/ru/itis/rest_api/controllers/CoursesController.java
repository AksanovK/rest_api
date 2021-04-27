package ru.itis.rest_api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itis.rest_api.dto.CourseDto;
import ru.itis.rest_api.dto.TeacherDto;
import ru.itis.rest_api.models.Course;
import ru.itis.rest_api.services.CoursesService;

import java.util.List;


@RestController
public class CoursesController {

    @Autowired
    private CoursesService coursesService;

    @GetMapping("/courses")
    public ResponseEntity<List<Course>> getAllCourses() {
        return ResponseEntity.ok(coursesService.getAllCourses());
    }

    @PostMapping("/courses")
    public ResponseEntity<Course> addCourse(@RequestBody CourseDto course) {
        return ResponseEntity.ok(coursesService.addCourse(course));
    }

    @PostMapping("/courses/{course-id}/teachers")
    public ResponseEntity<Course> addTeacherIntoCourse(@PathVariable("course-id") Long courseId,
                                                       @RequestBody TeacherDto teacher) {
        return ResponseEntity.ok(coursesService.addTeacherIntoCourse(courseId, teacher));
    }

}
