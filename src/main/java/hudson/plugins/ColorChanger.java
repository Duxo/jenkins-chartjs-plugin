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

/**
 *
 * @author edda
 */
public class ColorChanger {

    static String codeHex(Color c) {
        String hex = "#";
        hex += codeColorComponent(c.getRed());
        hex += codeColorComponent(c.getGreen());
        hex += codeColorComponent(c.getBlue());
        return hex;
    }

    public static String shiftColorBy(String hex, int r, int g, int b) {
        return shiftColorBy(Color.decode(hex), r, g, b);
    }

    static String shiftColorBy(Color c, int r, int g, int b) {
        int red = shiftColorComponent(c.getRed(), r);
        int green = shiftColorComponent(c.getGreen(), g);
        int blue = shiftColorComponent(c.getBlue(), b);
        return codeHex(new Color(red, green, blue));
    }

    static int shiftColorComponent(int colorComponent, int shiftBy) {
        int newColorComponent = colorComponent + shiftBy;
        if (newColorComponent >= 0) {
            return Math.abs(newColorComponent % 256);
        }
        return Math.abs(256 + (newColorComponent % 256));
    }

    public static String randomColor() {
        Random r = new Random();
        int red = r.nextInt(256);
        int green = r.nextInt(256);
        int blue = r.nextInt(256);
        return codeHex(new Color(red, green, blue));
    }

    public static String randomColor(Random r) {
        int red = r.nextInt(256);
        int green = r.nextInt(256);
        int blue = r.nextInt(256);
        return codeHex(new Color(red, green, blue));
    }

    static String codeColorComponent(int colorComponent) {
        String hex = Integer.toHexString(colorComponent);
        if (hex.length() >= 2) {
            return hex;
        }
        return "0" + hex;
    }
}
