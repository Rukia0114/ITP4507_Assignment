import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;
import java.util.Enumeration;

public class DeletePlayerCommandFactory implements CommandFactory {
    private Team currentTeam;

    @Override
    public void setTeam(Vector<Team> teams) {
        // This factory doesn't need the list of all teams
    }

    @Override
    public void setCurrentTeam(Team currentTeam) {
        this.currentTeam = currentTeam;
    }

    @Override
    public Command create() throws IOException {
        if (currentTeam == null) {
            System.out.println("No current team selected.");
            return null;
        }

        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);

        System.out.print("Please input player ID: ");
        String playerID = br.readLine();
        Player player = findPlayerByID(playerID);

        if (player == null) {
            System.out.println("Player not found.");
            return null;
        }

        return new DeletePlayerCommand(currentTeam, player);
    }

    private Player findPlayerByID(String playerID) {
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
