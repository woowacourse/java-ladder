package ladderGameSolo.controller;

import ladderGameSolo.domain.GameMembers;
import ladderGameSolo.domain.Ladder;
import ladderGameSolo.domain.Member;
import ladderGameSolo.domain.Position;
import ladderGameSolo.view.GameView;
import ladderGameSolo.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {
    private static final int START_POSITION = 0;
    private static final String DELIMITER_COMMA = ",";
    private static final String MESSAGE_ALL = "all";
    private GameView gameView;

    public LadderGame(GameView gameView) {
        this.gameView = gameView;
    }

    public void run() {
        String[] names = InputView.inputName().split(DELIMITER_COMMA);
        String[] inputResult = InputView.inputResult(names.length).split(DELIMITER_COMMA);
        int height = InputView.inputHeight();
        Ladder ladder = getLadders(names.length, height);

        gameView.printLadderInfo(names, inputResult, ladder);

        String targetName = InputView.inputTargetName(names);
        GameMembers gameMembers = new GameMembers(makeMembers(names, targetName, height));
        gameView.printGameResult(inputResult, ladder, gameMembers);
    }

    private static Ladder getLadders(int countOfPeople, int height) {
        return new Ladder(countOfPeople, height);
    }

    private static List<Member> makeMembers(String[] names, String targetName, int height) {
        List<Member> members = new ArrayList<>();

        String[] targetNames = getTargetNames(names, targetName);
        for (int i = 0; i < targetNames.length; i++) {
            members.add(new Member(targetNames[i], new Position(START_POSITION, height), i));
        }

        return members;
    }

    private static String[] getTargetNames(String[] names, String targetName) {
        if (MESSAGE_ALL.equals(targetName)) {
            return names;
        }

        return new String[]{targetName};
    }
}
