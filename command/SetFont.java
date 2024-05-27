// Command(233): ConcreteCommand
// Prototype(117): ConcretePrototype

package command;

import glyph.Glyph;
import window.Window;

public class SetFont extends Command {

    private Window window;
    private Glyph glyph;
    private int undo;
    private int size;

    public SetFont(Window window, Glyph glyph, int size) {
        this.window = window;
        this.glyph = glyph;
        this.size = size;
    }

    protected SetFont(Window window, Glyph glyph, int size, int undo) {
        this.window = window;
        this.glyph = glyph;
        this.size = size;
        this.undo = undo;
    }

    @Override
    public void execute() {
        undo = window.getFontSize();
        window.setFontSize(Math.max(2, size));
        glyph.getRoot().compose();
    }

    @Override
    public void unexecute() {
        window.setFontSize(undo);
        glyph.getRoot().compose();
    }

    @Override
    public Command clone() {
        return new SetFont(window, glyph, size, undo);
    }
}
