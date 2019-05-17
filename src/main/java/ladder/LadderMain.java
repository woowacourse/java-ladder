package ladder;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderMain {
    private static Players players;
    private static Ladder ladder;


    public static void main(String[] args) {

        LadderResult ladderResult = ready();

        play(ladderResult);

    }

    private static LadderResult ready() {
        createPlayers();
        LadderRewards ladderRewards = createRewards();
        LadderResult ladderResult = createLadder(ladderRewards);
        show(ladderRewards);
        return ladderResult;
    }

    private static void createPlayers() {
        try {
            players = new Players(InputView.readName());
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            createPlayers();
        }

    }

    private static LadderRewards createRewards() {
        try {
            return new LadderRewards(InputView.readReward(), players.count());
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return createRewards();
        }
    }

    private static LadderResult createLadder(LadderRewards ladderRewards) {
        try {
            ladder = new Ladder().init(players.count(), InputView.readHeight());
            return new LadderResult(ladderRewards);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return createLadder(ladderRewards);
        }
    }

    private static void play(LadderResult ladderResult) {
        String name = InputView.readPlayer();
        if (name.equals(Player.FINISH_COMMAND)) {
            new OutputView().print(ladderResult.result(ladder, players));
            return;
        }
        try {
            new OutputView().print(ladderResult.result(ladder, players.player(name)));
            play(ladderResult);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            play(ladderResult);
        }
    }

    private static void show(LadderRewards ladderRewards) {
        new OutputView().print(players, ladder, ladderRewards);
    }
}
