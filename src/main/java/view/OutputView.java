package view;

import controller.LadderGameController;
import domain.GameResult;
import domain.LadderGame;
import domain.ladder.Block;
import domain.ladder.LadderPrize;
import domain.ladder.Line;
import domain.participants.Participant;

public class OutputView {

    private static final String ABLE_TO_MOVE = "-----";
    private static final String DISABLE_TO_MOVE = "     ";
    private static final String LINE_START = "    |";
    private static final String BLOCK_DELIMITER = "|";
    private static final String LADDER_RESULT_MESSAGE = "\n사다리결과";
    private static final String GAME_RESULT_MESSAGE = "\n실행결과";
    private static final boolean CONNECTED = true;
    private static final int EMPTY = 0;
    public static final String ALL = "all";
    public static final String DELIMITER = " : ";

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
        ladderGame.getParticipants().forEach((participant) -> gameMap.append(reformatName(participant)));
        gameMap.append(System.lineSeparator());
    }

    private String reformatName(Participant participant) {
        return String.format("%5s ", participant.getName());
    }

    private void addLadder(LadderGame ladderGame) {
        ladderGame.getLines()
            .forEach((line) -> gameMap.append(reformatLine(line)));
    }

    private String reformatLine(Line line) {
        final StringBuilder reformattedLine = new StringBuilder();
        reformattedLine.append(LINE_START);
        line.getBlocks().forEach((block) -> reformattedLine.append(reformatBlock(block)).append(BLOCK_DELIMITER));
        reformattedLine.append(System.lineSeparator());
        return reformattedLine.toString();
    }

    private String reformatBlock(Block block) {
        if (block.isConnected() == CONNECTED) {
            return ABLE_TO_MOVE;
        }
        return DISABLE_TO_MOVE;
    }

    private void addLadderResults(LadderGame ladderGame) {
        ladderGame.getPrizes()
            .stream().map(LadderPrize::getName)
            .forEach((ladderResult) -> gameMap.append(reformatLadderResult(ladderResult)));
        gameMap.append(System.lineSeparator());
    }

    private String reformatLadderResult(String ladderResult) {
        return String.format("%5s ", ladderResult);
    }

    public void printGameResult(String name, GameResult gameResult) {
        if (name.equals(LadderGameController.EXIT_RESERVED_WORD)) {
            return;
        }
        System.out.println(GAME_RESULT_MESSAGE);
        if (name.equals(ALL)) {
            printAllGameResult(gameResult);
            return;
        }
        printOneGameResult(name, gameResult);
    }

    public void printOneGameResult(String name, GameResult gameResult) {
        System.out.println(gameResult.getPrizeByName(name).getName());
    }

    public void printAllGameResult(GameResult gameResult) {
        gameResult.getAllResults()
            .forEach((key, value) -> System.out.println(key.getName() + DELIMITER + value.getName()));
    }
}
