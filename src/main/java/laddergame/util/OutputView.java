package laddergame.util;

import laddergame.domain.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OutputView {
    public static void outputMessage(String message) {
        System.out.println(message);
    }

    public static void outputLadderGame(Tags members, Ladder ladder, Tags prizes) {
        System.out.println("사다리 결과");
        outputTag(members.getTagsName());
        outputLadder(ladder);
        outputTag(prizes.getTagsName());
    }

    private static void outputTag(List<String> names) {
        StringBuilder namesView = new StringBuilder();
        for (String name : names) {
            namesView.append(makeNameView(name));
        }
        System.out.println(namesView);
    }

    private static StringBuilder makeNameView(String name) {
        StringBuilder nameView = new StringBuilder("       ");
        int nameStart = 3 - name.length() / 2;
        int nameEnd = nameStart + name.length();

        nameView.replace(nameStart, nameEnd, name);
        return nameView;
    }

    private static void outputLadder(Ladder ladder) {
        StringBuilder ladderView = new StringBuilder();
        int height = ladder.getHeight();
        for (int i = 0; i < height; i++) {
            ladderView.append(makeLineView(ladder, i));
        }
        System.out.print(ladderView);
    }

    private static StringBuilder makeLineView(Ladder ladder, int index) {
        StringBuilder lineView = new StringBuilder();
        List<String> scaffoldsView = new ArrayList<>();

        for (Boolean scaffold : ladder.getLine(index).getScaffolds()) {
            scaffoldsView.add(makeScaffoldView(scaffold));
        }
        lineView.append(String.join("|", scaffoldsView).substring(3));
        lineView.append("\n");
        return lineView;
    }

    private static String makeScaffoldView(Boolean scaffold) {
        return scaffold ? "------" : "      ";
    }

    public static void outputLadderGameResult(String person, LadderGameResult ladderGameResult) {
        System.out.println("실행 결과");
        if (person.equals("all")) {
            outputAllResult(ladderGameResult.allPrizes());
            return;
        }
        System.out.println(ladderGameResult.prize(person));
    }

    private static void outputAllResult(Map<String, String> allPrizes) {
        StringBuilder result = new StringBuilder();
        for (String person : allPrizes.keySet()) {
            result.append(person).append(" : ").append(allPrizes.get(person)).append('\n');
        }
        System.out.print(result);
    }
}
