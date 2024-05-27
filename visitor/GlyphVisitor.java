// Visitor(331): Visitor

package visitor;

import glyph.Glyph;
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

public interface GlyphVisitor {
    void visit(Glyph v);

    void visit(Character v);

    void visit(Rectangle v);

    void visit(Composition v);

    void visit(Row v);

    void visit(Column v);

    void visit(Embellishment v);

    void visit(Border v);

    void visit(Scroller v);

    void visit(Button v);

    void visit(Label v);
}