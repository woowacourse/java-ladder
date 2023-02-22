package view;

import controller.dto.LadderResponse;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OutputView {

    public static final String RESULT_TITLE = "실행결과";
    public static final String POINT_SEPARATOR = "|";

    public void printGeneratedLadder(LadderResponse ladderResponse) {
        printLine(RESULT_TITLE);
        printEmptyLine();
        List<String> playerNames = ladderResponse.getPlayers();
        List<String> prizes = ladderResponse.getPrizes();
        int nameFormatSize = getNameFormatSize(playerNames, prizes);
        printNames(playerNames, nameFormatSize);
        printLadder(ladderResponse.getLadder(), nameFormatSize);
        printNames(prizes, nameFormatSize);
    }

    private int getNameFormatSize(List<String> playerNames, List<String> prizes) {
        List<String> names = new ArrayList<>();
        names.addAll(playerNames);
        names.addAll(prizes);
        return names.stream()
                .map(String::length)
                .max(Comparator.naturalOrder())
                .orElse(0);
    }

    private void printNames(List<String> playerNames, int nameFormatSize) {
        StringBuilder stringBuilder = new StringBuilder();
        String nameFormat = String.format("%%%ds", nameFormatSize);
        playerNames.forEach((playerName) -> {
            stringBuilder.append(String.format(nameFormat, playerName));
            stringBuilder.append(" ");
        });
        printLine(stringBuilder.toString());
    }

    private void printLadder(List<List<Boolean>> ladder, int nameFormatSize) {
        StringBuilder stringBuilder = new StringBuilder();
        for (List<Boolean> line : ladder) {
            stringBuilder.append(getLineUi(line, nameFormatSize));
            printLine(stringBuilder.toString());
            stringBuilder.setLength(0);
        }
    }

    private String getLineUi(List<Boolean> line, int nameFormatSize) {
        StringBuilder stringBuilder = new StringBuilder();
        getFormattedPoint(nameFormatSize - 1, false, stringBuilder);
        line.forEach(point -> getFormattedPoint(nameFormatSize, point, stringBuilder));
        return stringBuilder.toString();
    }

    private void getFormattedPoint(int nameFormatSize, Boolean point, StringBuilder stringBuilder) {
        stringBuilder.append(getPointUi(point, nameFormatSize));
        stringBuilder.append(POINT_SEPARATOR);
    }

    private String getPointUi(boolean point, int nameFormatSize) {
        return String.valueOf(PointUi.getPointUi(point))
                .repeat(Math.max(0, nameFormatSize));
    }

    private void printEmptyLine() {
        printLine("");
    }

    private void printLine(final String value) {
        System.out.println(value);
    }

}
