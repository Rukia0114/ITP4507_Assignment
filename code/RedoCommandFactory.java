import java.io.IOException;
import java.util.Stack;
import java.util.Vector;

public class RedoCommandFactory implements CommandFactory {
    private Stack<Command> undoStack;
    private Stack<Command> redoStack;

    public RedoCommandFactory(Stack<Command> undoStack, Stack<Command> redoStack) {
        this.undoStack = undoStack;
        this.redoStack = redoStack;
    }

    @Override
    public void setTeam(Vector<Team> teams) {
        // The RedoCommand doesn't need a list of teams.
    }

    @Override
    public void setCurrentTeam(Team currentTeam) {
        // The RedoCommand doesn't need a current team.
    }

    @Override
    public Command create() throws IOException {
        return new RedoCommand(undoStack, redoStack);
    }

    @Override
    public void setCaretaker(Caretaker caretaker) {
        // The RedoCommand doesn't need a caretaker.
    }

}