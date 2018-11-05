/*
 * The MIT License
 *
 * Copyright 2018 edda.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package hudson.plugins;

import java.awt.Color;
import java.util.Random;
import static junit.framework.TestCase.assertEquals;
import org.junit.Test;

/**
 *
 * @author edda
 */
public class ColorChangerTest {

    @Test
    public void codeHex() {
        assertEquals("#000000", ColorChanger.codeHex(new Color(0, 0, 0)));
        assertEquals("#ffffff", ColorChanger.codeHex(new Color(255, 255, 255)));
        assertEquals("#ff0101", ColorChanger.codeHex(new Color(255, 1, 1)));
    }

    @Test
    public void shiftColorComponent() {
        assertEquals(0, ColorChanger.shiftColorComponent(255, 1));
        assertEquals(30, ColorChanger.shiftColorComponent(30, 256));
        assertEquals(255, ColorChanger.shiftColorComponent(0, -1));
    }

    @Test
    public void randomColor() {
        assertEquals("#bbd43d", ColorChanger.randomColor(new Random(0)));
    }
}
