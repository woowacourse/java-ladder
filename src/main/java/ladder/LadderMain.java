package ladder;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderMain {

    public static void main(String[] args) {
        Players players = CreateController.createPlayers();
        LadderRewards ladderRewards = CreateController.createRewards(players.count());
        Height height = CreateController.createHeight();

        Ladder ladder = new Ladder(players.count(), height);
        LadderResult ladderResult = new LadderResult(ladderRewards);

        OutputView.print(players, ladder, ladderRewards);
        play(players, ladder, ladderResult);
    }

    private static void play(Players players, Ladder ladder, LadderResult ladderResult) {
        String name = InputView.readPlayer();
        if (name.equals(Player.FINISH_COMMAND)) {
            OutputView.print(ladderResult.result(ladder, players));
            return;
        }
        try {
            OutputView.print(ladderResult.result(ladder, players.player(name)));
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
        play(players, ladder, ladderResult);
    }
}
