import java.io.IOException;
import java.util.Stack;
import java.util.Vector;

public class UndoCommandFactory implements CommandFactory {
    private Command command;

    // public UndoCommandFactory(Stack<Memento> undoStack) {
    //     this.undoStack = undoStack;
    // }
    // public UndoCommandFactory(Command command) {
    //     this.command = command;
    // }
    
    @Override
    public void setTeam(Vector<Team> teams) {
     
    }

    @Override
    public void setCurrentTeam(Team currentTeam) {
        // The UndoCommand doesn't need a current team.
    }

    @Override
    public Command create() throws IOException {
        return new UndoCommand(command);
    }


}