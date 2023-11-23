import java.util.Stack;

public class ModifyPlayerPositionCommand implements Command {
    private Player player;
    private int oldPosition;
    private int newPosition;
    //private Stack<Memento> undoStack;

    public ModifyPlayerPositionCommand(Player player, int newPosition) {
        this.player = player;
        this.oldPosition = player.getPosition();
        this.newPosition = newPosition;
        //this.undoStack = undoStack;
    }

    @Override
    public void execute() {
        // Memento memento = new PlayerPositionMemento(player);
        // undoStack.push(memento);
        player.setPosition(newPosition);
        System.out.println("Position is updated.");
    }

    @Override
    public void undo() {
        // if (!undoStack.isEmpty()) {
        //     Memento memento = undoStack.pop();
        //     memento.restore();
        //     System.out.println("Position update is undone.");
         player.setPosition(oldPosition);
         System.out.println("Command (" + this.toString() + ")" + "is undone");
        }

    @Override
    public void redo() {
        execute();
    }

    public String toString(){
        return "Modify player’s position " + player.getPlayerID() +", " + player.getPosition(); 
    }
    }
