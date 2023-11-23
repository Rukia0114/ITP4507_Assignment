import java.util.Stack;

public class ChangeTeamNameCommand implements Command {
    private Team team;
    private String oldName;
    private String newName;
    private Caretaker caretaker;
    
    //private Stack<Memento> undoStack;


    public ChangeTeamNameCommand(Team team, String newName, Caretaker caretaker) {
        this.team = team;
        this.oldName = team.getName();
        this.newName = newName;
        this.caretaker = caretaker;
        //this.undoStack = undoStack;
    }

    @Override
    public void execute() {
        //Memento memento = new TeamNameMemento(team);
        //undoStack.push(memento);
        caretaker.saveTeamName(team);
        team.setName(newName);
        System.out.println("Team’s name is updated.");
    }
    @Override
    public void undo() {
        
        caretaker.undo();  // Restore state
        System.out.println("Command (Change team’s name " + team.getTeamID() + ", " + this.newName + ")" + " is undone");
        //System.out.println("Team’s name update undo.");
        
        
    }

    public String toString() {
        return "Change team’s name " + team.getTeamID() + ", " + team.getName() ;
    }

    @Override
    public void redo() {
        caretaker.redo(); 
        System.out.println("Command (" + this.toString() + ")" + " is redone");
    }
}