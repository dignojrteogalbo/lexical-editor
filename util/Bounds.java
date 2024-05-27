package util;

/**
 * This class represents the rectangular bounds of an object. The point of
 * origin is composed of (x, y) coordinates and locates the top left of the
 * object. The size of the bounds is composed by width and height.
 * 
 * @author Digno JR Teogalbo
 * @version CS472 Sp24
 */
public class Bounds {

    private int x;
    private int y;
    private int width;
    private int height;

    /**
     * Create a bounds with the point of origin (x, y) and the provided width
     * and height.
     * 
     * @param x X coordinate of origin.
     * @param y Y coordinate of origin.
     * @param width Bounds width.
     * @param height Bounds height.
     */
    public Bounds(int x, int y, int width, int height) {
        setPoint(x, y);
        setSize(width, height);
    }

    /**
     * Returns the X coordinate
     * 
     * @return X coordinate of the bounds.
     */
    public int getX() { return x; }

    /**
     * Returns the Y coordinate
     * 
     * @return Y coordinate of the bounds.
     */
    public int getY() { return y; }

    /**
     * Sets the point of origin.
     * 
     * @param x New X coordinate.
     * @param y New Y coordinate.
     */
    public void setPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns the width of the bounds.
     * 
     * @return Width of the bounds.
     */
    public int getWidth() { return width; }

    /**
     * Returns the height of the bounds.
     * 
     * @return Height of the bounds.
     */
    public int getHeight() { return height; }

    /**
     * Sets the new width and height of the bounds.
     * 
     * @param width New width of the bounds.
     * @param height New height of the bounds.
     */
    public void setSize(int width, int height) {
        this.width = width;
        this.height = height;
    }

    /**
     * Compares the x and y coordinates provided against the bounds and returns
     * if it intersects.
     * 
     * @param x X coordinate to intersect.
     * @param y Y cooridnate to intersect.
     * @return True if (x, y) exists within the bounds, otherwise false.
     */
    public boolean intersects(int x, int y) {
        int maxWidth = this.x + width;
        int maxHeight = this.y + height;
        if (x < this.x || x > maxWidth) return false;
        if (y < this.y || y > maxHeight) return false;
        return true;
    }

    @Override
    public String toString() {
        String xStr = "X: " + x;
        String yStr = "Y: " + y;
        String wStr = "Width: " + width;
        String hStr = "Height: " + height;
        return "{ " + xStr + "," + yStr + "," + wStr + "," + hStr + " }";
    }
}
