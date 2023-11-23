import java.io.IOException;
import java.util.Vector;

public interface CommandFactory{
    public void setTeam(Vector<Team> teams);
    public void setCurrentTeam(Team currentTeam);
    public Command create()  throws IOException;
}