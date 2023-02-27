package domain.game;

public class State {

    private boolean isPlayed;

    public State() {
        this.isPlayed = false;
    }

    public void flipState() {
        this.isPlayed = !isPlayed;
    }

    public boolean isPlayed() {
        return isPlayed;
    }
}
