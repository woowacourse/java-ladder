package controller;

import domain.*;
import view.InputView;
import view.OutputView;

import java.util.List;

public class LadderGame {

    public static final String EXIT ="[ERROR] 잘못된 입력의 반복으로 프로그램을 종료합니다.";

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void play() {
        try {
            run();
        } catch (StackOverflowError e) {
            System.out.println(EXIT);
        }
    }

    private void run() {
        Participants participants = recruitParticipants();
        Result result = decideResult(participants.getCount());
        Ladder ladder = makeLadder(participants);
        MatchResult matchResult = new MatchResult(participants, result, ladder);
        outputView.printLadderResult(participants, ladder, result);
        while (true) {
            showResult(matchResult);
        }
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

    private Result decideResult(int participantsCount) {
        try {
            List<String> prizes = inputView.readPrizes();
            return new Result(prizes, participantsCount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return decideResult(participantsCount);
        }
    }

    private Ladder makeLadder(Participants participants) {
        try {
            int height = inputView.readHeight();
            return new Ladder(height, participants.getCount(), new RandomStepGenerator());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return makeLadder(participants);
        }
    }

    private void showResult(MatchResult matchResult) {
        String input = inputView.readResultChoice();
        if (Command.contains(input)) {
            showResultByCommand(matchResult, input);
            return;
        }
        showResultByName(matchResult, input);
    }

    private void showResultByCommand(MatchResult matchResult, String input) {
        if (Command.isExit(input)) {
            System.exit(0);
        }
        if (Command.isAll(input)) {
            showResultAll(matchResult);
        }
    }

    private void showResultByName(MatchResult matchResult, String who) {
        try {
            Name name = new Name(who);
            Prize prize = matchResult.getResultByName(name);
            outputView.printOneResult(prize);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void showResultAll(MatchResult matchResult) {
        outputView.printAllResult(matchResult.getResultAll());
    }
}
