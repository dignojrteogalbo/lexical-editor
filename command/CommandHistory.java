// Singleton(127): Singleton
// Command(233): Invoker
// Prototype(117): Client

package command;

import java.util.Deque;
import java.util.LinkedList;

public class CommandHistory {

    public enum History {
        undo,
        redo
    }

    private static CommandHistory instance;
    private Deque<Command> undo = new LinkedList<>();
    private Deque<Command> redo = new LinkedList<>();

    private CommandHistory() {}

    public static CommandHistory getInstance() {
        if (instance == null)
            instance = new CommandHistory();
        return instance;
    }

    public void execute(Command command) {
        if (command == null) return;
        command.execute();
        if (!command.isReversible()) return;
        redo.clear(); // not performing undo/redo
        add(command, History.undo);
    }

    public void add(Command command, History history) {
        if (!command.isReversible()) return;
        Command clone = command.clone();
        Deque<Command> added = history == History.undo ? undo : redo;
        added.addFirst(clone);
    }

    public void clear(History history) {
        Deque<Command> cleared = history == History.undo ? undo : redo;
        cleared.clear();
    }

    public Command pop(History history) {
        Deque<Command> popped = history == History.undo ? undo : redo;
        return popped.pollFirst();
    }

    public void redo() {
        Command redo = pop(CommandHistory.History.redo);
        if (redo == null) return;
        redo.execute();
        add(redo, CommandHistory.History.undo);
    }

    public void undo() {
        Command undo = pop(CommandHistory.History.undo);
        if (undo == null) return;
        undo.unexecute();
        add(undo, CommandHistory.History.redo);
    }
}
