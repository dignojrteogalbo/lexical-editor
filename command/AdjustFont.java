// Command(233): ConcreteCommand
// Prototype(117): ConcretePrototype

package command;

import glyph.Glyph;
import window.Window;

public class AdjustFont extends Command {
    
    private Window window;
    private Glyph glyph;
    private int size;
    
    public AdjustFont(Window window, Glyph glyph, int size) {
        this.window = window;
        this.glyph = glyph;
        this.size = size;
    }

    @Override
    public void execute() {
        int currentSize = window.getFontSize();
        window.setFontSize(Math.max(2, currentSize + size));
        glyph.getRoot().compose();
    }

    @Override
    public void unexecute() {
        int currentSize = window.getFontSize();
        window.setFontSize(Math.max(2, currentSize - size));
        glyph.getRoot().compose();
    }

    @Override
    public Command clone() {
        return this;
    }
}
