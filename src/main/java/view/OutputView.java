package view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {

    private static final Map<String,String> PASS_PRINT_STORAGE = new HashMap<>();

    static {
        PASS_PRINT_STORAGE.put("RIGHT","  |--");
        PASS_PRINT_STORAGE.put("LEFT","--|  ");
        PASS_PRINT_STORAGE.put("NOTHING","  |  ");
    }

    public void noticeInputParticipants() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    }

    public void noticeInputHeightOfLadder() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
    }

    public void noticeResult() {
        System.out.println("실행결과");
    }

    public void printNames(List<String> names){
        String result = names.stream()
            .map(name -> String.format("%-5s ",name))
            .collect(Collectors.joining());
        System.out.println(result);
    }

    public void printLadder(List<List<String>> ladder){
        for (List<String> line : ladder) {
            System.out.print(joinLine(line));
            System.out.println();
        }

    }

    private String joinLine(List<String> line){
        return line.stream()
            .map(PASS_PRINT_STORAGE::get)
            .collect(Collectors.joining());
    }

}
