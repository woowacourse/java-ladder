package ladder;

import ladder.domain.Ladder;
import ladder.domain.LadderResult;
import ladder.domain.LadderRewards;
import ladder.domain.Players;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderMain {
    private static InputView inputView;
    private static OutputView outputView;
    private static Players players;
    private static Ladder ladder;
    private static LadderRewards ladderRewards;
    private static LadderResult ladderResult;


    public static void main(String[] args) {

        ready();

        play();

    }

    private static void play() {
        String name = inputView.readPlayer();
        if (name.equals("all")) {
            outputView.print(ladderResult.result(ladder, players));
            return;
        }
        try {
            outputView.print(ladderResult.result(ladder, players.player(name)));
            play();
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            play();
        }
    }

    private static void ready() {
        inputView = new InputView();
        outputView = new OutputView();

        createPlayers();
        createRewards();
        createLadder();

        show();
    }

    private static void show() {
        outputView.print(players, ladder, ladderRewards);
    }

    private static void createLadder() {
        try {
            ladder = new Ladder(players.count(), inputView.readHeight());
            ladder.make();
            ladderResult = new LadderResult(ladderRewards);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            createLadder();
        }
    }

    private static void createRewards() {
        try {
            ladderRewards = new LadderRewards(inputView.readReward(), players.count());
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            createRewards();
        }
    }

    private static void createPlayers() {
        try {
            players = new Players(inputView.readName());
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            createPlayers();
        }

    }
}
