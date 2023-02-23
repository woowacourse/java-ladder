package controller;

import controller.dto.LadderResponse;
import controller.dto.PersonalResultResponse;
import controller.dto.TotalResultResponse;
import domain.LadderGame;
import domain.LadderGameResult;
import domain.ladder.Ladder;
import domain.ladder.PointGenerator;
import domain.players.Players;
import domain.prize.Prize;
import domain.prize.Prizes;
import view.InputView;
import view.OutputView;

import java.util.List;

public class LadderGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final PointGenerator pointGenerator;
    private LadderGame ladderGame;

    public LadderGameController(final InputView inputView, final OutputView outputView, final PointGenerator pointGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.pointGenerator = pointGenerator;
    }

    public void play() {
        ready();
        printGeneratedLadder();
        printResult();
    }

    private void ready() {
        List<String> playerNames = inputView.readPlayerNames();
        Players players = Players.valueOf(playerNames);
        List<String> prizes = inputView.readPrizes();
        int ladderHeight = inputView.readLadderHeight();
        ladderGame = new LadderGame(players, ladderHeight, prizes, pointGenerator);
    }

    private void printGeneratedLadder() {
        Ladder ladder = ladderGame.getLadder();
        Players players = ladderGame.getPlayers();
        Prizes prizes = ladderGame.getPrizes();
        LadderResponse ladderResponse = LadderResponse.of(ladder, players, prizes);
        outputView.printGeneratedLadder(ladderResponse);
    }

    private void printResult() {
        RequestType requestType = RequestType.PERSONAL;
        while (requestType == RequestType.PERSONAL) {
            String resultRequest = inputView.readResultRequest();
            requestType = checkRequestType(resultRequest);
            printResultByRequestType(requestType, resultRequest);
        }
    }

    private RequestType checkRequestType(final String input) {
        final String TOTAL_REQUEST = "all";

        if (input.equals(TOTAL_REQUEST)) {
            return RequestType.TOTAL;
        }
        return RequestType.PERSONAL;
    }

    private void printResultByRequestType(RequestType requestType, String input) {
        if (requestType == RequestType.TOTAL) {
            printTotalResult();
            return;
        }
        printPersonalResult(input);
    }

    private void printTotalResult() {
        LadderGameResult result = ladderGame.getResult();
        TotalResultResponse totalResultResponse = TotalResultResponse.from(result);
        outputView.printTotalResult(totalResultResponse);
    }

    private void printPersonalResult(String playerName) {
        Prize prize = ladderGame.getPersonalResult(playerName);
        PersonalResultResponse personalResultResponse = PersonalResultResponse.from(prize);
        outputView.printPersonalResult(personalResultResponse);
    }

    private enum RequestType {
        TOTAL, PERSONAL,
    }

}
