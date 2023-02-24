package ladder.controller;

import java.util.List;
import java.util.Map;

import ladder.domain.ladder.Line;
import ladder.exception.NotFoundPlayerException;
import ladder.service.LadderGame;
import ladder.service.LadderGameMaker;
import ladder.view.InputView;
import ladder.view.OutputView;
import ladder.view.ResultView;

public class LadderGameController {

    private static final String ALL_PLAYER_NAME = "all";
    private static final String WRONG_PLAYER_NAME_ERROR_MESSAGE = "[ERROR] 결과를 보고 싶은 사람은 참여자 중에 1명을 입력하거나, 모든 참여자의 결과를 보고 싶으면 \"all\"을 입력해주세요.";

    public void start() {
        LadderGame ladderGame = generateLadderGame();
        printGameResult(ladderGame.getPlayerNames(), ladderGame.getLines(), ladderGame.getResults());
        printResultByPlayer(ladderGame);
    }

    private LadderGame generateLadderGame() {
        try {
            return LadderGameMaker.createLadderGame(readNames(), readResults(), readLadderHeight());
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return generateLadderGame();
        }
    }

    private List<String> readNames() {
        OutputView.printPlayerNamesReadMessage();
        try {
            return InputView.readNames();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return readNames();
        }
    }

    private List<String> readResults() {
        OutputView.printRunResultReadMessage();
        try {
            return InputView.readResults();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return readResults();
        }
    }

    private int readLadderHeight() {
        OutputView.printMaxLadderHeightReadMessage();
        try {
            return InputView.readLadderHeight();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return readLadderHeight();
        }
    }

    private void printGameResult(List<String> playerNames, List<Line> lines, List<String> results) {
        ResultView.printLadderResultMessage();
        ResultView.printPlayerNames(playerNames);
        ResultView.printLadder(lines);
        ResultView.printRunResults(results);
    }

    private void printResultByPlayer(LadderGame ladderGame) {
        String playerNameToShowResult = readPlayerNameToShowResult();
        if (!playerNameToShowResult.equals(ALL_PLAYER_NAME)) {
            printOneResult(playerNameToShowResult, ladderGame);
        }
        if (playerNameToShowResult.equals(ALL_PLAYER_NAME)) {
            printAllResult(ladderGame);
        }
    }

    private String readPlayerNameToShowResult() {
        OutputView.printPlayerNameToShowResultReadMessage();
        return InputView.readPlayerNameToShowResult();
    }

    private void printOneResult(String playerNameToShowResult, LadderGame ladderGame) {
        try {
            String oneResult = findOneResult(ladderGame, playerNameToShowResult);
            ResultView.printOneResult(oneResult);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            printResultByPlayer(ladderGame);
        }
    }

    private void printAllResult(LadderGame ladderGame) {
        Map<String, String> allResult = findAllResult(ladderGame);
        ResultView.printAllResult(allResult);
    }

    private String findOneResult(LadderGame ladderGame, String playerName) {
        try {
            return ladderGame.findResultByPlayerName(playerName);
        } catch (NotFoundPlayerException e) {
            throw new IllegalArgumentException(WRONG_PLAYER_NAME_ERROR_MESSAGE);
        }
    }

    private Map<String, String> findAllResult(LadderGame ladderGame) {
        return ladderGame.findAllResultByPlayerName();
    }
}
