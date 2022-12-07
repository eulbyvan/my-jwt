//package com.enigmacamp.api.controller;
//
//import com.enigmacamp.util.JwtUtil;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * @author stu (https://www.eulbyvan.com/)
// * @version 1.0
// * @since 07/12/2022
// */
//
//@RestController
//@RequestMapping("/token")
//public class TokenController {
//    @Autowired
//    JwtUtil jwtUtil;
//
//    @GetMapping
//    public ResponseEntity getToken() {
//        return ResponseEntity.ok(jwtUtil.generateToken("stupid"));
//    }
//}
