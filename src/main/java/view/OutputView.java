package view;

import dto.GameDto;
import dto.LadderDto;
import dto.NamesDto;

import java.util.List;
import java.util.stream.Collectors;

import static view.constant.LadderShapes.*;

public class OutputView {
    public void printRequestNames() {
        System.out.printf("참여할 사람 이름을 입력하세요. (이름은 %s(%s)로 구분하세요)%n", "쉼표", ",");
    }

    public void printRequestLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
    }

    public void printResult(GameDto gameDto) {
        printResultMessage();
        printParticipantNames(gameDto.getNamesDto());
        printGeneratedLadder(gameDto.getLadderDto(), gameDto.getNamesDto().getMaxNameLength());
    }

    private void printResultMessage() {
        System.out.println("실행결과");
    }

    private void printParticipantNames(NamesDto namesDto) {
        int length = namesDto.getMaxNameLength();
        List<String> names = namesDto.getNames();
        names.stream().map(name -> alignLeft(name, length))
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    private String alignLeft(String name, int length) {
        return String.format("%-" + length + "s", name);
    }

    private void printGeneratedLadder(LadderDto ladderDto, int maxNameLength) {
        for (List<Boolean> line : ladderDto.getLadderInfo()) {
            printLine(line, maxNameLength);
        }
    }

    private void printLine(List<Boolean> line, int maxLength) {
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
