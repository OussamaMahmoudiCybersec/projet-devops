package com.oussema.projetdevops.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class MainController {

    @GetMapping("/hello")
    public Map<String, String> sayHello() {
        return Collections.singletonMap("message", "Hello, DevOps!");
    }

    @PostMapping("/echo")
    public ResponseEntity<Object> echo(@RequestBody Object requestBody) {
        return ResponseEntity.ok(requestBody);
    }
}
