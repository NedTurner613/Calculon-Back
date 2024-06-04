package com.calculon.demo.services;

import com.calculon.demo.models.SimplePack;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SimpleService {

    public Optional<SimplePack> process(SimplePack pack){
        System.out.println("Input: " +pack.getInput());
        pack.setResult(pack.getInput()+1);
        System.out.println("Result: "+ pack.getResult());
        return Optional.of(pack);
    }
}
