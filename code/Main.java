import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.Vector;

public class Main {
        
        
    public static void main(String[] args) {
        Vector<Team> teams = new Vector<>();
        Team currentTeam = null;
        Caretaker caretaker = new Caretaker();
        Stack<Command> undocommandStack = new Stack<>();
        Stack<Command> redocommandStack = new Stack<>();

        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);

        String[] factoryNames = {
            "CreateTeamFactory", "SetCurrentTeamCommandFactory",
            "AddPlayerCommandFactory","ModifyPlayerPositionCommandFactory","DeletePlayerCommandFactory",
            "ShowCurrentTeamCommandFactory","DisplayAllTeamCommandFactory","ChangeTeamNameCommandFactory",
            "UndoCommandFactory","RedoCommandFactory"};

        CommandFactory[] factories = new CommandFactory[factoryNames.length];

        try {
            for (int i = 0; i < factories.length; i++) {
                factories[i] = (CommandFactory) Class.forName(factoryNames[i]).newInstance();
                factories[i].setTeam(teams);
            }
        
        while (true) {
            showMenu(currentTeam);
            
            String command = br.readLine().trim();
            Command c;

           switch (command) {
            case "c": //create team
                c = factories[0].create();
                c.execute();
                currentTeam = teams.lastElement();
                for (CommandFactory factory : factories) {
                    factory.setCurrentTeam(currentTeam);
                }
                undocommandStack.push(c);
                break;

            case "g": //set current team
                c = factories[1].create();
                c.execute();
                currentTeam = ((SetCurrentTeamCommandFactory)factories[1]).getCurrentTeam();
                for (CommandFactory factory : factories) {
                    factory.setCurrentTeam(currentTeam);
                }
                undocommandStack.push(c);
                break;

            case "a": //add player
                c = factories[2].create();
                c.execute();
                undocommandStack.push(c);
                break;

            case "m": //modify player’s position
                c = factories[3].create();
                c.execute();
                undocommandStack.push(c);
                break;

            case "d": //delete player
                c = factories[4].create();
                c.execute();
                undocommandStack.push(c);
                break;

            case "s": //show team
                c = factories[5].create();
                c.execute();
                break;

            case "p": //display all teams
                c = factories[6].create();
                c.execute();
                break;

            case "t": //change team’s name
                c = factories[7].create();
                c.execute();
                undocommandStack.push(c);
                break;

            case "u": //undo
                if (!undocommandStack.isEmpty()) {
                    Command undoCommand = undocommandStack.pop();
                    undoCommand.undo();
                    // undoCommand.toString();
                    // c = factories[8].create();
                    // c.execute();
                    redocommandStack.push(undoCommand);
                }else{
                    System.out.println("Undo stack is empty");
                }
                break;
                // if (!undocommandStack.isEmpty()) {
                //     Command undoCommand = undocommandStack.pop();
                //     undoCommand.undo();
                //     UndoCommand undo = (UndoCommand) factories[8].create();
                //     undo.setCommand(undoCommand);
                //     undo.execute();
                //     redocommandStack.push(undoCommand);
                // } else {
                //     System.out.println("Undo stack is empty");
                // }
                // break;
    
            case "r": //redo
                if (!redocommandStack.isEmpty()) {
                    Command redoCommand = redocommandStack.pop();
                    redoCommand.execute();
                    //redoCommand.toString();
                    undocommandStack.push(redoCommand);
                }else{
                    System.out.println("Undo stack is empty");
                }
                break;

            case "l": //list undo + redo list
                //c = new ShowUndoRedoListCommand(undocommandStack,redocommandStack)
                c = new ShowUndoRedoListCommandFactory(undocommandStack,redocommandStack).create();
                c.execute();
                break;

            case "x": //exit system
                System.exit(0);
                break;

            default:
                System.out.println("Invalid command");
                break;

            }

        }
        
        
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void showMenu(Team currentTeam){
        System.out.println("Sport Teams Management System (STMS)");
        System.out.println("c = create team, g = set current team, a = add player, m = modify player’s position, d = delete player, s = show team, p = display all teams, t = change team’s name, u = undo, r = redo, l = list undo/redo, x = exit system");
        if(currentTeam != null){
             System.out.println("The current team is " +  currentTeam.getTeamID() + " " + currentTeam.getName()  );
        }

        System.out.print("Please enter command [ c | g | a | m | d | s | p | t | u | r | l | x ] : ");

    }
}
