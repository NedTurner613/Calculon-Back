package com.calculon.demo.controllers;

import com.calculon.demo.models.ArithObject;
import com.calculon.demo.services.ArithService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/arith")
@RequiredArgsConstructor
@CrossOrigin(origins = {"http://localhost:4200"})
public class ArithController {
    private final ArithService arithService;

    @PostMapping("/process")
    public ResponseEntity<ArithObject> process(@RequestBody ArithObject equation){
        System.out.println("Arithmetic Equation Received");

        System.out.println("Input X Value: " + equation.getX());
        System.out.println("Input Y Value: " + equation.getY());


        Optional<ArithObject> optional = arithService.process(equation);
        if(!optional.isPresent()){
            return ResponseEntity.badRequest().build();
        }
        System.out.println("Y equals " + optional.get().getY());

        return ResponseEntity.ok(optional.get());
    }
}
