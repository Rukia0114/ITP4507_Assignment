import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.Vector;

public class ChangeTeamNameCommandFactory implements CommandFactory {
    private Team currentTeam;
    private Vector<Team> teams;
    private Caretaker caretaker;


    @Override
    public void setTeam(Vector<Team> teams) {
        this.teams = teams;
    }

    @Override
    public void setCurrentTeam(Team currentTeam) {
        this.currentTeam = currentTeam;
    }

    @Override
    public void setCaretaker(Caretaker caretaker) {
        this.caretaker = caretaker;
    }

    @Override
    public Command create() throws IOException {
        if (currentTeam == null) {
            System.out.println("No team existed.");
            return null;
        }

        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);

        System.out.print("Please input new name of the current team: ");
        String newName = br.readLine();

        return new ChangeTeamNameCommand(currentTeam, newName, caretaker);
        
        
    }



}