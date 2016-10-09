package com.example.alex.facebooklayout;

import com.example.alex.unittestobject.Calculator;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;


public class CalculatorTest {
    private Calculator mCalc;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mCalc = Mockito.spy(new Calculator());
    }

    @Test
    public void multiplicationIsCorrect() throws Exception {
        Mockito.when(mCalc.addition(Matchers.anyInt(), Matchers.anyInt())).thenReturn(2);
        //As doubleSum(int a) returns multiplication(sum, a);
        assertEquals(mCalc.doubleSum(3), 4);
    }

    @Test
    public void divisionIsCorrectNoException() throws Exception {
        Mockito.when(mCalc.addition(Matchers.anyInt(), Matchers.anyInt())).thenReturn(4);
        //As average() of 4 elements returns division(aver, 4);
        assertEquals(mCalc.average(2, 2, 2, 2), 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void divisionIsCorrectThrowException() throws Exception {
        mCalc.division(12, 0);
    }
}
