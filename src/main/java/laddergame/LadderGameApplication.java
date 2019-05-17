package laddergame;

import laddergame.controller.Maker;
import laddergame.domain.*;
import laddergame.util.InputView;
import laddergame.util.OutputView;

public class LadderGameApplication {
    public static void main(String[] args) {
        Tags members = Maker.makeMembers();
        Tags prizes = Maker.makePrizes(members.size());
        int height = InputView.inputHeight();
        Rule rule = new RandomCreate();
        Ladder ladder = LadderGenerator.generateLadder(height, members.size(), rule);
        LadderGameResult ladderGameResult = LadderGame.startGame(members, ladder, prizes);

        OutputView.outputLadderGame(members, ladder, prizes);
        String person = InputView.inputWantResult();
        OutputView.outputLadderGameResult(person, ladderGameResult);
    }
}
