import java.util.Stack;

public class RedoCommand implements Command {
    private Stack<Command> undoStack;
    private Stack<Command> redoStack;

    public RedoCommand(Stack<Command> undoStack, Stack<Command> redoStack) {
        this.undoStack = undoStack;
        this.redoStack = redoStack;
    }

    @Override
    public void execute() {
        if (!redoStack.isEmpty()) {
            Command command = redoStack.pop();
            command.redo();
            undoStack.push(command);
            System.out.println("Command (" + command.toString() +" )" + "is redone.");
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