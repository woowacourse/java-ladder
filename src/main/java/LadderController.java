import java.util.List;

public class LadderController {

    public void run() {
        // input
        List<Player> players = makePlayers();
        Ladder ladder = makeLadder();
        printLadder(players, ladder);
    }

    private List<Player> makePlayers() {
        String players =  InputView.receivePlayer();
    }

    private Ladder makeLadder() {
        int height = InputView.receiveHeight();
    }

    private void printLadder(List<Player> players, Ladder ladder) {
    }

}
