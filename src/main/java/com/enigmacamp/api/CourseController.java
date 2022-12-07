package com.enigmacamp.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 07/12/2022
 */

@RestController
@RequestMapping("/courses")
public class CourseController {
    @GetMapping
    public ResponseEntity getAllCourse(@RequestHeader(name = "my-header", required = false) String header) {
        System.out.println(header);

        if (header == null) return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("token is null");

        if (header.equals("123")) return ResponseEntity.ok("get all courses");

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("token is invalid");
    }

    @GetMapping("/{id}")
    public ResponseEntity getCourseById(@PathVariable String id, @RequestHeader Map<String, String> headers) {
        for (String headerName : headers.keySet()) {
            System.out.println("Key: " + headerName + " " + headers.get(headerName));
        }
        return ResponseEntity.ok("get course with id: " + id);
    }
}
