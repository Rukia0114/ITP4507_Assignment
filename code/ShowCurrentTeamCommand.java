public class ShowCurrentTeamCommand implements Command {

    private Team currentTeam;

    public ShowCurrentTeamCommand(Team currentTeam) {
        this.currentTeam = currentTeam;
    }


    public void execute() {
        if(currentTeam != null) {
            currentTeam.displayTeam();
        } else {
            System.out.println("No current team now.");
        }
    }

    @Override
    public void undo() {
      
    }


    @Override
    public void redo() {
      
    }
    
}
