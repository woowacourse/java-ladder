package view;

import java.util.stream.IntStream;
import model.Line;
import model.Names;
import model.Path;

public class OutputView {

    private static final String PARTICIPANT_NAME_FORMAT = "%-5s ";
    private static final String PARTICIPANT_NAME_FORMAT_FOR_LAST_INDEX = "%4s";
    private static final String LEFT_LEG = "    |";
    private static final String LEG = "|";
    private static final String ACTIVATED_BLOCK = "-----";
    private static final String DEACTIVATED_BLOCK = "     ";

    public void noticeInputParticipants() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    }

    public void noticeInputHeightOfLadder() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
    }

    public void noticeResult() {
        System.out.println("실행결과");
    }

    public void printNameOfParticipants(Names names) {
        IntStream.range(0,names.getNames().size())
            .mapToObj(i -> printName(names.getNames().get(i).getName(), names.getNames().size(), i))
            .forEach(System.out::print);
        System.out.println();
    }

    private String printName(String name, int totalSize, int index) {
        if (totalSize - 1 != index){
            return String.format(PARTICIPANT_NAME_FORMAT, name);
        }
        return String.format(PARTICIPANT_NAME_FORMAT_FOR_LAST_INDEX, name);
    }

    public void printBlocks(Line line) {
        System.out.print(LEFT_LEG);
        for (Path path : line.getLine()) {
            System.out.print(path.getLog());
            System.out.print(LEG);

        }
        System.out.println();
    }
}
