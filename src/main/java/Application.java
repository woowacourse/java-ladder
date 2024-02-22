import controller.LadderGame;

public class Application {

    public static void main(String[] args) {
        final LadderGame ladderGame = new LadderGame();
        try {
            ladderGame.start();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
