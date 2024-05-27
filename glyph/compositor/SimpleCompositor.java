// Strategy(315): ConcreteStrategy

package glyph.compositor;

import glyph.CompositeGlyph;
import glyph.Glyph;
import iterator.Iterator;
import util.Bounds;
import window.Window;
/**
 * This class implements the SimpleCompositor strategy.
 * 
 * @author Digno JR Teogalbo
 * @version CS472 Sp24
 */
public class SimpleCompositor extends Compositor {

    /**
     * Composing strategy to compose elements based on the cursor.
     * 
     * @param window Window for the compositor.
     */
    public SimpleCompositor(Window window) {
        super(window);
    }

    @Override
    public void compose() {
        if (composition == null) return;
        Bounds cursor = composition.createCursor();
        Iterator<Glyph> iterator = composition.createIterator();
        // iterator.first();
        // while (iterator.hasNext()) {
        //     iterator.next();
        //     Glyph child = iterator.current();
        //     child.setSize(window);
        //     Bounds childBounds = child.getBounds();
        //     childBounds.setPoint(cursor.getX(), cursor.getY());
        //     child.compose();
        //     composition.adjust(child, cursor);
        // }
        for (iterator.first(); iterator.hasNext(); iterator.next()) {
            Glyph child = iterator.current();
            child.setSize(window);
            Bounds childBounds = child.getBounds();
            childBounds.setPoint(cursor.getX(), cursor.getY());
            child.compose();
            composition.adjust(child, cursor);
        }
        CompositeGlyph parent = composition.getParent();
        if (parent != null) {
            Bounds parentBounds = composition.getBounds();
            parentBounds = parent.getBounds();
            parentBounds.setSize(cursor.getWidth(), cursor.getHeight());
        }
    }
}
