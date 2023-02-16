package view;

import dto.GameDto;

import java.util.List;
import java.util.stream.Collectors;

import static view.constant.LadderShapes.*;

public class OutputView {
    public static void printRequestNames() {
        System.out.printf("참여할 사람 이름을 입력하세요. (이름은 %s(%s)로 구분하세요)%n", "쉼표", ",");
    }

    public static void printRequestLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
    }

    public static void printResult(final GameDto gameDto) {
        printResultMessage();
        printParticipantNames(gameDto.getMaxNameLength(), gameDto.getNames());
        printGeneratedLadder(gameDto.getGeneratedLadderInfo(), gameDto.getMaxNameLength());
    }

    private static void printResultMessage() {
        System.out.println("실행결과");
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
        System.out.println(PILLAR.getShape());
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

    private static void printLine(final String shape, final int maxLength) {
        String footSteps = shape.repeat(maxLength);
        System.out.printf("%s%s", PILLAR.getShape(), footSteps);
    }

    public static void printErrorMessage(final String errorMessage) {
        System.out.println(errorMessage);
    }
}
