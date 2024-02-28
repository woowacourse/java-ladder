package controller;

import domain.Ladder;
import domain.LadderGame;
import domain.Participants;
import domain.Prizes;
import java.util.List;
import utils.RandomStepGenerator;
import view.InputView;
import view.OutputView;

public class LadderGameController {

    public static final String EXIT = "종료";
    public static final String ALL = "all";
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private LadderGame ladderGame;

    public void play() {
        try {
            run();
        } catch (StackOverflowError e) {
            System.out.println("[ERROR] 잘못된 입력의 반복으로 프로그램을 종료합니다.");
        }
    }

    private void run() {
        Participants participants = recruitParticipants();
        Prizes prizes = decidePrizes(participants);
        Ladder ladder = makeLadder(participants);
        outputView.printLadderInformation(participants, ladder, prizes);
        ladderGame = new LadderGame(participants, prizes, ladder);
        result(participants);
    }

    private Participants recruitParticipants() {
        try {
            List<String> names = inputView.readNames();
            return new Participants(names);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return recruitParticipants();
        }
    }

    private Prizes decidePrizes(Participants participants) {
        try {
            List<String> prizes = inputView.readResults();
            return new Prizes(prizes, participants);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return decidePrizes(participants);
        }
    }

    private Ladder makeLadder(Participants participants) {
        try {
            int height = inputView.readHeight();
            return new Ladder(height, participants.getParticipantsCount(), new RandomStepGenerator());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return makeLadder(participants);
        }
    }

    private void result(Participants participants) {
        try {
            String name = inputView.readResultName();
            validateResultName(name, participants);
            checkResult(participants, name);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            result(participants);
        }
    }

    private void checkResult(Participants participants, String name) {
        if (name.equals(EXIT)) {
            return;
        }
        if (name.equals(ALL)) {
            checkAllResult(participants);
            return;
        }
        checkOneResult(participants, name);
    }

    private void checkAllResult(Participants participants) {
        outputView.printAllResult(ladderGame.allResultOfLadder());
        result(participants);
    }

    private void checkOneResult(Participants participants, String name) {
        outputView.printOneResult(ladderGame.oneResultOfLadder(name));
        result(participants);
    }

    private void validateResultName(String name, Participants participants) {
        if (!name.equals(EXIT) && !name.equals(ALL) && !participants.hasParticipated(name)) {
            throw new IllegalArgumentException("[ERROR] 해당하는 참가자가 없습니다.");
        }
    }
}
