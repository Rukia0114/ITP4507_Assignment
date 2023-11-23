public class Player {
   // Team team;
    private String playerID;
    private String name;
    private int position;

    //constructor
    public Player(String playerID,String name){
        this.playerID= playerID;
        this.name = name;
    }

    //get player ID method
    public String getPlayerID(){return this.playerID;}

    //get player position method
    public int getPosition(){return this.position;}

    //set player position method 
    public void setPosition(int position){this.position = position;}

     //get player name method
    public String getName(){return this.name;}

    //set player name method 
    public String setName(String name){return this.name = name;}

    // public void setTeam(Team team){
    //     this.team =team;
    // }

    // public Team getTeam(){
    //     return this.team;
    // }


}
