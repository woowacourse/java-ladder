package controller;

import domain.Height;
import domain.Ladder;
import domain.Name;
import domain.Names;
import domain.Prize;
import domain.Prizes;
import domain.RandomScaffoldGenerator;
import domain.ScaffoldGenerator;
import domain.Width;
import java.util.Map;
import java.util.stream.Collectors;
import view.InputView;
import view.OutputView;

public class LadderController {
    private static final String SHOW_NAMES_COMMAND = "all";
    private static final String ERROR_NON_EXIST_USER = "[ERROR] 해당 이름을 가진 사용자가 존재하지 않습니다";
    private static final String BLANK = "";

    private final ScaffoldGenerator scaffoldGenerator = new RandomScaffoldGenerator();

    public void run() {
        final Names names = new Names(InputView.inputNames().stream()
                .map(Name::new)
                .collect(Collectors.toList()));
        final Prizes prizes = new Prizes(InputView.inputPrizes().stream()
                .map(Prize::new)
                .collect(Collectors.toList()), names);
        final Ladder ladder = new Ladder( names.toWidth(), new Height(InputView.inputHeight()), scaffoldGenerator);
        OutputView.printLadderResult(ladder, names, prizes);
        calculateWinResult(ladder, names, prizes);
    }

    private void calculateWinResult(final Ladder ladder, final Names names, final Prizes prizes) {
        Map<String, String> ladderResult = ladder.calculateResult(names, prizes);
        String targetName = BLANK;
        while (!targetName.equals(SHOW_NAMES_COMMAND)) {
            targetName = InputView.inputTargetName();
            checkResultByTargetName(ladderResult, names, targetName);
        }
    }

    private void checkResultByTargetName(final Map<String, String> ladderResult, final Names names, String targetName) {
        if (targetName.equals(SHOW_NAMES_COMMAND)) {
            OutputView.printTotalMatching(ladderResult);
            return;
        }
        validateTargetUserExists(names, targetName);
        OutputView.printSingleMatching(ladderResult.get(targetName));
    }

    private void validateTargetUserExists(final Names names, final String targetName) {
        if (names.isNotExistUser(targetName)) {
            throw new IllegalArgumentException(ERROR_NON_EXIST_USER);
        }
    }
}
