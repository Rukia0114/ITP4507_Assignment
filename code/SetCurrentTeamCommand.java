import java.util.Vector;

public class SetCurrentTeamCommand implements Command {
    private Vector<Team> teams;
    private String teamID;
    private Team previousTeam;
    private SetCurrentTeamCommandFactory factory;


    public SetCurrentTeamCommand(SetCurrentTeamCommandFactory factory, Vector<Team> teams, String teamID) {
        this.factory = factory;
        this.teams = teams;
        this.teamID = teamID;
    }

    @Override
    public void execute() {
        previousTeam = factory.getCurrentTeam();
        for (Team team : teams) {
            if (team.getTeamID().equals(teamID)) {
                factory.setCurrentTeam(team);
                System.out.println("Current team is changed to " + teamID);
                return;
            }
        }
        System.out.println("No team found with ID " + teamID);
    }

    public String toString(){
        return "The current is changed to" + teamID + " ";
    }

    @Override
    public void undo() {
        //System.out.println("Command (" + this.toString() + ")" + " re undone");
        factory.setCurrentTeam(previousTeam);
    }

    @Override
    public void redo() {
        System.out.println("Command (" + this.toString() + ")" + " is redone");
        execute();
        
    }
}