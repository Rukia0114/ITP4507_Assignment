import java.util.Enumeration;

public class FootballTeam extends Team{
    private final int GOALKEEPER_POSITION = 1;
    private final int DEFENDER_POSITION = 2;
    private final int MIDFIEDER_POSITION = 3;
    private final int FORWARD_POSITION = 4;

    //constructor
    public FootballTeam(String teamID){
        super(teamID);
    }

    //override updatePlayerpoistion method
    public void updatePlayerPosition(){
        System.out.print("Position (1 = goal keeper | 2 = defender | 3 = midfielder | 4 = forward):");
    }

    //override displayTeam
    public void displayTeam(){
            System.out.println("Football Team " + getName() + " (" + getTeamID() + ")");
        
            System.out.println("Goal keeper:");
            Enumeration<Player> players = getAllPlayer();
            boolean goalkeeperFound = false;
            while (players.hasMoreElements()) {
                Player player = players.nextElement();
                if (player.getPosition() == GOALKEEPER_POSITION) {
                    System.out.println(player.getPlayerID() + ", " + player.getName());
                    goalkeeperFound = true;
                }
            }
            if (!goalkeeperFound) {
                System.out.println("NIL");
            }
        
            System.out.println("Defender:");
            players = getAllPlayer();
            boolean defenderFound = false;
            while (players.hasMoreElements()) {
                Player player = players.nextElement();
                if (player.getPosition() == DEFENDER_POSITION) {
                    System.out.println(player.getPlayerID() + ", " + player.getName());
                    defenderFound = true;
                }
            }
            if (!defenderFound) {
                System.out.println("NIL");
            }
        
            System.out.println("Midfielder:");
            players = getAllPlayer();
            boolean midfielderFound = false;
            while (players.hasMoreElements()) {
                Player player = players.nextElement();
                if (player.getPosition() == MIDFIEDER_POSITION) {
                    System.out.println(player.getPlayerID() + ", " + player.getName());
                    midfielderFound = true;
                }
            }
            if (!midfielderFound) {
                System.out.println("NIL");
            }
        
            System.out.println("Forward:");
            players = getAllPlayer();
            boolean forwardFound = false;
            while (players.hasMoreElements()) {
                Player player = players.nextElement();
                if (player.getPosition() == FORWARD_POSITION) {
                    System.out.println(player.getPlayerID() + ", " + player.getName());
                    forwardFound = true;
                }
            }
            if (!forwardFound) {
                System.out.println("NIL");
            }
        
    }
}
