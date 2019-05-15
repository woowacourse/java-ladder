package laddergame;

import laddergame.domain.Ladder;
import laddergame.domain.LadderHeight;
import laddergame.domain.PlayerMaker;
import laddergame.domain.Players;
import laddergame.view.InputView;

public class Main {
    public static void main(String[] args) {
        PlayerMaker playerMaker = new PlayerMaker(InputView.showMessageOfNames());
        LadderHeight ladderHeight = new LadderHeight(InputView.showMessageOfHeight());
        Players players = new Players(playerMaker.makePlayers());
        Ladder ladder = new Ladder(players.getTotalPlayers(), ladderHeight.getLadderHeight());
        OutputView.showResult(players, ladder.makeLadder());
    }


}
