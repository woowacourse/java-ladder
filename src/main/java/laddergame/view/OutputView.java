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

    public void printResultHeader() {
        System.out.println();
        System.out.println("사다리 결과");
        System.out.println();
    }

    public void printParticipantsNames(Participants participants) {
        String result = participants.getParticipants()
                .stream()
                .map(Participant::getName)
                .map(this::alignNameText)
                .collect(Collectors.joining(" "));
        System.out.println(result);
    }

    public void printLadder(LadderGame ladderGame) {
        List<Line> lines = ladderGame.getLines();
        lines.stream()
                .map(Line::getLineStates)
                .map(this::getStringBuilder)
                .forEach(System.out::println);
    }

    public void printExecutionResults(ExecutionResults executionResults) {
        String result = executionResults.getExecutionResults()
                .stream()
                .map(ExecutionResult::getName)
                .map(this::alignNameText)
                .collect(Collectors.joining(" "));
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

    private StringBuilder getStringBuilder(List<LineState> lineStates) {
        StringBuilder result = new StringBuilder("    ");
        for (int i = 0; i < lineStates.size() - 1; i++) {
            LineState now = lineStates.get(i);
            result.append("|");
            String text = getDelimiterByState(now);
            result.append(text);
        }
        result.append("|");
        return result;
    }

    private String getDelimiterByState(LineState now) {
        if (now == LineState.START) {
            return "-----";
        }
        return "     ";
    }

    private String convertResultText(List<GameResult> gameResults) {
        if (gameResults.size() == SINGLE_GAME_RESUlT_COUNT) {
            return gameResults.stream()
                    .map(GameResult::getExecutionResult)
                    .map(ExecutionResult::getName)
                    .collect(Collectors.joining(""));
        }
        return gameResults.stream()
                .map(result -> String.format("%s : %s", result.getParticipant().getName(),
                        result.getExecutionResult().getName()))
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
