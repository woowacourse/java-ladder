package view;

import java.util.List;
import model.Block;
import model.Blocks;

public class OutputView {

    public void noticeInputParticipants() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    }

    public void noticeInputHeightOfLadder() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
    }

    public void noticeResult() {
        System.out.println("실행결과");
    }

    public void printNameOfParticipants(List<String> names) {
        /*
        for (String name : names) {
            System.out.print(printName(name));
        }

         */
        for (int i = 0; i < names.size()-1; i++) {
            System.out.print(printName(names.get(i)));
        }
        //System.out.println();
       System.out.println(printLastName(names.get(names.size() - 1)));
    }

    private String printName(String name) {

        if (name.length() == 5) {
            return String.format("%5s ", name);
        }
        return String.format("%-5s ", name);

    }

    private String printLastName(String name) {

        if (name.length() == 5) {
            return String.format("%5s ", name);
        }
        return String.format("%4s ", name);

    }

    public void printBlocks(Blocks blocks, List<String> names) {
        int firstNameLength = names.get(0).length();
        System.out.print(String.format(String.format("%%%ds",firstNameLength)," "));

//        for (int i = 0; i < 5 - (5 - names.size()); i++) {
//            System.out.print(" ");
//        }

        System.out.print("|");
        for (Block block : blocks.getBlocks()) {
            System.out.print(printPass(block));
            System.out.print("|");
        }
        System.out.println();
        //printNameOfParticipants(names);
    }

    private String printPass(Block block) {
        if (block.isPass()) {
            return "-----";
        }
        return "     ";
    }

}
