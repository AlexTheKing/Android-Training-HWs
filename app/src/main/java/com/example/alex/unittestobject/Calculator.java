package com.example.alex.unittestobject;

/**
 * Created by User on 08.10.2016.
 */

public class Calculator implements ICalculator {
    @Override
    public int addition(int a, int b) {
        return a+b;
    }

    @Override
    public int subtraction(int a, int b) {
        return a-b;
    }

    @Override
    public int multiplication(int a, int b) {
        return a*b;
    }

    @Override
    public int division(int a, int b) throws IllegalArgumentException{
        if(b == 0)throw new IllegalArgumentException("Second argument cannot be zero");
        return a/b;
    }

    @Override
    public int square(int a){
        return multiplication(a, a);
    }

    public int average(int a, int b, int c, int d){
        return division(addition(addition(addition(a, b), c), d), 4);
    }

    public int doubleSum(int a){
        int sum = 0;
        for(int i = 1; i < a; i++){
            sum = addition(sum, i);
        }
        return multiplication(sum, 2);
    }
}
