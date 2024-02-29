package controller;

import domain.LadderGame;
import domain.ladder.Height;
import domain.ladder.Ladder;
import domain.participants.Participants;
import domain.result.Prizes;
import java.util.List;
import utils.RandomStepGenerator;
import view.InputView;
import view.OutputView;

public class LadderGameController {

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
            return new Ladder(new Height(height), participants.getParticipantsCount(), new RandomStepGenerator());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return makeLadder(participants);
        }
    }

    private void result(Participants participants) {
        try {
            String name = inputView.readResultName(participants);
            checkResult(participants, name);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            result(participants);
        }
    }

    private void checkResult(Participants participants, String name) {
        if (InputView.EXIT.equals(name)) {
            return;
        }
        if (InputView.ALL.equals(name)) {
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
}
