package laddergame.util;

import laddergame.domain.Ladder;

import java.util.ArrayList;
import java.util.List;

public class OutputView {
    public static void outputLadderGameResult(List<String> names, Ladder ladder) {
        System.out.println("실행결과");
        outputMembers(names);
        outputLadder(ladder);
    }

    private static void outputMembers(List<String> names) {
        StringBuilder namesView = new StringBuilder();
        for (String name : names) {
            namesView.append(makeNameToSevenLength(name));
        }
        System.out.println(namesView);
    }

    private static StringBuilder makeNameToSevenLength(String name) {
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
            ladderView.append(outputLine(ladder, i));
        }
        System.out.println(ladderView);
    }

    private static StringBuilder outputLine(Ladder ladder, int index) {
        StringBuilder lineView = new StringBuilder();
        List<String> scaffoldsView = new ArrayList<>();

        for (Boolean scaffold : ladder.getLine(index).getScaffolds()) {
            scaffoldsView.add(outputScaffold(scaffold));
        }
        lineView.append(String.join("|", scaffoldsView).substring(3));
        lineView.append("\n");
        return lineView;
    }

    private static String outputScaffold(Boolean scaffold) {
        return scaffold ? "------" : "      ";
    }
}
