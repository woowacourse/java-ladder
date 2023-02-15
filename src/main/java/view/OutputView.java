package view;

import java.util.stream.IntStream;
import model.Block;
import model.Blocks;
import model.Names;

public class OutputView {

    public static final String PARTICIPANT_NAME_FORMAT = "%-5s ";
    public static final String PARTICIPANT_NAME_FORMAT_FOR_LAST_INDEX = "%4s";
    public static final String LEFT_LEG = "    |";
    public static final String LEG = "|";
    public static final String ACTIVATED_BLOCK = "-----";
    public static final String DEACTIVATED_BLOCK = "     ";

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

    public void printBlocks(Blocks blocks) {
        System.out.print(LEFT_LEG);
        for (Block block : blocks.getBlocks()) {
            System.out.print(printPass(block));
            System.out.print(LEG);

        }
        System.out.println();
    }

    private String printPass(Block block) {
        if (block.isPass()) {
            return ACTIVATED_BLOCK;
        }
        return DEACTIVATED_BLOCK;
    }

}
