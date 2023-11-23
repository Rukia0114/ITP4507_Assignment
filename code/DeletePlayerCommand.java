public class DeletePlayerCommand implements Command {
    private Team currentTeam;
    private Player player;

    public DeletePlayerCommand(Team currentTeam, Player player) {
        this.currentTeam = currentTeam;
        this.player = player;
    }

    @Override
    public void execute() {
        currentTeam.remove(player);
        System.out.println("Player is deleted.");
    }

    @Override
    public void undo() {
        currentTeam.addPlayer(player);
        System.out.println("Command (" + this.toString() + ")" + " is undone");
    }

    public String toString() {
        return "Delete player, " + player.getPlayerID();
    }

    @Override
    public void redo() {
       execute();
       System.out.println("Command (" + this.toString() + ")" + " is redone");
    }

}
