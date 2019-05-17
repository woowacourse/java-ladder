package com.woowacourse.ladder.Controller;

import com.woowacourse.ladder.*;
import com.woowacourse.ladder.view.InputVIew;
import com.woowacourse.ladder.view.OutputView;

public class LadderGame {

    public static void main(String[] args) {
        PlayerList playerList = InputVIew.promptPlayerNames();
        ResultList resultList = InputVIew.promptExecuteResults();
        Height height = InputVIew.promptHeight();

      // Ladder ladder = PartGenerator.generateLadder(playerList.getNames().size(), height.getHeight());

        //OutputView.printLadder(playerList, resultList, ladder);
    }
}
