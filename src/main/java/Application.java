import controller.LadderGame;

public class Application {

    public static final void main(String[] args) {
        final LadderGame ladderGame = new LadderGame();
        try {
            ladderGame.start();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
