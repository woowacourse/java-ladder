package ladder.controller;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LadderController {
    private static final String COMMA_DELIMITER = ",";
    
    public void run() {
        PlayerNames playerNames = getCorrectPlayerNames();
        GameResults gameResults = getGameResult(playerNames);
    
        Ladder ladder = getLadder(playerNames);
    
        printLadderStructure(playerNames, ladder, gameResults);
        viewResult(playerNames, ladder, gameResults);
    }
    
    private PlayerNames getCorrectPlayerNames() {
        return InputView.repeat(() -> new PlayerNames(parsePlayerNames(InputView.inputPeopleNames())));
    }
    
    private List<PlayerName> parsePlayerNames(String names) {
        return Arrays.stream(names.split(","))
                .map(PlayerName::new)
                .collect(Collectors.toUnmodifiableList());
    }
    
    private GameResults getGameResult(PlayerNames playerNames) {
        return InputView.repeat(() -> new GameResults(splitGameResults(getExecutionResults()), playerNames));
    }
    
    private String getExecutionResults() {
        return InputView.inputExecutionResults();
    }
    
    private List<GameResult> splitGameResults(String gameResults) {
        return Arrays.stream(gameResults.split(COMMA_DELIMITER))
                .map(GameResult::new)
                .collect(Collectors.toUnmodifiableList());
    }
    
    private Ladder getLadder(PlayerNames playerNames) {
        return InputView.repeat(() -> getLadder(playerNames, getCorrectLadderHeight()));
    }
    
    private Integer getCorrectLadderHeight() {
        return InputView.repeat(InputView::inputLadderHeight);
    }
    
    private Ladder getLadder(PlayerNames playerNames, int ladderHeight) {
        return new Ladder(new RandomBasedBarGenerator(), ladderHeight, playerNames.playerSize());
    }
    
    private void printLadderStructure(PlayerNames playerNames, Ladder ladder, GameResults gameResults) {
        OutputView.printNames(playerNames);
        OutputView.printLadder(ladder, playerNames.getFirstPlayerNameLength());
        OutputView.printGameResults(gameResults);
    }
    
    private void viewResult(PlayerNames playerNames, Ladder ladder, GameResults gameResults) {
        String existedPlayer = getExistedPlayer(playerNames);
        List<Integer> movedPositions = getMovedPositions(playerNames, ladder);
    
        if ("all".equals(existedPlayer)) {
            OutputView.printAllPlayerResult(playerNames, movedPositions, gameResults);
            return;
        }
        
        OutputView.printOnePlayerResult(getPlayerIndex(playerNames, existedPlayer), movedPositions, gameResults);
        viewResult(playerNames, ladder, gameResults);
    }
    
    private String getExistedPlayer(PlayerNames playerNames) {
        return InputView.repeat(() -> getPlayer(playerNames));
    }
    
    private String getPlayer(PlayerNames playerNames) {
        String player = InputView.inputPlayerName();
        return playerNames.findByName(player);
    }
    
    private List<Integer> getMovedPositions(PlayerNames playerNames, Ladder ladder) {
        return ladder.getMovedPositions(playerNames.playerSize());
    }
    
    private int getPlayerIndex(PlayerNames playerNames, String existedPlayer) {
        return playerNames.getPlayerIndex(existedPlayer);
    }
}
