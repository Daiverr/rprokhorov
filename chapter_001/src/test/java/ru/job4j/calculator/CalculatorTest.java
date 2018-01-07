package ru.job4j.calculator;

import org.junit.Test;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;



public class CalculatorTest {
    @Test
    public void whenAddOnePlusTwoThenThree() {
        Calculator calculator = new Calculator();
        calculator.add(1D, 2D);
        double result = calculator.getResult();
        double expected  = 3D;
        assertThat(result, is(expected));
    }
    @Test
    public void whenTwoSubtractOneThenOne() {
        Calculator calculator = new Calculator();
        calculator.subtract(2D, 1D);
        double result = calculator.getResult();
        double expected  = 1D;
        assertThat(result, is(expected));
    }
    @Test
    public void whenFourDivTwoThenTwo() {
        Calculator calculator = new Calculator();
        calculator.div(4D, 2D);
        double result = calculator.getResult();
        double expected  = 2D;
        assertThat(result, is(expected));
    }
    @Test
    public void whenAddOneMultipleTwoThenTwo() {
        Calculator calculator = new Calculator();
        calculator.multiple(1D, 2D);
        double result = calculator.getResult();
        double expected  = 2D;
        assertThat(result, is(expected));
    }

}
