package ru.job4j.strategy;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by Zoxy1 on 12.10.17.
 */
public class PaintTest {

    @Test
    public void whenOutputSquareThenPaintSquare() {
        Output outputConsole = new ConsoleOutput(System.out);
        Paint paintConsole = new Paint(outputConsole);
        paintConsole.draw(new Square());

        MockOutput mockOutput = new MockOutput();
        Paint mockPaint = new Paint(mockOutput);
        mockPaint.draw(new Square());
        StringBuilder expected = new StringBuilder();
        expected.append("**********\n");
        expected.append("*        *\n");
        expected.append("*        *\n");
        expected.append("*        *\n");
        expected.append("**********\n");
        assertThat(mockOutput.getOut(), is(expected.toString()));
    }

    @Test
    public void whenOutputTriangleThenPaintTriangle() {
        Output outputConsole = new ConsoleOutput(System.out);
        Paint paintConsole = new Paint(outputConsole);
        paintConsole.draw(new Triangle());

        MockOutput output = new MockOutput();
        Paint paint = new Paint(output);
        paint.draw(new Triangle());
        StringBuilder expected = new StringBuilder();
        expected.append("     *    \n");
        expected.append("    * *   \n");
        expected.append("   *   *  \n");
        expected.append("  *     * \n");
        expected.append(" *       *\n");
        expected.append("***********\n");
        assertThat(output.getOut(), is(expected.toString()));
    }
}
