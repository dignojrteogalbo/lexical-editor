// Command(233): ConcreteCommand

package command;

import glyph.Glyph;
import iterator.Iterator;
import iterator.PreorderIterator;
import visitor.GlyphVisitor;
import visitor.WordsVisitor;

public class AnalyzeWords extends Command {

    private Glyph glyph;

    public AnalyzeWords(Glyph glyph) {
        this.glyph = glyph;
    }

    @Override
    public void execute() {
        GlyphVisitor visitor = new WordsVisitor();
        Iterator<Glyph> preorder = new PreorderIterator<>(glyph.getRoot());
        for (preorder.first(); preorder.hasNext(); preorder.next()) {
            Glyph current = preorder.current();
            current.accept(visitor);
        }
        System.out.println(visitor.toString());
    }

    @Override
    public void unexecute() {}

    @Override
    public Command clone() {
        return this;
    }

    @Override
    public boolean isReversible() {
        return false;
    }
    
}
