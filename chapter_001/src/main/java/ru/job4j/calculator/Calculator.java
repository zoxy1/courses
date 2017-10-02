package ru.job4j.calculator;

/**
 * calculator.
 *
 * @author Andrey Kudryavtsev (zoxy1@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Calculator {
    /**
     * This variable stores the result of operations.
     */
    private double result;

    /**
     * Method add two number.
     *
     * @param first  first number .
     * @param second second number .
     */
    public void add(double first, double second) {
        this.result = first + second;
    }

    /**
     * Method subtract from first second number.
     *
     * @param first  first number .
     * @param second second number .
     */
    public void subtract(double first, double second) {
        this.result = first - second;
    }

    /**
     * Method div first on second number.
     *
     * @param first  first number .
     * @param second second number .
     */
    public void div(double first, double second) {
        this.result = first / second;
    }

    /**
     * Method multiple two number.
     *
     * @param first  first number .
     * @param second second number .
     */
    public void multiple(double first, double second) {
        this.result = first * second;
    }

    /**
     * Method get calculation result.
     *
     * @return result calculation.
     */
    public double getResult() {
        return this.result;
    }
}
