package ladderGameSolo.controller;

import ladderGameSolo.domain.*;
import ladderGameSolo.view.GameView;
import ladderGameSolo.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {
    private static final int START_POSITION = 0;
    private static final String DELIMITER_COMMA = ",";
    private static final String MESSAGE_ALL = "all";

    public void run() {
        String[] names = InputView.inputName().split(DELIMITER_COMMA);
        String[] inputResult = InputView.inputResult(names.length).split(DELIMITER_COMMA);
        Height height = new Height(InputView.inputHeight());
        Ladder ladder = getLadders(names.length, height.getHeight());

        GameView.printLadderInfo(names, inputResult, ladder);

        String targetName = InputView.inputTargetName(names);
        List<Member> members = new ArrayList<>(makeMembers(names, targetName, height.getHeight()));
        GameMembers gameMembers = new GameMembers(members);
        GameView.printGameResult(gameMembers, getResult(ladder, gameMembers, inputResult));
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

    private List<String> getResult(Ladder ladder, GameMembers gameMembers, String[] result) {
        List<String> results = new ArrayList<>();

        for (int i = 0; i < gameMembers.getSize(); i++) {
            int resultIndex = gameMembers.getMemberByIndex(i).getResultIndex(ladder);
            results.add(result[resultIndex]);
        }

        return results;
    }
}
