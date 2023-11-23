import java.util.Stack;

public class ChangeTeamNameCommand implements Command {
    private Team team;
    private String oldName;
    private String newName;
    
    //private Stack<Memento> undoStack;


    public ChangeTeamNameCommand(Team team, String newName) {
        this.team = team;
        this.oldName = team.getName();
        this.newName = newName;
        //this.undoStack = undoStack;
    }

    @Override
    public void execute() {
        //Memento memento = new TeamNameMemento(team);
        //undoStack.push(memento);

        team.setName(newName);
        System.out.println("Team’s name is updated.");
    }
    @Override
    public void undo() {
        team.setName(oldName);
        //System.out.println("Team’s name update undo.");
        System.out.println("Command (" + this.toString() + ")" + " is undone");
        
    }

    public String toString() {
        return "Change team’s name " + team.getTeamID() + ", " + team.getName() ;
    }

    @Override
    public void redo() {
        execute();
        System.out.println("Command (" + this.toString() + ")" + " is redone");
    }
}