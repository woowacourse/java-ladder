package laddergame.view;

import java.util.List;
import java.util.stream.Collectors;
import laddergame.model.executionresults.ExecutionResult;
import laddergame.model.executionresults.ExecutionResults;
import laddergame.model.laddergame.GameResult;
import laddergame.model.laddergame.LadderGame;
import laddergame.model.laddergame.Line;
import laddergame.model.laddergame.LineState;
import laddergame.model.participants.Participant;
import laddergame.model.participants.Participants;

public class OutputView {
    private static final int STANDARD_NAME_LENGTH = 5;
    private static final int SINGLE_GAME_RESUlT_COUNT = 1;
    private static final String MULTIPLE_RESULTS_DELIMITER_ONE_LINE = " ";

    public void printResultHeader() {
        System.out.println();
        System.out.println("사다리 결과");
        System.out.println();
    }

    public void printParticipantsNames(Participants participants) {
        String result = participants.getParticipants()
                .stream()
                .map(Participant::name)
                .map(this::alignNameText)
                .collect(Collectors.joining(MULTIPLE_RESULTS_DELIMITER_ONE_LINE));
        System.out.println(result);
    }

    public void printLadder(LadderGame ladderGame) {
        List<Line> lines = ladderGame.getLines();
        lines.stream()
                .map(Line::getLineStates)
                .map(this::getLadderText)
                .forEach(text -> System.out.printf("    %s%n", text));
    }

    public void printExecutionResults(ExecutionResults executionResults) {
        String result = executionResults.getExecutionResults()
                .stream()
                .map(ExecutionResult::name)
                .map(this::alignNameText)
                .collect(Collectors.joining(MULTIPLE_RESULTS_DELIMITER_ONE_LINE));
        System.out.println(result);
    }

    public void printGameResults(List<GameResult> gameResults) {
        System.out.println();
        System.out.println("실행 결과");
        System.out.println(convertResultText(gameResults));
    }

    private String alignNameText(String name) {
        if (name.length() < STANDARD_NAME_LENGTH) {
            return String.format("%4s ", name);
        }
        return name;
    }

    private String getLadderText(List<LineState> lineStates) {
        StringBuilder result = new StringBuilder();
        for (LineState lineState : lineStates) {
            String verticalPole = LadderElement.VERTICAL_POLE.getText();
            result.append(verticalPole);
            String horizontalPole = getLadderElementByState(lineState).getText();
            result.append(horizontalPole);
        }
        return result.toString().trim();
    }

    private LadderElement getLadderElementByState(LineState now) {
        if (now == LineState.START) {
            return LadderElement.CONNECTED_HORIZONTAL_POLE;
        }
        return LadderElement.NOT_CONNECTED_HORIZONTAL_POLE;
    }

    private String convertResultText(List<GameResult> gameResults) {
        if (gameResults.size() == SINGLE_GAME_RESUlT_COUNT) {
            return gameResults.stream()
                    .map(GameResult::executionResult)
                    .map(ExecutionResult::name)
                    .collect(Collectors.joining(""));
        }
        return gameResults.stream()
                .map(result -> String.format("%s : %s", result.participant().name(),
                        result.executionResult().name()))
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
