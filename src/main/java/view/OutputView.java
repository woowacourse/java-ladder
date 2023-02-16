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

    public static void printResult(GameDto gameDto) {
        printResultMessage();
        printParticipantNames(gameDto.getMaxNameLength(), gameDto.getNames());
        printGeneratedLadder(gameDto.getGeneratedLadderInfo(), gameDto.getMaxNameLength());
    }

    private static void printResultMessage() {
        System.out.println("실행결과");
    }

    private static void printParticipantNames(int maxNameLength, List<String> names) {
        names.stream().map(name -> alignLeft(name, maxNameLength))
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    private static String alignLeft(String name, int length) {
        return String.format("%-" + length + "s", name);
    }

    private static void printGeneratedLadder(List<List<Boolean>> ladderInfo, int maxNameLength) {
        for (List<Boolean> line : ladderInfo) {
            printLine(line, maxNameLength);
        }
    }

    private static void printLine(List<Boolean> line, int maxLength) {
        for (Boolean isSteppable : line) {
            if (isSteppable) {
                String footSteps = FOOTSTEP.getShape().repeat(maxLength);
                System.out.printf("%s%s", PILLAR.getShape(), footSteps);
            }
            if (!isSteppable) {
                String footSteps = BLANK.getShape().repeat(maxLength);
                System.out.printf("%s%s", PILLAR.getShape(), footSteps);
            }
        }
        System.out.println(PILLAR.getShape());
    }
}
