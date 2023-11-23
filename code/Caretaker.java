import java.util.Stack;
import java.util.Vector;

public class Caretaker {
    private Vector<Memento> undoList;
    private Vector<Memento> redoList;

    public Caretaker(){
        undoList = new Vector <Memento>();
        redoList = new Vector <Memento>();
    }

    public void saveTeamName(Team team){
        Memento m = new TeamNameMemento(team);
        undoList.add(m);
        redoList.clear();
    }

    public void savePlayerPosition(Player player){
        Memento m = new PlayerPositionMemento(player);
        undoList.add(m);
        redoList.clear();
    }

    public void undo(){
        if(undoList.size()>0){
            Memento m = undoList.lastElement();
            m.restore();
            undoList.removeElement(m);
            redoList.add(m); 
        }
    }

    public void redo(){
        if(redoList.size()>0){
            Memento m = redoList.lastElement();
            m.restore();
            redoList.removeElement(m);
            undoList.add(m);  
        }
    }

    // private Stack<Memento> commandStack = new Stack<>();
    // private Stack<Memento> undoStack = new Stack<>();

    // public void addMemento(Memento m) {
    //     commandStack.push(m);
    //     undoStack.clear();
    // }

    // public Memento getMemento() {
    //     Memento m = commandStack.pop();
    //     undoStack.push(m);
    //     return m;
    // }

    // public Memento undo() {
    //     if (!commandStack.isEmpty()) {
    //         Memento m = commandStack.pop();
    //         undoStack.push(m);
    //         return m;
    //     }
    //     return null;
    // }

    // public Memento redo() {
    //     if (!undoStack.isEmpty()) {
    //         Memento m = undoStack.pop();
    //         commandStack.push(m);
    //         return m;
    //     }
    //     return null;
    // }
}