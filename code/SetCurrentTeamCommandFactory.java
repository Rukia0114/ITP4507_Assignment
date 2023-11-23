import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

public class SetCurrentTeamCommandFactory implements CommandFactory {
    Vector<Team> teams;
    Team currentTeam;

    @Override
    public void setTeam(Vector<Team> teams) {
        this.teams = teams;
    }

    public void setCurrentTeam(Team currentTeam){
        this.currentTeam = currentTeam;
    }

    @Override
    public Command create() throws IOException {
            InputStreamReader is = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(is);
            System.out.print("Please input team ID: ");
            String teamID = br.readLine();
            SetCurrentTeamCommand command = new SetCurrentTeamCommand(this, teams, teamID);
            return command;
    }
    

    public Team getCurrentTeam() {
        return this.currentTeam;
    }

    @Override
    public void setCaretaker(Caretaker caretaker) {
    
    }
}
