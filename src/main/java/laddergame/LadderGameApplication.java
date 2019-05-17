package laddergame;

import laddergame.controller.Maker;
import laddergame.domain.*;
import laddergame.domain.rule.RandomCreateRule;
import laddergame.domain.rule.Rule;
import laddergame.util.InputView;
import laddergame.util.OutputView;

public class LadderGameApplication {
    public static void main(String[] args) {
        Tags members = Maker.makeMembers();
        Tags prizes = Maker.makePrizes(members.size());
        int height = InputView.inputHeight();
        Rule rule = new RandomCreateRule();
        Ladder ladder = LadderGenerator.generateLadder(height, members.size(), rule);
        LadderGameResult ladderGameResult = LadderGame.startGame(members, ladder, prizes);

        OutputView.outputLadderGame(members, ladder, prizes);
        String person = InputView.inputWantResult();
        OutputView.outputLadderGameResult(person, ladderGameResult);
    }
}
