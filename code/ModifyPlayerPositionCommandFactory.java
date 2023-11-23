import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.Stack;
import java.util.Vector;

public class ModifyPlayerPositionCommandFactory implements CommandFactory {
    private Team currentTeam;
    private Vector<Team> teams;
    //private Stack<Memento> undoStack;
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
            System.out.println("No current team.");
            return null;
        }

        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);

        System.out.print("Please input player ID: ");
        String playerID = br.readLine();
        Player player = findPlayerByID(playerID);

        if (player == null) {
            System.out.println("No Player found.");
            return null;
        }

        currentTeam.updatePlayerPosition();
        int newPosition = Integer.parseInt(br.readLine());

        return new ModifyPlayerPositionCommand(player, newPosition,caretaker,currentTeam);
    }

    public Player findPlayerByID(String playerID) { 
        Enumeration<Player> players = currentTeam.getAllPlayer();
        while (players.hasMoreElements()) {
            Player player = players.nextElement();
            if (player.getPlayerID().equals(playerID)) {  
                return player;
            }
        }
        return null;
    }


}