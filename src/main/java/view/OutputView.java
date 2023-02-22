package view;

import domain.GameResult;
import domain.LadderGame;
import domain.Line;

public class OutputView {

    private static final String ABLE_TO_MOVE = "-----";
    private static final String DISABLE_TO_MOVE = "     ";
    private static final String LINE_START = "    |";
    private static final String BLOCK_DELIMITER = "|";
    private static final String LADDER_RESULT_MESSAGE = "\n사다리결과";
    private static final String GAME_RESULT_MESSAGE = "\n실행결과";
    private static final boolean CONNECTED = true;
    private static final int EMPTY = 0;

    private final StringBuilder gameMap = new StringBuilder();

    public void printGameMap(LadderGame ladderGame) {
        gameMap.setLength(EMPTY);
        gameMap.append(LADDER_RESULT_MESSAGE);
        gameMap.append(System.lineSeparator());
        addNames(ladderGame);
        addLadder(ladderGame);
        addLadderResults(ladderGame);
        System.out.print(gameMap);
    }

    private void addNames(LadderGame ladderGame) {
        ladderGame.getParticipantNames().forEach((participantName) -> gameMap.append(reformatName(participantName)));
        gameMap.append(System.lineSeparator());
    }

    private String reformatName(String name) {
        return String.format("%5s ", name);
    }

    private void addLadder(LadderGame ladderGame) {
        ladderGame.getLines()
            .forEach((line) -> gameMap.append(reformatLine(line)));
    }

    private String reformatLine(Line line) {
        final StringBuilder reformattedLine = new StringBuilder();
        reformattedLine.append(LINE_START);
        line.getBlocks()
            .forEach((block) -> reformattedLine.append(reformatBlock(block))
                .append(BLOCK_DELIMITER));
        reformattedLine.append(System.lineSeparator());
        return reformattedLine.toString();
    }

    private String reformatBlock(Boolean status) {
        if (status == CONNECTED) {
            return ABLE_TO_MOVE;
        }
        return DISABLE_TO_MOVE;
    }

    private void addLadderResults(LadderGame ladderGame) {
        ladderGame.getLadderResultNames()
            .forEach((ladderResult) -> gameMap.append(reformatResult(ladderResult)));
        gameMap.append(System.lineSeparator());
    }

    private String reformatResult(String ladderResult) {
        return String.format("%5s ", ladderResult);
    }

    public void printGameResult(String result) {
        System.out.println(GAME_RESULT_MESSAGE);
        System.out.println(result);
    }

    public void printAllGameResult(GameResult gameResult) {
        System.out.println(GAME_RESULT_MESSAGE);
        gameResult.getResults().forEach((key, value) -> System.out.println(key + " : " + value));
    }
}
