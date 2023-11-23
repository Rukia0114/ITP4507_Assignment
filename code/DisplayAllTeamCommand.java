import java.util.Vector;

public class DisplayAllTeamCommand implements Command {
    private Vector<Team> teams;

    public DisplayAllTeamCommand(Vector<Team> teams) {
        this.teams = teams;
    }

    @Override
    public void execute() {
        for (Team team : teams) {//loop all the team store in vector
            if(team instanceof VolleyballTeam){
                System.out.println("Volleyball Team " + team.getName() +" (" + team.getTeamID() + ")" );
            }
            if(team instanceof FootballTeam){
                System.out.println("FootballTeam Team " + team.getName() +" (" + team.getTeamID() + ")" );
            }
        }
    }

    @Override
    public void undo() {
       
    }

    @Override
    public void redo() {
       
    }
}
