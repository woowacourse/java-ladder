package ladder.controller;

import ladder.domain.*;
import ladder.view.OutputView;

public class LadderController {
    public static void main(String[] args) {
        String[] inputPlayers = {"pobi", "denis", "brown", "whale", "kim"};
        Players players = new Players(inputPlayers);
        OutputView.printPlayers(players);

        Ladder ladder = new Ladder(inputPlayers.length, 7);
        OutputView.printLadder(ladder);

        String[] inputRewards = {"100", "200", "300", "꽝", "다꽝"};
        Rewards rewards = new Rewards(inputRewards);
        OutputView.printRewards(rewards);

        LadderGame ladderGame = new LadderGame(ladder);
        LadderGameResult ladderGameResult = ladderGame.play(players, rewards);
        OutputView.printLadderGameResult(ladderGameResult);
    }
}
