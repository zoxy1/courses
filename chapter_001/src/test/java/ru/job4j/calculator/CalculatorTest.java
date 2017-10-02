package ru.job4j.calculator;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test Calculator class.
 *
 * @author Andrey Kudryavtsev (zoxy1@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class CalculatorTest {
    /**
     * Test when add one plus one then two.
     */
    @Test
    public void whenAddOnePlusOneThenTwo() {
        Calculator calc = new Calculator();
        calc.add(1D, 1D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }
    /**
     * Test when from two subtruct one then one.
     */
    @Test
    public void whenFromTwoSubtructOneThenOne() {
        Calculator calc = new Calculator();
        calc.subtract(2D, 1D);
        double result = calc.getResult();
        double expected = 1D;
        assertThat(result, is(expected));
    }
    /**
     * Test when ten div on two then two.
     */
    @Test
    public void whenTenDivOnTwoThenTwo() {
        Calculator calc = new Calculator();
        calc.div(10D, 2D);
        double result = calc.getResult();
        double expected = 5D;
        assertThat(result, is(expected));
    }
    /**
     * Test when ten div on zero then infinity.
     */
    @Test()
    public void whenTenDivOnZeroThenInfinity() {
        Calculator calc = new Calculator();
        calc.div(10D, 0D);
        double result = calc.getResult();
        double expected = Double.POSITIVE_INFINITY;
        assertThat(result, is(expected));
    }
    /**
     * Test when multiple on five then fifty.
     */
    @Test
    public void whenTenMultipleOnFiveThenFifty() {
        Calculator calc = new Calculator();
        calc.multiple(10D, 5D);
        double result = calc.getResult();
        double expected = 50D;
        assertThat(result, is(expected));
    }
}

