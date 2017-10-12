package ru.job4j.strategy;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by Zoxy1 on 12.10.17.
 */
public class PaintTest {
    protected final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(output));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

    @Test
    public void whenOutputSquareThenPaintSquare() {
        Paint paintConsole = new Paint();
        paintConsole.draw(new Square());
        StringBuilder expected = new StringBuilder();
        expected.append("**********\n");
        expected.append("*        *\n");
        expected.append("*        *\n");
        expected.append("*        *\n");
        expected.append("**********\r\n");
        assertThat(output.toString(), is(expected.toString()));
    }

    @Test
    public void whenOutputTriangleThenPaintTriangle() {
        Paint paintConsole = new Paint();
        paintConsole.draw(new Triangle());
        StringBuilder expected = new StringBuilder();
        expected.append("     *    \n");
        expected.append("    * *   \n");
        expected.append("   *   *  \n");
        expected.append("  *     * \n");
        expected.append(" *       *\n");
        expected.append("***********\r\n");
        assertThat(output.toString(), is(expected.toString()));
    }
}
