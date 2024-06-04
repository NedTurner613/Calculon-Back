package com.calculon.demo.controllers;

import com.calculon.demo.models.SimplePack;
import com.calculon.demo.services.SimpleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/simple")
@RequiredArgsConstructor
@CrossOrigin(origins = {"http://localhost:4200"})
public class SimpleController {

    private final SimpleService simpleService;

    @PostMapping("/plusone")
    public ResponseEntity<SimplePack> process(@RequestBody SimplePack input){
        Optional<SimplePack> optional = simpleService.process(input);
        if(!optional.isPresent()){
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(optional.get());
    }
}
