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
    }

    public String toString() {
        return "Add player, " + player.getPlayerID() + ", " + player.getName() + ", " + player.getPosition();
    }

    @Override
    public void redo() {
        execute();
    }

}