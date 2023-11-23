public class PlayerPositionMemento implements Memento {
    private Player player;
    private int oldPosition;

    public PlayerPositionMemento(Player player) {
        this.player = player;
        this.oldPosition = player.getPosition();
    }

    @Override
    public void restore() {
        player.setPosition(oldPosition);
    }
}
