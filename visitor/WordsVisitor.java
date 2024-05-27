// Visitor(331): ConcreteVisitor
// Command(233): Receiver

package visitor;

import glyph.Glyph;

import java.util.Hashtable;
import java.util.Map;
import java.util.Map.Entry;

import glyph.Character;
import glyph.Rectangle;
import glyph.composition.Column;
import glyph.composition.Composition;
import glyph.composition.Row;
import glyph.composition.embellishment.Border;
import glyph.composition.embellishment.Button;
import glyph.composition.embellishment.Embellishment;
import glyph.composition.embellishment.Label;
import glyph.composition.embellishment.Scroller;

public class WordsVisitor implements GlyphVisitor { 

    private StringBuilder word = new StringBuilder();
    private Map<String, Integer> wordCount = new Hashtable<>();

    @Override
    public String toString() {
        resetWord();
        StringBuilder output = new StringBuilder();
        output.append("Total words: " + wordCount.keySet().size());
        for (Entry<String, Integer> record : wordCount.entrySet()) {
            output.append("\n");
            output.append(record.getKey() + ": " + record.getValue());
        }
        return output.toString();
    }

    private void resetWord() {
        if (word.length() == 0) return;
        String key = word.toString();
        wordCount.put(key, wordCount.getOrDefault(key, 0) + 1);
        word.setLength(0);
    }

    @Override
    public void visit(Glyph v) {
        resetWord();
    }

    @Override
    public void visit(Character v) {
        char vChar = v.getChar();
        if (java.lang.Character.isWhitespace(vChar)) {
            resetWord();
            return;
        }
        word.append(v.getChar());
    }

    @Override
    public void visit(Rectangle v) {
        resetWord();
    }

    @Override
    public void visit(Composition v) {
        resetWord();
    }

    @Override
    public void visit(Row v) {
        resetWord();
    }

    @Override
    public void visit(Column v) {
        resetWord();
    }

    @Override
    public void visit(Embellishment v) {
        resetWord();
    }

    @Override
    public void visit(Border v) {
        resetWord();
    }

    @Override
    public void visit(Scroller v) {
        resetWord();
    }

    @Override
    public void visit(Button v) {
        resetWord();
    }

    @Override
    public void visit(Label v) {
        resetWord();
    }
    
}
