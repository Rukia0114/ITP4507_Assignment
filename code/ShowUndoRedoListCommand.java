import java.util.Stack;

public class ShowUndoRedoListCommand implements Command {
    private Stack<Command> undoStack;
    private Stack<Command> redoStack;

    public ShowUndoRedoListCommand(Stack<Command> undoStack, Stack<Command> redoStack) {
        this.undoStack = undoStack;
        this.redoStack = redoStack;
    }

    @Override
    public void execute() {
        System.out.println("Undo List");
        for (Command command : undoStack) {
            System.out.println(command.toString());
        }
        System.out.println("-- End of undo list --");

        System.out.println("Redo List");
        for (Command command : redoStack) {
            System.out.println(command.toString());
        }
        System.out.println("-- End of redo list --");
    }

    @Override
    public void undo() {
    }

    @Override
    public void redo() {
      
    }
}