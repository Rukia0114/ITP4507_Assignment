import java.util.Vector;

public abstract class CreateTeamCommand implements Command {
    protected Team team;
    protected Vector<Team> teams;
    protected String teamID;
    protected String teamName;

    public CreateTeamCommand(Vector<Team> teams, String teamID, String teamName){
        this.teams = teams;
        this.teamID = teamID;
        this.teamName = teamName;
    }

    public abstract void execute();
    public abstract void undo();
    public abstract void redo();
}
