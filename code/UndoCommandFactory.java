import java.io.IOException;
import java.util.Stack;
import java.util.Vector;

public class UndoCommandFactory implements CommandFactory {
    private Stack<Command> undoStack;
    private Stack<Command> redoStack;

    public UndoCommandFactory(Stack<Command> undoStack, Stack<Command> redoStack) {
        this.undoStack = undoStack;
        this.redoStack = redoStack;
    }

    @Override
    public void setTeam(Vector<Team> teams) {
        // The UndoCommand doesn't need a list of teams.
    }

    @Override
    public void setCurrentTeam(Team currentTeam) {
        // The UndoCommand doesn't need a current team.
    }

    @Override
    public Command create() throws IOException {
        return new UndoCommand(undoStack, redoStack);
    }

    @Override
    public void setCaretaker(Caretaker caretaker) {
      
    }

  
}