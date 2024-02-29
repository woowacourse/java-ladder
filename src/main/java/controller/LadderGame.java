package controller;

import constant.controller.LadderGameExceptionMessage;
import domain.*;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.Objects;

public class LadderGame {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private Participants participants;
    private Result result;
    private Ladder ladder;
    private MatchResult matchResult;

    public void play() {
        try {
            run();
        } catch (StackOverflowError e) {
            System.out.println(LadderGameExceptionMessage.EXIT.getExceptionMessage());
        }
    }

    private void run() {
        participants = recruitParticipants();
        result = decideResult(participants.getParticipantsCount());
        ladder = makeLadder();
        matchResult = new MatchResult(participants, result, ladder);
        outputView.printLadderResult(participants, ladder, result);
        while (true) {
            showResult();
        }
    }

    private void showResult() {
        String who = inputView.readWho();
        if (Command.contains(who)) {
            showResultByCommand(who);
            return;
        }
        showResultByName(who);
    }

    private void showResultByName(String who) {
        try {
            Name name = new Name(who);
            Prize prize = matchResult.getResultByName(name);
            outputView.printPrize(prize);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void showResultByCommand(String who) {
        if (Objects.equals(who, Command.EXIT.getCommand())) {
            System.exit(0);
        }
        if (Objects.equals(who, Command.ALL.getCommand())) {
            showResultAll();
        }
    }

    private void showResultAll() {
        outputView.printPrizes(matchResult.getResultAll());
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

    private Ladder makeLadder() {
        try {
            int height = inputView.readHeight();
            return new Ladder(height, participants.getParticipantsCount());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return makeLadder();
        }
    }
}
