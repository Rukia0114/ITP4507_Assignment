import java.io.IOException;
import java.util.Stack;
import java.util.Vector;

public class ShowUndoRedoListCommandFactory implements CommandFactory {
    private Stack<Command> undoStack;
    private Stack<Command> redoStack;
    private Vector<Team> teams;
    private Team currentTeam;

    public ShowUndoRedoListCommandFactory(Stack<Command> undoStack, Stack<Command> redoStack) {
        this.undoStack = undoStack;
        this.redoStack = redoStack;
    }

    @Override
    public void setTeam(Vector<Team> teams) {
        this.teams = teams;
    }

    @Override
    public void setCurrentTeam(Team currentTeam) {
        this.currentTeam = currentTeam;
    }

    @Override
    public Command create() throws IOException {
        return new ShowUndoRedoListCommand(undoStack, redoStack);
    }
}