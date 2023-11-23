import java.util.Enumeration;

public class VolleyballTeam extends Team{
    private final int ATTACKER_POSITION = 1;
    private final int DEFENDER = 2;

    //constructor
    public VolleyballTeam(String teamID){
        super(teamID); // super class
    }
    
    //override updateplayerposition
    public void updatePlayerPosition(){
        System.out.print("Position (1 = attacker | 2 = defender):");
    }

    //override displayTeam
    public void displayTeam(){
        System.out.println("Volleyball Team " + getName() + " (" + getTeamID() + ")");
       
        System.out.println("Attacker:");
        Enumeration <Player> players = getAllPlayer();
        boolean attackerfound = false;
        while (players.hasMoreElements()) {
            Player player = players.nextElement();
            if (player.getPosition() == ATTACKER_POSITION) {
                System.out.println(player.getPlayerID() + ", " + player.getName());
                attackerfound = true;
            }
        }
        
        if (!attackerfound) {
            System.out.println("NIL");
        }

        System.out.println("Defender:");
        players = getAllPlayer();
        boolean defenderFound = false;
        while (players.hasMoreElements()) {
            Player player = players.nextElement();
            if (player.getPosition() == DEFENDER) {
                System.out.println(player.getPlayerID() + ", " + player.getName());
                defenderFound = true;
            }
        }
        if (!defenderFound) {
            System.out.println("NIL");
        }
    }
    
}
