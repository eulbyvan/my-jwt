package com.enigmacamp.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 07/12/2022
 */

@RestController
@RequestMapping("/courses")
public class CourseController {
    @GetMapping
    public ResponseEntity getAllCourse() {
        return ResponseEntity.ok("get all courses");
    }

    @GetMapping("/{id}")
    public ResponseEntity getCourseById(@PathVariable String id) {
        return ResponseEntity.ok("get course with id: " + id);
    }
}
