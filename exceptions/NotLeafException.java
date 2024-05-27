package exceptions;

/**
 * This class represents the exception thrown when a method is invoked on a
 * Glyph object that is not a leaf.
 * 
 * @author Digno JR Teogalbo
 * @version CS472 Sp24
 */
public class NotLeafException extends Exception {
    public NotLeafException(String errorMessage) {
        super(errorMessage);
    }
}
