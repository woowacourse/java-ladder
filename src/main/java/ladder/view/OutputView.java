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
        println(parseDisplayElements(playerNames.getNames()));
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
    
    public static void printExecutionResults(GameResult gameResult) {
        println(parseDisplayElements(gameResult.getExecutionResults()));
    }
    
    public static void printAllPlayerResult(PlayerNames playerNames, GameResult gameResult) {
        List<String> names = playerNames.getNames();
        List<String> allExecutionResult = gameResult.getAllExecutionResult();
        
        println(parseAllPlayerResult(names, allExecutionResult));
    }
    
    private static String parseAllPlayerResult(List<String> names, List<String> allExecutionResult) {
        return IntStream.range(0, names.size())
                .mapToObj(playerIndex -> parsePlayerResult(playerIndex, names, allExecutionResult))
                .collect(Collectors.joining("\n"));
    }
    
    private static String parsePlayerResult(int playerIndex, List<String> names, List<String> allExecutionResult) {
        return names.get(playerIndex) + " : " + allExecutionResult.get(playerIndex);
    }
    
    public static void printOnePlayerResult(int playerIndex, GameResult gameResult) {
        println("실행 결과");
        println(gameResult.getOneExecutionResult(playerIndex));
    }
    
    public static void printExceptionMessage(IllegalArgumentException illegalArgumentException) {
        println(illegalArgumentException.getMessage());
    }
    
    private static void println(String message) {
        System.out.println(message);
    }
}
