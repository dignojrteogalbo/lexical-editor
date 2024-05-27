// Composite(163): Client
// AbstractFactory(87): Client
// Command(233): Client

package lexi;

import window.*;
import command.AdjustFont;
import command.AnalyzeWords;
import command.KeyMap;
import command.Redo;
import command.SetFont;
import command.Undo;
import factory.widget.WidgetFactory;
import glyph.*;
import glyph.Character;
import glyph.composition.Column;
import glyph.composition.Composition;
import glyph.composition.Row;
import glyph.composition.embellishment.Border;
import glyph.composition.embellishment.Button;
import glyph.composition.embellishment.Embellishment;
import glyph.composition.embellishment.Label;
import glyph.composition.embellishment.Scroller;

public class Main {

    private static String title = "Aly";

    public static void main(String args[]) {
        WidgetFactory widgetFactory = WidgetFactory.getInstance();
        Window app = new ApplicationWindow(title);

        Glyph document = new Column(app);

        KeyMap commands = new KeyMap();
        commands.put('i', new AdjustFont(app, document, 1));
        commands.put('d', new AdjustFont(app, document, -1));
        commands.put('u', new Undo());
        commands.put('r', new Redo());
        commands.put('w', new AnalyzeWords(document));
        app.setKeyMap(commands);

        Embellishment border = new Border(6, app);
        Embellishment scroller = new Scroller(10, app);
        Composition row1 = new Row("ab", app);
        Composition row2 = new Row("xy", app);
        Composition row3 = new Row(app);
        Composition column = new Column("XZ", app);
        Glyph tallRect = new Rectangle(10, 20);
        Glyph wideRect = new Rectangle(20, 10);
        Label label = widgetFactory.createLabel(app);
        Composition labelText = new Row("pq", app);
        Button button = widgetFactory.createButton(app);
        Composition buttonText = new Row("PQ", app);
        Composition fontRow = new Row(app);
        Button increment = widgetFactory.createButton(app, new AdjustFont(app, document, 1));
        Glyph plus = new Character('+');
        Button decrement = widgetFactory.createButton(app, new AdjustFont(app, document, -1));
        Composition minus = new Row(" - ", app);
        Button setFontTo14 = widgetFactory.createButton(app, new SetFont(app, document, 14));
        Composition textSetFontto14 = new Row("14", app);
        Button setFontTo20 = widgetFactory.createButton(app, new SetFont(app, document, 20));
        Composition textSetFontto20 = new Row("20", app);
        String[] paragraph = {
            "Hello world!",
            "This is some sample text.",
            "Here is some more sample text.",
        };
        Composition longText = new Column(paragraph, app);

        try {
            increment.insert(plus);
            decrement.insert(minus);
            setFontTo14.insert(textSetFontto14);
            setFontTo20.insert(textSetFontto20);
            fontRow.insert(increment);
            fontRow.insert(decrement);
            fontRow.insert(setFontTo14);
            fontRow.insert(setFontTo20);
            label.insert(labelText);
            button.insert(buttonText);
            scroller.insert(document);
            border.insert(scroller);
            row1.insert(tallRect, 1);
            column.insert(label, 1);
            row1.insert(column, 2);
            row2.insert(wideRect, 1);
            row3.insert(button);
            document.insert(row1);
            document.insert(row2);
            document.insert(row3);
            document.insert(fontRow);
            document.insert(longText);
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }

        Glyph root = document.getRoot();
        app.setContents(root);
    }

}
