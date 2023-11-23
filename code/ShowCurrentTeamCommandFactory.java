import java.io.IOException;
import java.util.Vector;

public class ShowCurrentTeamCommandFactory implements CommandFactory{
    private Team currentTeam;
    private Vector<Team> teams;

    @Override
    public void setTeam(Vector<Team> teams) {
       this.teams = teams;
    }

    @Override
    public void setCurrentTeam(Team currentTeam) {
      this.currentTeam = currentTeam;
    }

    @Override
    public Command create() throws IOException {
        return new ShowCurrentTeamCommand(currentTeam);
    }
    
}
