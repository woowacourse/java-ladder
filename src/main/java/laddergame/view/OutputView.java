package laddergame.view;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import laddergame.Ladder;

public class OutputView {

    // TODO : 클래스 분리
    public void printNames(final List<String> names, final int width) {
        System.out.print(names.get(0) + " ");

        for (int i = 1; i < names.size() - 1; i++) {
            final String name = names.get(i);
            final String formattedName = String.format("%" + (width + 1) + "s", name);
            System.out.print(formattedName);
        }

        System.out.printf("%" + width + "s", names.get(names.size() - 1));
    }

    public void printLadder(final Ladder ladder, final int width, final int firstWidth) {
        ladder.getLines().forEach(line -> System.out.println(" ".repeat(firstWidth) + printLine(line, width)));
    }

    private String printLine(final List<Boolean> points, final int width) {
        List<String> convertedPoints = new ArrayList<>();

        // TODO : 인뎁스 줄이기
        for(int i=0; i<points.size(); i++) {
            if (points.get(i)) {
                convertedPoints.add("-".repeat(width));
            } else {
                convertedPoints.add(" ".repeat(width));
            }
        }

        return convertedPoints.stream().collect(Collectors.joining("|", "|", "|"));
    }

}
