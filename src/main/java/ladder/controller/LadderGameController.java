package ladder.controller;

import ladder.domain.LadderGame;
import ladder.domain.ladder.LineStrategy;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.List;

public class LadderGameController {
    private LadderGame ladderGame;
    private static final String ALL_RESULT_MESSAGE = "all";

    public void playGame(LineStrategy lineStrategy) {
        makeLadderGame(lineStrategy);
        findPlayerResult();
    }

    private void makeLadderGame(LineStrategy lineStrategy) {
        List<String> names = readNames();
        List<String> rewards = InputView.readRewards();
        int height = InputView.readLadderHeight();
        this.ladderGame = new LadderGame(names, rewards, height, lineStrategy);
        OutputView.printLadder(ladderGame.getPlayerNames(), ladderGame.getLines(), ladderGame.getRewards());
    }

    private List<String> readNames() {
        List<String> names = InputView.readNames();
        validateCommandNameMatch(names);
        return names;
    }

    private void validateCommandNameMatch(List<String> names) {
        boolean isSame = names.stream()
                .anyMatch(name -> name.equals(ALL_RESULT_MESSAGE));
        if (isSame) {
            throw new IllegalArgumentException("플레이어의 이름은 " + ALL_RESULT_MESSAGE + "이 될 수 없습니다.");
        }
    }

    private void findPlayerResult() {
        String playerName = InputView.readResultPlayerName();
        if (playerName.equals(ALL_RESULT_MESSAGE)) {
            OutputView.printPlayerResultAll(ladderGame.getGameResult());
            return;
        }
        String playerResult = ladderGame.getPlayerResult(playerName);
        OutputView.printPlayerResult(playerResult);
        findPlayerResult();
    }
}
