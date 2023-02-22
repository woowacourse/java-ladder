package domain.game;

public class State {

    private GameState state;

    private State(final GameState state) {
        this.state = state;
    }

    public static State processing() {
        return new State(GameState.PROCEEDING);
    }

    public GameState get() {
        return state;
    }

    public void set(final GameState status) {
        this.state = status;
    }

    public boolean isEnd() {
        return this.state == GameState.END;
    }
}
