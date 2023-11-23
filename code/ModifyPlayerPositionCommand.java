import java.util.Stack;

public class ModifyPlayerPositionCommand implements Command {
    private Player player;
    //private int oldPosition;
    private int newPosition;
    private Caretaker caretaker;
    private Team currentTeam;
    //private Stack<Memento> undoStack;

    public ModifyPlayerPositionCommand(Player player, int newPosition,Caretaker caretaker,Team currentTeam) {
        this.player = player;
       //this.oldPosition = player.getPosition();
        this.newPosition = newPosition;
        this.caretaker = caretaker;
        this.currentTeam = currentTeam;
        //this.undoStack = undoStack;
    }

    @Override
    public void execute() {
        // Memento memento = new PlayerPositionMemento(player);
        // undoStack.push(memento);
        caretaker.savePlayerPosition(player);
        player.setPosition(newPosition);
        System.out.println("Position is updated.");
    }

    @Override
    public void undo() {
        // if (!undoStack.isEmpty()) {
        //     Memento memento = undoStack.pop();
        //     memento.restore();
        //     System.out.println("Position update is undone.");
         //player.setPosition(oldPosition);
         caretaker.undo();
         System.out.println("Command (Modify player’s position " + player.getPlayerID() +", " + getStrPoistion(this.newPosition) + ")" + "is undone");
        }

    @Override
    public void redo() {
        caretaker.redo();
        System.out.println("Command (" + this.toString() + ")" + "is redone");
    }

    public String toString(){
        return "Modify player’s position " + player.getPlayerID() +", " + getStrPoistion(player.getPosition()); 
    }

    public String getStrPoistion(int position){
        if(currentTeam instanceof VolleyballTeam){
            if(position ==1)
                return "attacker";
            else if(position ==2)
                return "defender";
        }

        if(currentTeam instanceof FootballTeam){
            if(position==1)
                return "Goal keeper";
            else if(position==2)
                return "Defender";
            else if (position==3)
                return "Midfielder";
            else if(position==4)
                return "Forward";
        }

        return "Error";
   
    }
}
