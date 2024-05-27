package exceptions;

/**
 * This class represents the exception thrown when a method is invoked on a
 * Glyph object that cannot hold children.
 * 
 * @author Digno JR Teogalbo
 * @version CS472 Sp24
 */
public class NoChildException extends Exception {
    public NoChildException(String errorMessage) {
        super(errorMessage);
    }
}
