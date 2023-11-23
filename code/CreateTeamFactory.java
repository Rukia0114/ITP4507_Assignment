import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

public class CreateTeamFactory implements CommandFactory {
    // private String teamID;
    // private String name;
    // private Vector<Player> players;
    private Vector<Team> teams;
    //private String[] teamType = {"CreateVolleyballTeamCommand", "CreateFootballTeamCommand"};


    @Override
    public void setTeam(Vector<Team> teams) {
        this.teams = teams;
       
    }

    public void setCurrentTeam(Team currentTeam){
        
    }

    @Override
    public Command create() throws IOException {
        try{
            InputStreamReader is = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(is);
            System.out.print("Enter sport type (v = volleyball | f = football): ");
            String sportType = br.readLine();
            System.out.print("Team ID: ");
            String teamID = br.readLine();
            System.out.print("Team Name: ");
            String teamName = br.readLine();
            
            if(sportType.equals("v")){
                return new CreateVolleyballTeamCommand(teams,teamID,teamName);
            }
            if(sportType.equals("f")){
                return new CreateFootballTeamCommand(teams,teamID,teamName);
            }
        }
        catch(NullPointerException e){
            System.out.println("Invalid sport type" );
        }
          
        return null;
       
    }


    
}
