import java.util.Vector;

public class CreateVolleyballTeamCommand extends CreateTeamCommand {

    private Team team;
    private String teamID;
    private String teamName;

    public CreateVolleyballTeamCommand(Vector<Team> teams, String teamID,String teamName){
        super(teams, teamID, teamName);
        this.teamID = teamID;
        this.teamName = teamName;
    }


    @Override
    public void execute() {
        try{
            //System.out.println("CreateVolleyballTeamCommand: execute() " );
            team = new VolleyballTeam(teamID);
            team.setName(teamName);
            super.teams.add(team);
            System.out.println("Volleyball team is created. " );
            System.out.println("Current team is changed to " + teamID);

        }catch(NullPointerException e){
            System.out.println("Invalid sport type" );
        }

    }

    @Override
    public void undo() {
        //System.out.println("CreateVolleyballTeamCommand: undo() " );
		teams.remove(team);
        System.out.println("Command (" + this.toString() + ")" + " is undone");
    }
    
    public String toString() {
        return "Create Volleyball team, " + teamID + ", " + teamName;
    }


    @Override
    public void redo() {
        execute();
    }
}
