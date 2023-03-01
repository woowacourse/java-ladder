package view;

import static java.util.stream.Collectors.joining;

import domain.ladder.Direction;
import domain.ladder.Ladder;
import domain.ladder.LadderPrize;
import domain.ladder.LadderPrizes;
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
                               LadderPrizes ladderPrizes) {
        System.out.println("사다리 결과");

        System.out.println(getFormattedNames(players));
        printLadder(ladder, ladderPrizes);
    }

    private String getFormattedNames(Players players) {
        return players.getPlayers().stream()
                .map(player -> String.format("%-5s", player.getName()))
                .collect(joining(" "));
    }

    private void printLadder(Ladder ladder, LadderPrizes ladderPrizes) {
        List<Line> lines = ladder.getLines();
        for (Line line : lines) {
            printLine(line);
        }
        System.out.println(getFormattedResults(ladderPrizes));
    }

    private void printLine(Line line) {
        line.getPoints().forEach(this::printPoint);
        System.out.println();
    }

    private void printPoint(LinePoint point) {
        if (point.getDirection().equals(Direction.RIGHT)) {
            System.out.print(EDGE_OF_POINT + PASSABLE_POINT);
            return;
        }
        System.out.print(EDGE_OF_POINT + BLOCKED_POINT);
    }

    private String getFormattedResults(LadderPrizes ladderPrizes) {
        return ladderPrizes.stream()
                .map(LadderPrize::getPrize)
                .map(result -> String.format("%-5s", result))
                .collect(joining(" "));
    }

    public void printSinglePlayerResult(LadderPrize result) {
        System.out.println("실행 결과");
        System.out.println(result.getPrize());
    }

    public void printAllPlayerResult(List<GameResultDto> gameResultDtos) {
        System.out.println("실행 결과");
        for (GameResultDto result : gameResultDtos) {
            System.out.println(String.format("%s : %s%n", result.getPlayerName(), result.getPrize()));
        }
    }

    public void printPlayerNotExistMessage(ResultRequestDto request) {
        System.out.println(request.getMessage() + "는 존재하지 않는 플레이어입니다.");
    }

    public void printErrorMessage(String message) {
        System.out.println(ERROR_MESSAGE_PREFIX + message);
    }
}
