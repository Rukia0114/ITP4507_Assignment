public class TeamNameMemento implements Memento {
    private Team team;
    private String oldName;

    public TeamNameMemento(Team team) {
        this.team = team;
        this.oldName = team.getName();

        
    }

    @Override
    public void restore() {
        team.setName(oldName);
    }
}