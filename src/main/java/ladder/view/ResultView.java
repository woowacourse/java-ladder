package ladder.view;

import java.util.List;
import java.util.Map.Entry;
import ladder.domain.Step;
import ladder.dto.ResultDto;
import ladder.dto.LadderDto;
import ladder.dto.NamesDto;

public class ResultView {

    private ResultView() {
    }

    public static void printResult(NamesDto playerNamesDto, LadderDto ladderDto,
        NamesDto rewardNamesDto) {
        printResultTitle();
        printNames(playerNamesDto);
        printRows(ladderDto);
        printNames(rewardNamesDto);
        System.out.println();
    }

    private static void printResultTitle() {
        System.out.println("사다리 결과");
        System.out.println();
    }

    private static void printNames(NamesDto namesDto) {
        namesDto.getNames().forEach(ResultView::printName);
        System.out.println();
    }

    private static void printName(String name) {
        System.out.printf("%6s", name);
    }

    private static void printRows(LadderDto ladderDto) {
        List<List<Step>> lines = ladderDto.getLines();
        lines.forEach(ResultView::printRow);
    }

    private static void printRow(List<Step> steps) {
        System.out.print("     |");
        for (int i = 0; i < steps.size(); i++) {
            printStep(steps, i);
        }
        System.out.println();
    }

    private static void printStep(List<Step> steps, int index) {
        if (steps.get(index) == Step.CONNECTED) {
            System.out.print("-----|");
            return;
        }
        System.out.print("     |");
    }

    public static void printResult(String result) {
        System.out.println();
        System.out.println("실행 결과");
        System.out.println(result);
        System.out.println();
    }

    public static void printAllResult(ResultDto resultDto) {
        System.out.println();
        System.out.println("실행 결과");
        for (Entry<String, String> result : resultDto.getResults().entrySet()) {
            System.out.println(result.getKey() + " : " + result.getValue());
        }
        System.out.println();
    }

    public static void printQuitMessage() {
        System.out.println("사다리 게임을 종료합니다.");
    }

    public static void printErrorMessage(Exception e) {
        System.out.println(e.getMessage());
    }
}
