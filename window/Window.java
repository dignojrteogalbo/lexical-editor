// Bridge(151): Abstraction
// Command(233): Receiver
// ChainOfResponsibility(223): Client

package window;

import factory.window.WindowImp;
import command.KeyMap;
import factory.window.WindowFactory;
import glyph.*;

public abstract class Window {

  protected WindowImp implementor;

  public Window(String title) {
    this.implementor = WindowFactory.getInstance().createWindowImp(title, this);
  }

  public void drawCharacter(char c, int x, int y) {
    implementor.drawCharacter(c, x, y);
  }

  public void drawRectangle(int x, int y, int width, int height) {
    implementor.drawRectangle(x, y, width, height);
  }

  public int charWidth(char c) {
    return implementor.charWidth(c);
  }

  public int charHeight(char c) {
    return implementor.charHeight(c);
  }

  public abstract void setContents(Glyph glyph);

  public void addBorder(int x1, int y1, int x2, int y2, int width) {
    implementor.addBorder(x1, y1, x2, y2, width);
  }

  public void addScrollBar(int x, int y, int width, int height) {
    implementor.addScrollBar(x, y, width, height);
  }

  public void drawButton(int x, int y, int width, int height, String color) {
    implementor.drawButton(x, y, width, height, color);
  }

  public void drawLabel(int x, int y, int width, int height, String color) {
    implementor.drawLabel(x, y, width, height, color);
  }

  public int getFontSize() {
    return implementor.getFontSize();
  }

  public void setFontSize(int size) {
    implementor.setFontSize(size);
  }

  public void repaint() {
    implementor.repaint();
  }

  public abstract void draw();

  public abstract void key(char c);

  public abstract void click(int x, int y);

  public abstract void setKeyMap(KeyMap commands);
}
