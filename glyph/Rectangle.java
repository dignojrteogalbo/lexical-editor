// Composite(163): Leaf

package glyph;

import window.Window;
/**
 * This class implements a rectangle glyph.
 * 
 * @author Digno JR Teogalbo
 * @version CS472 Sp24
 */
public class Rectangle extends Glyph {

    /**
     * Initializes a rectangle glyph with width and height in pixels.
     * 
     * @param width Width of the rectangle
     * @param height Height of the rectangle
     */
    public Rectangle(int width, int height) { bounds.setSize(width, height); }

    @Override
    public void draw(Window window) {
        window.drawRectangle(bounds.getX(), bounds.getY(),
        bounds.getWidth(), bounds.getHeight());
    }

    @Override
    public void setSize(Window window) {}

    @Override
    public String toString() {
        return "Rectangle";
    }
}
