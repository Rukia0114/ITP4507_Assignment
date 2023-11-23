import java.io.IOException;
import java.util.Vector;

public class DisplayAllTeamCommandFactory implements CommandFactory {
    private Vector<Team> teams;

    @Override
    public void setTeam(Vector<Team> teams) {
        this.teams = teams;
    }

    @Override
    public void setCurrentTeam(Team currentTeam) {
    }

    @Override
    public Command create() throws IOException {
        return new DisplayAllTeamCommand(teams);
    }
    
}
