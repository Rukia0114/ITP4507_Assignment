import java.io.IOException;
import java.util.Stack;
import java.util.Vector;

public class RedoCommandFactory implements CommandFactory {
    private Stack<Command> redoStack;

    // public RedoCommandFactory(Stack<Command> redoStack) {
    //     this.redoStack = redoStack;
    // }

    @Override
    public void setTeam(Vector<Team> teams) {
        
    }

    @Override
    public void setCurrentTeam(Team currentTeam) {
       
    }

    @Override
    public Command create() throws IOException {
        return new RedoCommand(redoStack);
    }
}