package ladder.view;

import ladder.domain.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OutputView {
    private static final int PER_NAME_SPACE = 6;
    
    private OutputView() {
        throw new IllegalStateException("인스턴스를 생성할 수 없는 유틸클래스입니다.");
    }
    
    public static void printNames(PlayerNames playerNames) {
        println("\n" + parseDisplayElements(parsePlayerNames(playerNames)));
    }
    
    private static List<String> parsePlayerNames(PlayerNames playerNames) {
        return playerNames.getNames().stream()
                .map(PlayerName::getPlayerName)
                .collect(Collectors.toUnmodifiableList());
    }
    
    private static String parseDisplayElements(List<String> names) {
        return IntStream.range(0, names.size())
                .mapToObj(nameIndex -> parseDisplayName(names, nameIndex))
                .collect(Collectors.joining());
    }

    private static String parseDisplayName(List<String> names, int nameIndex) {
        if (nameIndex == 0) {
            return names.get(nameIndex);
        }
        return String.format("%6s", names.get(nameIndex));
    }

    public static void printLadder(Ladder ladder, int firstNameLength) {
        println(parseLadder(ladder, firstNameLength));
    }

    private static String parseLadder(Ladder ladder, int firstNameLength) {
        return ladder.getLines().stream()
                .map(OutputView::parseLine)
                .map(lineDisplay -> lineDisplay.substring(PER_NAME_SPACE - firstNameLength))
                .collect(Collectors.joining("\n"));
    }

    private static String parseLine(Line line) {
        return line.getLine().stream()
                .map(OutputView::parseBar)
                .collect(Collectors.joining("|", "", "|"));
    }
    
    private static String parseBar(Direction direction) {
        return parseBarMatcher(direction.getLeftBar()).getBarDisplay();
    }
    
    private static BarDisplayMatcher parseBarMatcher(Bar bar) {
        return BarDisplayMatcher.valueOfBarMatcher(bar);
    }
    
    public static void printGameResults(GameResults gameResults) {
        println(parseDisplayElements(parseGameResultsDisplay(gameResults)));
    }
    
    private static List<String> parseGameResultsDisplay(GameResults gameResults) {
        return gameResults.getGameResults().stream().map(GameResult::getGameResult).collect(Collectors.toUnmodifiableList());
    }
    
    public static void printAllPlayerResult(PlayerNames playerNames, List<Integer> movedPositions, GameResults gameResults) {
        List<String> names = parsePlayerNames(playerNames);
        List<GameResult> sortedGameResults = gameResults.getSortedGameResults(movedPositions);
        
        println("\n실행 결과");
        println(parseAllPlayerResult(names, sortedGameResults));
    }
    
    private static String parseAllPlayerResult(List<String> names, List<GameResult> gameResults) {
        return IntStream.range(0, names.size())
                .mapToObj(playerIndex -> parsePlayerResult(playerIndex, names, gameResults))
                .collect(Collectors.joining("\n"));
    }
    
    private static String parsePlayerResult(int playerIndex, List<String> names, List<GameResult> gameResults) {
        GameResult gameResult = gameResults.get(playerIndex);
        return names.get(playerIndex) + " : " + gameResult.getGameResult();
    }
    
    public static void printOnePlayerResult(int playerIndex, List<Integer> movedPositions, GameResults gameResults) {
        println("\n실행 결과");
        
        GameResult gameResult = gameResults.getGameResult(playerIndex, movedPositions);
        println(gameResult.getGameResult());
    }
    
    public static void printExceptionMessage(IllegalArgumentException illegalArgumentException) {
        println(illegalArgumentException.getMessage());
    }
    
    private static void println(String message) {
        System.out.println(message);
    }
}
