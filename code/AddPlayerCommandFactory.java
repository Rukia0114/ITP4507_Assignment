import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

public class AddPlayerCommandFactory implements CommandFactory{
    private Vector<Team> teams;
    private Team currentTeam;

    @Override
    public void setTeam(Vector<Team> teams) {
        this.teams = teams;
    }

    public void setCurrentTeam(Team currentTeam) {
        this.currentTeam = currentTeam;
    }

    @Override
    public Command create() throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
    
        if(currentTeam == null){
            System.out.println("No current team selected");
            return null;
        }
    
        System.out.print("Please input player information (id, name): ");
        String[] playerInfo = br.readLine().split(",");
        String playerID = playerInfo[0].trim();
        String playerName = playerInfo[1].trim();
        currentTeam.updatePlayerPosition();
        int position = Integer.parseInt(br.readLine().trim());
    
        return new AddPlayerCommand(currentTeam,playerID,playerName,position);
    }
    
}
