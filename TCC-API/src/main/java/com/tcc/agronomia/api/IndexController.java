package com.tcc.agronomia.api;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class IndexController {


    @GetMapping
    public String get(){
        return "API Agronomia";
    }

    @PostMapping
    public String post(){
        return "API Agronomia";
    }

}
