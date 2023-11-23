import java.util.Vector;

public class CreateFootballTeamCommand extends CreateTeamCommand {

    private Team team;
    private String teamID;
    private String teamName;
    

    public CreateFootballTeamCommand(Vector<Team> teams, String teamID, String teamName){
        super(teams, teamID, teamName);
        this.teamID = teamID;
        this.teamName = teamName;
    }


    @Override
    public void execute() {
        
            //System.out.println("CreateFootballTeamCommand: execute() " );
            team = new FootballTeam(teamID);
            team.setName(teamName);
            super.teams.add(team);
            System.out.println("Football team is created. " );
            System.out.println("Current team is changed to " + teamID);
            
       
    }

    @Override
    public void undo() {
        //System.out.println("CreateFootballTeamCommand: undo() " );
		teams.remove(team);
        System.out.println("Command (" + this.toString() + ")" + " is undone");
        //System.out.println("CreateFootballTeamCommand: removed() " );
    }

    public String toString() {
        return "Create football team, " + teamID + ", " + teamName;
    }


    @Override
    public void redo() {
        team = new FootballTeam(teamID);
        team.setName(teamName);
        super.teams.add(team);
        // team = new FootballTeam(teamID);
        // team.setName(teamName);
        // super.teams.add(team);
        //  System.out.println("Command (" + this.toString() + ")" + " is redone");
    }
    
}
