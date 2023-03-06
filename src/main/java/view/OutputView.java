package view;

import static view.constant.LadderShapes.BLANK;
import static view.constant.LadderShapes.FOOTSTEP;
import static view.constant.LadderShapes.PILLAR;

import domain.ladder.Ladder;
import domain.player.Name;
import domain.player.Names;
import domain.result.Prizes;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String LADDER_RESULT_MESSAGE = "\n사다리 결과";
    private static final String RESULT_MESSAGE = "\n실행 결과";

    private OutputView() {
    }


    public static void printResult(final Names names, final Ladder ladder, final Prizes prizes) {
        final int intervalSize = getMaxNameLength(names);

        printResultMessage();
        printParticipantNames(intervalSize, getNames(names));
        printGeneratedLadder(ladder.getLadderShape(), intervalSize);
        printPrizes(intervalSize, prizes.getPrizeNames());
    }

    private static void printPrizes(final int intervalSize, final List<String> prizeNames) {
        prizeNames.stream().map(prize -> alignLeft(prize, intervalSize))
                .collect(Collectors.toList())
                .forEach(System.out::print);
        System.out.println();
    }

    private static List<String> getNames(final Names names) {
        return names.getNames()
                .stream()
                .map(Name::getValue)
                .collect(Collectors.toList());
    }

    private static void printResultMessage() {
        System.out.println(LADDER_RESULT_MESSAGE);
    }

    public static void printPlayerResult(final String result) {
        System.out.println(RESULT_MESSAGE);
        System.out.println(result);
    }

    private static void printParticipantNames(final int maxNameLength, final List<String> names) {
        names.stream().map(name -> alignLeft(name, maxNameLength))
                .collect(Collectors.toList())
                .forEach(System.out::print);
        System.out.println();
    }

    private static String alignLeft(final String name, final int length) {
        return String.format("%-" + length + "s ", name);
    }

    private static void printGeneratedLadder(final List<List<Boolean>> ladderInfo, final int maxNameLength) {
        for (List<Boolean> line : ladderInfo) {
            printLine(line, maxNameLength);
        }
    }

    private static void printLine(final List<Boolean> line, final int maxLength) {
        for (Boolean isSteppable : line) {
            printSteppableLine(maxLength, isSteppable);
            printUnSteppableLine(maxLength, isSteppable);
        }
        System.out.println();
    }

    private static void printUnSteppableLine(final int maxLength, final Boolean isSteppable) {
        if (!isSteppable) {
            printLine(BLANK.getShape(), maxLength);
        }
    }

    private static void printSteppableLine(final int maxLength, final Boolean isSteppable) {
        if (isSteppable) {
            printLine(FOOTSTEP.getShape(), maxLength);
        }
    }

    private static int getMaxNameLength(final Names names) {
        return Collections.max(getNames(names)
                .stream()
                .map(String::length)
                .collect(Collectors.toList()));
    }

    private static void printLine(final String shape, final int maxLength) {
        String footSteps = shape.repeat(maxLength);
        System.out.printf("%s%s", PILLAR.getShape(), footSteps);
    }

    public static void printErrorMessage(final String errorMessage) {
        System.out.println(errorMessage);
    }
}
