// Bridge(151): RefinedAbstraction
// Command(233): Invoker
// ChainOfCommand(223): Client

package window;

import command.Command;
import command.CommandHistory;
import command.KeyMap;
import glyph.*;

public class ApplicationWindow extends Window {

  private Glyph glyph;
  private KeyMap commands;

  public ApplicationWindow(String title) {
    super(title);
  }

  public void setKeyMap(KeyMap commands) {
    this.commands = commands;
  }

  @Override
  public void draw() {
    if (glyph != null)
      glyph.draw(this);
  }

  @Override
  public void setContents(Glyph glyph) {
    this.glyph = glyph;
    implementor.setContents();
  }

  @Override
  public void key(char c) {
    if (commands == null) return;
    Command command = commands.get(c);
    if (command == null) return;
    CommandHistory history = CommandHistory.getInstance();
    history.execute(command);
    repaint();
  }

  @Override
  public void click(int x, int y) {
    Glyph clicked = glyph.getRoot().find(x, y);
    if (clicked != null) {
      Command command = clicked.click();
      CommandHistory history = CommandHistory.getInstance();
      history.execute(command);
      repaint();
    }
  }

}
