package ru.job4j.Calculator;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

    public class CalculatorTest {
        @Test
        public void whenAddOnePlusOneThenTwo() {
            Calculator calc = new Calculator();
            calc.add(1D, 1D);
            double result = calc.getResult();
            double expected = 2D;
            assertThat(result, is(expected));
        }

        @Test
        public void whenFromTwoSubtructOneThenOne() {
            Calculator calc = new Calculator();
            calc.subtract(2D, 1D);
            double result = calc.getResult();
            double expected = 1D;
            assertThat(result, is(expected));
        }

        @Test
        public void whenTenDivOnTwoThenTwo() {
            Calculator calc = new Calculator();
            calc.div(10D, 2D);
            double result = calc.getResult();
            double expected = 5D;
            assertThat(result, is(expected));
        }
        @Test()
        public void whenTenDivOnZeroThenInfinity() {
            Calculator calc = new Calculator();
            calc.div(10D, 0D);
            double result = calc.getResult();
            double expected = Double.POSITIVE_INFINITY;
            assertThat(result, is(expected));
        }
        @Test
        public void whenTenMultipleOnFiveThenFifty() {
            Calculator calc = new Calculator();
            calc.multiple(10D, 5D);
            double result = calc.getResult();
            double expected = 50D;
            assertThat(result, is(expected));
        }
    }

