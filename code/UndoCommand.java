import java.util.Stack;

public class UndoCommand implements Command {
    private Stack<Command> undoStack;
    private Stack<Command> redoStack;

    public UndoCommand(Stack<Command> undoStack, Stack<Command> redoStack) {
        this.undoStack = undoStack;
        this.redoStack = redoStack;
    }

    @Override
    public void execute() {
        if (!undoStack.isEmpty()) {
            Command command = undoStack.pop();
            command.undo();
            redoStack.push(command);
            //System.out.println("Command (" + command.toString() +" )" + "is undone.");
        } else {
            System.out.println("Nothing to undo.");
        }
    }

    @Override
    public void undo() {
        
    }

    @Override
    public void redo() {
       
    }

}