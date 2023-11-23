import java.util.Stack;

public class RedoCommand implements Command {
    private Stack<Command> redoStack;

    public RedoCommand(Stack<Command> redoStack) {
        this.redoStack = redoStack;
    }

    @Override
    public void execute() {
        if (!redoStack.isEmpty()) {
            Command commandToRedo = redoStack.pop();
            System.out.println("Command (" + commandToRedo.toString() + ") is redone.");
            commandToRedo.execute();
        } else {
            System.out.println("Nothing to redo.");
        }
    }

    @Override
    public void undo() {
        
    }

    @Override
    public void redo() {
    
    }
}