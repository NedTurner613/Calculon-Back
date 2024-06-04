package com.calculon.demo.services;

import com.calculon.demo.models.ArithObject;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ArithService {

    public Optional<ArithObject> process(ArithObject equation){

        String toSolve = equation.getToSolve();
        System.out.println("Solving for " + equation.getToSolve());

        switch (toSolve){
            case "x1":
                break;
            case "x2":
                break;
            case "y":
                equation = solveForY(equation);
                break;
        }

        return Optional.of(equation);
    }

//    private static ArithObject solveForY(ArithObject equation){
////        account for Null values
//        if(equation.getX1() == null){
//            equation.setX1(1.0);
//            System.out.println("X1 value set from null to 1");
//        }
//        if (equation.getX2()==null){
//            equation.setX2(1.0);
//            System.out.println("X2 value set from null to 1");
//        }
//
////        get and simplify the variables into ax1 and ax2
//        Double ax1 = equation.getA()*equation.getX1();
//        System.out.println("ax1 = " + ax1);
//        Double bx2 = equation.getB()*equation.getX2();
//
////        perform relevant operations based on the type of operator
//        switch (equation.getOperator()){
//            case "+":
//                equation.setY(ax1 + bx2);
//                break;
//            case "-":
//                equation.setY(ax1 - bx2);
//                break;
//            case "*":
//                equation.setY(ax1 * bx2);
//                break;
//            case "/":
//                equation.setY(ax1 / bx2);
//                break;
//        }
//
//        return equation;
//    }

    private static ArithObject solveForY(ArithObject equation){
//        account for Null values
        if(equation.getX() == null){
            equation.setX(1.0);
            System.out.println("X value set from null to 1");
        }

//        get and simplify the variables into ax1 and ax2
        Double ax = equation.getA()*equation.getX();
        System.out.println("ax = " + ax);
        Double bx = equation.getB()*equation.getX();
        System.out.println("bx = " + bx);

//        perform relevant operations based on the type of operator
        switch (equation.getOperator()){
            case "+":
                equation.setY(ax + bx);
                break;
            case "-":
                equation.setY(ax - bx);
                break;
            case "*":
                equation.setY(ax * bx);
                break;
            case "/":
                equation.setY(ax / bx);
                break;
        }

        return equation;
    }




//    private static ArithObject solveForX1(ArithObject equation){
//        Double a = equation.getA();
//        Double bx2 = equation.getB()*equation.getX2();
//        Double y = equation.getY();
//
////        perform relevant operations based on the type of operator
//        switch (equation.getOperator()){
//            case "+":
//                equation.setX1((y-bx2)/a);
//                break;
//            case "-":
//                equation.setX1((y+bx2)/a);
//                break;
//            case "*":
//                equation.setX1(y/(a*bx2));
//                break;
//            case "/":
//                equation.setX1(bx2*y/a);
//                break;
//        }
//
//        return equation;
//    }



    private static ArithObject solveForX(ArithObject equation){
        Double a = equation.getA();
        Double b = equation.getB();
        Double y = equation.getY();

//        perform relevant operations based on the type of operator
        switch (equation.getOperator()){
            case "+":
                equation.setX1((y-b)/a);
                break;
            case "-":
                equation.setX1((y+b)/a);
                break;
            case "*":
                equation.setX1(y/(a*b));
                break;
            case "/":
                equation.setX1(b*y/a);
                break;
        }

        return equation;
    }





//    private static ArithObject solveForX2(ArithObject equation){
//        Double ax1 = equation.getA()*equation.getX1();
//        Double b = equation.getB();
//        Double y = equation.getY();
//
////        perform relevant operations based on the type of operator
//        switch (equation.getOperator()){
//            case "+":
//                equation.setX2((y-ax1)/b);
//                break;
//            case "-":
//                equation.setX2((ax1-y)/-b);
//                break;
//            case "*":
//                equation.setX2(y/(ax1*b));
//                break;
//            case "/":
//                equation.setX2(ax1/(b*y));
//                break;
//        }
//        return equation;
//    }
}



// reference of finding all the relevant variables
//    Double a = equation.getA();
//    Double x1 = equation.getX1();
//    Double b = equation.getB();
//    Double x2 = equation.getX2();
//    Double y = equation.getY();
//    String operator = equation.getOperator();