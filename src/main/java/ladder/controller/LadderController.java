package ladder.controller;

import ladder.domain.Ladder;
import ladder.domain.Players;
import ladder.domain.Rewards;
import ladder.view.OutputView;

public class LadderController {
    public static void main(String[] args) {
        String[] inputPlayers = {"pobi", "denis", "brown", "whale", "kim"};
        Players players = new Players(inputPlayers);
        OutputView.printPlayers(players);

        Ladder ladder = new Ladder(5, 7);
        OutputView.printLadder(ladder);

        String[] inputRewards = {"100", "200", "300", "꽝", "다꽝"};
        Rewards rewards = new Rewards(inputRewards);
        OutputView.printRewards(rewards);
    }
}
