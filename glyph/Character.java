// Composite(163): Leaf
// Visitor(331): ConcreteElement

package glyph;

import visitor.GlyphVisitor;
import window.Window;
/**
 * This class implements a glyph character.
 * 
 * @author Digno JR Teogalbo
 * @version CS472 Sp24
 */
public class Character extends Glyph {

    private char character;

    /**
     * Initializes the character glyph.
     * 
     * @param character Character of the glyph.
     */
    public Character(char character) { this.character = character; }

    @Override
    public void draw(Window window) {
        window.drawCharacter(character, bounds.getX(), bounds.getY());
    }

    @Override
    public void setSize(Window window) {
        bounds.setSize(
            window.charWidth(character), window.charHeight(character));
    }

    public char getChar() {
        return character;
    }

    @Override
    public void accept(GlyphVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return "Character: " + character;
    }
}
