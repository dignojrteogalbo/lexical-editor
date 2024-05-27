// Command(233): Command
// Prototype(117): Prototype

package command;

public abstract class Command {

    public boolean isReversible() {
        return true;
    };

    public abstract void execute();
    public abstract void unexecute();
    public abstract Command clone();
}
