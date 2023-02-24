package view;

import static java.util.stream.Collectors.joining;

import domain.ladder.Ladder;
import domain.ladder.LadderResult;
import domain.ladder.LadderResults;
import domain.ladder.Line;
import domain.ladder.LinePoint;
import domain.player.Players;
import dto.GameResultDto;
import dto.ResultRequestDto;
import java.util.List;

public class OutputView {

    private static final String EDGE_OF_POINT = "|";
    private static final String PASSABLE_POINT = "-----";
    private static final String BLOCKED_POINT = "     ";
    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";

    public void printLadderMap(Players players,
                               Ladder ladder,
                               LadderResults ladderResults) {
        System.out.println("사다리 결과");

        System.out.println(getFormattedNames(players));
        printLadder(ladder, ladderResults);
    }

    private String getFormattedNames(Players players) {
        return players.getPlayers().stream()
                .map(player -> String.format("%-5s", player.getName()))
                .collect(joining(" "));
    }

    private void printLadder(Ladder ladder, LadderResults ladderResults) {
        List<Line> lines = ladder.getLines();
        for (Line line : lines) {
            printLine(line);
        }
        System.out.println(getFormattedResults(ladderResults));
    }

    private void printLine(Line line) {
        line.getPoints().forEach(this::printPoint);
        System.out.println(EDGE_OF_POINT);
    }

    private void printPoint(LinePoint point) {
        if (point.isPassable()) {
            System.out.print(EDGE_OF_POINT + PASSABLE_POINT);
            return;
        }
        System.out.print(EDGE_OF_POINT + BLOCKED_POINT);
    }

    private String getFormattedResults(LadderResults ladderResults) {
        return ladderResults.stream()
                .map(LadderResult::getResult)
                .map(result -> String.format("%-5s", result))
                .collect(joining(" "));
    }

    public void printSinglePlayerResult(LadderResult result) {
        System.out.println("실행 결과");
        System.out.println(result.getResult());
    }

    public void printAllPlayerResult(List<GameResultDto> everyPlayerResult) {
        System.out.println("실행 결과");
        for (GameResultDto playerLadderResult : everyPlayerResult) {
            System.out.println(String.format("%s : %s",
                    playerLadderResult.getPlayerName(), playerLadderResult.getResult()));
        }
    }

    public void printPlayerNotExistMessage(ResultRequestDto request) {
        System.out.println(request.getMessage() + "는 존재하지 않는 플레이어입니다.");
    }

    public void printErrorMessage(String message) {
        System.out.println(ERROR_MESSAGE_PREFIX + message);
    }
}
