package domain.game;

public class State {

    private GameState state;

    private State() {
    }

    public static State prepared() {
        State state = new State();
        state.set(GameState.PREPARED);
        return state;
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
