import java.util.Stack;

public class UndoCommand implements Command {
    // private Stack<Memento> undoStack;
    private Command command;

    public UndoCommand(Command command) {
        this.command = command;
    }
    public void setCommand(Command command) {
        this.command = command;
    }

    @Override
    public void execute() {
        // if (!undoStack.isEmpty()) {
        //     Memento memento = undoStack.pop();
        //     memento.restore();
        // } else {
        //     System.out.println("Nothing to undo.");
        // }

        System.out.println("Command (" + command.toString() +" )" + "is undone.");
    }

    @Override
    public void undo() {
       
    }

    @Override
    public void redo() {
    
    }
}