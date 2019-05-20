package ladder;

import ladder.domain.*;
import ladder.view.OutputView;
import ladder.view.InputView;

import java.util.List;

public class Main {
    private static final int NUM_TRIAL_PER_ROW = 2;

    public static void main(String[] args) {
        List<Player> players = InputView.initPlayers();
        List<Reward> rewards = InputView.initRewards(players);

        System.out.println("사다리 결과");
        int height = InputView.initLadderHeight();
        Ladder ladder = Ladder.create(height, players.size());

        // Todo: 몇개 정도 선긋기를 시도하는게 좋을까?
        LadderDrawer.tryDraw(ladder, height * NUM_TRIAL_PER_ROW);

        DrawnLadder drawnLadder = ladder.drawn();
        OutputView.printLadderGameBoard(drawnLadder, players, rewards);

        keepPlayGame(drawnLadder, players, rewards);
    }

    private static void keepPlayGame(DrawnLadder drawnLadder, List<Player> players, List<Reward> rewards) {
        LadderGame game = new LadderGame(drawnLadder, players, rewards);
        while(true) {
            List<Player> inputPlayers = InputView.readPlayerOrAll(players);
            List<Reward> playedRewards = game.play(inputPlayers);

            OutputView.printGameResult(inputPlayers, playedRewards);
        }
    }
}
