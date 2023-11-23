import java.util.Enumeration;
import java.util.Vector;

public abstract class Team{
    //init variables
    private String teamID;
    private String name;
    private Vector<Player> players;

    //constructor
    public Team(String teamID){
        this.teamID = teamID;
        this.players = new Vector<Player>();
    }

    //get TeamID method
    public String getTeamID(){return this.teamID;}
    
    //get Name method
    public String getName(){return this.name;}

    //set Name method
    public void setName(String name){this.name = name;}

    //add player method
    public void addPlayer(Player player){players.add(player);}

    //remove player method
    public void remove(Player player){players.remove(player);}

    //getAllPlayer method
    public Enumeration<Player> getAllPlayer() {
        return players.elements();
    }

    //update player position method
    public abstract void updatePlayerPosition();
    //Display information
    public abstract void displayTeam();
}