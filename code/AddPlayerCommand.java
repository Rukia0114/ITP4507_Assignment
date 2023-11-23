public class AddPlayerCommand implements Command {
    private String playerID;
    private String playerName;
    private Team currentTeam;  
    private Player player;

    public AddPlayerCommand(Team currentTeam, String playerID, String playerName, int position){
        this.player = new Player(playerID, playerName);
        //this.player.setTeam(currentTeam);
        this.player.setPosition(position);
        this.currentTeam = currentTeam; 
    }

    @Override
    public void execute() {
        currentTeam.addPlayer(player);  
        System.out.println("Player is added.");
    }

    @Override
    public void undo() {
        currentTeam.remove(player); 
        System.out.println("Command (" + this.toString() + " ) is undone");
    }

    public String toString() {
        return "Add player, " + player.getPlayerID() + ", " + player.getName() + ", " + getStrPoistion(player.getPosition());
    }

    @Override
    public void redo() {
        currentTeam.addPlayer(player);  
    }

    public String getStrPoistion(int position){
        if(currentTeam instanceof VolleyballTeam){
            if(position ==1)
                return "attacker";
            else if(position ==2)
                return "defender";
        }

        if(currentTeam instanceof FootballTeam){
            if(position==1)
                return "Goal keeper";
            else if(position==2)
                return "Defender";
            else if (position==3)
                return "Midfielder";
            else if(position==4)
                return "Forward";
        }

        return "Error";
   
    }
}