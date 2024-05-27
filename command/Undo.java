// Command(233): ConcreteCommand
// Prototype(117): ConcretePrototype

package command;

public class Undo extends Command {

    @Override
    public void execute() {
        CommandHistory history = CommandHistory.getInstance();
        history.undo();
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
