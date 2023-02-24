package ladder.controller;

import java.util.List;
import java.util.Map;

import ladder.exception.NotFoundPlayerException;
import ladder.service.LadderGame;
import ladder.view.InputView;
import ladder.view.OutputView;
import ladder.view.ResultView;

public class LadderGameController {

    private static final String ALL_PLAYER_NAME = "all";
    private static final String WRONG_PLAYER_NAME_ERROR_MESSAGE = "[ERROR] 결과를 보고 싶은 사람은 참여자 중에 1명을 입력하거나, 모든 참여자의 결과를 보고 싶으면 \"all\"을 입력해주세요.";

    private LadderGame ladderGame;

    public void start() {
        generateLadderGameStep();
        printGameResultStep();
        printResultByPlayerStep();
    }

    private void generateLadderGameStep() {
        try {
            this.ladderGame = new LadderGame(readNames(), readResults(), readLadderHeight());
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            generateLadderGameStep();
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

    private void printGameResultStep() {
        ResultView.printLadderResultMessage();
        ResultView.printPlayerNames(ladderGame.getPlayerNames());
        ResultView.printLadder(ladderGame.getLines());
        ResultView.printRunResults(ladderGame.getResults());
    }

    private void printResultByPlayerStep() {
        String playerNameToShowResult = readPlayerNameToShowResult();
        if (!playerNameToShowResult.equals(ALL_PLAYER_NAME)) {
            printOneResult(playerNameToShowResult);
        }
        if (playerNameToShowResult.equals(ALL_PLAYER_NAME)) {
            printAllResult();
        }
    }

    private String readPlayerNameToShowResult() {
        OutputView.printPlayerNameToShowResultReadMessage();
        return InputView.readPlayerNameToShowResult();
    }

    private void printOneResult(String playerNameToShowResult) {
        try {
            String oneResult = findOneResult(playerNameToShowResult);
            ResultView.printOneResult(oneResult);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            printResultByPlayerStep();
        }
    }

    private void printAllResult() {
        Map<String, String> allResult = findAllResult();
        ResultView.printAllResult(allResult);
    }

    private String findOneResult(String playerName) {
        try {
            return ladderGame.findResultByPlayerName(playerName);
        } catch (NotFoundPlayerException e) {
            throw new IllegalArgumentException(WRONG_PLAYER_NAME_ERROR_MESSAGE);
        }
    }

    private Map<String, String> findAllResult() {
        return ladderGame.findAllResultByPlayerName();
    }

}
